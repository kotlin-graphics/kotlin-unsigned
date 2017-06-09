package unsigned.java_1_7

import java.math.BigInteger


fun Long.toUnsignedString(radix: Int = 10): String {
    return when {
        this >= 0 -> toString(radix)
        else -> when (radix) {
            2 -> toBinaryString()

            4 -> toUnsignedString0(2)

            8 -> toOctalString()

            10 -> {
                /*
                 * We can get the effect of an unsigned division by 10
                 * on a long value by first shifting right, yielding a
                 * positive value, and then dividing by 5.  This
                 * allows the last digit and preceding digits to be
                 * isolated more quickly than by an initial conversion
                 * to BigInteger.
                 */
                val quot = this.ushr(1) / 5
                val rem = this - quot * 10
                quot.toString_() + rem
            }

            16 -> toHexString()

            32 -> toUnsignedString0(5)

            else -> toUnsignedBigInteger().toString(radix)
        }
    }
}

fun Long.toString(radix: Int): String {
    var i = this
    var _radix = radix
    if (_radix < Character.MIN_RADIX || _radix > Character.MAX_RADIX)
        _radix = 10
    if (_radix == 10)
        return toString_()
    val buf = CharArray(65)
    var charPos = 64
    val negative = i < 0

    if (!negative) {
        i = -i
    }

    while (i <= -_radix) {
        buf[charPos--] = digits[(-(i % _radix)).toInt()]
        i = i / _radix
    }
    buf[charPos] = digits[(-i).toInt()]

    if (negative) {
        buf[--charPos] = '-'
    }

    return String(buf, charPos, 65 - charPos)
}

fun Long.toString_(): String {
    if (this == java.lang.Long.MIN_VALUE)
        return "-9223372036854775808"
    val size = if (this < 0) stringSize(-this) + 1 else stringSize(this)
    val buf = CharArray(size)
    getChars(this, size, buf)
    return String(buf)
}

internal fun stringSize(x: Long): Int {
    var p = 10L
    for (i in 1..18) {
        if (x < p)
            return i
        p *= 10
    }
    return 19
}

internal fun getChars(i: Long, index: Int, buf: CharArray) {
    var _i = i
    var q: Long
    var r: Int
    var charPos = index
    var sign: Char = 0.toChar()

    if (_i < 0) {
        sign = '-'
        _i = -_i
    }

    // Get 2 digits/iteration using longs until quotient fits into an int
    while (_i > Integer.MAX_VALUE) {
        q = _i / 100
        // really: r = i - (q * 100);
        r = (_i - ((q shl 6) + (q shl 5) + (q shl 2))).toInt()
        _i = q
        buf[--charPos] = DigitOnes[r]
        buf[--charPos] = DigitTens[r]
    }

    // Get 2 digits/iteration using ints
    var q2: Int
    var i2 = _i.toInt()
    while (i2 >= 65536) {
        q2 = i2 / 100
        // really: r = i2 - (q * 100);
        r = i2 - ((q2 shl 6) + (q2 shl 5) + (q2 shl 2))
        i2 = q2
        buf[--charPos] = DigitOnes[r]
        buf[--charPos] = DigitTens[r]
    }

    // Fall thru to fast mode for smaller numbers
    // assert(i2 <= 65536, i2);
    while (true) {
        q2 = (i2 * 52429).ushr(16 + 3)
        r = i2 - ((q2 shl 3) + (q2 shl 1))  // r = i2-(q2*10) ...
        buf[--charPos] = digits[r]
        i2 = q2
        if (i2 == 0) break
    }
    if (sign.toInt() != 0)
        buf[--charPos] = sign
}

internal val DigitTens by lazy {
    charArrayOf(
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9')
}

internal val DigitOnes by lazy {
    charArrayOf(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
}

internal val digits by lazy {
    charArrayOf(
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z')
}

fun Long.toBinaryString() = toUnsignedString0(1)

internal fun Long.toUnsignedString0(shift: Int): String {
    // assert shift > 0 && shift <=5 : "Illegal shift value";
    val mag = java.lang.Long.SIZE - java.lang.Long.numberOfLeadingZeros(this)
    val chars = Math.max((mag + (shift - 1)) / shift, 1)
    val buf = CharArray(chars)

    formatUnsignedLong(shift, buf, 0, chars)
    return String(buf)
}

internal fun Long.formatUnsignedLong(shift: Int, buf: CharArray, offset: Int, len: Int): Int {
    var _this = this
    var charPos = len
    val radix = 1 shl shift
    val mask = radix - 1
    do {
        buf[offset + --charPos] = digits[toInt() and mask]
        _this = _this ushr shift
    } while (_this != 0L && charPos > 0)

    return charPos
}

fun Long.toOctalString() = toUnsignedString0(3)

fun Long.toHexString() = toUnsignedString0(4)

private fun Long.toUnsignedBigInteger(): BigInteger {
    if (this >= 0L)
        return BigInteger.valueOf(this)
    else {
        val upper = this.ushr(32).toInt()
        val lower = this.toInt()

        // return (upper << 32) + lower
        return BigInteger.valueOf(Integer.toUnsignedLong(upper)).shiftLeft(32).add(BigInteger.valueOf(Integer.toUnsignedLong(lower)))
    }
}