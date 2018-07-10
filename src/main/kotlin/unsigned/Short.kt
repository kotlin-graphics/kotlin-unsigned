/**
 * Created by GBarbieri on 03.02.2017.
 */

package unsigned

import java.math.BigInteger
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.experimental.xor


fun Short.toUByte() = toByte()
fun Short.toUInt() = toInt() and 0xffff
fun Short.toULong() = toUInt().toLong()

fun Short.toUbyte() = Ubyte(this)
fun Short.toUshort() = Ushort(this)
fun Short.toUint() = Uint(toUInt())
fun Short.toUlong() = Ulong(toUInt())

fun Short.toBigInt(): BigInteger = BigInteger.valueOf(toLong())
fun Short.toUBigInt(): BigInteger = BigInteger.valueOf(toULong())

val Short.ub
    get() = toUbyte()
val Short.ui
    get() = toUint()
val Short.ul
    get() = toUlong()
val Short.us
    get() = toUshort()

infix fun Short.udiv(b: Byte) = (toUInt() / b.toUInt()).toShort()
infix fun Short.urem(b: Byte) = (toUInt() % b.toUInt()).toShort()
infix fun Short.ucmp(b: Byte) = toUInt().compareTo(b.toUInt())
infix fun Short.ushr(b: Byte) = (toUInt() ushr b.toUInt()).toShort()

infix fun Short.udiv(b: Short) = (toUInt() / b.toUInt()).toShort()
infix fun Short.urem(b: Short) = (toUInt() % b.toUInt()).toShort()
infix fun Short.ucmp(b: Short) = toUInt().compareTo(b.toUInt())
infix fun Short.ushr(b: Short) = (toUInt() ushr b.toUInt()).toShort()

infix fun Short.udiv(b: Int) = (toULong() / b.toULong()).toShort()
infix fun Short.urem(b: Int) = (toULong() % b.toULong()).toShort()
infix fun Short.ucmp(b: Int) = toULong().compareTo(b.toULong())
infix fun Short.ushr(b: Int) = (toUInt() ushr b).toShort()

infix fun Short.udiv(b: Long) = (toBigInt() / b.toBigInt()).toShort()
infix fun Short.urem(b: Long) = (toBigInt() % b.toBigInt()).toShort()
infix fun Short.ucmp(b: Long) = toBigInt().compareTo(b.toBigInt())
// no Short ushr Long


operator fun Short.plus(b: Ubyte) = (this + b.v).toShort()
operator fun Short.minus(b: Ubyte) = (this - b.v).toShort()
operator fun Short.times(b: Ubyte) = (this * b.v).toShort()
infix fun Short.and(b: Ubyte) = this and b.toShort()
infix fun Short.or(b: Ubyte) = this or b.toShort()
infix fun Short.xor(b: Ubyte) = this xor b.toShort()
infix fun Short.shl(b: Ubyte) = (toInt() shl b.toInt()).toShort()

infix fun Short.udiv(b: Ubyte) = (toUInt() / b.toInt()).toShort()
infix fun Short.urem(b: Ubyte) = (toUInt() % b.toInt()).toShort()
infix fun Short.ucmp(b: Ubyte) = toUInt().compareTo(b.toInt())
infix fun Short.ushr(b: Ubyte) = (toUInt() ushr b.toInt()).toShort()


operator fun Short.plus(b: Ushort) = (this + b.v).toShort()
operator fun Short.minus(b: Ushort) = (this - b.v).toShort()
operator fun Short.times(b: Ushort) = (this * b.v).toShort()
infix fun Short.and(b: Ushort) = this and b.v
infix fun Short.or(b: Ushort) = this or b.v
infix fun Short.xor(b: Ushort) = this xor b.v
infix fun Short.shl(b: Ushort) = (toInt() shl b.toInt()).toShort()

infix fun Short.udiv(b: Ushort) = (toUInt() / b.toInt()).toShort()
infix fun Short.urem(b: Ushort) = (toUInt() % b.toInt()).toShort()
infix fun Short.ucmp(b: Ushort) = toUInt().compareTo(b.toInt())
infix fun Short.ushr(b: Ushort) = (toUInt() ushr b.toInt()).toShort()


operator fun Short.plus(b: Uint) = (this + b.v).toShort()
operator fun Short.minus(b: Uint) = (this - b.v).toShort()
operator fun Short.times(b: Uint) = (this * b.v).toShort()
infix fun Short.and(b: Uint) = this and b.toShort()
infix fun Short.or(b: Uint) = this or b.toShort()
infix fun Short.xor(b: Uint) = this xor b.toShort()
infix fun Short.shl(b: Uint) = (toInt() shl b.v).toShort()

infix fun Short.udiv(b: Uint) = (toULong() / b.toLong()).toShort()
infix fun Short.urem(b: Uint) = (toULong() % b.toLong()).toShort()
infix fun Short.ucmp(b: Uint) = toULong().compareTo(b.toLong())
infix fun Short.ushr(b: Uint) = (toUInt() ushr b.toInt()).toShort()


operator fun Short.plus(b: Ulong) = (this + b.v).toShort()
operator fun Short.minus(b: Ulong) = (this - b.v).toShort()
operator fun Short.times(b: Ulong) = (this * b.v).toShort()
infix fun Short.and(b: Ulong) = this and b.toShort()
infix fun Short.or(b: Ulong) = this or b.toShort()
infix fun Short.xor(b: Ulong) = this xor b.toShort()
infix fun Short.shl(b: Ulong) = (toInt() shl b.toInt()).toShort()

infix fun Short.udiv(b: Ulong) = (toULong() / b.toLong()).toShort()
infix fun Short.urem(b: Ulong) = (toULong() % b.toLong()).toShort()
infix fun Short.ucmp(b: Ulong) = toULong().compareTo(b.toLong())
// no Short ushr Ulong