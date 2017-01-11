import java.math.BigInteger

/**
 * Created by GBarbieri on 06.10.2016.
 */

infix fun Byte.udiv(b: Byte) = (toUInt() / b.toUInt()).toByte()
infix fun Byte.urem(b: Byte) = (toUInt() % b.toUInt()).toByte()
infix fun Byte.ucmp(b: Byte) = toUInt().compareTo(b.toUInt())
infix fun Byte.ushr(b: Byte) = (toUInt() ushr b.toUInt()).toByte()

infix fun Byte.udiv(b: Int) = (toUInt() / b).toByte()
infix fun Byte.urem(b: Int) = (toUInt() % b).toByte()
infix fun Byte.ucmp(b: Int) = toUInt().compareTo(b)
infix fun Byte.ushr(b: Int) = (toUInt() ushr b).toByte()

infix fun Short.udiv(b: Short) = (toUInt() / b.toUInt()).toShort()
infix fun Short.urem(b: Short) = (toUInt() % b.toUInt()).toShort()
infix fun Short.ucmp(b: Short) = toUInt().compareTo(b.toUInt())
infix fun Short.ushr(b: Short) = (toUInt() ushr b.toUInt()).toShort()

infix fun Short.udiv(b: Int) = (toUInt() / b).toShort()
infix fun Short.urem(b: Int) = (toUInt() % b).toShort()
infix fun Short.ucmp(b: Int) = toUInt().compareTo(b)
infix fun Short.ushr(b: Int) = (toUInt() ushr b).toShort()

infix fun Int.udiv(b: Byte) = Integer.divideUnsigned(this, b.toUInt())
infix fun Int.urem(b: Byte) = Integer.remainderUnsigned(this, b.toUInt())
infix fun Int.ucmp(b: Byte) = Integer.compareUnsigned(this, b.toUInt())
// Int.ushl(b: Int) is already provided by Kotlin lib
infix fun Int.udiv(b: Short) = Integer.divideUnsigned(this, b.toUInt())
infix fun Int.urem(b: Short) = Integer.remainderUnsigned(this, b.toUInt())
infix fun Int.ucmp(b: Short) = Integer.compareUnsigned(this, b.toUInt())
// Int.ushl(b: Int) is already provided by Kotlin lib
infix fun Int.udiv(b: Int) = Integer.divideUnsigned(this, b)
infix fun Int.urem(b: Int) = Integer.remainderUnsigned(this, b)
infix fun Int.ucmp(b: Int) = Integer.compareUnsigned(this, b)
// Int.ushl(b: Int) is already provided by Kotlin lib

infix fun Long.udiv(b: Long) = java.lang.Long.divideUnsigned(this, b)
infix fun Long.urem(b: Long) = java.lang.Long.remainderUnsigned(this, b)
infix fun Long.ucmp(b: Long) = java.lang.Long.compareUnsigned(this, b)
// Long.ushl(b: Long) is already provided by Kotlin lib

// TODO if == Ubyte?
fun Number.toUbyte() = Ubyte(toByte())
fun Number.toUint() = Uint(toInt())
fun Number.toUlong() = Ulong(toLong())
fun Number.toUshort() = Ushort(toShort())

fun Char.toUbyte() = Ubyte(toByte())
fun Char.toUint() = Uint(toInt())
fun Char.toUlong() = Ulong(toLong())
fun Char.toUshort() = Ushort(toShort())

fun Byte.toUInt() = toInt() and 0xff
fun Short.toUInt() = toInt() and 0xffff
fun Int.toULong() = toLong() and 0xffffffffL
fun Long.toUBigInt() = if (this < 0) BigInteger.valueOf(this) + Ulong.MAX_VALUE + BigInteger.ONE else BigInteger.valueOf(this)


data class Ubyte(var v: Byte = 0) : Number() {

    companion object {
        /**
         * A constant holding the minimum value an <code>unsigned byte</code> can have, 0.
         */
        const val MIN_VALUE = 0x00
        /**
         * A constant holding the maximum value an <code>unsigned byte</code> can have, 2<sup>8</sup>-1.
         */
        const val MAX_VALUE = 0xff

        fun checkSigned(v: Number) = v.toInt() >= MIN_VALUE && v.toInt() <= MAX_VALUE
    }


    constructor(number: Number) : this(number.toByte())
    constructor(string: String) : this(Integer.parseUnsignedInt(string).toByte())


    fun toBigInteger() = BigInteger.valueOf(toLong())
    override fun toDouble() = toInt().toDouble()
    override fun toFloat() = toInt().toFloat()
    override fun toLong() = toInt().toLong()
    override fun toInt() = v.toUInt()
    override fun toChar() = toInt().toChar()
    override fun toShort() = toInt().toShort()
    override fun toByte() = v

    fun toUbyte() = this
    fun toUlong() = Ulong(toInt())
    fun toUint() = Uint(toInt())
    fun toUshort() = Ushort(toInt())

    operator fun inc() = Ubyte(v + 1)
    operator fun dec() = Ubyte(v - 1)

    infix operator fun plus(b: Ubyte) = Ubyte(toInt() + b.toInt())
    infix operator fun plus(b: Byte) = Ubyte(toInt() + b.toUInt())
    infix operator fun plus(b: Int) = Ubyte(toInt() + b)

    infix operator fun minus(b: Ubyte) = Ubyte(toInt() - b.toInt())
    infix operator fun minus(b: Byte) = Ubyte(toInt() - b.toUInt())
    infix operator fun minus(b: Int) = Ubyte(toInt() - b)

    infix operator fun times(b: Ubyte) = Ubyte(toInt() * b.toInt())
    infix operator fun times(b: Byte) = Ubyte(toInt() * b.toUInt())
    infix operator fun times(b: Int) = Ubyte(toInt() * b)

    infix operator fun div(b: Ubyte) = Ubyte(toInt() / b.toInt())
    infix operator fun div(b: Byte) = Ubyte(toInt() / b.toUInt())
    infix operator fun div(b: Int) = Ubyte(Integer.divideUnsigned(toInt(), b))

    infix operator fun rem(b: Ubyte) = Ubyte(toInt() % b.toInt())
    infix operator fun rem(b: Byte) = Ubyte(toInt() % b.toUInt())
    infix operator fun rem(b: Int) = Ubyte(Integer.remainderUnsigned(toInt(), b))

    // TODO add counterparts with res
    infix fun and(b: Ubyte) = Ubyte(v and b.v)
    infix fun and(b: Byte) = Ubyte(v and b)
    infix fun and(b: Int) = Ubyte(toInt() and b)

    infix fun or(b: Ubyte) = Ubyte(toInt() or b.toInt())
    infix fun or(b: Byte) = Ubyte(toInt() or b.toUInt())
    infix fun or(b: Int) = Ubyte(toInt() or b)

    infix fun xor(b: Ubyte) = Ubyte(toInt() xor b.toInt())
    infix fun xor(b: Byte) = Ubyte(toInt() xor b.toUInt())
    infix fun xor(b: Int) = Ubyte(toInt() xor b)

    infix fun shl(b: Ubyte) = Ubyte(toInt() shl b.toInt())
    infix fun shl(b: Byte) = Ubyte(toInt() shl b.toUInt())
    infix fun shl(b: Int) = Ubyte(toInt() shl b)

    infix fun shr(b: Ubyte) = Ubyte(toInt() ushr b.toInt())
    infix fun shr(b: Byte) = Ubyte(toInt() ushr b.toUInt())
    infix fun shr(b: Int) = Ubyte(toInt() ushr b)

    fun inv() = Ubyte(toInt().inv())

    operator fun compareTo(b: Ubyte) = Integer.compareUnsigned(toInt(), b.toInt())
    operator fun compareTo(b: Byte) = Integer.compareUnsigned(toInt(), b.toUInt())
    operator fun compareTo(b: Int) = Integer.compareUnsigned(toInt(), b)
}

data class Uint(var v: Int = 0) : Number() {

    companion object {
        /**
         * A constant holding the minimum value an <code>unsigned int</code> can have, 0.
         */
        const val MIN_VALUE = 0x00000000
        /**
         * A constant holding the maximum value an <code>unsigned int</code> can have, 2<sup>32</sup>-1.
         */
        const val MAX_VALUE = 0xffffffffL

        fun checkSigned(v: Number) = v.toLong() >= MIN_VALUE && v.toLong() <= MAX_VALUE
    }


    constructor(number: Number) : this(number.toInt())
    constructor(string: String, base: Int = 10) : this(Integer.parseUnsignedInt(string.filter { it != '_' && it != '\'' },  base))


    fun toBigInteger() = BigInteger.valueOf(toLong())
    override fun toDouble() = toLong().toDouble()
    override fun toFloat() = toLong().toFloat()
    override fun toLong() = v.toULong()
    override fun toInt() = v
    override fun toChar() = v.toChar()
    override fun toShort() = v.toShort()
    override fun toByte() = v.toByte()

    fun toUbyte() = Ubyte(toInt())
    fun toUshort() = Ushort(toInt())
    fun toUlong() = Ulong(toLong())

    operator fun inc() = Uint(v + 1)
    operator fun dec() = Uint(v - 1)

    infix operator fun plus(b: Uint) = Uint(v + b.v)
    infix operator fun plus(b: Int) = Uint(v + b)

    infix operator fun minus(b: Uint) = Uint(v - b.v)
    infix operator fun minus(b: Int) = Uint(v - b)

    infix operator fun times(b: Uint) = Uint(v * b.v)
    infix operator fun times(b: Int) = Uint(v * b)

    infix operator fun div(b: Uint) = Uint(Integer.divideUnsigned(v, b.toInt()))
    infix operator fun div(b: Int) = Uint(Integer.divideUnsigned(v, b))

    infix operator fun rem(b: Uint) = Uint(Integer.remainderUnsigned(v, b.toInt()))
    infix operator fun rem(b: Int) = Uint(Integer.remainderUnsigned(v, b))

    infix fun and(b: Uint) = Uint(v and b.toInt())
    infix fun and(b: Int) = Uint(v and b)

    infix fun or(b: Uint) = Uint(v or b.toInt())
    infix fun or(b: Int) = Uint(v or b)

    infix fun xor(b: Uint) = Uint(v xor b.toInt())
    infix fun xor(b: Int) = Uint(v xor b)

    infix fun shl(b: Uint) = Uint(v shl b.toInt())
    infix fun shl(b: Int) = Uint(v shl b)

    infix fun shr(b: Uint) = Uint(v ushr b.toInt())
    infix fun shr(b: Int) = Uint(v ushr b)

    fun inv() = Uint(v.inv())


    operator fun compareTo(b: Uint) = Integer.compareUnsigned(v, b.toInt())
    operator fun compareTo(b: Int) = Integer.compareUnsigned(v, b)
    // TODO long
}

data class Ulong(var v: Long = 0) : Number(), Comparable<Ulong> {

    companion object {
        /**
         * A constant holding the minimum value an <code>unsigned long</code> can have, 0.
         */
        val MIN_VALUE = BigInteger.ZERO
        /**
         * A constant holding the maximum value an <code>unsigned long</code> can have, 2<sup>64</sup>-1.
         */
        val MAX_VALUE = BigInteger("18446744073709551615")

        fun checkSigned(v: Number) = BigInteger.valueOf(v.toLong()) >= MIN_VALUE && BigInteger.valueOf(v.toLong()) <= MAX_VALUE
    }

    constructor(number: Number) : this(number.toLong())
    constructor(string: String, base: Int = 10) : this(java.lang.Long.parseUnsignedLong(string.filter { it != '_' && it != '\'' }, base))

    fun toBigInteger() = if (v < 0) BigInteger.valueOf(v) + MAX_VALUE + BigInteger.ONE else BigInteger.valueOf(v)
    override fun toDouble() = toBigInteger().toDouble()
    override fun toFloat() = toBigInteger().toFloat()
    override fun toLong() = v
    override fun toInt() = v.toInt()
    override fun toChar() = v.toChar()
    override fun toShort() = v.toShort()
    override fun toByte() = v.toByte()

    fun toUint() = Uint(toInt())
    fun toUshort() = Ushort(toInt())
    fun toUbyte() = Ubyte(toInt())

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

data class Ushort(var v: Short = 0) : Number() {

    companion object {
        /**
         * A constant holding the minimum value an <code>unsigned short</code> can have, 0.
         */
        const val MIN_VALUE = 0x0000
        /**
         * A constant holding the maximum value an <code>unsigned short</code> can have, 2<sup>16</sup>-1.
         */
        const val MAX_VALUE = 0xffff

        fun checkSigned(v: Number) = v.toInt() >= MIN_VALUE && v.toInt() <= MAX_VALUE
    }


    constructor(number: Number) : this(number.toShort())
    constructor(string: String, base:Int = 10) : this(Integer.parseUnsignedInt(string.filter { it != '_' && it != '\'' }, base).toShort())


    fun toBigInteger() = BigInteger.valueOf(toLong())
    override fun toDouble() = toInt().toDouble()
    override fun toFloat() = toInt().toFloat()
    override fun toLong() = toInt().toLong()
    override fun toInt() = v.toUInt()
    override fun toChar() = v.toChar()
    override fun toShort() = v
    override fun toByte() = v.toByte()

    fun toUlong() = Ulong(toInt())
    fun toUint() = Uint(toInt())
    fun toUbyte() = Ubyte(toInt())

    operator fun inc() = Ushort(v + 1)
    operator fun dec() = Ushort(v - 1)

    infix operator fun plus(b: Ushort) = Ushort(toInt() + b.toInt())
    infix operator fun plus(b: Short) = Ushort(toInt() + b.toUInt())
    infix operator fun plus(b: Int) = Ushort(toInt() + b)

    infix operator fun minus(b: Ushort) = Ushort(toInt() - b.toInt())
    infix operator fun minus(b: Short) = Ushort(toInt() - b.toUInt())
    infix operator fun minus(b: Int) = Ushort(toInt() - b)

    infix operator fun times(b: Ushort) = Ushort(toInt() * b.toInt())
    infix operator fun times(b: Short) = Ushort(toInt() * b.toUInt())
    infix operator fun times(b: Int) = Ushort(toInt() * b)

    infix operator fun div(b: Ushort) = Ushort(toInt() / b.toInt())
    infix operator fun div(b: Short) = Ushort(toInt() / b.toUInt())
    infix operator fun div(b: Int) = Ushort(Integer.divideUnsigned(toInt(), b))

    infix operator fun rem(b: Ushort) = Ushort(toInt() % b.toInt())
    infix operator fun rem(b: Short) = Ushort(toInt() % b.toUInt())
    infix operator fun rem(b: Int) = Ushort(Integer.remainderUnsigned(toInt(), b))

    infix fun and(b: Ushort) = Ushort(v and b.v)
    infix fun and(b: Short) = Ushort(v and b)
    infix fun and(b: Int) = Ushort(toInt() and b)

    infix fun or(b: Ushort) = Ushort(v or b.v)
    infix fun or(b: Short) = Ushort(v or b)
    infix fun or(b: Int) = Ushort(toInt() or b)

    infix fun xor(b: Ushort) = Ushort(v xor b.v)
    infix fun xor(b: Short) = Ushort(v xor b)
    infix fun xor(b: Int) = Ushort(toInt() xor b)

    infix fun shl(b: Ushort) = Ushort(toInt() shl b.toInt())
    infix fun shl(b: Short) = Ushort(toInt() shl b.toUInt())
    infix fun shl(b: Int) = Ushort(toInt() shl b)

    infix fun shr(b: Ushort) = Ushort(toInt() ushr b.toInt())
    infix fun shr(b: Short) = Ushort(toInt() ushr b.toUInt())
    infix fun shr(b: Int) = Ushort(toInt() ushr b)

    fun inv() = Ushort(toInt().inv())

    operator fun compareTo(b: Ushort) = Integer.compareUnsigned(toInt(), b.toInt())
    operator fun compareTo(b: Short) = Integer.compareUnsigned(toInt(), b.toUInt())
    operator fun compareTo(b: Int) = Integer.compareUnsigned(toInt(), b)
}


operator fun Byte.plus(b: Ubyte): Byte = (toUInt() + b.toInt()).toByte()
operator fun Byte.minus(b: Ubyte) = (toUInt() - b.toInt()).toByte()
operator fun Byte.times(b: Ubyte) = (toUInt() * b.toInt()).toByte()
operator fun Byte.div(b: Ubyte) = (toUInt() / b.toInt()).toByte()
operator fun Byte.rem(b: Ubyte) = (toUInt() % b.toInt()).toByte()
infix fun Byte.and(b: Ubyte) = (this and b.v).toByte()
infix fun Byte.or(b: Ubyte) = (this or b.v).toByte()
infix fun Byte.xor(b: Ubyte) = (this xor b.v).toByte()
infix fun Byte.shl(b: Ubyte) = (toUInt() shl b.toInt()).toByte()
infix fun Byte.shr(b: Ubyte) = (toUInt() shr b.toInt()).toByte()
fun Byte.inv() = toUInt().inv().toByte()
infix operator fun Byte.compareTo(b: Ubyte) = Integer.compareUnsigned(toUInt(), b.toInt())


operator fun Int.plus(b: Ubyte) = this + b.toInt()
operator fun Int.minus(b: Ubyte) = this - b.toInt()
operator fun Int.times(b: Ubyte) = this * b.toInt()
operator fun Int.div(b: Ubyte) = Integer.divideUnsigned(this, b.toInt())
operator fun Int.rem(b: Ubyte) = Integer.remainderUnsigned(this, b.toInt())
infix fun Int.and(b: Ubyte) = this and b.toInt()
infix fun Int.or(b: Ubyte) = this or b.toInt()
infix fun Int.xor(b: Ubyte) = this xor b.toInt()
infix fun Int.shl(b: Ubyte) = this shl b.toInt()
infix fun Int.shr(b: Ubyte) = this shr b.toInt()
// Int.inv() is already provided by Kotlin lib
infix operator fun Int.compareTo(b: Ubyte) = Integer.compareUnsigned(this, b.toInt())


operator fun Int.plus(b: Uint) = this + b.toInt()
operator fun Int.minus(b: Uint) = this - b.toInt()
operator fun Int.times(b: Uint) = this * b.toInt()
operator fun Int.div(b: Uint) = Integer.divideUnsigned(this, b.toInt())
operator fun Int.rem(b: Uint) = Integer.remainderUnsigned(this, b.toInt())
infix fun Int.and(b: Uint) = this and b.toInt()
infix fun Int.or(b: Uint) = this or b.toInt()
infix fun Int.xor(b: Uint) = this xor b.toInt()
infix fun Int.shl(b: Uint) = this shl b.toInt()
infix fun Int.shr(b: Uint) = this shr b.toInt()
// Int.inv() is already provided by Kotlin lib
infix operator fun Int.compareTo(b: Uint) = Integer.compareUnsigned(this, b.toInt())


operator fun Long.plus(b: Ulong) = this + b.toLong()
operator fun Long.minus(b: Ulong) = this - b.toLong()
operator fun Long.times(b: Ulong) = this * b.toLong()
operator fun Long.div(b: Ulong) = java.lang.Long.divideUnsigned(this, b.toLong())
operator fun Long.rem(b: Ulong) = java.lang.Long.remainderUnsigned(this, b.toLong())
infix fun Long.and(b: Ulong) = this and b.toLong()
infix fun Long.or(b: Ulong) = this or b.toLong()
infix fun Long.xor(b: Ulong) = this xor b.toLong()
// no main.shl, main.shr, since they need int
infix operator fun Long.compareTo(b: Ulong) = java.lang.Long.compareUnsigned(this, b.toLong())


operator fun Short.plus(b: Ushort) = (toInt() + b.toInt()).toShort()
operator fun Short.minus(b: Ushort) = (toInt() - b.toInt()).toShort()
operator fun Short.times(b: Ushort) = (toInt() * b.toInt()).toShort()
operator fun Short.div(b: Ushort) = (toUInt() / b.toInt()).toShort()
operator fun Short.rem(b: Ushort) = (toUInt() % b.toInt()).toShort()
infix fun Short.and(b: Ushort) = (this and b.v).toShort()
infix fun Short.or(b: Ushort) = (this or b.v).toShort()
infix fun Short.xor(b: Ushort) = (this xor b.v).toShort()
infix fun Short.shl(b: Ushort) = (toInt() shl b.toInt()).toShort()
infix fun Short.shr(b: Ushort) = (toInt() shr b.toInt()).toShort()
fun Short.inv() = toUInt().inv().toShort()
infix operator fun Short.compareTo(b: Ushort) = Integer.compareUnsigned(toUInt(), b.toInt())


operator fun Int.plus(b: Ushort) = this + b.toInt()
operator fun Int.minus(b: Ushort) = this - b.toInt()
operator fun Int.times(b: Ushort) = this * b.toInt()
operator fun Int.div(b: Ushort) = Integer.divideUnsigned(this, b.toInt())
operator fun Int.rem(b: Ushort) = Integer.remainderUnsigned(this, b.toInt())
infix fun Int.and(b: Ushort) = this and b.toInt()
infix fun Int.or(b: Ushort) = this or b.toInt()
infix fun Int.xor(b: Ushort) = this xor b.toInt()
infix fun Int.shl(b: Ushort) = this shl b.toInt()
infix fun Int.shr(b: Ushort) = this shr b.toInt()
// Int.inv() is already provided by Kotlin lib
infix operator fun Int.compareTo(b: Ushort) = Integer.compareUnsigned(this, b.toInt())