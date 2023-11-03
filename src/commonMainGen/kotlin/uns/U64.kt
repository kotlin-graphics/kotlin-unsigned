@file:Suppress("NOTHING_TO_INLINE")
package uns

import com.ionspin.kotlin.bignum.integer.BigInteger
import uns.U16
import uns.format.format
import uns.U8
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.and
import uns.U32
import kotlin.experimental.xor
import uns.BigInt
import com.ionspin.kotlin.bignum.integer.toBigInteger

inline fun U64(byte: Byte): U64 = U64(byte.toUByte())
inline fun U64(short: Short): U64 = U64(short.toUShort())
inline fun U64(int: Int): U64 = U64(int.toUInt())
inline fun U64(long: Long): U64 = U64(long.toULong())
class U64(var v: ULong = MIN.v) : Number(), Comparable<U64> {
	companion object {
		/** A bigint constant holding the minimum value an `unsigned long` can have, 0. */
		val MIN_bigint: BigInt = BigInteger.ZERO
		
		/** A bigint constant holding the maximum value an `unsigned long` can have, 2^64-1. */
		val MAX_bigint: BigInt = ULong.MAX_VALUE.toBigInteger()
		
		/** A constant holding the minimum value an `unsigned long` can have, 0.  */
		val MIN = U64(ULong.MIN_VALUE)
		
		/** A constant holding the maximum value an `unsigned long` can have, 2^64-1. */
		val MAX = U64(ULong.MAX_VALUE)
		
		/** The number of bytes used to represent an instance of UByte in a binary form. */
		const val SIZE_BYTES: Int = ULong.SIZE_BYTES
		
		/** The number of bits used to represent an instance of UByte in a binary form. */
		const val SIZE_BITS: Int = ULong.SIZE_BITS
	}
	constructor(u8: U8) : this(u8.toULong())
	constructor(u16: U16) : this(u16.toULong())
	constructor(u32: U32) : this(u32.toULong())
	constructor(u64: U64) : this(u64.v)
	constructor(bigint: BigInt, exactRequired: Boolean = true) : this(bigint.ulongValue(exactRequired))
	constructor(ubyte: UByte) : this(ubyte.toULong())
	constructor(ushort: UShort) : this(ushort.toULong())
	constructor(uint: UInt) : this(uint.toULong())
	constructor(string: String, radix: Int = 10) : this(string.filter { it != '_' && it != '\'' }.toULong(radix))
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
	inline fun toUInt(): UInt = v.toUInt()
	inline fun toULong(): ULong = v
	@Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it's recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith = ReplaceWith("this.toInt().toChar()"))
	override fun toChar() = toInt().toChar()
	inline fun copy(): U64 = toU64()
	inline operator fun inc(): U64 = U64(v.inc())
	inline operator fun dec(): U64 = U64(v.dec())
	infix inline operator fun plus(b: Byte): U64 = U64(v + b.toUByte().toULong())
	infix inline operator fun plus(b: Short): U64 = U64(v + b.toUShort().toULong())
	infix inline operator fun plus(b: Int): U64 = U64(v + b.toUInt().toULong())
	infix inline operator fun plus(b: Long): U64 = U64(v + b.toULong())
	infix inline operator fun plus(b: U8): U64 = U64(v + b.v)
	infix inline operator fun plus(b: U16): U64 = U64(v + b.v)
	infix inline operator fun plus(b: U32): U64 = U64(v + b.v)
	infix inline operator fun plus(b: U64): U64 = U64(v + b.v)
	infix inline operator fun plus(b: BigInt): BigInt = v.toBigInteger() + b
	infix inline operator fun plus(b: Float): Float = v.toFloat() + b
	infix inline operator fun plus(b: Double): Double = v.toDouble() + b
	infix inline operator fun plus(b: UByte): U64 = U64(v + b)
	infix inline operator fun plus(b: UShort): U64 = U64(v + b)
	infix inline operator fun plus(b: UInt): U64 = U64(v + b)
	infix inline operator fun plus(b: ULong): U64 = U64(v + b)
	infix inline operator fun minus(b: Byte): U64 = U64(v - b.toUByte().toULong())
	infix inline operator fun minus(b: Short): U64 = U64(v - b.toUShort().toULong())
	infix inline operator fun minus(b: Int): U64 = U64(v - b.toUInt().toULong())
	infix inline operator fun minus(b: Long): U64 = U64(v - b.toULong())
	infix inline operator fun minus(b: U8): U64 = U64(v - b.v)
	infix inline operator fun minus(b: U16): U64 = U64(v - b.v)
	infix inline operator fun minus(b: U32): U64 = U64(v - b.v)
	infix inline operator fun minus(b: U64): U64 = U64(v - b.v)
	infix inline operator fun minus(b: BigInt): BigInt = v.toBigInteger() - b
	infix inline operator fun minus(b: Float): Float = v.toFloat() - b
	infix inline operator fun minus(b: Double): Double = v.toDouble() - b
	infix inline operator fun minus(b: UByte): U64 = U64(v - b)
	infix inline operator fun minus(b: UShort): U64 = U64(v - b)
	infix inline operator fun minus(b: UInt): U64 = U64(v - b)
	infix inline operator fun minus(b: ULong): U64 = U64(v - b)
	infix inline operator fun times(b: Byte): U64 = U64(v * b.toUByte().toULong())
	infix inline operator fun times(b: Short): U64 = U64(v * b.toUShort().toULong())
	infix inline operator fun times(b: Int): U64 = U64(v * b.toUInt().toULong())
	infix inline operator fun times(b: Long): U64 = U64(v * b.toULong())
	infix inline operator fun times(b: U8): U64 = U64(v * b.v)
	infix inline operator fun times(b: U16): U64 = U64(v * b.v)
	infix inline operator fun times(b: U32): U64 = U64(v * b.v)
	infix inline operator fun times(b: U64): U64 = U64(v * b.v)
	infix inline operator fun times(b: BigInt): BigInt = v.toBigInteger() * b
	infix inline operator fun times(b: Float): Float = v.toFloat() * b
	infix inline operator fun times(b: Double): Double = v.toDouble() * b
	infix inline operator fun times(b: UByte): U64 = U64(v * b)
	infix inline operator fun times(b: UShort): U64 = U64(v * b)
	infix inline operator fun times(b: UInt): U64 = U64(v * b)
	infix inline operator fun times(b: ULong): U64 = U64(v * b)
	infix inline operator fun div(b: Byte): U64 = U64(v / b.toUByte().toULong())
	infix inline operator fun div(b: Short): U64 = U64(v / b.toUShort().toULong())
	infix inline operator fun div(b: Int): U64 = U64(v / b.toUInt().toULong())
	infix inline operator fun div(b: Long): U64 = U64(v / b.toULong())
	infix inline operator fun div(b: U8): U64 = U64(v / b.v)
	infix inline operator fun div(b: U16): U64 = U64(v / b.v)
	infix inline operator fun div(b: U32): U64 = U64(v / b.v)
	infix inline operator fun div(b: U64): U64 = U64(v / b.v)
	infix inline operator fun div(b: BigInt): BigInt = v.toBigInteger() / b
	infix inline operator fun div(b: Float): Float = v.toFloat() / b
	infix inline operator fun div(b: Double): Double = v.toDouble() / b
	infix inline operator fun div(b: UByte): U64 = U64(v / b)
	infix inline operator fun div(b: UShort): U64 = U64(v / b)
	infix inline operator fun div(b: UInt): U64 = U64(v / b)
	infix inline operator fun div(b: ULong): U64 = U64(v / b)
	infix inline operator fun rem(b: Byte): U64 = U64(v % b.toUByte().toULong())
	infix inline operator fun rem(b: Short): U64 = U64(v % b.toUShort().toULong())
	infix inline operator fun rem(b: Int): U64 = U64(v % b.toUInt().toULong())
	infix inline operator fun rem(b: Long): U64 = U64(v % b.toULong())
	infix inline operator fun rem(b: U8): U64 = U64(v % b.v)
	infix inline operator fun rem(b: U16): U64 = U64(v % b.v)
	infix inline operator fun rem(b: U32): U64 = U64(v % b.v)
	infix inline operator fun rem(b: U64): U64 = U64(v % b.v)
	infix inline operator fun rem(b: BigInt): BigInt = v.toBigInteger() % b
	infix inline operator fun rem(b: Float): Float = v.toFloat() % b
	infix inline operator fun rem(b: Double): Double = v.toDouble() % b
	infix inline operator fun rem(b: UByte): U64 = U64(v % b)
	infix inline operator fun rem(b: UShort): U64 = U64(v % b)
	infix inline operator fun rem(b: UInt): U64 = U64(v % b)
	infix inline operator fun rem(b: ULong): U64 = U64(v % b)
	inline operator fun plusAssign(b: Byte) { v += b.toUByte().toULong() }
	inline operator fun plusAssign(b: Short) { v += b.toUShort().toULong() }
	inline operator fun plusAssign(b: Int) { v += b.toUInt().toULong() }
	inline operator fun plusAssign(b: Long) { v += b.toULong() }
	inline operator fun plusAssign(b: U8) { v += b.v }
	inline operator fun plusAssign(b: U16) { v += b.v }
	inline operator fun plusAssign(b: U32) { v += b.v }
	inline operator fun plusAssign(b: U64) { v += b.v }
	inline operator fun plusAssign(b: BigInt) { v = (v.toBigInteger() + b).ulongValue() }
	inline operator fun plusAssign(b: Float) { v = (v.toFloat() + b).toLong().toULong() }
	inline operator fun plusAssign(b: Double) { v = (v.toDouble() + b).toLong().toULong() }
	inline operator fun plusAssign(b: UByte) { v += b }
	inline operator fun plusAssign(b: UShort) { v += b }
	inline operator fun plusAssign(b: UInt) { v += b }
	inline operator fun plusAssign(b: ULong) { v += b }
	inline operator fun minusAssign(b: Byte) { v -= b.toUByte().toULong() }
	inline operator fun minusAssign(b: Short) { v -= b.toUShort().toULong() }
	inline operator fun minusAssign(b: Int) { v -= b.toUInt().toULong() }
	inline operator fun minusAssign(b: Long) { v -= b.toULong() }
	inline operator fun minusAssign(b: U8) { v -= b.v }
	inline operator fun minusAssign(b: U16) { v -= b.v }
	inline operator fun minusAssign(b: U32) { v -= b.v }
	inline operator fun minusAssign(b: U64) { v -= b.v }
	inline operator fun minusAssign(b: BigInt) { v = (v.toBigInteger() - b).ulongValue() }
	inline operator fun minusAssign(b: Float) { v = (v.toFloat() - b).toLong().toULong() }
	inline operator fun minusAssign(b: Double) { v = (v.toDouble() - b).toLong().toULong() }
	inline operator fun minusAssign(b: UByte) { v -= b }
	inline operator fun minusAssign(b: UShort) { v -= b }
	inline operator fun minusAssign(b: UInt) { v -= b }
	inline operator fun minusAssign(b: ULong) { v -= b }
	inline operator fun timesAssign(b: Byte) { v *= b.toUByte().toULong() }
	inline operator fun timesAssign(b: Short) { v *= b.toUShort().toULong() }
	inline operator fun timesAssign(b: Int) { v *= b.toUInt().toULong() }
	inline operator fun timesAssign(b: Long) { v *= b.toULong() }
	inline operator fun timesAssign(b: U8) { v *= b.v }
	inline operator fun timesAssign(b: U16) { v *= b.v }
	inline operator fun timesAssign(b: U32) { v *= b.v }
	inline operator fun timesAssign(b: U64) { v *= b.v }
	inline operator fun timesAssign(b: BigInt) { v = (v.toBigInteger() * b).ulongValue() }
	inline operator fun timesAssign(b: Float) { v = (v.toFloat() * b).toLong().toULong() }
	inline operator fun timesAssign(b: Double) { v = (v.toDouble() * b).toLong().toULong() }
	inline operator fun timesAssign(b: UByte) { v *= b }
	inline operator fun timesAssign(b: UShort) { v *= b }
	inline operator fun timesAssign(b: UInt) { v *= b }
	inline operator fun timesAssign(b: ULong) { v *= b }
	inline operator fun divAssign(b: Byte) { v /= b.toUByte().toULong() }
	inline operator fun divAssign(b: Short) { v /= b.toUShort().toULong() }
	inline operator fun divAssign(b: Int) { v /= b.toUInt().toULong() }
	inline operator fun divAssign(b: Long) { v /= b.toULong() }
	inline operator fun divAssign(b: U8) { v /= b.v }
	inline operator fun divAssign(b: U16) { v /= b.v }
	inline operator fun divAssign(b: U32) { v /= b.v }
	inline operator fun divAssign(b: U64) { v /= b.v }
	inline operator fun divAssign(b: BigInt) { v = (v.toBigInteger() / b).ulongValue() }
	inline operator fun divAssign(b: Float) { v = (v.toFloat() / b).toLong().toULong() }
	inline operator fun divAssign(b: Double) { v = (v.toDouble() / b).toLong().toULong() }
	inline operator fun divAssign(b: UByte) { v /= b }
	inline operator fun divAssign(b: UShort) { v /= b }
	inline operator fun divAssign(b: UInt) { v /= b }
	inline operator fun divAssign(b: ULong) { v /= b }
	inline operator fun remAssign(b: Byte) { v %= b.toUByte().toULong() }
	inline operator fun remAssign(b: Short) { v %= b.toUShort().toULong() }
	inline operator fun remAssign(b: Int) { v %= b.toUInt().toULong() }
	inline operator fun remAssign(b: Long) { v %= b.toULong() }
	inline operator fun remAssign(b: U8) { v %= b.v }
	inline operator fun remAssign(b: U16) { v %= b.v }
	inline operator fun remAssign(b: U32) { v %= b.v }
	inline operator fun remAssign(b: U64) { v %= b.v }
	inline operator fun remAssign(b: BigInt) { v = (v.toBigInteger() % b).ulongValue() }
	inline operator fun remAssign(b: Float) { v = (v.toFloat() % b).toLong().toULong() }
	inline operator fun remAssign(b: Double) { v = (v.toDouble() % b).toLong().toULong() }
	inline operator fun remAssign(b: UByte) { v %= b }
	inline operator fun remAssign(b: UShort) { v %= b }
	inline operator fun remAssign(b: UInt) { v %= b }
	inline operator fun remAssign(b: ULong) { v %= b }
	inline infix fun and(b: Byte): U64 = U64(v and b.toUByte().toULong())
	inline infix fun and(b: Short): U64 = U64(v and b.toUShort().toULong())
	inline infix fun and(b: Int): U64 = U64(v and b.toUInt().toULong())
	inline infix fun and(b: Long): U64 = U64(v and b.toULong())
	inline infix fun and(b: U8): U64 = U64(v and b.v.toULong())
	inline infix fun and(b: U16): U64 = U64(v and b.v.toULong())
	inline infix fun and(b: U32): U64 = U64(v and b.v.toULong())
	inline infix fun and(b: U64): U64 = U64(v and b.v)
	inline infix fun and(b: BigInt): U64 = U64(v and b.ulongValue())
	inline infix fun and(b: UByte): U64 = U64(v and b.toULong())
	inline infix fun and(b: UShort): U64 = U64(v and b.toULong())
	inline infix fun and(b: UInt): U64 = U64(v and b.toULong())
	inline infix fun and(b: ULong): U64 = U64(v and b)
	inline infix fun or(b: Byte): U64 = U64(v or b.toUByte().toULong())
	inline infix fun or(b: Short): U64 = U64(v or b.toUShort().toULong())
	inline infix fun or(b: Int): U64 = U64(v or b.toUInt().toULong())
	inline infix fun or(b: Long): U64 = U64(v or b.toULong())
	inline infix fun or(b: U8): U64 = U64(v or b.v.toULong())
	inline infix fun or(b: U16): U64 = U64(v or b.v.toULong())
	inline infix fun or(b: U32): U64 = U64(v or b.v.toULong())
	inline infix fun or(b: U64): U64 = U64(v or b.v)
	inline infix fun or(b: BigInt): U64 = U64(v or b.ulongValue())
	inline infix fun or(b: UByte): U64 = U64(v or b.toULong())
	inline infix fun or(b: UShort): U64 = U64(v or b.toULong())
	inline infix fun or(b: UInt): U64 = U64(v or b.toULong())
	inline infix fun or(b: ULong): U64 = U64(v or b)
	inline infix fun xor(b: Byte): U64 = U64(v xor b.toUByte().toULong())
	inline infix fun xor(b: Short): U64 = U64(v xor b.toUShort().toULong())
	inline infix fun xor(b: Int): U64 = U64(v xor b.toUInt().toULong())
	inline infix fun xor(b: Long): U64 = U64(v xor b.toULong())
	inline infix fun xor(b: U8): U64 = U64(v xor b.v.toULong())
	inline infix fun xor(b: U16): U64 = U64(v xor b.v.toULong())
	inline infix fun xor(b: U32): U64 = U64(v xor b.v.toULong())
	inline infix fun xor(b: U64): U64 = U64(v xor b.v)
	inline infix fun xor(b: BigInt): U64 = U64(v xor b.ulongValue())
	inline infix fun xor(b: UByte): U64 = U64(v xor b.toULong())
	inline infix fun xor(b: UShort): U64 = U64(v xor b.toULong())
	inline infix fun xor(b: UInt): U64 = U64(v xor b.toULong())
	inline infix fun xor(b: ULong): U64 = U64(v xor b)
	inline infix fun shl(b: Byte): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: Short): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: Int): U64 = U64(v shl b)
	inline infix fun shl(b: Long): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: U8): U64 = U64(v shl b.v.toInt())
	inline infix fun shl(b: U16): U64 = U64(v shl b.v.toInt())
	inline infix fun shl(b: U32): U64 = U64(v shl b.v.toInt())
	inline infix fun shl(b: U64): U64 = U64(v shl b.v.toInt())
	inline infix fun shl(b: BigInt): U64 = U64(v shl b.intValue())
	inline infix fun shl(b: UByte): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: UShort): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: UInt): U64 = U64(v shl b.toInt())
	inline infix fun shl(b: ULong): U64 = U64(v shl b.toInt())
	inline infix fun shr(b: Byte): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: Short): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: Int): U64 = U64(v shr b)
	inline infix fun shr(b: Long): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: U8): U64 = U64(v shr b.v.toInt())
	inline infix fun shr(b: U16): U64 = U64(v shr b.v.toInt())
	inline infix fun shr(b: U32): U64 = U64(v shr b.v.toInt())
	inline infix fun shr(b: U64): U64 = U64(v shr b.v.toInt())
	inline infix fun shr(b: BigInt): U64 = U64(v shr b.intValue())
	inline infix fun shr(b: UByte): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: UShort): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: UInt): U64 = U64(v shr b.toInt())
	inline infix fun shr(b: ULong): U64 = U64(v shr b.toInt())
	inline fun inv(): U64 = U64(v.inv())
	inline infix fun andAssign(b: Byte) { v = v and b.toULong() }
	inline infix fun andAssign(b: Short) { v = v and b.toULong() }
	inline infix fun andAssign(b: Int) { v = v and b.toULong() }
	inline infix fun andAssign(b: Long) { v = v and b.toULong() }
	inline infix fun andAssign(b: U8) { v = v and b.v.toULong() }
	inline infix fun andAssign(b: U16) { v = v and b.v.toULong() }
	inline infix fun andAssign(b: U32) { v = v and b.v.toULong() }
	inline infix fun andAssign(b: U64) { v = v and b.v }
	inline infix fun andAssign(b: BigInt) { v = v and b.ulongValue() }
	inline infix fun andAssign(b: UByte) { v = v and b.toULong() }
	inline infix fun andAssign(b: UShort) { v = v and b.toULong() }
	inline infix fun andAssign(b: UInt) { v = v and b.toULong() }
	inline infix fun andAssign(b: ULong) { v = v and b }
	inline infix fun orAssign(b: Byte) { v = v or b.toULong() }
	inline infix fun orAssign(b: Short) { v = v or b.toULong() }
	inline infix fun orAssign(b: Int) { v = v or b.toULong() }
	inline infix fun orAssign(b: Long) { v = v or b.toULong() }
	inline infix fun orAssign(b: U8) { v = v or b.v.toULong() }
	inline infix fun orAssign(b: U16) { v = v or b.v.toULong() }
	inline infix fun orAssign(b: U32) { v = v or b.v.toULong() }
	inline infix fun orAssign(b: U64) { v = v or b.v }
	inline infix fun orAssign(b: BigInt) { v = v or b.ulongValue() }
	inline infix fun orAssign(b: UByte) { v = v or b.toULong() }
	inline infix fun orAssign(b: UShort) { v = v or b.toULong() }
	inline infix fun orAssign(b: UInt) { v = v or b.toULong() }
	inline infix fun orAssign(b: ULong) { v = v or b }
	inline infix fun xorAssign(b: Byte) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: Short) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: Int) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: Long) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: U8) { v = v xor b.v.toULong() }
	inline infix fun xorAssign(b: U16) { v = v xor b.v.toULong() }
	inline infix fun xorAssign(b: U32) { v = v xor b.v.toULong() }
	inline infix fun xorAssign(b: U64) { v = v xor b.v }
	inline infix fun xorAssign(b: BigInt) { v = v xor b.ulongValue() }
	inline infix fun xorAssign(b: UByte) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: UShort) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: UInt) { v = v xor b.toULong() }
	inline infix fun xorAssign(b: ULong) { v = v xor b }
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
	infix inline operator fun compareTo(other: U32): Int = toUInt().compareTo(other.v)
	infix override operator fun compareTo(other: U64): Int = v.compareTo(other.v)
	infix inline operator fun compareTo(other: UByte): Int = toUByte().compareTo(other)
	infix inline operator fun compareTo(other: UShort): Int = toUShort().compareTo(other)
	infix inline operator fun compareTo(other: UInt): Int = toUInt().compareTo(other)
	infix inline operator fun compareTo(other: ULong): Int = v.compareTo(other)
	override fun equals(other: Any?): Boolean = other is U64 && v == other.v
	override fun hashCode(): Int = v.hashCode()
	override fun toString(): String = v.toString()
	inline fun toString(radix: Int): String = v.toString(radix)
	inline fun toString(format: String): String = format.format(this)
}
