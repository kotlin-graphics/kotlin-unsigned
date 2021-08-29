package unsigned


fun UbyteArray(size: Int) = UbyteArray(ByteArray(size))
fun UbyteArray(size: Int, init: (Int) -> Byte) = UbyteArray(ByteArray(size, init))

@JvmInline
value class UbyteArray(val data: ByteArray) {

    operator fun get(index: Int) = Ubyte(data[index])

    operator fun set(index: Int, value: Ubyte) {
        data[index] = value.v
    }
}


fun UshortArray(size: Int) = UshortArray(ShortArray(size))
fun UshortArray(size: Int, init: (Int) -> Short) = UshortArray(ShortArray(size, init))

@JvmInline
value class UshortArray(val data: ShortArray) {

    operator fun get(index: Int) = Ushort(data[index])

    operator fun set(index: Int, value: Ushort) {
        data[index] = value.v
    }
}


fun UintArray(size: Int) = UintArray(IntArray(size))
fun UintArray(size: Int, init: (Int) -> Int) = UintArray(IntArray(size, init))

@JvmInline
value class UintArray(val data: IntArray) {

    operator fun get(index: Int) = Uint(data[index])

    operator fun set(index: Int, value: Uint) {
        data[index] = value.v
    }
}

fun UlongArray(size: Int) = UlongArray(LongArray(size))
fun UlongArray(size: Int, init: (Int) -> Long) = UlongArray(LongArray(size, init))

@JvmInline
value class UlongArray(val data: LongArray) {

    operator fun get(index: Int) = Ulong(data[index])

    operator fun set(index: Int, value: Ulong) {
        data[index] = value.v
    }
}