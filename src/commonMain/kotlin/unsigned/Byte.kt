/**
 * Created by elect on 19/01/2017.
 */

package unsigned

//import com.ionspin.kotlin.bignum.integer.BigInteger
//import kotlin.experimental.and
//import kotlin.experimental.or
//import kotlin.experimental.xor
//
//
//inline fun Byte.toUbyte(): Ubyte = Ubyte(this)
//fun Byte.toUshort(): Ushort = Ushort(this)
//fun Byte.toUint(): Uint = Uint(this)
//fun Byte.toUlong(): Ulong = Ulong(this)
//
//fun Byte.toBigInt(): BigInteger = BigInteger.fromLong(toLong())
//fun Byte.toUBigInt(): BigInteger = BigInteger.fromULong(toULong())
//
//val Byte.ub: Ubyte
//    get() = toUbyte()
//val Byte.ui: Uint
//    get() = toUint()
//val Byte.ul: Ulong
//    get() = toUlong()
//val Byte.us: Ushort
//    get() = toUshort()
//
infix fun Byte.udiv(b: Byte): Byte = toUByte().div(b.toUByte()).toByte()
infix fun Byte.urem(b: Byte): Byte = toUByte().rem(b.toUByte()).toByte()
infix fun Byte.ucmp(b: Byte): Int = toUByte().compareTo(b.toUByte())
infix fun Byte.ushr(b: Byte): Byte = toUByte().toUInt().shr(b.toInt()).toByte()
//
//infix fun Byte.udiv(b: Short): Byte = toUByte().div(b.toUByte()).toByte()
//infix fun Byte.urem(b: Short): Byte = toUByte().rem(b.toUByte()).toByte()
//infix fun Byte.ucmp(b: Short): Int = toUInt().compareTo(b.toUInt())
//infix fun Byte.ushr(b: Short): Byte = (toUInt() shr b.toInt()).toByte()
//
//infix fun Byte.udiv(b: Int): Byte = (toULong() / b.toULong()).toByte()
//infix fun Byte.urem(b: Int): Byte = (toULong() % b.toULong()).toByte()
//infix fun Byte.ucmp(b: Int): Int = toULong().compareTo(b.toULong())
//infix fun Byte.ushr(b: Int): Byte = (toUInt() shr b).toByte()
//
//infix fun Byte.udiv(b: Long): Byte = (toBigInt() / b.toBigInt()).byteValue()
//infix fun Byte.urem(b: Long): Byte = (toBigInt() % b.toBigInt()).byteValue()
//infix fun Byte.ucmp(b: Long): Int = toBigInt().compareTo(b.toBigInt())
//// no Byte ushr Long
//
//
//operator fun Byte.plus(b: Ubyte): Byte = (this + b.v).toByte()
//operator fun Byte.minus(b: Ubyte): Byte = (this - b.v).toByte()
//operator fun Byte.times(b: Ubyte): Byte = (this * b.v).toByte()
//infix fun Byte.and(b: Ubyte): Byte = this and b.v
//infix fun Byte.or(b: Ubyte): Byte = this or b.v
//infix fun Byte.xor(b: Ubyte): Byte = this xor b.v
//infix fun Byte.shl(b: Ubyte): Byte = (toInt() shl b.toInt()).toByte()
//
//infix fun Byte.udiv(b: Ubyte): Byte = (toUInt() / b.v.toUInt()).toByte()
//infix fun Byte.urem(b: Ubyte): Byte = (toUInt() % b.v.toUInt()).toByte()
//infix fun Byte.ucmp(b: Ubyte): Int = toUInt().compareTo(b.v.toUInt())
//infix fun Byte.ushr(b: Ubyte): Byte = (toUInt() shr b.toInt()).toByte()
//
//
//operator fun Byte.plus(b: Ushort): Byte = (this + b.v).toByte()
//operator fun Byte.minus(b: Ushort): Byte = (this - b.v).toByte()
//operator fun Byte.times(b: Ushort): Byte = (this * b.v).toByte()
//infix fun Byte.and(b: Ushort): Byte = this and b.toByte()
//infix fun Byte.or(b: Ushort): Byte = this or b.toByte()
//infix fun Byte.xor(b: Ushort): Byte = this xor b.toByte()
//infix fun Byte.shl(b: Ushort): Byte = (toInt() shl b.v.toInt()).toByte()
//
//infix fun Byte.udiv(b: Ushort): Byte = (toUInt() / b.toInt()).toByte()
//infix fun Byte.urem(b: Ushort): Byte = (toUInt() % b.toInt()).toByte()
//infix fun Byte.ucmp(b: Ushort): Int = toUInt().compareTo(b.toInt())
//infix fun Byte.ushr(b: Ushort): Byte = (toUInt() shr b.v.toInt()).toByte()
//
//
//operator fun Byte.plus(b: Uint) = (this + b.v).toByte()
//operator fun Byte.minus(b: Uint) = (this - b.v).toByte()
//operator fun Byte.times(b: Uint) = (this * b.v).toByte()
//infix fun Byte.and(b: Uint) = this and b.toByte()
//infix fun Byte.or(b: Uint) = this or b.toByte()
//infix fun Byte.xor(b: Uint) = this xor b.toByte()
//infix fun Byte.shl(b: Uint) = (toInt() shl b.v).toByte()
//
//infix fun Byte.udiv(b: Uint) = (toULong() / b.toLong()).toByte()
//infix fun Byte.urem(b: Uint) = (toULong() % b.toLong()).toByte()
//infix fun Byte.ucmp(b: Uint) = toULong().compareTo(b.toLong())
//infix fun Byte.ushr(b: Uint) = (toUInt() ushr b.toInt()).toByte()
//
//
//operator fun Byte.plus(b: Ulong) = (this + b.v).toByte()
//operator fun Byte.minus(b: Ulong) = (this - b.v).toByte()
//operator fun Byte.times(b: Ulong) = (this * b.v).toByte()
//infix fun Byte.and(b: Ulong) = this and b.toByte()
//infix fun Byte.or(b: Ulong) = this or b.toByte()
//infix fun Byte.xor(b: Ulong) = this xor b.toByte()
//infix fun Byte.shl(b: Ulong) = (toInt() shl b.toInt()).toByte()
//
//infix fun Byte.udiv(b: Ulong) = (toULong() / b.toLong()).toByte()
//infix fun Byte.urem(b: Ulong) = (toULong() % b.toLong()).toByte()
//infix fun Byte.ucmp(b: Ulong) = toULong().compareTo(b.toLong())
//// no Byte ushr Ulong
//
