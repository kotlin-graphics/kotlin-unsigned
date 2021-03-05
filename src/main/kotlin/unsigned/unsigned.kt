package unsigned

/**
 * Created by GBarbieri on 06.10.2016.
 */

// TODO if == unsigned.Ubyte?
fun Number.toUbyte() = Ubyte(toByte())

fun Number.toUint() = Uint(this)
fun Number.toUlong() = Ulong(toLong())
fun Number.toUshort() = Ushort(toShort())

// TODO char?

fun Char.toUbyte() = Ubyte(toByte())
fun Char.toUint() = Uint(toInt())
fun Char.toUlong() = Ulong(toLong())
fun Char.toUshort() = Ushort(toShort())