package uns

import com.ionspin.kotlin.bignum.integer.toBigInteger

inline val Byte.i16: I16
    get() = toShort()
inline val Byte.i32: I32
    get() = toInt()
inline val Byte.i: I32
    get() = i32
inline val Byte.i64: I64
    get() = toLong()
inline val Byte.L: I64
    get() = i64
inline val Byte.u8: U8
    get() = U8(this)
inline val Byte.u16: U16
    get() = U16(this)
inline val Byte.u32: U32
    get() = U32(this)
inline val Byte.u64: U64
    get() = U64(this)
inline val Byte.bigInt: BigInt
    get() = toBigInteger()
inline val Byte.ub: UByte
    get() = toUByte()
inline val Byte.us: UShort
    get() = toUShort()
inline val Byte.ui: UInt
    get() = toUInt()
inline val Byte.ul: ULong
    get() = toULong()
inline val Byte.f32: F32
    get() = toFloat()
inline val Byte.f: F32
    get() = f32
inline val Byte.f64: F64
    get() = toDouble()
inline val Short.i8: I8
    get() = toByte()
inline val Short.i32: I32
    get() = toInt()
inline val Short.i: I32
    get() = i32
inline val Short.i64: I64
    get() = toLong()
inline val Short.L: I64
    get() = i64
inline val Short.u8: U8
    get() = U8(this)
inline val Short.u16: U16
    get() = U16(this)
inline val Short.u32: U32
    get() = U32(this)
inline val Short.u64: U64
    get() = U64(this)
inline val Short.bigInt: BigInt
    get() = toBigInteger()
inline val Short.ub: UByte
    get() = toUByte()
inline val Short.us: UShort
    get() = toUShort()
inline val Short.ui: UInt
    get() = toUInt()
inline val Short.ul: ULong
    get() = toULong()
inline val Short.f32: F32
    get() = toFloat()
inline val Short.f: F32
    get() = f32
inline val Short.f64: F64
    get() = toDouble()
inline val Int.i8: I8
    get() = toByte()
inline val Int.i16: I16
    get() = toShort()
inline val Int.i64: I64
    get() = toLong()
inline val Int.L: I64
    get() = i64
inline val Int.u8: U8
    get() = U8(this)
inline val Int.u16: U16
    get() = U16(this)
inline val Int.u32: U32
    get() = U32(this)
inline val Int.u64: U64
    get() = U64(this)
inline val Int.bigInt: BigInt
    get() = toBigInteger()
inline val Int.ub: UByte
    get() = toUByte()
inline val Int.us: UShort
    get() = toUShort()
inline val Int.ui: UInt
    get() = toUInt()
inline val Int.ul: ULong
    get() = toULong()
inline val Int.f32: F32
    get() = toFloat()
inline val Int.f: F32
    get() = f32
inline val Int.f64: F64
    get() = toDouble()
inline val Long.i8: I8
    get() = toByte()
inline val Long.i16: I16
    get() = toShort()
inline val Long.i32: I32
    get() = toInt()
inline val Long.i: I32
    get() = i32
inline val Long.u8: U8
    get() = U8(this)
inline val Long.u16: U16
    get() = U16(this)
inline val Long.u32: U32
    get() = U32(this)
inline val Long.u64: U64
    get() = U64(this)
inline val Long.bigInt: BigInt
    get() = toBigInteger()
inline val Long.ub: UByte
    get() = toUByte()
inline val Long.us: UShort
    get() = toUShort()
inline val Long.ui: UInt
    get() = toUInt()
inline val Long.ul: ULong
    get() = toULong()
inline val Long.f32: F32
    get() = toFloat()
inline val Long.f: F32
    get() = f32
inline val Long.f64: F64
    get() = toDouble()
inline val U8.i8: I8
    get() = toByte()
inline val U8.i16: I16
    get() = toShort()
inline val U8.i32: I32
    get() = toInt()
inline val U8.i: I32
    get() = i32
inline val U8.i64: I64
    get() = toLong()
inline val U8.L: I64
    get() = i64
inline val U8.u16: U16
    get() = U16(this)
inline val U8.u32: U32
    get() = U32(this)
inline val U8.u64: U64
    get() = U64(this)
inline val U8.bigInt: BigInt
    get() = toBigInt()
inline val U8.ub: UByte
    get() = toUByte()
inline val U8.us: UShort
    get() = toUShort()
inline val U8.ui: UInt
    get() = toUInt()
inline val U8.ul: ULong
    get() = toULong()
inline val U8.f32: F32
    get() = toFloat()
inline val U8.f: F32
    get() = f32
inline val U8.f64: F64
    get() = toDouble()
inline val U16.i8: I8
    get() = toByte()
inline val U16.i16: I16
    get() = toShort()
inline val U16.i32: I32
    get() = toInt()
inline val U16.i: I32
    get() = i32
inline val U16.i64: I64
    get() = toLong()
inline val U16.L: I64
    get() = i64
inline val U16.u8: U8
    get() = U8(this)
inline val U16.u32: U32
    get() = U32(this)
inline val U16.u64: U64
    get() = U64(this)
inline val U16.bigInt: BigInt
    get() = toBigInt()
inline val U16.ub: UByte
    get() = toUByte()
inline val U16.us: UShort
    get() = toUShort()
inline val U16.ui: UInt
    get() = toUInt()
inline val U16.ul: ULong
    get() = toULong()
inline val U16.f32: F32
    get() = toFloat()
inline val U16.f: F32
    get() = f32
inline val U16.f64: F64
    get() = toDouble()
inline val U32.i8: I8
    get() = toByte()
inline val U32.i16: I16
    get() = toShort()
inline val U32.i32: I32
    get() = toInt()
inline val U32.i: I32
    get() = i32
inline val U32.i64: I64
    get() = toLong()
inline val U32.L: I64
    get() = i64
inline val U32.u8: U8
    get() = U8(this)
inline val U32.u16: U16
    get() = U16(this)
inline val U32.u64: U64
    get() = U64(this)
inline val U32.bigInt: BigInt
    get() = toBigInt()
inline val U32.ub: UByte
    get() = toUByte()
inline val U32.us: UShort
    get() = toUShort()
inline val U32.ui: UInt
    get() = toUInt()
inline val U32.ul: ULong
    get() = toULong()
inline val U32.f32: F32
    get() = toFloat()
inline val U32.f: F32
    get() = f32
inline val U32.f64: F64
    get() = toDouble()
inline val U64.i8: I8
    get() = toByte()
inline val U64.i16: I16
    get() = toShort()
inline val U64.i32: I32
    get() = toInt()
inline val U64.i: I32
    get() = i32
inline val U64.i64: I64
    get() = toLong()
inline val U64.L: I64
    get() = i64
inline val U64.u8: U8
    get() = U8(this)
inline val U64.u16: U16
    get() = U16(this)
inline val U64.u32: U32
    get() = U32(this)
inline val U64.bigInt: BigInt
    get() = toBigInt()
inline val U64.ub: UByte
    get() = toUByte()
inline val U64.us: UShort
    get() = toUShort()
inline val U64.ui: UInt
    get() = toUInt()
inline val U64.ul: ULong
    get() = toULong()
inline val U64.f32: F32
    get() = toFloat()
inline val U64.f: F32
    get() = f32
inline val U64.f64: F64
    get() = toDouble()
inline val BigInt.i8: I8
    get() = byteValue()
inline val BigInt.i16: I16
    get() = shortValue()
inline val BigInt.i32: I32
    get() = intValue()
inline val BigInt.i: I32
    get() = i32
inline val BigInt.i64: I64
    get() = longValue()
inline val BigInt.L: I64
    get() = i64
inline val BigInt.u8: U8
    get() = U8(ubyteValue())
inline val BigInt.u16: U16
    get() = U16(ushortValue())
inline val BigInt.u32: U32
    get() = U32(uintValue())
inline val BigInt.u64: U64
    get() = U64(ulongValue())
inline val BigInt.ub: UByte
    get() = ubyteValue()
inline val BigInt.us: UShort
    get() = ushortValue()
inline val BigInt.ui: UInt
    get() = uintValue()
inline val BigInt.ul: ULong
    get() = ulongValue()
inline val BigInt.f32: F32
    get() = floatValue()
inline val BigInt.f: F32
    get() = f32
inline val BigInt.f64: F64
    get() = doubleValue()
inline val UByte.i8: I8
    get() = toByte()
inline val UByte.i16: I16
    get() = toShort()
inline val UByte.i32: I32
    get() = toInt()
inline val UByte.i: I32
    get() = i32
inline val UByte.i64: I64
    get() = toLong()
inline val UByte.L: I64
    get() = i64
inline val UByte.u8: U8
    get() = U8(this)
inline val UByte.u16: U16
    get() = U16(this)
inline val UByte.u32: U32
    get() = U32(this)
inline val UByte.u64: U64
    get() = U64(this)
inline val UByte.bigInt: BigInt
    get() = toBigInteger()
inline val UByte.us: UShort
    get() = toUShort()
inline val UByte.ui: UInt
    get() = toUInt()
inline val UByte.ul: ULong
    get() = toULong()
inline val UByte.f32: F32
    get() = toFloat()
inline val UByte.f: F32
    get() = f32
inline val UByte.f64: F64
    get() = toDouble()
inline val UShort.i8: I8
    get() = toByte()
inline val UShort.i16: I16
    get() = toShort()
inline val UShort.i32: I32
    get() = toInt()
inline val UShort.i: I32
    get() = i32
inline val UShort.i64: I64
    get() = toLong()
inline val UShort.L: I64
    get() = i64
inline val UShort.u8: U8
    get() = U8(this)
inline val UShort.u16: U16
    get() = U16(this)
inline val UShort.u32: U32
    get() = U32(this)
inline val UShort.u64: U64
    get() = U64(this)
inline val UShort.bigInt: BigInt
    get() = toBigInteger()
inline val UShort.ub: UByte
    get() = toUByte()
inline val UShort.ui: UInt
    get() = toUInt()
inline val UShort.ul: ULong
    get() = toULong()
inline val UShort.f32: F32
    get() = toFloat()
inline val UShort.f: F32
    get() = f32
inline val UShort.f64: F64
    get() = toDouble()
inline val UInt.i8: I8
    get() = toByte()
inline val UInt.i16: I16
    get() = toShort()
inline val UInt.i32: I32
    get() = toInt()
inline val UInt.i: I32
    get() = i32
inline val UInt.i64: I64
    get() = toLong()
inline val UInt.L: I64
    get() = i64
inline val UInt.u8: U8
    get() = U8(this)
inline val UInt.u16: U16
    get() = U16(this)
inline val UInt.u32: U32
    get() = U32(this)
inline val UInt.u64: U64
    get() = U64(this)
inline val UInt.bigInt: BigInt
    get() = toBigInteger()
inline val UInt.ub: UByte
    get() = toUByte()
inline val UInt.us: UShort
    get() = toUShort()
inline val UInt.ul: ULong
    get() = toULong()
inline val UInt.f32: F32
    get() = toFloat()
inline val UInt.f: F32
    get() = f32
inline val UInt.f64: F64
    get() = toDouble()
inline val ULong.i8: I8
    get() = toByte()
inline val ULong.i16: I16
    get() = toShort()
inline val ULong.i32: I32
    get() = toInt()
inline val ULong.i: I32
    get() = i32
inline val ULong.i64: I64
    get() = toLong()
inline val ULong.L: I64
    get() = i64
inline val ULong.u8: U8
    get() = U8(this)
inline val ULong.u16: U16
    get() = U16(this)
inline val ULong.u32: U32
    get() = U32(this)
inline val ULong.u64: U64
    get() = U64(this)
inline val ULong.bigInt: BigInt
    get() = toBigInteger()
inline val ULong.ub: UByte
    get() = toUByte()
inline val ULong.us: UShort
    get() = toUShort()
inline val ULong.ui: UInt
    get() = toUInt()
inline val ULong.f32: F32
    get() = toFloat()
inline val ULong.f: F32
    get() = f32
inline val ULong.f64: F64
    get() = toDouble()
