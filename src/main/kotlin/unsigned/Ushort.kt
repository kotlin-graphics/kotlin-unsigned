package unsigned

import java.math.BigInteger
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 20.03.2017.
 */

data class Ushort(var v: Short = 0) : Number() {

    companion object {

        /** A constant holding the minimum value an <code>unsigned short</code> can have, 0.    */
        const val MIN_VALUE = 0x0000

        /** A constant holding the maximum value an <code>unsigned short</code> can have, 2<sup>16</sup>-1. */
        const val MAX_VALUE = 0xffff

        fun checkSigned(v: Number) = v.toInt() in MIN_VALUE..MAX_VALUE
    }

    constructor(number: Number) : this(number.toShort())
    @JvmOverloads constructor(string: String, base: Int = 10) :
            this(Integer.parseUnsignedInt(string.filter { it != '_' && it != '\'' }, base).toShort())

    override fun toByte() = v.toByte()
    override fun toShort() = v
    override fun toInt() = v.toUInt()
    override fun toLong() = v.toULong()

    fun toBigInt(): BigInteger = BigInteger.valueOf(toLong())

    override fun toDouble() = toInt().toDouble()
    override fun toFloat() = toInt().toFloat()

    override fun toChar() = v.toChar()

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

    fun inv() = Ushort(v.inv())

    operator fun compareTo(b: Ushort) = Integer.compareUnsigned(toInt(), b.toInt())
    operator fun compareTo(b: Short) = Integer.compareUnsigned(toInt(), b.toUInt())
    operator fun compareTo(b: Int) = Integer.compareUnsigned(toInt(), b)
}