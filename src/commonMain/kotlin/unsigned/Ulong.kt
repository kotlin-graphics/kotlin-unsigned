package unsigned
//
//import com.ionspin.kotlin.bignum.integer.BigInteger
//
///**
// * Created by GBarbieri on 20.03.2017.
// */
//
//data class Ulong(var v: Long = 0) : Number(), Comparable<Ulong> {
//
//    companion object {
//
//        /** A constant holding the minimum value an <code>unsigned long</code> can have, 0. */
//        val MIN_VALUE: BigInteger = BigInteger.ZERO
//
//        /** A constant holding the maximum value an <code>unsigned long</code> can have, 2<sup>64</sup>-1.  */
//        val MAX_VALUE = BigInteger.parseString("18446744073709551615")
//
//        /** A constant holding the minimum value an <code>unsigned long</code> can have, 0. */
//        val MIN = Ulong(0L)
//
//        /** A constant holding the maximum value an <code>unsigned long</code> can have, 2<sup>64</sup>-1.  */
//        val MAX = Ulong(-1L)
//
//        fun checkSigned(v: Number) = BigInteger.fromLong(v.toLong()) in MIN_VALUE..MAX_VALUE
//    }
//
//    constructor(number: Number) : this(number.toLong())
//    constructor(string: String, base: Int = 10) : this(string.filter { it != '_' && it != '\'' }.parseUnsignedLong(base))
//
//    override fun toByte(): Byte = v.toByte()
//    override fun toShort(): Short = v.toShort()
//    override fun toInt(): Int = v.toInt()
//    override fun toLong(): Long = v
//
//    fun toBigInt(): BigInteger = BigInteger.fromULong(v.toULong())
//
//    override fun toDouble(): Double = toBigInt().doubleValue()
//    override fun toFloat(): Float = toBigInt().floatValue()
//
//    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it's recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith = ReplaceWith("this.toInt().toChar()"))
//    override fun toChar(): Char = v.toInt().toChar()
//
//    operator fun inc(): Ulong = Ulong(v + 1)
//    operator fun dec(): Ulong = Ulong(v - 1)
//
//    infix operator fun plus(b: Ulong): Ulong = Ulong(v + b.v)
//    infix operator fun plus(b: Long): Ulong = Ulong(v + b)
//
//    infix operator fun minus(b: Ulong): Ulong = Ulong(v - b.v)
//    infix operator fun minus(b: Long): Ulong = Ulong(v - b)
//
//    infix operator fun times(b: Ulong): Ulong = Ulong(v * b.v)
//    infix operator fun times(b: Long): Ulong = Ulong(v * b)
//
//    infix operator fun div(b: Ulong) = Ulong(v divideUnsigned b.toLong())
//    infix operator fun div(b: Long) = Ulong(v divideUnsigned b)
//
//    infix operator fun rem(b: Ulong) = Ulong(v remainderUnsigned b.toLong())
//    infix operator fun rem(b: Long) = Ulong(v remainderUnsigned b)
//
//    infix fun and(b: Ulong) = Ulong(v and b.toLong())
//    infix fun and(b: Long) = Ulong(v and b)
//
//    infix fun or(b: Ulong) = Ulong(v or b.toLong())
//    infix fun or(b: Long) = Ulong(v or b)
//
//    infix fun xor(b: Ulong) = Ulong(v xor b.toLong())
//    infix fun xor(b: Long) = Ulong(v xor b)
//
//    infix fun shl(b: Int) = Ulong(v shl b)
//
//    infix fun shr(b: Int) = Ulong(v ushr b)
//
//    fun inv() = Ulong(v.inv())
//
//    override operator fun compareTo(other: Ulong) = v compareUnsigned other.toLong()
//    operator fun compareTo(other: Long) = v compareUnsigned other
//
//    // TODO others
//
//    override fun equals(other: Any?) = other is Ulong && v == other.v
//    override fun hashCode(): Int = v.hashCode()
//    override fun toString() = toBigInt().toString()
//    fun toString(radix: Int) = toBigInt().toString(radix)
//    fun toString(format: String) = format.format(toBigInt())
//
//    operator fun rangeTo(b: Ulong) = UlongRange(this, b)
//
//    class UlongRange(override val start: Ulong, override val endInclusive: Ulong) : ClosedRange<Ulong>, Iterable<Ulong> {
//
//        override fun iterator(): Iterator<Ulong> = UlongIterator(this)
//
//        override fun contains(value: Ulong): Boolean = value in start..endInclusive
//    }
//
//    class UlongIterator(val ulongRange: UlongRange) : Iterator<Ulong> {
//        var current = ulongRange.start
//        override fun next(): Ulong {
//            val result = current
//            current++
//            return result
//        }
//
//        override fun hasNext() = current <= ulongRange.endInclusive
//    }
//}