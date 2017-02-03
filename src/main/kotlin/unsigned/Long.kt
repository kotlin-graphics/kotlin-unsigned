import unsigned.*
import java.math.BigInteger

/**
 * Created by GBarbieri on 31.01.2017.
 */

fun Long.toUByte() = toByte()
fun Long.toUShort() = toShort()
fun Long.toUInt() = toInt()
fun Long.toBigInt() = BigInteger(java.lang.Long.toUnsignedString(this))

fun Long.toUbyte() = Ubyte(this)
fun Long.toUshort() = Ushort(this)
fun Long.toUint() = Uint(this)
fun Long.toUlong() = Ulong(this)

val Long.ub
    get() = toUbyte()
val Long.ui
    get() = toUint()
val Long.ul
    get() = toUlong()
val Long.us
    get() = toUshort()

infix fun Long.udiv(b: Byte) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Byte) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Byte) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Byte) = (toBigInt() ushr b.toUInt()).toLong()

infix fun Long.udiv(b: Short) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Short) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Short) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Short) = (toBigInt() ushr b.toUInt()).toLong()

infix fun Long.udiv(b: Int) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Int) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Int) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Int) = (toBigInt() ushr b).toLong()

infix fun Long.udiv(b: Long) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Long) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Long) = toBigInt().compareTo(b.toBigInt())
// no Long ushr Long


operator fun Long.plus(b: Ubyte) = this + b.v
operator fun Long.minus(b: Ubyte) = this - b.v
operator fun Long.times(b: Ubyte) = this * b.v
infix fun Long.and(b: Ubyte) = this and b.toLong()
infix fun Long.or(b: Ubyte) = this or b.toLong()
infix fun Long.xor(b: Ubyte) = this xor b.toLong()
infix fun Long.shl(b: Ubyte) = this shl b.toInt()

infix fun Long.udiv(b: Ubyte) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Ubyte) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Ubyte) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Ubyte) = this ushr b.toInt()


operator fun Long.plus(b: Ushort) = this + b.v
operator fun Long.minus(b: Ushort) = this - b.v
operator fun Long.times(b: Ushort) = this * b.v
infix fun Long.and(b: Ushort) = this and b.toLong()
infix fun Long.or(b: Ushort) = this or b.toLong()
infix fun Long.xor(b: Ushort) = this xor b.toLong()
infix fun Long.shl(b: Ushort) = this shl b.toInt()

infix fun Long.udiv(b: Ushort) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Ushort) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Ushort) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Ushort) = (toBigInt() ushr b.toInt()).toLong()


operator fun Long.plus(b: Uint) = this + b.v
operator fun Long.minus(b: Uint) = this - b.v
operator fun Long.times(b: Uint) = this * b.v
infix fun Long.and(b: Uint) = this and b.toLong()
infix fun Long.or(b: Uint) = this or b.toLong()
infix fun Long.xor(b: Uint) = this xor b.toLong()
infix fun Long.shl(b: Uint) = this shl b.v

infix fun Long.udiv(b: Uint) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Uint) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Uint) = toBigInt().compareTo(b.toBigInt())
infix fun Long.ushr(b: Uint) = (toBigInt() ushr b.toInt()).toLong()


operator fun Long.plus(b: Ulong) = this + b.v
operator fun Long.minus(b: Ulong) = this - b.v
operator fun Long.times(b: Ulong) = this * b.v
infix fun Long.and(b: Ulong) = this and b.toLong()
infix fun Long.or(b: Ulong) = this or b.toLong()
infix fun Long.xor(b: Ulong) = this xor b.toLong()
infix fun Long.shl(b: Ulong) = this shl b.toInt()

infix fun Long.udiv(b: Ulong) = (toBigInt() / b.toBigInt()).toLong()
infix fun Long.urem(b: Ulong) = (toBigInt() % b.toBigInt()).toLong()
infix fun Long.ucmp(b: Ulong) = toBigInt().compareTo(b.toBigInt())
// no Int ushr Ulong