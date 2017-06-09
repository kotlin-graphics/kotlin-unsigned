package unsigned.java_1_7

import java.math.BigInteger


// In lieu of tricky code, for now just use long arithmetic.
fun Int.divideUnsigned(divisor: Int) = (toUnsignedLong() / divisor.toUnsignedLong()).toInt()

fun Int.toUnsignedLong() = toLong() and 0xffffffffL

// In lieu of tricky code, for now just use long arithmetic.
fun Int.remainderUnsigned(divisor: Int) = (toUnsignedLong() % divisor.toUnsignedLong()).toInt()

fun Int.compareUnsigned(b: Int) = compare(this + Int.MIN_VALUE, b + Int.MIN_VALUE)

fun compare(x: Int, y: Int) = if (x < y) -1 else if (x == y) 0 else 1

@Throws(NumberFormatException::class)
fun String.parseUnsignedInt(radix: Int): Int {

    val len = length
    if (len > 0) {
        val firstChar = this[0]
        if (firstChar == '-')
            throw NumberFormatException(String.format("Illegal leading minus sign " + "on unsigned string %s.", this))
        else {
            if (len <= 5 || // Integer.MAX_VALUE in Character.MAX_RADIX is 6 digits
                    radix == 10 && len <= 9) // Integer.MAX_VALUE in base 10 is 10 digits
                return this.toInt(radix)
            else {
                val ell = this.toLong(radix)
                if (ell and BigInteger("0xffff_ffff_0000_0000").toLong() == 0L)
                    return ell.toInt()
                else
                    throw NumberFormatException(String.format("String value %s exceeds " + "range of unsigned int.", this))
            }
        }
    } else throw NumberFormatException("For input string: $this")
}