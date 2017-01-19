/**
 * Created by elect on 19/01/2017.
 */

val Number.ui
    get() = toUint()
val Int.b
    get() = toByte()

fun main(args: Array<String>) {

    val b = 255.b
    println(b.toUInt())
    println(b.toUint())
    println(b.ui)
}