package unsigned

import java.math.BigInteger

/**
 * Created by GBarbieri on 20.03.2017.
 */

data class Uint(var v: Int = 0) : Number() {

    companion object {

        /** A constant holding the minimum value an <code>unsigned int</code> can have, 0.  */
        const val MIN_VALUE = 0x00000000

        /** A constant holding the maximum value an <code>unsigned int</code> can have, 2<sup>32</sup>-1.   */
        const val MAX_VALUE = 0xffffffffL

        fun checkSigned(v: Number) = v.toLong() in MIN_VALUE..MAX_VALUE
    }


    constructor(number: Number) : this(number.toInt())
    @JvmOverloads constructor(string: String, base: Int = 10) : this(Integer.parseUnsignedInt(string.filter { it != '_' && it != '\'' }, base))

    override fun toByte() = v.toByte()
    override fun toShort() = v.toShort()
    override fun toInt() = v
    override fun toLong() = v.toULong()

    fun toBigInt(): BigInteger = BigInteger.valueOf(toLong())

    override fun toDouble() = toLong().toDouble()
    override fun toFloat() = toLong().toFloat()

    override fun toChar() = v.toChar()

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

    // TODO long?
}