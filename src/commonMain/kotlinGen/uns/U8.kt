@file:Suppress("NOTHING_TO_INLINE")
package uns

import com.ionspin.kotlin.bignum.integer.BigInteger
import uns.U16
import uns.format.format
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.and
import uns.U32
import uns.U64
import kotlin.experimental.xor
import uns.BigInt
import com.ionspin.kotlin.bignum.integer.toBigInteger

inline fun U8(byte: Byte): U8 = U8(byte.toUByte())
inline fun U8(short: Short): U8 = U8(short.toUShort())
inline fun U8(int: Int): U8 = U8(int.toUInt())
inline fun U8(long: Long): U8 = U8(long.toULong())
class U8(var v: UByte = MIN.v) : Number(), Comparable<U8> {
	companion object {
		/** A uint constant holding the minimum value an `unsigned byte` can have, 0. */
		val MIN_uint: UInt = 0u
		
		/** A uint constant holding the maximum value an `unsigned byte` can have, 2^8-1. */
		val MAX_uint: UInt = 0xFFu
		
		/** A constant holding the minimum value an `unsigned byte` can have, 0.  */
		val MIN = U8(UByte.MIN_VALUE)
		
		/** A constant holding the maximum value an `unsigned byte` can have, 2^8-1. */
		val MAX = U8(UByte.MAX_VALUE)
		
		/** The number of bytes used to represent an instance of UByte in a binary form. */
		const val SIZE_BYTES: Int = UByte.SIZE_BYTES
		
		/** The number of bits used to represent an instance of UByte in a binary form. */
		const val SIZE_BITS: Int = UByte.SIZE_BITS
	}
	constructor(u8: U8) : this(u8.v)
	constructor(u16: U16) : this(u16.toUByte())
	constructor(u32: U32) : this(u32.toUByte())
	constructor(u64: U64) : this(u64.toUByte())
	constructor(bigint: BigInt, exactRequired: Boolean = true) : this(bigint.ubyteValue(exactRequired))
	constructor(ushort: UShort) : this(ushort.toUByte())
	constructor(uint: UInt) : this(uint.toUByte())
	constructor(ulong: ULong) : this(ulong.toUByte())
	constructor(string: String, radix: Int = 10) : this(string.filter { it != '_' && it != '\'' }.toUByte(radix))
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
	inline fun toUByte(): UByte = v
	inline fun toUShort(): UShort = v.toUShort()
	inline fun toUInt(): UInt = v.toUInt()
	inline fun toULong(): ULong = v.toULong()
	@Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it's recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith = ReplaceWith("this.toInt().toChar()"))
	override fun toChar() = toInt().toChar()
	inline fun copy(): U8 = toU8()
	inline operator fun inc(): U8 = U8(v.inc())
	inline operator fun dec(): U8 = U8(v.dec())
	infix inline operator fun plus(b: Byte): U8 = U8(v + b.toUByte())
	infix inline operator fun plus(b: Short): Short = (v.toShort() + b).toShort()
	infix inline operator fun plus(b: Int): Int = v.toInt() + b
	infix inline operator fun plus(b: Long): Long = v.toLong() + b
	infix inline operator fun plus(b: U8): U8 = U8(v + b.v)
	infix inline operator fun plus(b: U16): U16 = U16(v.toUShort() + b.v)
	infix inline operator fun plus(b: U32): U32 = U32(v.toUInt() + b.v)
	infix inline operator fun plus(b: U64): U64 = U64(v.toULong() + b.v)
	infix inline operator fun plus(b: BigInt): BigInt = v.toBigInteger() + b
	infix inline operator fun plus(b: Float): Float = v.toFloat() + b
	infix inline operator fun plus(b: Double): Double = v.toDouble() + b
	infix inline operator fun plus(b: UByte): U8 = U8(v + b)
	infix inline operator fun plus(b: UShort): UShort = (v.toUShort() + b).toUShort()
	infix inline operator fun plus(b: UInt): UInt = v.toUInt() + b
	infix inline operator fun plus(b: ULong): ULong = v.toULong() + b
	infix inline operator fun minus(b: Byte): U8 = U8(v - b.toUByte())
	infix inline operator fun minus(b: Short): Short = (v.toShort() - b).toShort()
	infix inline operator fun minus(b: Int): Int = v.toInt() - b
	infix inline operator fun minus(b: Long): Long = v.toLong() - b
	infix inline operator fun minus(b: U8): U8 = U8(v - b.v)
	infix inline operator fun minus(b: U16): U16 = U16(v.toUShort() - b.v)
	infix inline operator fun minus(b: U32): U32 = U32(v.toUInt() - b.v)
	infix inline operator fun minus(b: U64): U64 = U64(v.toULong() - b.v)
	infix inline operator fun minus(b: BigInt): BigInt = v.toBigInteger() - b
	infix inline operator fun minus(b: Float): Float = v.toFloat() - b
	infix inline operator fun minus(b: Double): Double = v.toDouble() - b
	infix inline operator fun minus(b: UByte): U8 = U8(v - b)
	infix inline operator fun minus(b: UShort): UShort = (v.toUShort() - b).toUShort()
	infix inline operator fun minus(b: UInt): UInt = v.toUInt() - b
	infix inline operator fun minus(b: ULong): ULong = v.toULong() - b
	infix inline operator fun times(b: Byte): U8 = U8(v * b.toUByte())
	infix inline operator fun times(b: Short): Short = (v.toShort() * b).toShort()
	infix inline operator fun times(b: Int): Int = v.toInt() * b
	infix inline operator fun times(b: Long): Long = v.toLong() * b
	infix inline operator fun times(b: U8): U8 = U8(v * b.v)
	infix inline operator fun times(b: U16): U16 = U16(v.toUShort() * b.v)
	infix inline operator fun times(b: U32): U32 = U32(v.toUInt() * b.v)
	infix inline operator fun times(b: U64): U64 = U64(v.toULong() * b.v)
	infix inline operator fun times(b: BigInt): BigInt = v.toBigInteger() * b
	infix inline operator fun times(b: Float): Float = v.toFloat() * b
	infix inline operator fun times(b: Double): Double = v.toDouble() * b
	infix inline operator fun times(b: UByte): U8 = U8(v * b)
	infix inline operator fun times(b: UShort): UShort = (v.toUShort() * b).toUShort()
	infix inline operator fun times(b: UInt): UInt = v.toUInt() * b
	infix inline operator fun times(b: ULong): ULong = v.toULong() * b
	infix inline operator fun div(b: Byte): U8 = U8(v / b.toUByte())
	infix inline operator fun div(b: Short): Short = (v.toShort() / b).toShort()
	infix inline operator fun div(b: Int): Int = v.toInt() / b
	infix inline operator fun div(b: Long): Long = v.toLong() / b
	infix inline operator fun div(b: U8): U8 = U8(v / b.v)
	infix inline operator fun div(b: U16): U16 = U16(v.toUShort() / b.v)
	infix inline operator fun div(b: U32): U32 = U32(v.toUInt() / b.v)
	infix inline operator fun div(b: U64): U64 = U64(v.toULong() / b.v)
	infix inline operator fun div(b: BigInt): BigInt = v.toBigInteger() / b
	infix inline operator fun div(b: Float): Float = v.toFloat() / b
	infix inline operator fun div(b: Double): Double = v.toDouble() / b
	infix inline operator fun div(b: UByte): U8 = U8(v / b)
	infix inline operator fun div(b: UShort): UShort = (v.toUShort() / b).toUShort()
	infix inline operator fun div(b: UInt): UInt = v.toUInt() / b
	infix inline operator fun div(b: ULong): ULong = v.toULong() / b
	infix inline operator fun rem(b: Byte): U8 = U8(v % b.toUByte())
	infix inline operator fun rem(b: Short): Short = (v.toShort() % b).toShort()
	infix inline operator fun rem(b: Int): Int = v.toInt() % b
	infix inline operator fun rem(b: Long): Long = v.toLong() % b
	infix inline operator fun rem(b: U8): U8 = U8(v % b.v)
	infix inline operator fun rem(b: U16): U16 = U16(v.toUShort() % b.v)
	infix inline operator fun rem(b: U32): U32 = U32(v.toUInt() % b.v)
	infix inline operator fun rem(b: U64): U64 = U64(v.toULong() % b.v)
	infix inline operator fun rem(b: BigInt): BigInt = v.toBigInteger() % b
	infix inline operator fun rem(b: Float): Float = v.toFloat() % b
	infix inline operator fun rem(b: Double): Double = v.toDouble() % b
	infix inline operator fun rem(b: UByte): U8 = U8(v % b)
	infix inline operator fun rem(b: UShort): UShort = (v.toUShort() % b).toUShort()
	infix inline operator fun rem(b: UInt): UInt = v.toUInt() % b
	infix inline operator fun rem(b: ULong): ULong = v.toULong() % b
	inline operator fun plusAssign(b: Byte) { v = (v + b.toUByte()).toUByte() }
	inline operator fun plusAssign(b: Short) { v = (v.toShort() + b).toUByte() }
	inline operator fun plusAssign(b: Int) { v = (v.toInt() + b).toUByte() }
	inline operator fun plusAssign(b: Long) { v = (v.toLong() + b).toUByte() }
	inline operator fun plusAssign(b: U8) { v = (v + b.v).toUByte() }
	inline operator fun plusAssign(b: U16) { v = (v.toUShort() + b.v).toUByte() }
	inline operator fun plusAssign(b: U32) { v = (v.toUInt() + b.v).toUByte() }
	inline operator fun plusAssign(b: U64) { v = (v.toULong() + b.v).toUByte() }
	inline operator fun plusAssign(b: BigInt) { v = (v.toBigInteger() + b).ubyteValue() }
	inline operator fun plusAssign(b: Float) { v = (v.toFloat() + b).toInt().toUByte() }
	inline operator fun plusAssign(b: Double) { v = (v.toDouble() + b).toInt().toUByte() }
	inline operator fun plusAssign(b: UByte) { v = (v + b).toUByte() }
	inline operator fun plusAssign(b: UShort) { v = (v.toUShort() + b).toUByte() }
	inline operator fun plusAssign(b: UInt) { v = (v.toUInt() + b).toUByte() }
	inline operator fun plusAssign(b: ULong) { v = (v.toULong() + b).toUByte() }
	inline operator fun minusAssign(b: Byte) { v = (v - b.toUByte()).toUByte() }
	inline operator fun minusAssign(b: Short) { v = (v.toShort() - b).toUByte() }
	inline operator fun minusAssign(b: Int) { v = (v.toInt() - b).toUByte() }
	inline operator fun minusAssign(b: Long) { v = (v.toLong() - b).toUByte() }
	inline operator fun minusAssign(b: U8) { v = (v - b.v).toUByte() }
	inline operator fun minusAssign(b: U16) { v = (v.toUShort() - b.v).toUByte() }
	inline operator fun minusAssign(b: U32) { v = (v.toUInt() - b.v).toUByte() }
	inline operator fun minusAssign(b: U64) { v = (v.toULong() - b.v).toUByte() }
	inline operator fun minusAssign(b: BigInt) { v = (v.toBigInteger() - b).ubyteValue() }
	inline operator fun minusAssign(b: Float) { v = (v.toFloat() - b).toInt().toUByte() }
	inline operator fun minusAssign(b: Double) { v = (v.toDouble() - b).toInt().toUByte() }
	inline operator fun minusAssign(b: UByte) { v = (v - b).toUByte() }
	inline operator fun minusAssign(b: UShort) { v = (v.toUShort() - b).toUByte() }
	inline operator fun minusAssign(b: UInt) { v = (v.toUInt() - b).toUByte() }
	inline operator fun minusAssign(b: ULong) { v = (v.toULong() - b).toUByte() }
	inline operator fun timesAssign(b: Byte) { v = (v * b.toUByte()).toUByte() }
	inline operator fun timesAssign(b: Short) { v = (v.toShort() * b).toUByte() }
	inline operator fun timesAssign(b: Int) { v = (v.toInt() * b).toUByte() }
	inline operator fun timesAssign(b: Long) { v = (v.toLong() * b).toUByte() }
	inline operator fun timesAssign(b: U8) { v = (v * b.v).toUByte() }
	inline operator fun timesAssign(b: U16) { v = (v.toUShort() * b.v).toUByte() }
	inline operator fun timesAssign(b: U32) { v = (v.toUInt() * b.v).toUByte() }
	inline operator fun timesAssign(b: U64) { v = (v.toULong() * b.v).toUByte() }
	inline operator fun timesAssign(b: BigInt) { v = (v.toBigInteger() * b).ubyteValue() }
	inline operator fun timesAssign(b: Float) { v = (v.toFloat() * b).toInt().toUByte() }
	inline operator fun timesAssign(b: Double) { v = (v.toDouble() * b).toInt().toUByte() }
	inline operator fun timesAssign(b: UByte) { v = (v * b).toUByte() }
	inline operator fun timesAssign(b: UShort) { v = (v.toUShort() * b).toUByte() }
	inline operator fun timesAssign(b: UInt) { v = (v.toUInt() * b).toUByte() }
	inline operator fun timesAssign(b: ULong) { v = (v.toULong() * b).toUByte() }
	inline operator fun divAssign(b: Byte) { v = (v / b.toUByte()).toUByte() }
	inline operator fun divAssign(b: Short) { v = (v.toShort() / b).toUByte() }
	inline operator fun divAssign(b: Int) { v = (v.toInt() / b).toUByte() }
	inline operator fun divAssign(b: Long) { v = (v.toLong() / b).toUByte() }
	inline operator fun divAssign(b: U8) { v = (v / b.v).toUByte() }
	inline operator fun divAssign(b: U16) { v = (v.toUShort() / b.v).toUByte() }
	inline operator fun divAssign(b: U32) { v = (v.toUInt() / b.v).toUByte() }
	inline operator fun divAssign(b: U64) { v = (v.toULong() / b.v).toUByte() }
	inline operator fun divAssign(b: BigInt) { v = (v.toBigInteger() / b).ubyteValue() }
	inline operator fun divAssign(b: Float) { v = (v.toFloat() / b).toInt().toUByte() }
	inline operator fun divAssign(b: Double) { v = (v.toDouble() / b).toInt().toUByte() }
	inline operator fun divAssign(b: UByte) { v = (v / b).toUByte() }
	inline operator fun divAssign(b: UShort) { v = (v.toUShort() / b).toUByte() }
	inline operator fun divAssign(b: UInt) { v = (v.toUInt() / b).toUByte() }
	inline operator fun divAssign(b: ULong) { v = (v.toULong() / b).toUByte() }
	inline operator fun remAssign(b: Byte) { v = (v % b.toUByte()).toUByte() }
	inline operator fun remAssign(b: Short) { v = (v.toShort() % b).toUByte() }
	inline operator fun remAssign(b: Int) { v = (v.toInt() % b).toUByte() }
	inline operator fun remAssign(b: Long) { v = (v.toLong() % b).toUByte() }
	inline operator fun remAssign(b: U8) { v = (v % b.v).toUByte() }
	inline operator fun remAssign(b: U16) { v = (v.toUShort() % b.v).toUByte() }
	inline operator fun remAssign(b: U32) { v = (v.toUInt() % b.v).toUByte() }
	inline operator fun remAssign(b: U64) { v = (v.toULong() % b.v).toUByte() }
	inline operator fun remAssign(b: BigInt) { v = (v.toBigInteger() % b).ubyteValue() }
	inline operator fun remAssign(b: Float) { v = (v.toFloat() % b).toInt().toUByte() }
	inline operator fun remAssign(b: Double) { v = (v.toDouble() % b).toInt().toUByte() }
	inline operator fun remAssign(b: UByte) { v = (v % b).toUByte() }
	inline operator fun remAssign(b: UShort) { v = (v.toUShort() % b).toUByte() }
	inline operator fun remAssign(b: UInt) { v = (v.toUInt() % b).toUByte() }
	inline operator fun remAssign(b: ULong) { v = (v.toULong() % b).toUByte() }
	inline infix fun and(b: Byte): U8 = U8(v and b.toUByte())
	inline infix fun and(b: Short): U8 = U8(v and b.toUShort().toUByte())
	inline infix fun and(b: Int): U8 = U8(v and b.toUInt().toUByte())
	inline infix fun and(b: Long): U8 = U8(v and b.toULong().toUByte())
	inline infix fun and(b: U8): U8 = U8(v and b.v)
	inline infix fun and(b: U16): U8 = U8(v and b.v.toUByte())
	inline infix fun and(b: U32): U8 = U8(v and b.v.toUByte())
	inline infix fun and(b: U64): U8 = U8(v and b.v.toUByte())
	inline infix fun and(b: BigInt): U8 = U8(v and b.ubyteValue())
	inline infix fun and(b: UByte): U8 = U8(v and b)
	inline infix fun and(b: UShort): U8 = U8(v and b.toUByte())
	inline infix fun and(b: UInt): U8 = U8(v and b.toUByte())
	inline infix fun and(b: ULong): U8 = U8(v and b.toUByte())
	inline infix fun or(b: Byte): U8 = U8(v or b.toUByte())
	inline infix fun or(b: Short): U8 = U8(v or b.toUShort().toUByte())
	inline infix fun or(b: Int): U8 = U8(v or b.toUInt().toUByte())
	inline infix fun or(b: Long): U8 = U8(v or b.toULong().toUByte())
	inline infix fun or(b: U8): U8 = U8(v or b.v)
	inline infix fun or(b: U16): U8 = U8(v or b.v.toUByte())
	inline infix fun or(b: U32): U8 = U8(v or b.v.toUByte())
	inline infix fun or(b: U64): U8 = U8(v or b.v.toUByte())
	inline infix fun or(b: BigInt): U8 = U8(v or b.ubyteValue())
	inline infix fun or(b: UByte): U8 = U8(v or b)
	inline infix fun or(b: UShort): U8 = U8(v or b.toUByte())
	inline infix fun or(b: UInt): U8 = U8(v or b.toUByte())
	inline infix fun or(b: ULong): U8 = U8(v or b.toUByte())
	inline infix fun xor(b: Byte): U8 = U8(v xor b.toUByte())
	inline infix fun xor(b: Short): U8 = U8(v xor b.toUShort().toUByte())
	inline infix fun xor(b: Int): U8 = U8(v xor b.toUInt().toUByte())
	inline infix fun xor(b: Long): U8 = U8(v xor b.toULong().toUByte())
	inline infix fun xor(b: U8): U8 = U8(v xor b.v)
	inline infix fun xor(b: U16): U8 = U8(v xor b.v.toUByte())
	inline infix fun xor(b: U32): U8 = U8(v xor b.v.toUByte())
	inline infix fun xor(b: U64): U8 = U8(v xor b.v.toUByte())
	inline infix fun xor(b: BigInt): U8 = U8(v xor b.ubyteValue())
	inline infix fun xor(b: UByte): U8 = U8(v xor b)
	inline infix fun xor(b: UShort): U8 = U8(v xor b.toUByte())
	inline infix fun xor(b: UInt): U8 = U8(v xor b.toUByte())
	inline infix fun xor(b: ULong): U8 = U8(v xor b.toUByte())
	inline infix fun shl(b: Byte): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: Short): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: Int): U8 = U8(v.toUInt() shl b)
	inline infix fun shl(b: Long): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: U8): U8 = U8(v.toUInt() shl b.v.toInt())
	inline infix fun shl(b: U16): U8 = U8(v.toUInt() shl b.v.toInt())
	inline infix fun shl(b: U32): U8 = U8(v.toUInt() shl b.v.toInt())
	inline infix fun shl(b: U64): U8 = U8(v.toUInt() shl b.v.toInt())
	inline infix fun shl(b: BigInt): U8 = U8(v.toUInt() shl b.intValue())
	inline infix fun shl(b: UByte): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: UShort): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: UInt): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shl(b: ULong): U8 = U8(v.toUInt() shl b.toInt())
	inline infix fun shr(b: Byte): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: Short): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: Int): U8 = U8(v.toUInt() shr b)
	inline infix fun shr(b: Long): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: U8): U8 = U8(v.toUInt() shr b.v.toInt())
	inline infix fun shr(b: U16): U8 = U8(v.toUInt() shr b.v.toInt())
	inline infix fun shr(b: U32): U8 = U8(v.toUInt() shr b.v.toInt())
	inline infix fun shr(b: U64): U8 = U8(v.toUInt() shr b.v.toInt())
	inline infix fun shr(b: BigInt): U8 = U8(v.toUInt() shr b.intValue())
	inline infix fun shr(b: UByte): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: UShort): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: UInt): U8 = U8(v.toUInt() shr b.toInt())
	inline infix fun shr(b: ULong): U8 = U8(v.toUInt() shr b.toInt())
	inline fun inv(): U8 = U8(v.inv())
	inline infix fun andAssign(b: Byte) { v = v and b.toUByte() }
	inline infix fun andAssign(b: Short) { v = v and b.toUByte() }
	inline infix fun andAssign(b: Int) { v = v and b.toUByte() }
	inline infix fun andAssign(b: Long) { v = v and b.toUByte() }
	inline infix fun andAssign(b: U8) { v = v and b.v }
	inline infix fun andAssign(b: U16) { v = v and b.v.toUByte() }
	inline infix fun andAssign(b: U32) { v = v and b.v.toUByte() }
	inline infix fun andAssign(b: U64) { v = v and b.v.toUByte() }
	inline infix fun andAssign(b: BigInt) { v = v and b.ubyteValue() }
	inline infix fun andAssign(b: UByte) { v = v and b }
	inline infix fun andAssign(b: UShort) { v = v and b.toUByte() }
	inline infix fun andAssign(b: UInt) { v = v and b.toUByte() }
	inline infix fun andAssign(b: ULong) { v = v and b.toUByte() }
	inline infix fun orAssign(b: Byte) { v = v or b.toUByte() }
	inline infix fun orAssign(b: Short) { v = v or b.toUByte() }
	inline infix fun orAssign(b: Int) { v = v or b.toUByte() }
	inline infix fun orAssign(b: Long) { v = v or b.toUByte() }
	inline infix fun orAssign(b: U8) { v = v or b.v }
	inline infix fun orAssign(b: U16) { v = v or b.v.toUByte() }
	inline infix fun orAssign(b: U32) { v = v or b.v.toUByte() }
	inline infix fun orAssign(b: U64) { v = v or b.v.toUByte() }
	inline infix fun orAssign(b: BigInt) { v = v or b.ubyteValue() }
	inline infix fun orAssign(b: UByte) { v = v or b }
	inline infix fun orAssign(b: UShort) { v = v or b.toUByte() }
	inline infix fun orAssign(b: UInt) { v = v or b.toUByte() }
	inline infix fun orAssign(b: ULong) { v = v or b.toUByte() }
	inline infix fun xorAssign(b: Byte) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: Short) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: Int) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: Long) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: U8) { v = v xor b.v }
	inline infix fun xorAssign(b: U16) { v = v xor b.v.toUByte() }
	inline infix fun xorAssign(b: U32) { v = v xor b.v.toUByte() }
	inline infix fun xorAssign(b: U64) { v = v xor b.v.toUByte() }
	inline infix fun xorAssign(b: BigInt) { v = v xor b.ubyteValue() }
	inline infix fun xorAssign(b: UByte) { v = v xor b }
	inline infix fun xorAssign(b: UShort) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: UInt) { v = v xor b.toUByte() }
	inline infix fun xorAssign(b: ULong) { v = v xor b.toUByte() }
	inline infix fun shlAssign(b: Byte) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: Short) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: Int) { v = (v.toUInt() shl b).toUByte() }
	inline infix fun shlAssign(b: Long) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: U8) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: U16) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: U32) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: U64) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: BigInt) { v = (v.toUInt() shl b.intValue()).toUByte() }
	inline infix fun shlAssign(b: UByte) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: UShort) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: UInt) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shlAssign(b: ULong) { v = (v.toUInt() shl b.toInt()).toUByte() }
	inline infix fun shrAssign(b: Byte) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: Short) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: Int) { v = (v.toUInt() shr b).toUByte() }
	inline infix fun shrAssign(b: Long) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: U8) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: U16) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: U32) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: U64) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: BigInt) { v = (v.toUInt() shr b.intValue()).toUByte() }
	inline infix fun shrAssign(b: UByte) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: UShort) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: UInt) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline infix fun shrAssign(b: ULong) { v = (v.toUInt() shr b.toInt()).toUByte() }
	inline fun invAssign() { v = v.inv() }
	infix override operator fun compareTo(other: U8): Int = v.compareTo(other.v)
	infix inline operator fun compareTo(other: U16): Int = toUShort().compareTo(other.v)
	infix inline operator fun compareTo(other: U32): Int = toUInt().compareTo(other.v)
	infix inline operator fun compareTo(other: U64): Int = toULong().compareTo(other.v)
	infix inline operator fun compareTo(other: UByte): Int = v.compareTo(other)
	infix inline operator fun compareTo(other: UShort): Int = toUShort().compareTo(other)
	infix inline operator fun compareTo(other: UInt): Int = toUInt().compareTo(other)
	infix inline operator fun compareTo(other: ULong): Int = toULong().compareTo(other)
	override fun equals(other: Any?): Boolean = other is U8 && v == other.v
	override fun hashCode(): Int = v.hashCode()
	override fun toString(): String = v.toString()
	inline fun toString(radix: Int): String = v.toString(radix)
	inline fun toString(format: String): String = format.format(this)
}
