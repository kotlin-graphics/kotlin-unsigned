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
        i /= _radix
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
        buf[offset + --charPos] = digits[_this.toInt() and mask]
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
        return BigInteger.valueOf(upper.toUnsignedLong()).shiftLeft(32).add(BigInteger.valueOf(lower.toUnsignedLong()))
    }
}

@Throws(NumberFormatException::class)
fun String.parseUnsignedLong(radix: Int = 10): Long {

    if (length > 0) {
        val firstChar = this[0]
        if (firstChar == '-')
            throw NumberFormatException(String.format("Illegal leading minus sign on unsigned string $this."))
        else {
            if (length <= 12 || // Long.MAX_VALUE in Character.MAX_RADIX is 13 digits
                    radix == 10 && length <= 18) // Long.MAX_VALUE in base 10 is 19 digits
                return this.toLong(radix)

            // No need for range checks on len due to testing above.
            val first = substring(0, length - 1).toLong(radix)
            val second = Character.digit(this[length - 1], radix)
            if (second < 0)
                throw NumberFormatException("Bad digit at end of $this")
            val result = first * radix + second
            if (result compareUnsigned first < 0) {
                /*  The maximum unsigned value, (2^64)-1, takes at most one more digit to represent than the maximum
                    signed value, (2^63)-1.  Therefore, parsing (len - 1) digits will be appropriately in-range of the
                    signed parsing.  In other words, if parsing (len -1) digits overflows signed parsing, parsing len
                    digits will certainly overflow unsigned parsing.

                    The compareUnsigned check above catches situations where an unsigned overflow occurs incorporating
                    the contribution of the final digit.    */
                throw NumberFormatException(String.format("String value $this exceeds range of unsigned long."))
            }
            return result
        }
    } else throw NumberFormatException("For input string: $this")
}

infix fun Long.compareUnsigned(b: Long) = compare(this + Long.MIN_VALUE, b + Long.MIN_VALUE)

fun compare(a: Long, b: Long) = if (a < b) -1 else if (a == b) 0 else 1

infix fun Long.divideUnsigned(divisor: Long): Long {
    if (divisor < 0L) // signed comparison
    // Answer must be 0 or 1 depending on relative magnitude
    // of dividend and divisor.
        return if (compareUnsigned(divisor) < 0) 0L else 1L

    if (this > 0)
    //  Both inputs non-negative
        return this / divisor
    else
    /*
         * For simple code, leveraging BigInteger.  Longer and faster
         * code written directly in terms of operations on longs is
         * possible; see "Hacker's Delight" for divide and remainder
         * algorithms.
         */
        return toUnsignedBigInteger().divide(divisor.toUnsignedBigInteger()).toLong()
}

infix fun Long.remainderUnsigned(divisor: Long): Long {
    if (this > 0 && divisor > 0) // signed comparisons
        return this % divisor
    else
        if (compareUnsigned(divisor) < 0)
        // Avoid explicit check for 0 divisor
            return this
        else
            return toUnsignedBigInteger().remainder(divisor.toUnsignedBigInteger()).toLong()
}