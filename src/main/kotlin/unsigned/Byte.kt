/**
 * Created by elect on 19/01/2017.
 */

package unsigned

import java.math.BigInteger
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.experimental.xor


fun Byte.toUShort() = toUInt().toShort()
fun Byte.toUInt() = toInt() and 0xff
fun Byte.toULong() = toUInt().toLong()

fun Byte.toUbyte() = Ubyte(this)
fun Byte.toUshort() = Ushort(toUInt())
fun Byte.toUint() = Uint(toUInt())
fun Byte.toUlong() = Ulong(toUInt())

fun Byte.toBigInt(): BigInteger = BigInteger.valueOf(toLong())
fun Byte.toUBigInt(): BigInteger = BigInteger.valueOf(toULong())

val Byte.ub
    get() = toUbyte()
val Byte.ui
    get() = toUint()
val Byte.ul
    get() = toUlong()
val Byte.us
    get() = toUshort()

infix fun Byte.udiv(b: Byte) = (toUInt() / b.toUInt()).toByte()
infix fun Byte.urem(b: Byte) = (toUInt() % b.toUInt()).toByte()
infix fun Byte.ucmp(b: Byte) = toUInt().compareTo(b.toUInt())
infix fun Byte.ushr(b: Byte) = (toUInt() ushr b.toUInt()).toByte()

infix fun Byte.udiv(b: Short) = (toUInt() / b.toUInt()).toByte()
infix fun Byte.urem(b: Short) = (toUInt() % b.toUInt()).toByte()
infix fun Byte.ucmp(b: Short) = toUInt().compareTo(b.toUInt())
infix fun Byte.ushr(b: Short) = (toUInt() ushr b.toUInt()).toByte()

infix fun Byte.udiv(b: Int) = (toULong() / b.toULong()).toByte()
infix fun Byte.urem(b: Int) = (toULong() % b.toULong()).toByte()
infix fun Byte.ucmp(b: Int) = toULong().compareTo(b.toULong())
infix fun Byte.ushr(b: Int) = (toUInt() ushr b).toByte()

infix fun Byte.udiv(b: Long) = (toBigInt() / b.toBigInt()).toByte()
infix fun Byte.urem(b: Long) = (toBigInt() % b.toBigInt()).toByte()
infix fun Byte.ucmp(b: Long) = toBigInt().compareTo(b.toBigInt())
// no Byte ushr Long


operator fun Byte.plus(b: Ubyte) = (this + b.v).toByte()
operator fun Byte.minus(b: Ubyte) = (this - b.v).toByte()
operator fun Byte.times(b: Ubyte) = (this * b.v).toByte()
infix fun Byte.and(b: Ubyte) = this and b.v
infix fun Byte.or(b: Ubyte) = this or b.v
infix fun Byte.xor(b: Ubyte) = this xor b.v
infix fun Byte.shl(b: Ubyte) = (toInt() shl b.toInt()).toByte()

infix fun Byte.udiv(b: Ubyte) = (toUInt() / b.toInt()).toByte()
infix fun Byte.urem(b: Ubyte) = (toUInt() % b.toInt()).toByte()
infix fun Byte.ucmp(b: Ubyte) = toUInt().compareTo(b.toInt())
infix fun Byte.ushr(b: Ubyte) = (toUInt() ushr b.toInt()).toByte()


operator fun Byte.plus(b: Ushort) = (this + b.v).toByte()
operator fun Byte.minus(b: Ushort) = (this - b.v).toByte()
operator fun Byte.times(b: Ushort) = (this * b.v).toByte()
infix fun Byte.and(b: Ushort) = this and b.toByte()
infix fun Byte.or(b: Ushort) = this or b.toByte()
infix fun Byte.xor(b: Ushort) = this xor b.toByte()
infix fun Byte.shl(b: Ushort) = (toInt() shl b.toInt()).toByte()

infix fun Byte.udiv(b: Ushort) = (toUInt() / b.toInt()).toByte()
infix fun Byte.urem(b: Ushort) = (toUInt() % b.toInt()).toByte()
infix fun Byte.ucmp(b: Ushort) = toUInt().compareTo(b.toInt())
infix fun Byte.ushr(b: Ushort) = (toUInt() ushr b.toInt()).toByte()


operator fun Byte.plus(b: Uint) = (this + b.v).toByte()
operator fun Byte.minus(b: Uint) = (this - b.v).toByte()
operator fun Byte.times(b: Uint) = (this * b.v).toByte()
infix fun Byte.and(b: Uint) = this and b.toByte()
infix fun Byte.or(b: Uint) = this or b.toByte()
infix fun Byte.xor(b: Uint) = this xor b.toByte()
infix fun Byte.shl(b: Uint) = (toInt() shl b.v).toByte()

infix fun Byte.udiv(b: Uint) = (toULong() / b.toLong()).toByte()
infix fun Byte.urem(b: Uint) = (toULong() % b.toLong()).toByte()
infix fun Byte.ucmp(b: Uint) = toULong().compareTo(b.toLong())
infix fun Byte.ushr(b: Uint) = (toUInt() ushr b.toInt()).toByte()


operator fun Byte.plus(b: Ulong) = (this + b.v).toByte()
operator fun Byte.minus(b: Ulong) = (this - b.v).toByte()
operator fun Byte.times(b: Ulong) = (this * b.v).toByte()
infix fun Byte.and(b: Ulong) = this and b.toByte()
infix fun Byte.or(b: Ulong) = this or b.toByte()
infix fun Byte.xor(b: Ulong) = this xor b.toByte()
infix fun Byte.shl(b: Ulong) = (toInt() shl b.toInt()).toByte()

infix fun Byte.udiv(b: Ulong) = (toULong() / b.toLong()).toByte()
infix fun Byte.urem(b: Ulong) = (toULong() % b.toLong()).toByte()
infix fun Byte.ucmp(b: Ulong) = toULong().compareTo(b.toLong())
// no Byte ushr Ulong

