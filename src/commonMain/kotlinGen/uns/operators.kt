@file:Suppress("NOTHING_TO_INLINE")
package uns

import com.ionspin.kotlin.bignum.integer.toBigInteger

inline infix operator fun Byte.plus(other: U8): U8 = U8(this.toUByte() + other.v)
inline infix operator fun Byte.plus(other: U16): U16 = U16(this.toUByte() + other.v)
inline infix operator fun Byte.plus(other: U32): U32 = U32(this.toUByte() + other.v)
inline infix operator fun Byte.plus(other: U64): U64 = U64(this.toUByte() + other.v)
inline infix operator fun Byte.minus(other: U8): U8 = U8(this.toUByte() - other.v)
inline infix operator fun Byte.minus(other: U16): U16 = U16(this.toUByte() - other.v)
inline infix operator fun Byte.minus(other: U32): U32 = U32(this.toUByte() - other.v)
inline infix operator fun Byte.minus(other: U64): U64 = U64(this.toUByte() - other.v)
inline infix operator fun Byte.times(other: U8): U8 = U8(this.toUByte() * other.v)
inline infix operator fun Byte.times(other: U16): U16 = U16(this.toUByte() * other.v)
inline infix operator fun Byte.times(other: U32): U32 = U32(this.toUByte() * other.v)
inline infix operator fun Byte.times(other: U64): U64 = U64(this.toUByte() * other.v)
inline infix operator fun Byte.div(other: U8): U8 = U8(this.toUByte() / other.v)
inline infix operator fun Byte.div(other: U16): U16 = U16(this.toUByte() / other.v)
inline infix operator fun Byte.div(other: U32): U32 = U32(this.toUByte() / other.v)
inline infix operator fun Byte.div(other: U64): U64 = U64(this.toUByte() / other.v)
inline infix operator fun Byte.rem(other: U8): U8 = U8(this.toUByte() % other.v)
inline infix operator fun Byte.rem(other: U16): U16 = U16(this.toUByte() % other.v)
inline infix operator fun Byte.rem(other: U32): U32 = U32(this.toUByte() % other.v)
inline infix operator fun Byte.rem(other: U64): U64 = U64(this.toUByte() % other.v)
inline infix operator fun Short.plus(other: U8): Short = (this + other.toShort()).toShort()
inline infix operator fun Short.plus(other: U16): U16 = U16(this.toUShort() + other.v)
inline infix operator fun Short.plus(other: U32): U32 = U32(this.toUShort() + other.v)
inline infix operator fun Short.plus(other: U64): U64 = U64(this.toUShort() + other.v)
inline infix operator fun Short.minus(other: U8): Short = (this - other.toShort()).toShort()
inline infix operator fun Short.minus(other: U16): U16 = U16(this.toUShort() - other.v)
inline infix operator fun Short.minus(other: U32): U32 = U32(this.toUShort() - other.v)
inline infix operator fun Short.minus(other: U64): U64 = U64(this.toUShort() - other.v)
inline infix operator fun Short.times(other: U8): Short = (this * other.toShort()).toShort()
inline infix operator fun Short.times(other: U16): U16 = U16(this.toUShort() * other.v)
inline infix operator fun Short.times(other: U32): U32 = U32(this.toUShort() * other.v)
inline infix operator fun Short.times(other: U64): U64 = U64(this.toUShort() * other.v)
inline infix operator fun Short.div(other: U8): Short = (this / other.toShort()).toShort()
inline infix operator fun Short.div(other: U16): U16 = U16(this.toUShort() / other.v)
inline infix operator fun Short.div(other: U32): U32 = U32(this.toUShort() / other.v)
inline infix operator fun Short.div(other: U64): U64 = U64(this.toUShort() / other.v)
inline infix operator fun Short.rem(other: U8): Short = (this % other.toShort()).toShort()
inline infix operator fun Short.rem(other: U16): U16 = U16(this.toUShort() % other.v)
inline infix operator fun Short.rem(other: U32): U32 = U32(this.toUShort() % other.v)
inline infix operator fun Short.rem(other: U64): U64 = U64(this.toUShort() % other.v)
inline infix operator fun Int.plus(other: U8): Int = this + other.toInt()
inline infix operator fun Int.plus(other: U16): Int = this + other.toInt()
inline infix operator fun Int.plus(other: U32): U32 = U32(this.toUInt() + other.v)
inline infix operator fun Int.plus(other: U64): U64 = U64(this.toUInt() + other.v)
inline infix operator fun Int.minus(other: U8): Int = this - other.toInt()
inline infix operator fun Int.minus(other: U16): Int = this - other.toInt()
inline infix operator fun Int.minus(other: U32): U32 = U32(this.toUInt() - other.v)
inline infix operator fun Int.minus(other: U64): U64 = U64(this.toUInt() - other.v)
inline infix operator fun Int.times(other: U8): Int = this * other.toInt()
inline infix operator fun Int.times(other: U16): Int = this * other.toInt()
inline infix operator fun Int.times(other: U32): U32 = U32(this.toUInt() * other.v)
inline infix operator fun Int.times(other: U64): U64 = U64(this.toUInt() * other.v)
inline infix operator fun Int.div(other: U8): Int = this / other.toInt()
inline infix operator fun Int.div(other: U16): Int = this / other.toInt()
inline infix operator fun Int.div(other: U32): U32 = U32(this.toUInt() / other.v)
inline infix operator fun Int.div(other: U64): U64 = U64(this.toUInt() / other.v)
inline infix operator fun Int.rem(other: U8): Int = this % other.toInt()
inline infix operator fun Int.rem(other: U16): Int = this % other.toInt()
inline infix operator fun Int.rem(other: U32): U32 = U32(this.toUInt() % other.v)
inline infix operator fun Int.rem(other: U64): U64 = U64(this.toUInt() % other.v)
inline infix operator fun Long.plus(other: U8): Long = this + other.toLong()
inline infix operator fun Long.plus(other: U16): Long = this + other.toLong()
inline infix operator fun Long.plus(other: U32): Long = this + other.toLong()
inline infix operator fun Long.plus(other: U64): U64 = U64(this.toULong() + other.v)
inline infix operator fun Long.minus(other: U8): Long = this - other.toLong()
inline infix operator fun Long.minus(other: U16): Long = this - other.toLong()
inline infix operator fun Long.minus(other: U32): Long = this - other.toLong()
inline infix operator fun Long.minus(other: U64): U64 = U64(this.toULong() - other.v)
inline infix operator fun Long.times(other: U8): Long = this * other.toLong()
inline infix operator fun Long.times(other: U16): Long = this * other.toLong()
inline infix operator fun Long.times(other: U32): Long = this * other.toLong()
inline infix operator fun Long.times(other: U64): U64 = U64(this.toULong() * other.v)
inline infix operator fun Long.div(other: U8): Long = this / other.toLong()
inline infix operator fun Long.div(other: U16): Long = this / other.toLong()
inline infix operator fun Long.div(other: U32): Long = this / other.toLong()
inline infix operator fun Long.div(other: U64): U64 = U64(this.toULong() / other.v)
inline infix operator fun Long.rem(other: U8): Long = this % other.toLong()
inline infix operator fun Long.rem(other: U16): Long = this % other.toLong()
inline infix operator fun Long.rem(other: U32): Long = this % other.toLong()
inline infix operator fun Long.rem(other: U64): U64 = U64(this.toULong() % other.v)
inline infix operator fun BigInt.plus(other: U8): BigInt = this + other.toBigInt()
inline infix operator fun BigInt.plus(other: U16): BigInt = this + other.toBigInt()
inline infix operator fun BigInt.plus(other: U32): BigInt = this + other.toBigInt()
inline infix operator fun BigInt.plus(other: U64): BigInt = this + other.toBigInt()
inline infix operator fun BigInt.minus(other: U8): BigInt = this - other.toBigInt()
inline infix operator fun BigInt.minus(other: U16): BigInt = this - other.toBigInt()
inline infix operator fun BigInt.minus(other: U32): BigInt = this - other.toBigInt()
inline infix operator fun BigInt.minus(other: U64): BigInt = this - other.toBigInt()
inline infix operator fun BigInt.times(other: U8): BigInt = this * other.toBigInt()
inline infix operator fun BigInt.times(other: U16): BigInt = this * other.toBigInt()
inline infix operator fun BigInt.times(other: U32): BigInt = this * other.toBigInt()
inline infix operator fun BigInt.times(other: U64): BigInt = this * other.toBigInt()
inline infix operator fun BigInt.div(other: U8): BigInt = this / other.toBigInt()
inline infix operator fun BigInt.div(other: U16): BigInt = this / other.toBigInt()
inline infix operator fun BigInt.div(other: U32): BigInt = this / other.toBigInt()
inline infix operator fun BigInt.div(other: U64): BigInt = this / other.toBigInt()
inline infix operator fun BigInt.rem(other: U8): BigInt = this % other.toBigInt()
inline infix operator fun BigInt.rem(other: U16): BigInt = this % other.toBigInt()
inline infix operator fun BigInt.rem(other: U32): BigInt = this % other.toBigInt()
inline infix operator fun BigInt.rem(other: U64): BigInt = this % other.toBigInt()
inline infix operator fun UByte.plus(other: U8): U8 = U8(this + other.v)
inline infix operator fun UByte.plus(other: U16): U16 = U16(this + other.v)
inline infix operator fun UByte.plus(other: U32): U32 = U32(this + other.v)
inline infix operator fun UByte.plus(other: U64): U64 = U64(this + other.v)
inline infix operator fun UByte.minus(other: U8): U8 = U8(this - other.v)
inline infix operator fun UByte.minus(other: U16): U16 = U16(this - other.v)
inline infix operator fun UByte.minus(other: U32): U32 = U32(this - other.v)
inline infix operator fun UByte.minus(other: U64): U64 = U64(this - other.v)
inline infix operator fun UByte.times(other: U8): U8 = U8(this * other.v)
inline infix operator fun UByte.times(other: U16): U16 = U16(this * other.v)
inline infix operator fun UByte.times(other: U32): U32 = U32(this * other.v)
inline infix operator fun UByte.times(other: U64): U64 = U64(this * other.v)
inline infix operator fun UByte.div(other: U8): U8 = U8(this / other.v)
inline infix operator fun UByte.div(other: U16): U16 = U16(this / other.v)
inline infix operator fun UByte.div(other: U32): U32 = U32(this / other.v)
inline infix operator fun UByte.div(other: U64): U64 = U64(this / other.v)
inline infix operator fun UByte.rem(other: U8): U8 = U8(this % other.v)
inline infix operator fun UByte.rem(other: U16): U16 = U16(this % other.v)
inline infix operator fun UByte.rem(other: U32): U32 = U32(this % other.v)
inline infix operator fun UByte.rem(other: U64): U64 = U64(this % other.v)
inline infix operator fun UShort.plus(other: U8): UShort = (this + other.v).toUShort()
inline infix operator fun UShort.plus(other: U16): U16 = U16(this + other.v)
inline infix operator fun UShort.plus(other: U32): U32 = U32(this + other.v)
inline infix operator fun UShort.plus(other: U64): U64 = U64(this + other.v)
inline infix operator fun UShort.minus(other: U8): UShort = (this - other.v).toUShort()
inline infix operator fun UShort.minus(other: U16): U16 = U16(this - other.v)
inline infix operator fun UShort.minus(other: U32): U32 = U32(this - other.v)
inline infix operator fun UShort.minus(other: U64): U64 = U64(this - other.v)
inline infix operator fun UShort.times(other: U8): UShort = (this * other.v).toUShort()
inline infix operator fun UShort.times(other: U16): U16 = U16(this * other.v)
inline infix operator fun UShort.times(other: U32): U32 = U32(this * other.v)
inline infix operator fun UShort.times(other: U64): U64 = U64(this * other.v)
inline infix operator fun UShort.div(other: U8): UShort = (this / other.v).toUShort()
inline infix operator fun UShort.div(other: U16): U16 = U16(this / other.v)
inline infix operator fun UShort.div(other: U32): U32 = U32(this / other.v)
inline infix operator fun UShort.div(other: U64): U64 = U64(this / other.v)
inline infix operator fun UShort.rem(other: U8): UShort = (this % other.v).toUShort()
inline infix operator fun UShort.rem(other: U16): U16 = U16(this % other.v)
inline infix operator fun UShort.rem(other: U32): U32 = U32(this % other.v)
inline infix operator fun UShort.rem(other: U64): U64 = U64(this % other.v)
inline infix operator fun UInt.plus(other: U8): UInt = this + other.v
inline infix operator fun UInt.plus(other: U16): UInt = this + other.v
inline infix operator fun UInt.plus(other: U32): U32 = U32(this + other.v)
inline infix operator fun UInt.plus(other: U64): U64 = U64(this + other.v)
inline infix operator fun UInt.minus(other: U8): UInt = this - other.v
inline infix operator fun UInt.minus(other: U16): UInt = this - other.v
inline infix operator fun UInt.minus(other: U32): U32 = U32(this - other.v)
inline infix operator fun UInt.minus(other: U64): U64 = U64(this - other.v)
inline infix operator fun UInt.times(other: U8): UInt = this * other.v
inline infix operator fun UInt.times(other: U16): UInt = this * other.v
inline infix operator fun UInt.times(other: U32): U32 = U32(this * other.v)
inline infix operator fun UInt.times(other: U64): U64 = U64(this * other.v)
inline infix operator fun UInt.div(other: U8): UInt = this / other.v
inline infix operator fun UInt.div(other: U16): UInt = this / other.v
inline infix operator fun UInt.div(other: U32): U32 = U32(this / other.v)
inline infix operator fun UInt.div(other: U64): U64 = U64(this / other.v)
inline infix operator fun UInt.rem(other: U8): UInt = this % other.v
inline infix operator fun UInt.rem(other: U16): UInt = this % other.v
inline infix operator fun UInt.rem(other: U32): U32 = U32(this % other.v)
inline infix operator fun UInt.rem(other: U64): U64 = U64(this % other.v)
inline infix operator fun ULong.plus(other: U8): ULong = this + other.v
inline infix operator fun ULong.plus(other: U16): ULong = this + other.v
inline infix operator fun ULong.plus(other: U32): ULong = this + other.v
inline infix operator fun ULong.plus(other: U64): U64 = U64(this + other.v)
inline infix operator fun ULong.minus(other: U8): ULong = this - other.v
inline infix operator fun ULong.minus(other: U16): ULong = this - other.v
inline infix operator fun ULong.minus(other: U32): ULong = this - other.v
inline infix operator fun ULong.minus(other: U64): U64 = U64(this - other.v)
inline infix operator fun ULong.times(other: U8): ULong = this * other.v
inline infix operator fun ULong.times(other: U16): ULong = this * other.v
inline infix operator fun ULong.times(other: U32): ULong = this * other.v
inline infix operator fun ULong.times(other: U64): U64 = U64(this * other.v)
inline infix operator fun ULong.div(other: U8): ULong = this / other.v
inline infix operator fun ULong.div(other: U16): ULong = this / other.v
inline infix operator fun ULong.div(other: U32): ULong = this / other.v
inline infix operator fun ULong.div(other: U64): U64 = U64(this / other.v)
inline infix operator fun ULong.rem(other: U8): ULong = this % other.v
inline infix operator fun ULong.rem(other: U16): ULong = this % other.v
inline infix operator fun ULong.rem(other: U32): ULong = this % other.v
inline infix operator fun ULong.rem(other: U64): U64 = U64(this % other.v)
inline infix fun Byte.and(other: U8): Byte = (this.toUByte() and other.v).toByte()
inline infix fun Byte.and(other: U16): Byte = (this.toUByte() and other.v.toUByte()).toByte()
inline infix fun Byte.and(other: U32): Byte = (this.toUByte() and other.v.toUByte()).toByte()
inline infix fun Byte.and(other: U64): Byte = (this.toUByte() and other.v.toUByte()).toByte()
inline infix fun Byte.or(other: U8): Byte = (this.toUByte() or other.v).toByte()
inline infix fun Byte.or(other: U16): Byte = (this.toUByte() or other.v.toUByte()).toByte()
inline infix fun Byte.or(other: U32): Byte = (this.toUByte() or other.v.toUByte()).toByte()
inline infix fun Byte.or(other: U64): Byte = (this.toUByte() or other.v.toUByte()).toByte()
inline infix fun Byte.xor(other: U8): Byte = (this.toUByte() xor other.v).toByte()
inline infix fun Byte.xor(other: U16): Byte = (this.toUByte() xor other.v.toUByte()).toByte()
inline infix fun Byte.xor(other: U32): Byte = (this.toUByte() xor other.v.toUByte()).toByte()
inline infix fun Byte.xor(other: U64): Byte = (this.toUByte() xor other.v.toUByte()).toByte()
inline infix fun Byte.shl(other: U8): Byte = (this.toUByte().toUInt() shl other.v.toInt()).toByte()
inline infix fun Byte.shl(other: U16): Byte = (this.toUByte().toUInt() shl other.v.toInt()).toByte()
inline infix fun Byte.shl(other: U32): Byte = (this.toUByte().toUInt() shl other.v.toInt()).toByte()
inline infix fun Byte.shl(other: U64): Byte = (this.toUByte().toUInt() shl other.v.toInt()).toByte()
inline infix fun Byte.shr(other: U8): Byte = (this.toUByte().toUInt() shr other.v.toInt()).toByte()
inline infix fun Byte.shr(other: U16): Byte = (this.toUByte().toUInt() shr other.v.toInt()).toByte()
inline infix fun Byte.shr(other: U32): Byte = (this.toUByte().toUInt() shr other.v.toInt()).toByte()
inline infix fun Byte.shr(other: U64): Byte = (this.toUByte().toUInt() shr other.v.toInt()).toByte()
inline infix fun Short.and(other: U8): Short = (this.toUShort() and other.v.toUShort()).toShort()
inline infix fun Short.and(other: U16): Short = (this.toUShort() and other.v).toShort()
inline infix fun Short.and(other: U32): Short = (this.toUShort() and other.v.toUShort()).toShort()
inline infix fun Short.and(other: U64): Short = (this.toUShort() and other.v.toUShort()).toShort()
inline infix fun Short.or(other: U8): Short = (this.toUShort() or other.v.toUShort()).toShort()
inline infix fun Short.or(other: U16): Short = (this.toUShort() or other.v).toShort()
inline infix fun Short.or(other: U32): Short = (this.toUShort() or other.v.toUShort()).toShort()
inline infix fun Short.or(other: U64): Short = (this.toUShort() or other.v.toUShort()).toShort()
inline infix fun Short.xor(other: U8): Short = (this.toUShort() xor other.v.toUShort()).toShort()
inline infix fun Short.xor(other: U16): Short = (this.toUShort() xor other.v).toShort()
inline infix fun Short.xor(other: U32): Short = (this.toUShort() xor other.v.toUShort()).toShort()
inline infix fun Short.xor(other: U64): Short = (this.toUShort() xor other.v.toUShort()).toShort()
inline infix fun Short.shl(other: U8): Short = (this.toUShort().toUInt() shl other.v.toInt()).toShort()
inline infix fun Short.shl(other: U16): Short = (this.toUShort().toUInt() shl other.v.toInt()).toShort()
inline infix fun Short.shl(other: U32): Short = (this.toUShort().toUInt() shl other.v.toInt()).toShort()
inline infix fun Short.shl(other: U64): Short = (this.toUShort().toUInt() shl other.v.toInt()).toShort()
inline infix fun Short.shr(other: U8): Short = (this.toUShort().toUInt() shr other.v.toInt()).toShort()
inline infix fun Short.shr(other: U16): Short = (this.toUShort().toUInt() shr other.v.toInt()).toShort()
inline infix fun Short.shr(other: U32): Short = (this.toUShort().toUInt() shr other.v.toInt()).toShort()
inline infix fun Short.shr(other: U64): Short = (this.toUShort().toUInt() shr other.v.toInt()).toShort()
inline infix fun Int.and(other: U8): Int = (this.toUInt() and other.v.toUInt()).toInt()
inline infix fun Int.and(other: U16): Int = (this.toUInt() and other.v.toUInt()).toInt()
inline infix fun Int.and(other: U32): Int = (this.toUInt() and other.v).toInt()
inline infix fun Int.and(other: U64): Int = (this.toUInt() and other.v.toUInt()).toInt()
inline infix fun Int.or(other: U8): Int = (this.toUInt() or other.v.toUInt()).toInt()
inline infix fun Int.or(other: U16): Int = (this.toUInt() or other.v.toUInt()).toInt()
inline infix fun Int.or(other: U32): Int = (this.toUInt() or other.v).toInt()
inline infix fun Int.or(other: U64): Int = (this.toUInt() or other.v.toUInt()).toInt()
inline infix fun Int.xor(other: U8): Int = (this.toUInt() xor other.v.toUInt()).toInt()
inline infix fun Int.xor(other: U16): Int = (this.toUInt() xor other.v.toUInt()).toInt()
inline infix fun Int.xor(other: U32): Int = (this.toUInt() xor other.v).toInt()
inline infix fun Int.xor(other: U64): Int = (this.toUInt() xor other.v.toUInt()).toInt()
inline infix fun Int.shl(other: U8): Int = this shl other.v.toInt()
inline infix fun Int.shl(other: U16): Int = this shl other.v.toInt()
inline infix fun Int.shl(other: U32): Int = this shl other.v.toInt()
inline infix fun Int.shl(other: U64): Int = this shl other.v.toInt()
inline infix fun Int.shr(other: U8): Int = this shr other.v.toInt()
inline infix fun Int.shr(other: U16): Int = this shr other.v.toInt()
inline infix fun Int.shr(other: U32): Int = this shr other.v.toInt()
inline infix fun Int.shr(other: U64): Int = this shr other.v.toInt()
inline infix fun Long.and(other: U8): Long = (this.toULong() and other.v.toULong()).toLong()
inline infix fun Long.and(other: U16): Long = (this.toULong() and other.v.toULong()).toLong()
inline infix fun Long.and(other: U32): Long = (this.toULong() and other.v.toULong()).toLong()
inline infix fun Long.and(other: U64): Long = (this.toULong() and other.v).toLong()
inline infix fun Long.or(other: U8): Long = (this.toULong() or other.v.toULong()).toLong()
inline infix fun Long.or(other: U16): Long = (this.toULong() or other.v.toULong()).toLong()
inline infix fun Long.or(other: U32): Long = (this.toULong() or other.v.toULong()).toLong()
inline infix fun Long.or(other: U64): Long = (this.toULong() or other.v).toLong()
inline infix fun Long.xor(other: U8): Long = (this.toULong() xor other.v.toULong()).toLong()
inline infix fun Long.xor(other: U16): Long = (this.toULong() xor other.v.toULong()).toLong()
inline infix fun Long.xor(other: U32): Long = (this.toULong() xor other.v.toULong()).toLong()
inline infix fun Long.xor(other: U64): Long = (this.toULong() xor other.v).toLong()
inline infix fun Long.shl(other: U8): Long = this shl other.v.toInt()
inline infix fun Long.shl(other: U16): Long = this shl other.v.toInt()
inline infix fun Long.shl(other: U32): Long = this shl other.v.toInt()
inline infix fun Long.shl(other: U64): Long = this shl other.v.toInt()
inline infix fun Long.shr(other: U8): Long = this shr other.v.toInt()
inline infix fun Long.shr(other: U16): Long = this shr other.v.toInt()
inline infix fun Long.shr(other: U32): Long = this shr other.v.toInt()
inline infix fun Long.shr(other: U64): Long = this shr other.v.toInt()
inline infix fun BigInt.and(other: U8): BigInt = this and other.v.toBigInteger()
inline infix fun BigInt.and(other: U16): BigInt = this and other.v.toBigInteger()
inline infix fun BigInt.and(other: U32): BigInt = this and other.v.toBigInteger()
inline infix fun BigInt.and(other: U64): BigInt = this and other.v.toBigInteger()
inline infix fun BigInt.or(other: U8): BigInt = this or other.v.toBigInteger()
inline infix fun BigInt.or(other: U16): BigInt = this or other.v.toBigInteger()
inline infix fun BigInt.or(other: U32): BigInt = this or other.v.toBigInteger()
inline infix fun BigInt.or(other: U64): BigInt = this or other.v.toBigInteger()
inline infix fun BigInt.xor(other: U8): BigInt = this xor other.v.toBigInteger()
inline infix fun BigInt.xor(other: U16): BigInt = this xor other.v.toBigInteger()
inline infix fun BigInt.xor(other: U32): BigInt = this xor other.v.toBigInteger()
inline infix fun BigInt.xor(other: U64): BigInt = this xor other.v.toBigInteger()
inline infix fun BigInt.shl(other: U8): BigInt = this shl other.v.toInt()
inline infix fun BigInt.shl(other: U16): BigInt = this shl other.v.toInt()
inline infix fun BigInt.shl(other: U32): BigInt = this shl other.v.toInt()
inline infix fun BigInt.shl(other: U64): BigInt = this shl other.v.toInt()
inline infix fun BigInt.shr(other: U8): BigInt = this shr other.v.toInt()
inline infix fun BigInt.shr(other: U16): BigInt = this shr other.v.toInt()
inline infix fun BigInt.shr(other: U32): BigInt = this shr other.v.toInt()
inline infix fun BigInt.shr(other: U64): BigInt = this shr other.v.toInt()
inline infix fun UByte.and(other: U8): UByte = this and other.v
inline infix fun UByte.and(other: U16): UByte = this and other.v.toUByte()
inline infix fun UByte.and(other: U32): UByte = this and other.v.toUByte()
inline infix fun UByte.and(other: U64): UByte = this and other.v.toUByte()
inline infix fun UByte.or(other: U8): UByte = this or other.v
inline infix fun UByte.or(other: U16): UByte = this or other.v.toUByte()
inline infix fun UByte.or(other: U32): UByte = this or other.v.toUByte()
inline infix fun UByte.or(other: U64): UByte = this or other.v.toUByte()
inline infix fun UByte.xor(other: U8): UByte = this xor other.v
inline infix fun UByte.xor(other: U16): UByte = this xor other.v.toUByte()
inline infix fun UByte.xor(other: U32): UByte = this xor other.v.toUByte()
inline infix fun UByte.xor(other: U64): UByte = this xor other.v.toUByte()
inline infix fun UByte.shl(other: U8): UByte = (this.toUInt() shl other.v.toInt()).toUByte()
inline infix fun UByte.shl(other: U16): UByte = (this.toUInt() shl other.v.toInt()).toUByte()
inline infix fun UByte.shl(other: U32): UByte = (this.toUInt() shl other.v.toInt()).toUByte()
inline infix fun UByte.shl(other: U64): UByte = (this.toUInt() shl other.v.toInt()).toUByte()
inline infix fun UByte.shr(other: U8): UByte = (this.toUInt() shr other.v.toInt()).toUByte()
inline infix fun UByte.shr(other: U16): UByte = (this.toUInt() shr other.v.toInt()).toUByte()
inline infix fun UByte.shr(other: U32): UByte = (this.toUInt() shr other.v.toInt()).toUByte()
inline infix fun UByte.shr(other: U64): UByte = (this.toUInt() shr other.v.toInt()).toUByte()
infix operator fun UByte.compareTo(other: U8): Int = toUByte().compareTo(other.v)
infix operator fun UByte.compareTo(other: U16): Int = toUByte().compareTo(other.v)
infix operator fun UByte.compareTo(other: U32): Int = toUByte().compareTo(other.v)
infix operator fun UByte.compareTo(other: U64): Int = toUByte().compareTo(other.v)
inline infix fun UShort.and(other: U8): UShort = this and other.v.toUShort()
inline infix fun UShort.and(other: U16): UShort = this and other.v
inline infix fun UShort.and(other: U32): UShort = this and other.v.toUShort()
inline infix fun UShort.and(other: U64): UShort = this and other.v.toUShort()
inline infix fun UShort.or(other: U8): UShort = this or other.v.toUShort()
inline infix fun UShort.or(other: U16): UShort = this or other.v
inline infix fun UShort.or(other: U32): UShort = this or other.v.toUShort()
inline infix fun UShort.or(other: U64): UShort = this or other.v.toUShort()
inline infix fun UShort.xor(other: U8): UShort = this xor other.v.toUShort()
inline infix fun UShort.xor(other: U16): UShort = this xor other.v
inline infix fun UShort.xor(other: U32): UShort = this xor other.v.toUShort()
inline infix fun UShort.xor(other: U64): UShort = this xor other.v.toUShort()
inline infix fun UShort.shl(other: U8): UShort = (this.toUInt() shl other.v.toInt()).toUShort()
inline infix fun UShort.shl(other: U16): UShort = (this.toUInt() shl other.v.toInt()).toUShort()
inline infix fun UShort.shl(other: U32): UShort = (this.toUInt() shl other.v.toInt()).toUShort()
inline infix fun UShort.shl(other: U64): UShort = (this.toUInt() shl other.v.toInt()).toUShort()
inline infix fun UShort.shr(other: U8): UShort = (this.toUInt() shr other.v.toInt()).toUShort()
inline infix fun UShort.shr(other: U16): UShort = (this.toUInt() shr other.v.toInt()).toUShort()
inline infix fun UShort.shr(other: U32): UShort = (this.toUInt() shr other.v.toInt()).toUShort()
inline infix fun UShort.shr(other: U64): UShort = (this.toUInt() shr other.v.toInt()).toUShort()
infix operator fun UShort.compareTo(other: U8): Int = toUShort().compareTo(other.v)
infix operator fun UShort.compareTo(other: U16): Int = toUShort().compareTo(other.v)
infix operator fun UShort.compareTo(other: U32): Int = toUShort().compareTo(other.v)
infix operator fun UShort.compareTo(other: U64): Int = toUShort().compareTo(other.v)
inline infix fun UInt.and(other: U8): UInt = this and other.v.toUInt()
inline infix fun UInt.and(other: U16): UInt = this and other.v.toUInt()
inline infix fun UInt.and(other: U32): UInt = this and other.v
inline infix fun UInt.and(other: U64): UInt = this and other.v.toUInt()
inline infix fun UInt.or(other: U8): UInt = this or other.v.toUInt()
inline infix fun UInt.or(other: U16): UInt = this or other.v.toUInt()
inline infix fun UInt.or(other: U32): UInt = this or other.v
inline infix fun UInt.or(other: U64): UInt = this or other.v.toUInt()
inline infix fun UInt.xor(other: U8): UInt = this xor other.v.toUInt()
inline infix fun UInt.xor(other: U16): UInt = this xor other.v.toUInt()
inline infix fun UInt.xor(other: U32): UInt = this xor other.v
inline infix fun UInt.xor(other: U64): UInt = this xor other.v.toUInt()
inline infix fun UInt.shl(other: U8): UInt = this shl other.v.toInt()
inline infix fun UInt.shl(other: U16): UInt = this shl other.v.toInt()
inline infix fun UInt.shl(other: U32): UInt = this shl other.v.toInt()
inline infix fun UInt.shl(other: U64): UInt = this shl other.v.toInt()
inline infix fun UInt.shr(other: U8): UInt = this shr other.v.toInt()
inline infix fun UInt.shr(other: U16): UInt = this shr other.v.toInt()
inline infix fun UInt.shr(other: U32): UInt = this shr other.v.toInt()
inline infix fun UInt.shr(other: U64): UInt = this shr other.v.toInt()
infix operator fun UInt.compareTo(other: U8): Int = toUInt().compareTo(other.v)
infix operator fun UInt.compareTo(other: U16): Int = toUInt().compareTo(other.v)
infix operator fun UInt.compareTo(other: U32): Int = toUInt().compareTo(other.v)
infix operator fun UInt.compareTo(other: U64): Int = toUInt().compareTo(other.v)
inline infix fun ULong.and(other: U8): ULong = this and other.v.toULong()
inline infix fun ULong.and(other: U16): ULong = this and other.v.toULong()
inline infix fun ULong.and(other: U32): ULong = this and other.v.toULong()
inline infix fun ULong.and(other: U64): ULong = this and other.v
inline infix fun ULong.or(other: U8): ULong = this or other.v.toULong()
inline infix fun ULong.or(other: U16): ULong = this or other.v.toULong()
inline infix fun ULong.or(other: U32): ULong = this or other.v.toULong()
inline infix fun ULong.or(other: U64): ULong = this or other.v
inline infix fun ULong.xor(other: U8): ULong = this xor other.v.toULong()
inline infix fun ULong.xor(other: U16): ULong = this xor other.v.toULong()
inline infix fun ULong.xor(other: U32): ULong = this xor other.v.toULong()
inline infix fun ULong.xor(other: U64): ULong = this xor other.v
inline infix fun ULong.shl(other: U8): ULong = this shl other.v.toInt()
inline infix fun ULong.shl(other: U16): ULong = this shl other.v.toInt()
inline infix fun ULong.shl(other: U32): ULong = this shl other.v.toInt()
inline infix fun ULong.shl(other: U64): ULong = this shl other.v.toInt()
inline infix fun ULong.shr(other: U8): ULong = this shr other.v.toInt()
inline infix fun ULong.shr(other: U16): ULong = this shr other.v.toInt()
inline infix fun ULong.shr(other: U32): ULong = this shr other.v.toInt()
inline infix fun ULong.shr(other: U64): ULong = this shr other.v.toInt()
infix operator fun ULong.compareTo(other: U8): Int = toULong().compareTo(other.v)
infix operator fun ULong.compareTo(other: U16): Int = toULong().compareTo(other.v)
infix operator fun ULong.compareTo(other: U32): Int = toULong().compareTo(other.v)
infix operator fun ULong.compareTo(other: U64): Int = toULong().compareTo(other.v)