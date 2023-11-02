package uns.format

//import kotlinx.datetime.*
import uns.BigInt
import uns.bigInt

internal class Sprintf(val format: String, val args: Array<out Any?>) {

    private var pos = 0
    private var specStart = -1
    private val result = StringBuilder()
    private var currentIndex = 0

    fun process(): Sprintf {
        while (pos < format.length) {
            val ch = format[pos++]
//            println("$ch $pos $specStart [$result]")
            if (ch == '%')
                specStart = when {
                    specStart == pos - 1 -> {
                        result.append(ch)
                        -1
                    }
                    specStart < 0 -> pos
                    else -> invalidFormat("unexpected %")
                }
            else
                if (specStart >= 0) {
                    pos--
                    Specification(this, currentIndex++).scan()
                } else result.append(ch)
        }
        return this
    }

    internal fun nextChar(): Char {
        if (pos >= format.length) invalidFormat("unexpected end of string inside format specification")
        return format[pos++]
    }

    internal fun invalidFormat(reason: String): Nothing = throw IllegalArgumentException("bad format: $reason at ofset ${pos - 1} of \"$format\"")

    override fun toString(): String = result.toString()

    internal fun isNumber(index: Int): Boolean = args[index] is Number
    internal fun getNumber(index: Int): Number = notNullArg(index)
    internal fun getBigInt(index: Int): BigInt = when (val arg = args[index]!!) {
        is BigInt -> arg
        is UByte -> arg.bigInt
        is UShort -> arg.bigInt
        is UInt -> arg.bigInt
        is ULong -> arg.bigInt
        else -> error("")
    }

    internal fun getText(index: Int): String = args[index]!!.toString()

    internal fun getCharacter(index: Int): Char = notNullArg(index)

    internal fun specificationDone(text: String) {
        result.append(text)
        specStart = -1
    }

//    fun getLocalDateTime(index: Int): LocalDateTime = when (val t = notNullArg<Any>(index)) {
//        is Instant -> t.toLocalDateTime(TimeZone.currentSystemDefault())
//        is LocalDateTime -> t
//        is LocalDate -> t.atTime(0, 0, 0)
//        else -> ConvertToInstant(t).toLocalDateTime(TimeZone.currentSystemDefault())"
//    }

    @Suppress("UNCHECKED_CAST")
    fun <T> notNullArg(index: Int): T = args[index]!! as T

    fun pushbackArgumentIndex() {
        currentIndex--
    }
}

/**
 * Old good C-sprintf. See formats table in the
 * [readme](https://github.com/sergeych/mp_stools/blob/263cfc50f23cfde815928c7bdb748857fdaad2b0/README.md#L56-L56)
 */
fun String.sprintf(vararg args: Any?): String = Sprintf(this, args).process().toString()

/**
 * Old good C-printf. See formats table in readme. Just like C version it does not insert \n. See also
 * [sprintf]
 */
fun printf(format: String, vararg args: Any?) {
    print(Sprintf(format, args).process().toString())
}

/**
 * Like old good C printf but also adds new line (via println). See [sprintf]
 */
@Suppress("unused")
fun printlnf(format: String, vararg args: Any?) {
    println(Sprintf(format, args).process().toString())
}


fun String.format(vararg args: Any?): String = Sprintf(this, args).process().toString()

//expect fun ConvertToInstant(t: Any): Instant