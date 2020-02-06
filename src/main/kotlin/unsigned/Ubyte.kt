package unsigned

import java.math.BigInteger
import kotlin.experimental.and
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 20.03.2017.
 */

class Ubyte(var v: Byte) : Number(), Comparable<Ubyte> {

    companion object {

        /** A constant holding the minimum value an <code>unsigned byte</code> can have, 0. */
        const val MIN_VALUE: Int = 0
        /** A constant holding the maximum value an <code>unsigned byte</code> can have, 2<sup>8</sup>-1.   */
        const val MAX_VALUE: Int = 0xff

        /** A constant holding the minimum value an <code>unsigned byte</code> can have, 0. */
        val MIN = Ubyte(0)
        /** A constant holding the maximum value an <code>unsigned byte</code> can have, 2<sup>8</sup>-1.   */
        val MAX = Ubyte(0xff)

        fun checkSigned(v: Number) = v.toInt() in MIN_VALUE..MAX_VALUE
    }

    constructor(number: Number) : this(number.toByte())
    @JvmOverloads
    constructor(string: String, base: Int = 10) : this(string.filter { it != '_' && it != '\'' }.parseUnsignedInt(base).toByte())

    override fun toByte() = v
    override fun toShort() = v.toUInt().toShort()
    override fun toInt() = v.toUInt()
    override fun toLong() = v.toULong()

    fun toBigInt(): BigInteger = BigInteger.valueOf(toLong())

    override fun toDouble() = toInt().toDouble()
    override fun toFloat() = toInt().toFloat()

    override fun toChar() = toInt().toChar()

    fun toUbyte() = this
    fun toUshort() = Ushort(toInt())
    fun toUint() = Uint(toInt())
    fun toUlong() = Ulong(toInt())

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
    infix operator fun div(b: Int) = Ubyte(toInt() udiv b)

    infix operator fun rem(b: Ubyte) = Ubyte(toInt() % b.toInt())
    infix operator fun rem(b: Byte) = Ubyte(toInt() % b.toUInt())
    infix operator fun rem(b: Int) = Ubyte(toInt() urem b)

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

    fun inv() = Ubyte(v.inv())

    override operator fun compareTo(other: Ubyte) = toInt() compareUnsigned other.toInt()
    operator fun compareTo(other: Byte) = toInt() compareUnsigned other.toUInt()
    operator fun compareTo(other: Int) = toInt() compareUnsigned other

    override fun equals(other: Any?) = other is Ubyte && v == other.v
    override fun hashCode(): Int = v.hashCode()
    override fun toString() = toInt().toString()
    fun toString(radix: Int) = toInt().toString(radix)
    fun toString(format: String) = format.format(toInt())
}
