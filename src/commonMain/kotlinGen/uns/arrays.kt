@file:OptIn(kotlin.ExperimentalUnsignedTypes::class, kotlin.experimental.ExperimentalTypeInference::class)
package uns

import kotlin.jvm.JvmName
import kotlin.experimental.ExperimentalTypeInference
import kotlin.jvm.JvmInline

@JvmInline
value class U8Array(val data: UByteArray) {

    operator fun get(index: I32): U8 = U8(data[index])

    operator fun set(index: I32, value: U8) { data[index] = value.v }
    
    val indices: IntRange
        get() = data.indices
}

fun U8Array(size: I32): U8Array = U8Array(UByteArray(size))
@OverloadResolutionByLambdaReturnType
@JvmName("U8ArrayUByte")
inline fun U8Array(size: I32, init: (I32) -> UByte): U8Array = U8Array(UByteArray(size, init))
@OverloadResolutionByLambdaReturnType
@JvmName("U8ArrayU8")
inline fun U8Array(size: I32, init: (I32) -> U8): U8Array {
    val array = U8Array(UByteArray(size))
    for (i in array.indices)
        array[i] = init(i)
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U8ArrayI32")
inline fun U8Array(size: I32, init: (I32) -> I32): U8Array {
    val array = U8Array(UByteArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toUByte()
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U8ArrayU32")
inline fun U8Array(size: I32, init: (I32) -> U32): U8Array {
    val array = U8Array(UByteArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toUByte()
    return array
}
@JvmInline
value class U16Array(val data: UShortArray) {

    operator fun get(index: I32): U16 = U16(data[index])

    operator fun set(index: I32, value: U16) { data[index] = value.v }
    
    val indices: IntRange
        get() = data.indices
}

fun U16Array(size: I32): U16Array = U16Array(UShortArray(size))
@OverloadResolutionByLambdaReturnType
@JvmName("U16ArrayUShort")
inline fun U16Array(size: I32, init: (I32) -> UShort): U16Array = U16Array(UShortArray(size, init))
@OverloadResolutionByLambdaReturnType
@JvmName("U16ArrayU16")
inline fun U16Array(size: I32, init: (I32) -> U16): U16Array {
    val array = U16Array(UShortArray(size))
    for (i in array.indices)
        array[i] = init(i)
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U16ArrayI32")
inline fun U16Array(size: I32, init: (I32) -> I32): U16Array {
    val array = U16Array(UShortArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toUShort()
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U16ArrayU32")
inline fun U16Array(size: I32, init: (I32) -> U32): U16Array {
    val array = U16Array(UShortArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toUShort()
    return array
}
@JvmInline
value class U32Array(val data: UIntArray) {

    operator fun get(index: I32): U32 = U32(data[index])

    operator fun set(index: I32, value: U32) { data[index] = value.v }
    
    val indices: IntRange
        get() = data.indices
}

fun U32Array(size: I32): U32Array = U32Array(UIntArray(size))
@OverloadResolutionByLambdaReturnType
@JvmName("U32ArrayUInt")
inline fun U32Array(size: I32, init: (I32) -> UInt): U32Array = U32Array(UIntArray(size, init))
@OverloadResolutionByLambdaReturnType
@JvmName("U32ArrayU32")
inline fun U32Array(size: I32, init: (I32) -> U32): U32Array {
    val array = U32Array(UIntArray(size))
    for (i in array.indices)
        array[i] = init(i)
    return array
}
@JvmInline
value class U64Array(val data: ULongArray) {

    operator fun get(index: I32): U64 = U64(data[index])

    operator fun set(index: I32, value: U64) { data[index] = value.v }
    
    val indices: IntRange
        get() = data.indices
}

fun U64Array(size: I32): U64Array = U64Array(ULongArray(size))
@OverloadResolutionByLambdaReturnType
@JvmName("U64ArrayULong")
inline fun U64Array(size: I32, init: (I32) -> ULong): U64Array = U64Array(ULongArray(size, init))
@OverloadResolutionByLambdaReturnType
@JvmName("U64ArrayU64")
inline fun U64Array(size: I32, init: (I32) -> U64): U64Array {
    val array = U64Array(ULongArray(size))
    for (i in array.indices)
        array[i] = init(i)
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U64ArrayI32")
inline fun U64Array(size: I32, init: (I32) -> I32): U64Array {
    val array = U64Array(ULongArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toULong()
    return array
}
@OverloadResolutionByLambdaReturnType
@JvmName("U64ArrayU32")
inline fun U64Array(size: I32, init: (I32) -> U32): U64Array {
    val array = U64Array(ULongArray(size))
    for (i in array.indices)
        array.data[i] = init(i).toULong()
    return array
}
