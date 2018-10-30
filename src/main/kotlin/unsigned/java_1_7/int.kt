package unsigned.java_1_7

import java.math.BigInteger


// In lieu of tricky code, for now just use long arithmetic.
infix fun Int.divideUnsigned(divisor: Int) = (toUnsignedLong() / divisor.toUnsignedLong()).toInt()

fun Int.toUnsignedLong() = toLong() and 0xffffffffL

// In lieu of tricky code, for now just use long arithmetic.
infix fun Int.remainderUnsigned(divisor: Int) = (toUnsignedLong() % divisor.toUnsignedLong()).toInt()

infix fun Int.compareUnsigned(b: Int) = compare(this + Int.MIN_VALUE, b + Int.MIN_VALUE)

fun compare(a: Int, b: Int) = if (a < b) -1 else if (a == b) 0 else 1

@Throws(NumberFormatException::class)
fun String.parseUnsignedInt(radix: Int): Int {

    if (length > 0) {
        return when (this[0]) {
            '-' -> throw NumberFormatException(String.format("Illegal leading minus sign " + "on unsigned string %s.", this))
            else -> when {
                length <= 5 || /* Integer.MAX_VALUE in Character.MAX_RADIX is 6 digits */ radix == 10 && length <= 9 /* Integer.MAX_VALUE in base 10 is 10 digits*/ -> this.toInt(radix)
                else -> {
                    val ell = this.toLong(radix)
                    when {
                        ell and BigInteger("ffffffff00000000", 16).toLong() == 0L -> ell.toInt()
                        else -> throw NumberFormatException(String.format("String value %s exceeds " + "range of unsigned int.", this))
                    }
                }
            }
        }
    } else throw NumberFormatException("For input string: $this")
}