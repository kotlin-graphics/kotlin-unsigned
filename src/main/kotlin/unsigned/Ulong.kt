package unsigned

import java.math.BigInteger

/**
 * Created by GBarbieri on 20.03.2017.
 */

data class Ulong(var v: Long = 0) : Number(), Comparable<Ulong> {

    companion object {

        /** A constant holding the minimum value an <code>unsigned long</code> can have, 0. */
        val MIN_VALUE: BigInteger = BigInteger.ZERO

        /** A constant holding the maximum value an <code>unsigned long</code> can have, 2<sup>64</sup>-1.  */
        val MAX_VALUE = BigInteger("18446744073709551615")

        fun checkSigned(v: Number) = BigInteger.valueOf(v.toLong()) in MIN_VALUE..MAX_VALUE
    }

    constructor(number: Number) : this(number.toLong())
    constructor(string: String, base: Int = 10) : this(java.lang.Long.parseUnsignedLong(string.filter { it != '_' && it != '\'' }, base))

    override fun toByte() = v.toByte()
    override fun toShort() = v.toShort()
    override fun toInt() = v.toInt()
    override fun toLong() = v

    fun toBigInt(): BigInteger = BigInteger(java.lang.Long.toUnsignedString(v))

    override fun toDouble() = toBigInt().toDouble()
    override fun toFloat() = toBigInt().toFloat()

    override fun toChar() = v.toChar()

    operator fun inc() = Ulong(v + 1)
    operator fun dec() = Ulong(v - 1)

    infix operator fun plus(b: Ulong) = Ulong(v + b.v)
    infix operator fun plus(b: Long) = Ulong(v + b)

    infix operator fun minus(b: Ulong) = Ulong(v - b.v)
    infix operator fun minus(b: Long) = Ulong(v - b)

    infix operator fun times(b: Ulong) = Ulong(v * b.v)
    infix operator fun times(b: Long) = Ulong(v * b)

    infix operator fun div(b: Ulong) = Ulong(java.lang.Long.divideUnsigned(v, b.toLong()))
    infix operator fun div(b: Long) = Ulong(java.lang.Long.divideUnsigned(v, b))

    infix operator fun rem(b: Ulong) = Ulong(java.lang.Long.remainderUnsigned(v, b.toLong()))
    infix operator fun rem(b: Long) = Ulong(java.lang.Long.remainderUnsigned(v, b))

    infix fun and(b: Ulong) = Ulong(v and b.toLong())
    infix fun and(b: Long) = Ulong(v and b)

    infix fun or(b: Ulong) = Ulong(v or b.toLong())
    infix fun or(b: Long) = Ulong(v or b)

    infix fun xor(b: Ulong) = Ulong(v xor b.toLong())
    infix fun xor(b: Long) = Ulong(v xor b)

    infix fun shl(b: Int) = Ulong(v shl b)

    infix fun shr(b: Int) = Ulong(v ushr b)

    fun inv() = Ulong(v.inv())

    override operator fun compareTo(other: Ulong) = java.lang.Long.compareUnsigned(v, other.toLong())
    operator fun compareTo(other: Long) = java.lang.Long.compareUnsigned(v, other)

    // TODO others

    operator fun rangeTo(b: Ulong) = UlongRange(this, b)

    class UlongRange(override val start: Ulong, override val endInclusive: Ulong) : ClosedRange<Ulong>, Iterable<Ulong> {

        override fun iterator(): Iterator<Ulong> = UlongIterator(this)

        override fun contains(value: Ulong) = start <= value && value <= endInclusive
    }

    class UlongIterator(val ulongRange: UlongRange) : Iterator<Ulong> {
        var current = ulongRange.start
        override fun next(): Ulong {
            val result = current
            current++
            return result
        }

        override fun hasNext() = current <= ulongRange.endInclusive
    }
}