/**
 * Created by GBarbieri on 30.01.2017.
 */

package unsigned

import java.math.BigInteger


fun Int.toUByte() = toByte()
fun Int.toUShort() = toShort()
fun Int.toULong() = toLong() and 0xffffffffL

fun Int.toUbyte() = Ubyte(this)
fun Int.toUshort() = Ushort(this)
fun Int.toUint() = Uint(this)
fun Int.toUlong() = Ulong(toULong())

fun Int.toBigInt(): BigInteger = BigInteger.valueOf(toLong())
fun Int.toUBigInt(): BigInteger = BigInteger.valueOf(toULong())

val Int.ub
    get() = toUbyte()
val Int.ui
    get() = toUint()
val Int.ul
    get() = toUlong()
val Int.us
    get() = toUshort()

infix fun Int.udiv(b: Byte) = (toULong() / b.toUInt()).toInt()
infix fun Int.urem(b: Byte) = (toULong() % b.toUInt()).toInt()
infix fun Int.ucmp(b: Byte) = toULong().compareTo(b.toUInt())
infix fun Int.ushr(b: Byte) = (toULong() ushr b.toUInt()).toInt()

infix fun Int.udiv(b: Short) = (toULong() / b.toUInt()).toInt()
infix fun Int.urem(b: Short) = (toULong() % b.toUInt()).toInt()
infix fun Int.ucmp(b: Short) = toULong().compareTo(b.toUInt())
infix fun Int.ushr(b: Short) = (toULong() ushr b.toUInt()).toInt()

infix fun Int.udiv(b: Int) = (toULong() / b.toULong()).toInt()
infix fun Int.urem(b: Int) = (toULong() % b.toULong()).toInt()
infix fun Int.ucmp(b: Int) = toULong().compareTo(b.toULong())
// Int.ushr is already offered by the Kotlin lib

infix fun Int.udiv(b: Long) = (toBigInt() / b.toBigInt()).toInt()
infix fun Int.urem(b: Long) = (toBigInt() % b.toBigInt()).toInt()
infix fun Int.ucmp(b: Long) = toBigInt().compareTo(b.toBigInt())
// no Int ushr Long


operator fun Int.plus(b: Ubyte) = this + b.v
operator fun Int.minus(b: Ubyte) = this - b.v
operator fun Int.times(b: Ubyte) = this * b.v
infix fun Int.and(b: Ubyte) = this and b.toInt()
infix fun Int.or(b: Ubyte) = this or b.toInt()
infix fun Int.xor(b: Ubyte) = this xor b.toInt()
infix fun Int.shl(b: Ubyte) = this shl b.toInt()

infix fun Int.udiv(b: Ubyte) = (toULong() / b.toLong()).toInt()
infix fun Int.urem(b: Ubyte) = (toULong() % b.toLong()).toInt()
infix fun Int.ucmp(b: Ubyte) = toULong().compareTo(b.toLong())
infix fun Int.ushr(b: Ubyte) = this ushr b.toInt()


operator fun Int.plus(b: Ushort) = this + b.v
operator fun Int.minus(b: Ushort) = this - b.v
operator fun Int.times(b: Ushort) = this * b.v
infix fun Int.and(b: Ushort) = this and b.toInt()
infix fun Int.or(b: Ushort) = this or b.toInt()
infix fun Int.xor(b: Ushort) = this xor b.toInt()
infix fun Int.shl(b: Ushort) = this shl b.toInt()

infix fun Int.udiv(b: Ushort) = (toULong() / b.toLong()).toInt()
infix fun Int.urem(b: Ushort) = (toULong() % b.toLong()).toInt()
infix fun Int.ucmp(b: Ushort) = toULong().compareTo(b.toLong())
infix fun Int.ushr(b: Ushort) = (toULong() ushr b.toInt()).toInt()


operator fun Int.plus(b: Uint) = this + b.v
operator fun Int.minus(b: Uint) = this - b.v
operator fun Int.times(b: Uint) = this * b.v
infix fun Int.and(b: Uint) = this and b.toInt()
infix fun Int.or(b: Uint) = this or b.toInt()
infix fun Int.xor(b: Uint) = this xor b.toInt()
infix fun Int.shl(b: Uint) = this shl b.v

infix fun Int.udiv(b: Uint) = (toULong() / b.toLong()).toInt()
infix fun Int.urem(b: Uint) = (toULong() % b.toLong()).toInt()
infix fun Int.ucmp(b: Uint) = toULong().compareTo(b.toLong())
infix fun Int.ushr(b: Uint) = (toULong() ushr b.toInt()).toInt()


operator fun Int.plus(b: Ulong) = (this + b.v).toInt()
operator fun Int.minus(b: Ulong) = (this - b.v).toInt()
operator fun Int.times(b: Ulong) = (this * b.v).toInt()
infix fun Int.and(b: Ulong) = this and b.toInt()
infix fun Int.or(b: Ulong) = this or b.toInt()
infix fun Int.xor(b: Ulong) = this xor b.toInt()
infix fun Int.shl(b: Ulong) = this shl b.toInt()

infix fun Int.udiv(b: Ulong) = (toULong() / b.toLong()).toInt()
infix fun Int.urem(b: Ulong) = (toULong() % b.toLong()).toInt()
infix fun Int.ucmp(b: Ulong) = toULong().compareTo(b.toLong())
// no Int ushr Ulong


// binds jdk unsigned operation

infix fun Int.toUnsignedString(radix: Int): String = Integer.toUnsignedString(this, radix)
/** no-radix version has a different codepath */
val Int.toUnsignedString: String
    get() = Integer.toUnsignedString(this)

fun String.parseUnsignedInt(radix: Int = 10): Int = Integer.parseUnsignedInt(this, radix)

infix fun Int.compareUnsigned(b: Int): Int = Integer.compareUnsigned(this, b)

fun Int.toUnsignedLong(): Long = toLong() and 0xffffffffL

infix fun Int.divideUnsigned(divisor: Int) = Integer.divideUnsigned(this, divisor)
infix fun Int.remainderUnsigned(divisor: Int) = Integer.remainderUnsigned(this, divisor)
