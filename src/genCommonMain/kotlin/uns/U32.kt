@file:Suppress("NOTHING_TO_INLINE")
package uns

import com.ionspin.kotlin.bignum.integer.BigInteger
import uns.U16
import uns.format.format
import uns.U8
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.and
import uns.U64
import kotlin.experimental.xor
import uns.BigInt
import com.ionspin.kotlin.bignum.integer.toBigInteger

inline fun U32(byte: Byte): U32 = U32(byte.toUByte())
inline fun U32(short: Short): U32 = U32(short.toUShort())
inline fun U32(int: Int): U32 = U32(int.toUInt())
inline fun U32(long: Long): U32 = U32(long.toULong())
class U32(var v: UInt = MIN.v) : Number(), Comparable<U32> {
	companion object {
		/** A ulong constant holding the minimum value an `unsigned int` can have, 0. */
		val MIN_ulong: ULong = 0uL
		
		/** A ulong constant holding the maximum value an `unsigned int` can have, 2^32-1. */
		val MAX_ulong: ULong = 0xFFFF_FFFFuL
		
		/** A constant holding the minimum value an `unsigned int` can have, 0.  */
		val MIN = U32(UInt.MIN_VALUE)
		
		/** A constant holding the maximum value an `unsigned int` can have, 2^32-1. */
		val MAX = U32(UInt.MAX_VALUE)
		
		/** The number of bytes used to represent an instance of UByte in a binary form. */
		const val SIZE_BYTES: Int = UInt.SIZE_BYTES
		
		/** The number of bits used to represent an instance of UByte in a binary form. */
		const val SIZE_BITS: Int = UInt.SIZE_BITS
	}
	constructor(u8: U8) : this(u8.toUInt())
	constructor(u16: U16) : this(u16.toUInt())
	constructor(u32: U32) : this(u32.v)
	constructor(u64: U64) : this(u64.toUInt())
	constructor(bigint: BigInt, exactRequired: Boolean = true) : this(bigint.uintValue(exactRequired))
	constructor(ubyte: UByte) : this(ubyte.toUInt())
	constructor(ushort: UShort) : this(ushort.toUInt())
	constructor(ulong: ULong) : this(ulong.toUInt())
	constructor(string: String, radix: Int = 10) : this(string.filter { it != '_' && it != '\'' }.toUInt(radix))
	override fun toByte(): Byte = v.toByte()
	override fun toShort(): Short = v.toShort()
	override fun toInt(): Int = v.toInt()
	override fun toLong(): Long = v.toLong()
	inline fun toU8(): U8 = U8(v)
	inline fun toU16(): U16 = U16(v)
	inline fun toU32(): U32 = U32(v)
	inline fun toU64(): U64 = U64(v)
	inline fun toBigInt(): BigInt = v.toBigInteger()
	override fun toFloat(): Float = v.toFloat()
	override fun toDouble(): Double = v.toDouble()
	inline fun toUByte(): UByte = v.toUByte()
	inline fun toUShort(): UShort = v.toUShort()
	inline fun toUInt(): UInt = v
	inline fun toULong(): ULong = v.toULong()
	@Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it's recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith = ReplaceWith("this.toInt().toChar()"))
	override fun toChar() = toInt().toChar()
	inline fun copy(): U32 = toU32()
	inline operator fun inc(): U32 = U32(v.inc())
	inline operator fun dec(): U32 = U32(v.dec())
	infix inline operator fun plus(b: Byte): U32 = U32(v + b.toUByte().toUInt())
	infix inline operator fun plus(b: Short): U32 = U32(v + b.toUShort().toUInt())
	infix inline operator fun plus(b: Int): U32 = U32(v + b.toUInt())
	infix inline operator fun plus(b: Long): Long = v.toLong() + b
	infix inline operator fun plus(b: U8): U32 = U32(v + b.v)
	infix inline operator fun plus(b: U16): U32 = U32(v + b.v)
	infix inline operator fun plus(b: U32): U32 = U32(v + b.v)
	infix inline operator fun plus(b: U64): U64 = U64(v.toULong() + b.v)
	infix inline operator fun plus(b: BigInt): BigInt = v.toBigInteger() + b
	infix inline operator fun plus(b: Float): Float = v.toFloat() + b
	infix inline operator fun plus(b: Double): Double = v.toDouble() + b
	infix inline operator fun plus(b: UByte): U32 = U32(v + b)
	infix inline operator fun plus(b: UShort): U32 = U32(v + b)
	infix inline operator fun plus(b: UInt): U32 = U32(v + b)
	infix inline operator fun plus(b: ULong): ULong = v.toULong() + b
	infix inline operator fun minus(b: Byte): U32 = U32(v - b.toUByte().toUInt())
	infix inline operator fun minus(b: Short): U32 = U32(v - b.toUShort().toUInt())
	infix inline operator fun minus(b: Int): U32 = U32(v - b.toUInt())
	infix inline operator fun minus(b: Long): Long = v.toLong() - b
	infix inline operator fun minus(b: U8): U32 = U32(v - b.v)
	infix inline operator fun minus(b: U16): U32 = U32(v - b.v)
	infix inline operator fun minus(b: U32): U32 = U32(v - b.v)
	infix inline operator fun minus(b: U64): U64 = U64(v.toULong() - b.v)
	infix inline operator fun minus(b: BigInt): BigInt = v.toBigInteger() - b
	infix inline operator fun minus(b: Float): Float = v.toFloat() - b
	infix inline operator fun minus(b: Double): Double = v.toDouble() - b
	infix inline operator fun minus(b: UByte): U32 = U32(v - b)
	infix inline operator fun minus(b: UShort): U32 = U32(v - b)
	infix inline operator fun minus(b: UInt): U32 = U32(v - b)
	infix inline operator fun minus(b: ULong): ULong = v.toULong() - b
	infix inline operator fun times(b: Byte): U32 = U32(v * b.toUByte().toUInt())
	infix inline operator fun times(b: Short): U32 = U32(v * b.toUShort().toUInt())
	infix inline operator fun times(b: Int): U32 = U32(v * b.toUInt())
	infix inline operator fun times(b: Long): Long = v.toLong() * b
	infix inline operator fun times(b: U8): U32 = U32(v * b.v)
	infix inline operator fun times(b: U16): U32 = U32(v * b.v)
	infix inline operator fun times(b: U32): U32 = U32(v * b.v)
	infix inline operator fun times(b: U64): U64 = U64(v.toULong() * b.v)
	infix inline operator fun times(b: BigInt): BigInt = v.toBigInteger() * b
	infix inline operator fun times(b: Float): Float = v.toFloat() * b
	infix inline operator fun times(b: Double): Double = v.toDouble() * b
	infix inline operator fun times(b: UByte): U32 = U32(v * b)
	infix inline operator fun times(b: UShort): U32 = U32(v * b)
	infix inline operator fun times(b: UInt): U32 = U32(v * b)
	infix inline operator fun times(b: ULong): ULong = v.toULong() * b
	infix inline operator fun div(b: Byte): U32 = U32(v / b.toUByte().toUInt())
	infix inline operator fun div(b: Short): U32 = U32(v / b.toUShort().toUInt())
	infix inline operator fun div(b: Int): U32 = U32(v / b.toUInt())
	infix inline operator fun div(b: Long): Long = v.toLong() / b
	infix inline operator fun div(b: U8): U32 = U32(v / b.v)
	infix inline operator fun div(b: U16): U32 = U32(v / b.v)
	infix inline operator fun div(b: U32): U32 = U32(v / b.v)
	infix inline operator fun div(b: U64): U64 = U64(v.toULong() / b.v)
	infix inline operator fun div(b: BigInt): BigInt = v.toBigInteger() / b
	infix inline operator fun div(b: Float): Float = v.toFloat() / b
	infix inline operator fun div(b: Double): Double = v.toDouble() / b
	infix inline operator fun div(b: UByte): U32 = U32(v / b)
	infix inline operator fun div(b: UShort): U32 = U32(v / b)
	infix inline operator fun div(b: UInt): U32 = U32(v / b)
	infix inline operator fun div(b: ULong): ULong = v.toULong() / b
	infix inline operator fun rem(b: Byte): U32 = U32(v % b.toUByte().toUInt())
	infix inline operator fun rem(b: Short): U32 = U32(v % b.toUShort().toUInt())
	infix inline operator fun rem(b: Int): U32 = U32(v % b.toUInt())
	infix inline operator fun rem(b: Long): Long = v.toLong() % b
	infix inline operator fun rem(b: U8): U32 = U32(v % b.v)
	infix inline operator fun rem(b: U16): U32 = U32(v % b.v)
	infix inline operator fun rem(b: U32): U32 = U32(v % b.v)
	infix inline operator fun rem(b: U64): U64 = U64(v.toULong() % b.v)
	infix inline operator fun rem(b: BigInt): BigInt = v.toBigInteger() % b
	infix inline operator fun rem(b: Float): Float = v.toFloat() % b
	infix inline operator fun rem(b: Double): Double = v.toDouble() % b
	infix inline operator fun rem(b: UByte): U32 = U32(v % b)
	infix inline operator fun rem(b: UShort): U32 = U32(v % b)
	infix inline operator fun rem(b: UInt): U32 = U32(v % b)
	infix inline operator fun rem(b: ULong): ULong = v.toULong() % b
	inline operator fun plusAssign(b: Byte) { v += b.toUByte().toUInt() }
	inline operator fun plusAssign(b: Short) { v += b.toUShort().toUInt() }
	inline operator fun plusAssign(b: Int) { v += b.toUInt() }
	inline operator fun plusAssign(b: Long) { v = (v.toLong() + b).toUInt() }
	inline operator fun plusAssign(b: U8) { v += b.v }
	inline operator fun plusAssign(b: U16) { v += b.v }
	inline operator fun plusAssign(b: U32) { v += b.v }
	inline operator fun plusAssign(b: U64) { v = (v.toULong() + b.v).toUInt() }
	inline operator fun plusAssign(b: BigInt) { v = (v.toBigInteger() + b).uintValue() }
	inline operator fun plusAssign(b: Float) { v = (v.toFloat() + b).toUInt() }
	inline operator fun plusAssign(b: Double) { v = (v.toDouble() + b).toUInt() }
	inline operator fun plusAssign(b: UByte) { v += b }
	inline operator fun plusAssign(b: UShort) { v += b }
	inline operator fun plusAssign(b: UInt) { v += b }
	inline operator fun plusAssign(b: ULong) { v = (v.toULong() + b).toUInt() }
	inline operator fun minusAssign(b: Byte) { v -= b.toUByte().toUInt() }
	inline operator fun minusAssign(b: Short) { v -= b.toUShort().toUInt() }
	inline operator fun minusAssign(b: Int) { v -= b.toUInt() }
	inline operator fun minusAssign(b: Long) { v = (v.toLong() - b).toUInt() }
	inline operator fun minusAssign(b: U8) { v -= b.v }
	inline operator fun minusAssign(b: U16) { v -= b.v }
	inline operator fun minusAssign(b: U32) { v -= b.v }
	inline operator fun minusAssign(b: U64) { v = (v.toULong() - b.v).toUInt() }
	inline operator fun minusAssign(b: BigInt) { v = (v.toBigInteger() - b).uintValue() }
	inline operator fun minusAssign(b: Float) { v = (v.toFloat() - b).toUInt() }
	inline operator fun minusAssign(b: Double) { v = (v.toDouble() - b).toUInt() }
	inline operator fun minusAssign(b: UByte) { v -= b }
	inline operator fun minusAssign(b: UShort) { v -= b }
	inline operator fun minusAssign(b: UInt) { v -= b }
	inline operator fun minusAssign(b: ULong) { v = (v.toULong() - b).toUInt() }
	inline operator fun timesAssign(b: Byte) { v *= b.toUByte().toUInt() }
	inline operator fun timesAssign(b: Short) { v *= b.toUShort().toUInt() }
	inline operator fun timesAssign(b: Int) { v *= b.toUInt() }
	inline operator fun timesAssign(b: Long) { v = (v.toLong() * b).toUInt() }
	inline operator fun timesAssign(b: U8) { v *= b.v }
	inline operator fun timesAssign(b: U16) { v *= b.v }
	inline operator fun timesAssign(b: U32) { v *= b.v }
	inline operator fun timesAssign(b: U64) { v = (v.toULong() * b.v).toUInt() }
	inline operator fun timesAssign(b: BigInt) { v = (v.toBigInteger() * b).uintValue() }
	inline operator fun timesAssign(b: Float) { v = (v.toFloat() * b).toUInt() }
	inline operator fun timesAssign(b: Double) { v = (v.toDouble() * b).toUInt() }
	inline operator fun timesAssign(b: UByte) { v *= b }
	inline operator fun timesAssign(b: UShort) { v *= b }
	inline operator fun timesAssign(b: UInt) { v *= b }
	inline operator fun timesAssign(b: ULong) { v = (v.toULong() * b).toUInt() }
	inline operator fun divAssign(b: Byte) { v /= b.toUByte().toUInt() }
	inline operator fun divAssign(b: Short) { v /= b.toUShort().toUInt() }
	inline operator fun divAssign(b: Int) { v /= b.toUInt() }
	inline operator fun divAssign(b: Long) { v = (v.toLong() / b).toUInt() }
	inline operator fun divAssign(b: U8) { v /= b.v }
	inline operator fun divAssign(b: U16) { v /= b.v }
	inline operator fun divAssign(b: U32) { v /= b.v }
	inline operator fun divAssign(b: U64) { v = (v.toULong() / b.v).toUInt() }
	inline operator fun divAssign(b: BigInt) { v = (v.toBigInteger() / b).uintValue() }
	inline operator fun divAssign(b: Float) { v = (v.toFloat() / b).toUInt() }
	inline operator fun divAssign(b: Double) { v = (v.toDouble() / b).toUInt() }
	inline operator fun divAssign(b: UByte) { v /= b }
	inline operator fun divAssign(b: UShort) { v /= b }
	inline operator fun divAssign(b: UInt) { v /= b }
	inline operator fun divAssign(b: ULong) { v = (v.toULong() / b).toUInt() }
	inline operator fun remAssign(b: Byte) { v %= b.toUByte().toUInt() }
	inline operator fun remAssign(b: Short) { v %= b.toUShort().toUInt() }
	inline operator fun remAssign(b: Int) { v %= b.toUInt() }
	inline operator fun remAssign(b: Long) { v = (v.toLong() % b).toUInt() }
	inline operator fun remAssign(b: U8) { v %= b.v }
	inline operator fun remAssign(b: U16) { v %= b.v }
	inline operator fun remAssign(b: U32) { v %= b.v }
	inline operator fun remAssign(b: U64) { v = (v.toULong() % b.v).toUInt() }
	inline operator fun remAssign(b: BigInt) { v = (v.toBigInteger() % b).uintValue() }
	inline operator fun remAssign(b: Float) { v = (v.toFloat() % b).toUInt() }
	inline operator fun remAssign(b: Double) { v = (v.toDouble() % b).toUInt() }
	inline operator fun remAssign(b: UByte) { v %= b }
	inline operator fun remAssign(b: UShort) { v %= b }
	inline operator fun remAssign(b: UInt) { v %= b }
	inline operator fun remAssign(b: ULong) { v = (v.toULong() % b).toUInt() }
	inline infix fun and(b: Byte): U32 = U32(v and b.toUByte().toUInt())
	inline infix fun and(b: Short): U32 = U32(v and b.toUShort().toUInt())
	inline infix fun and(b: Int): U32 = U32(v and b.toUInt())
	inline infix fun and(b: Long): U32 = U32(v and b.toULong().toUInt())
	inline infix fun and(b: U8): U32 = U32(v and b.v.toUInt())
	inline infix fun and(b: U16): U32 = U32(v and b.v.toUInt())
	inline infix fun and(b: U32): U32 = U32(v and b.v)
	inline infix fun and(b: U64): U32 = U32(v and b.v.toUInt())
	inline infix fun and(b: BigInt): U32 = U32(v and b.uintValue())
	inline infix fun and(b: UByte): U32 = U32(v and b.toUInt())
	inline infix fun and(b: UShort): U32 = U32(v and b.toUInt())
	inline infix fun and(b: UInt): U32 = U32(v and b)
	inline infix fun and(b: ULong): U32 = U32(v and b.toUInt())
	inline infix fun or(b: Byte): U32 = U32(v or b.toUByte().toUInt())
	inline infix fun or(b: Short): U32 = U32(v or b.toUShort().toUInt())
	inline infix fun or(b: Int): U32 = U32(v or b.toUInt())
	inline infix fun or(b: Long): U32 = U32(v or b.toULong().toUInt())
	inline infix fun or(b: U8): U32 = U32(v or b.v.toUInt())
	inline infix fun or(b: U16): U32 = U32(v or b.v.toUInt())
	inline infix fun or(b: U32): U32 = U32(v or b.v)
	inline infix fun or(b: U64): U32 = U32(v or b.v.toUInt())
	inline infix fun or(b: BigInt): U32 = U32(v or b.uintValue())
	inline infix fun or(b: UByte): U32 = U32(v or b.toUInt())
	inline infix fun or(b: UShort): U32 = U32(v or b.toUInt())
	inline infix fun or(b: UInt): U32 = U32(v or b)
	inline infix fun or(b: ULong): U32 = U32(v or b.toUInt())
	inline infix fun xor(b: Byte): U32 = U32(v xor b.toUByte().toUInt())
	inline infix fun xor(b: Short): U32 = U32(v xor b.toUShort().toUInt())
	inline infix fun xor(b: Int): U32 = U32(v xor b.toUInt())
	inline infix fun xor(b: Long): U32 = U32(v xor b.toULong().toUInt())
	inline infix fun xor(b: U8): U32 = U32(v xor b.v.toUInt())
	inline infix fun xor(b: U16): U32 = U32(v xor b.v.toUInt())
	inline infix fun xor(b: U32): U32 = U32(v xor b.v)
	inline infix fun xor(b: U64): U32 = U32(v xor b.v.toUInt())
	inline infix fun xor(b: BigInt): U32 = U32(v xor b.uintValue())
	inline infix fun xor(b: UByte): U32 = U32(v xor b.toUInt())
	inline infix fun xor(b: UShort): U32 = U32(v xor b.toUInt())
	inline infix fun xor(b: UInt): U32 = U32(v xor b)
	inline infix fun xor(b: ULong): U32 = U32(v xor b.toUInt())
	inline infix fun shl(b: Byte): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: Short): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: Int): U32 = U32(v shl b)
	inline infix fun shl(b: Long): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: U8): U32 = U32(v shl b.v.toInt())
	inline infix fun shl(b: U16): U32 = U32(v shl b.v.toInt())
	inline infix fun shl(b: U32): U32 = U32(v shl b.v.toInt())
	inline infix fun shl(b: U64): U32 = U32(v shl b.v.toInt())
	inline infix fun shl(b: BigInt): U32 = U32(v shl b.intValue())
	inline infix fun shl(b: UByte): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: UShort): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: UInt): U32 = U32(v shl b.toInt())
	inline infix fun shl(b: ULong): U32 = U32(v shl b.toInt())
	inline infix fun shr(b: Byte): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: Short): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: Int): U32 = U32(v shr b)
	inline infix fun shr(b: Long): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: U8): U32 = U32(v shr b.v.toInt())
	inline infix fun shr(b: U16): U32 = U32(v shr b.v.toInt())
	inline infix fun shr(b: U32): U32 = U32(v shr b.v.toInt())
	inline infix fun shr(b: U64): U32 = U32(v shr b.v.toInt())
	inline infix fun shr(b: BigInt): U32 = U32(v shr b.intValue())
	inline infix fun shr(b: UByte): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: UShort): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: UInt): U32 = U32(v shr b.toInt())
	inline infix fun shr(b: ULong): U32 = U32(v shr b.toInt())
	inline fun inv(): U32 = U32(v.inv())
	inline infix fun andAssign(b: Byte) { v = v and b.toUInt() }
	inline infix fun andAssign(b: Short) { v = v and b.toUInt() }
	inline infix fun andAssign(b: Int) { v = v and b.toUInt() }
	inline infix fun andAssign(b: Long) { v = v and b.toUInt() }
	inline infix fun andAssign(b: U8) { v = v and b.v.toUInt() }
	inline infix fun andAssign(b: U16) { v = v and b.v.toUInt() }
	inline infix fun andAssign(b: U32) { v = v and b.v }
	inline infix fun andAssign(b: U64) { v = v and b.v.toUInt() }
	inline infix fun andAssign(b: BigInt) { v = v and b.uintValue() }
	inline infix fun andAssign(b: UByte) { v = v and b.toUInt() }
	inline infix fun andAssign(b: UShort) { v = v and b.toUInt() }
	inline infix fun andAssign(b: UInt) { v = v and b }
	inline infix fun andAssign(b: ULong) { v = v and b.toUInt() }
	inline infix fun orAssign(b: Byte) { v = v or b.toUInt() }
	inline infix fun orAssign(b: Short) { v = v or b.toUInt() }
	inline infix fun orAssign(b: Int) { v = v or b.toUInt() }
	inline infix fun orAssign(b: Long) { v = v or b.toUInt() }
	inline infix fun orAssign(b: U8) { v = v or b.v.toUInt() }
	inline infix fun orAssign(b: U16) { v = v or b.v.toUInt() }
	inline infix fun orAssign(b: U32) { v = v or b.v }
	inline infix fun orAssign(b: U64) { v = v or b.v.toUInt() }
	inline infix fun orAssign(b: BigInt) { v = v or b.uintValue() }
	inline infix fun orAssign(b: UByte) { v = v or b.toUInt() }
	inline infix fun orAssign(b: UShort) { v = v or b.toUInt() }
	inline infix fun orAssign(b: UInt) { v = v or b }
	inline infix fun orAssign(b: ULong) { v = v or b.toUInt() }
	inline infix fun xorAssign(b: Byte) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: Short) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: Int) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: Long) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: U8) { v = v xor b.v.toUInt() }
	inline infix fun xorAssign(b: U16) { v = v xor b.v.toUInt() }
	inline infix fun xorAssign(b: U32) { v = v xor b.v }
	inline infix fun xorAssign(b: U64) { v = v xor b.v.toUInt() }
	inline infix fun xorAssign(b: BigInt) { v = v xor b.uintValue() }
	inline infix fun xorAssign(b: UByte) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: UShort) { v = v xor b.toUInt() }
	inline infix fun xorAssign(b: UInt) { v = v xor b }
	inline infix fun xorAssign(b: ULong) { v = v xor b.toUInt() }
	inline infix fun shlAssign(b: Byte) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: Short) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: Int) { v = v shl b }
	inline infix fun shlAssign(b: Long) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: U8) { v = v shl b.v.toInt() }
	inline infix fun shlAssign(b: U16) { v = v shl b.v.toInt() }
	inline infix fun shlAssign(b: U32) { v = v shl b.v.toInt() }
	inline infix fun shlAssign(b: U64) { v = v shl b.v.toInt() }
	inline infix fun shlAssign(b: BigInt) { v = v shl b.intValue() }
	inline infix fun shlAssign(b: UByte) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: UShort) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: UInt) { v = v shl b.toInt() }
	inline infix fun shlAssign(b: ULong) { v = v shl b.toInt() }
	inline infix fun shrAssign(b: Byte) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: Short) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: Int) { v = v shr b }
	inline infix fun shrAssign(b: Long) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: U8) { v = v shr b.v.toInt() }
	inline infix fun shrAssign(b: U16) { v = v shr b.v.toInt() }
	inline infix fun shrAssign(b: U32) { v = v shr b.v.toInt() }
	inline infix fun shrAssign(b: U64) { v = v shr b.v.toInt() }
	inline infix fun shrAssign(b: BigInt) { v = v shr b.intValue() }
	inline infix fun shrAssign(b: UByte) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: UShort) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: UInt) { v = v shr b.toInt() }
	inline infix fun shrAssign(b: ULong) { v = v shr b.toInt() }
	inline fun invAssign() { v = v.inv() }
	infix inline operator fun compareTo(other: U8): Int = toUByte().compareTo(other.v)
	infix inline operator fun compareTo(other: U16): Int = toUShort().compareTo(other.v)
	infix override operator fun compareTo(other: U32): Int = v.compareTo(other.v)
	infix inline operator fun compareTo(other: U64): Int = toULong().compareTo(other.v)
	infix inline operator fun compareTo(other: UByte): Int = toUByte().compareTo(other)
	infix inline operator fun compareTo(other: UShort): Int = toUShort().compareTo(other)
	infix inline operator fun compareTo(other: UInt): Int = v.compareTo(other)
	infix inline operator fun compareTo(other: ULong): Int = toULong().compareTo(other)
	override fun equals(other: Any?): Boolean = other is U32 && v == other.v
	override fun hashCode(): Int = v.hashCode()
	override fun toString(): String = v.toString()
	inline fun toString(radix: Int): String = v.toString(radix)
	inline fun toString(format: String): String = format.format(this)
}
