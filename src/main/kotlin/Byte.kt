/**
 * Created by elect on 19/01/2017.
 */

infix fun Byte.udiv(b: Byte) = (toUInt() / b.toUInt()).toByte()

infix fun Byte.urem(b: Byte) = (toUInt() % b.toUInt()).toByte()
infix fun Byte.ucmp(b: Byte) = toUInt().compareTo(b.toUInt())
infix fun Byte.ushr(b: Byte) = (toUInt() ushr b.toUInt()).toByte()

infix fun Byte.udiv(b: Int) = (toUInt() / b).toByte()
infix fun Byte.urem(b: Int) = (toUInt() % b).toByte()
infix fun Byte.ucmp(b: Int) = toUInt().compareTo(b)
infix fun Byte.ushr(b: Int) = (toUInt() ushr b).toByte()

fun Byte.toUbyte() = Ubyte(this)
fun Byte.toUint() = Uint(toUInt())
fun Byte.toUlong() = Ulong(toUInt())
fun Byte.toUshort() = Ushort(toUInt())

val Byte.ub
    get() = toUbyte()
val Byte.ui
    get() = toUint()
val Byte.ul
    get() = toUlong()
val Byte.us
    get() = toUshort()