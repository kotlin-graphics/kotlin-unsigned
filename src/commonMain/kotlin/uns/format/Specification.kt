package uns.format

//import kotlinx.datetime.*

internal enum class Positioning {
    LEFT, RIGHT, CENTER
}

internal class Specification(val parent: Sprintf, var index: Int) {

    enum class Stage {
        FLAGS,
        LENGTH,
        FRACTION
    }

    private var stage = Stage.FLAGS

    private var size: Int = -1
    private var fractionalPartSize: Int = -1
    private var positioninig = Positioning.RIGHT
    private var fillChar = ' '
    private var currentPart = StringBuilder()

    //    private var pos = 0
    private var explicitPlus = false
    private var done = false
    private var indexIsOverriden = false

    private val isScanningFlags: Boolean
        get() = stage == Stage.FLAGS

    internal fun scan() {
        while (!done) {
            val ch = parent.nextChar()
//            println("spec: $ch: $stage [$currentPart]")
            when (ch) {
                '-', '^' -> {
                    if (!isScanningFlags) invalidFormat("unexpected $ch")
                    positioninig = if (ch == '-') Positioning.LEFT else Positioning.CENTER
                }
                '+' -> {
                    if (!isScanningFlags) invalidFormat("unexpected $ch")
                    explicitPlus = true
                }
                in "*#_=" -> {
                    if (!isScanningFlags) invalidFormat("bad fill char $ch position")
                    fillChar = ch
                }
                '0' -> {
                    if (isScanningFlags) fillChar = '0'
                    else
                        currentPart.append(ch)
                }
                in "123456789" -> {
                    if (stage == Stage.FLAGS) stage = Stage.LENGTH
                    currentPart.append(ch)
                }
                '$', '!' -> {
                    if (stage != Stage.LENGTH) invalidFormat("unexpected $ch position")
                    if (indexIsOverriden) invalidFormat("argument number '$ch' should occur only once")
                    indexIsOverriden = true
                    index = currentPart.toString().toInt() - 1
                    parent.pushbackArgumentIndex()
                    currentPart.clear()
                }
                's' -> createStringField()
                'd', 'i' -> createIntegerField()
                'o' -> createOctalField()
                'x' -> createHexField(false)
                'X' -> createHexField(true)
                'f', 'F' -> createFloat()
                'E' -> createScientific(true)
                'e' -> createScientific(false)
                'g' -> createAutoFloat(true)
                'G' -> createAutoFloat(false)
                'c', 'C' -> createCharacter()
//                't' -> createTimeField(false)
//                'T' -> createTimeField(true)
                '.' -> stage = when (stage) {
                    Stage.FLAGS -> Stage.FRACTION
                    Stage.LENGTH -> {
                        endStage(false)
                        Stage.FRACTION
                    }
                    else -> invalidFormat("can't parse specification: unexpected '.'")
                }
                else -> invalidFormat("unexpected character '$ch'")
            }
        }
    }

    private fun invalidFormat(message: String): Nothing = parent.invalidFormat(message)

//    private val time: LocalDateTime
//        get() = parent.getLocalDateTime(index)

//    private fun createTimeField(upperCase: Boolean) {
//        val ch = parent.nextChar()
//        endStage()
//        val result: String = when (ch) {
//            'H' -> "%02d".sprintf(time.hour)
//            'k' -> "%d".sprintf(time.hour)
//            'I', 'l' -> {
//                var t = time.hour
//                if (t > 12) t -= 12
//                if (ch == 'I') "%02d".sprintf(t)
//                else t.toString()
//            }
//            'M' -> "%02d".sprintf(time.minute)
//            'S' -> "%02d".sprintf(time.second)
//            'L' -> "%03d".sprintf(time.nanosecond / 1_000_000)
//            'N' -> "%09d".sprintf(time.nanosecond)
//            'p' -> when {
//                upperCase -> if (time.hour > 12) "PM" else "AM"
//                time.hour > 12 -> "pm"
//                else -> "am"
//            }
//            'z' -> {
//                val tz = TimeZone.currentSystemDefault()
//                tz.offsetAt(time.toInstant(tz)).toString().replace(":", "")
//            }
//            'Z' -> {
//                // There us yet no abbreviations like 'CET', so we put there string representation like +01:00
//                val tz = TimeZone.currentSystemDefault()
//                tz.offsetAt(time.toInstant(tz)).toString()
//            }
//            's' -> {
//                val tz = TimeZone.currentSystemDefault()
//                time.toInstant(tz).epochSeconds.toString()
//            }
//            'Q' -> {
//                val tz = TimeZone.currentSystemDefault()
//                time.toInstant(tz).toEpochMilliseconds().toString()
//            }
//            // Date fields
//            'B' -> getMonthName(time.month.number)
//            'b', 'h' -> getAbbreviatedMonthName(time.month.number)
//            'e' -> time.dayOfMonth.toString()
//            'd' -> "%02s".sprintf(time.dayOfMonth)
//            'm' -> "%02s".sprintf(time.month.number)
//            'A' -> getWeekDayName(time.dayOfWeek)
//            'a' -> getAbbreviatedWeekDayName(time.dayOfWeek)
//            'y' -> time.year.toString().takeLast(2)
//            'Y' -> "%04d".sprintf(time.year)
//            'j' -> "%03d".sprintf(time.dayOfYear)
//            // shortcuts
//            'R' -> "%1!tH:%1!tM".sprintf(time)
//            'r' ->
//                if (upperCase)
//                    "%1!tI:%1!tM:%1!tS %1!Tp".sprintf(time)
//                else
//                    "%1!tI:%1!tM:%1!tS %1!tp".sprintf(time)
//            'T' -> "%tH:%1!tM:%1!tS".sprintf(time)
//            'D' -> "%tm/%1!td/%1!ty".sprintf(time)
//            'F' -> "%tY-%1!tm-%1!td".sprintf(time)
//            'c' -> "%ta %1!tb %1!td %1!tT %1!tZ %1!tY".sprintf(time)
//            'O' -> {
//                val tz = TimeZone.currentSystemDefault()
//                val offset = tz.offsetAt(time.toInstant(tz)).toString()
//                "%tFT%1!tT%s".sprintf(time, offset)
//            }
//            '#' -> {
//                "%tY%1!tm%1!td%1!tH%1!tM%1!tS".sprintf(time.toInstant(TimeZone.UTC))
//            }
//            else -> invalidFormat("unknown time field specificator: 't$ch'")
//        }
//        insertField(result)
//    }

    private fun createStringField() {
        endStage()
        insertField(parent.getText(index))
    }

    private fun createIntegerField() {
        endStage()
        val number = parent.getNumber(index).toLong()
        if (explicitPlus && fillChar == '0' && number > 0)
            insertField(number.toString(), "+")
        else
            insertField(if (explicitPlus) "+$number" else "$number")
    }

    private fun createHexField(upperCase: Boolean) {
        endStage()
        if (explicitPlus) invalidFormat("'+' is incompatible with hex format")
        val text = when {
            parent.isNumber(index) -> parent.getNumber(index).toLong().toString(16)
            else -> parent.getBigInt(index).toString(16)
        }
        insertField(if (upperCase) text.uppercase() else text.lowercase())
    }

    private fun createOctalField() {
        endStage()
        val number = parent.getNumber(index).toLong()
        if (explicitPlus) invalidFormat("'+' is incompatible with oct format")
        insertField(number.toString(8))
    }

    private fun createCharacter() {
        endStage()
        insertField(parent.getCharacter(index).toString())
    }

    private fun endStage(setDone: Boolean = true) {
        if (setDone) done = true
        if (currentPart.isNotEmpty()) {
            when (stage) {
                Stage.LENGTH -> size = currentPart.toString().toInt()
                Stage.FRACTION -> fractionalPartSize = currentPart.toString().toInt()
                Stage.FLAGS -> invalidFormat("can't parse format specifier (error 7)")
            }
            currentPart.clear()
        }
    }

    private fun insertField(text: String, prefix: String = "") {
        val l = text.length + prefix.length
        if (size < 0 || size < l) {
            parent.specificationDone(prefix + text)
        } else {
            var padStart = 0
            var padEnd = 0
            when (positioninig) {
                Positioning.LEFT -> padEnd = size - l
                Positioning.RIGHT -> padStart = size - l
                Positioning.CENTER -> {
                    padStart = (size - l) / 2
                    padEnd = size - padStart - l

                }
            }
            val result = StringBuilder(prefix)
            while (padStart-- > 0) result.append(fillChar)
            result.append(text)
            while (padEnd-- > 0) result.append(fillChar)
            parent.specificationDone(result.toString())
        }
    }

    private fun createFloat() {
        endStage()
        val number = parent.getNumber(index).toDouble()
        val t = fractionalFormat(number, size, fractionalPartSize)

        if (explicitPlus && fillChar == '0' && number > 0)
            insertField(t, "+")
        else
            insertField(if (explicitPlus) "+$t" else t)
    }

    private fun createScientific(upperCase: Boolean) {
        endStage()
        val number = parent.getNumber(index).toDouble()
        val t = scientificFormat(number, size, fractionalPartSize).let {
            if (upperCase) it.uppercase() else it.lowercase()
        }

        if (explicitPlus && fillChar == '0' && number > 0)
            insertField(t, "+")
        else
            insertField(if (explicitPlus) "+$t" else t)
    }

    private fun createAutoFloat(upperCase: Boolean) {
        endStage()
        val number = parent.getNumber(index)
        val t = number.toString().let {
            if (upperCase) it.uppercase() else it.lowercase()
        }

        if (explicitPlus && fillChar == '0' && number.toDouble() > 0)
            insertField(t, "+")
        else
            insertField(if (explicitPlus) "+$t" else t)
    }

    companion object {
        val englishMonthNames: List<String> by lazy {
            "January February March April May June July August September October November December".split(
                ' '
            )
        }
        val englishWeekDayNames: List<String> by lazy {
            "Monday Tuesday Wednesday Thursday Friday Saturday Sunday".split(' ')
        }

//        fun getAbbreviatedMonthName(monthNumber: Int) =
//            LocaleSpecificAbbreviatedMonthName(monthNumber) ?: getMonthName(monthNumber).take(3)
//
//        fun getMonthName(monthNumber: Int) = LocaleSpecificMonthName(monthNumber) ?: englishMonthNames[monthNumber - 1]
//
//        fun getWeekDayName(d: DayOfWeek): String {
//            val n = d.isoDayNumber
//            return LocaleSpecificDayName(n) ?: englishWeekDayNames[n - 1]
//        }
//
//        fun getAbbreviatedWeekDayName(d: DayOfWeek): String {
//            val n = d.isoDayNumber
//            return LocaleSpecificAbbreviatedDayName(n) ?: englishWeekDayNames[n - 1].take(3)
//        }
    }
}

/**
 * Platform could provide current locale based month name or return null to use English. Month number is 1..12
 * as default in date operations in java
 */
//expect fun LocaleSpecificMonthName(monthNumber: Int): String?
//
//expect fun LocaleSpecificAbbreviatedMonthName(monthNumber: Int): String?
//
//expect fun LocaleSpecificDayName(isoDayNumber: Int): String?
//
//expect fun LocaleSpecificAbbreviatedDayName(isoDayNumber: Int): String?