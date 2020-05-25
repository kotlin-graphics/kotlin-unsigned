package unsigned

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe


class `Ulong test` : StringSpec() {

    init {
        "ulong" {

            val max = "ffff_ffff__ffff_ffff".hL

            Ulong(Ulong.MAX_VALUE).v shouldBe max
            Ulong("18446744073709551615").v shouldBe max

            var a = Ulong(Ulong.Companion.MAX_VALUE)

            a.toBigInt() shouldBe max.toUBigInt()
            a.toDouble() shouldBe max.toUBigInt().toDouble()
            a.toFloat() shouldBe max.toUBigInt().toFloat()
            a.toLong() shouldBe max.toLong()
            a.toInt() shouldBe max.toInt()
            a.toChar() shouldBe max.toChar()
            a.toShort() shouldBe max.s
            a.toByte() shouldBe max.b

            a.toUbyte() shouldBe Ubyte(max)
            a.toUshort() shouldBe Ushort(max)
            a.toUint() shouldBe Uint(max)

            var b = Ulong(1)
            var c = Ulong(0)

            a + b shouldBe c
            a + 1 shouldBe c

            c = Ulong("ffff_ffff__ffff_fffe".hL)

            a - b shouldBe c
            a - 1 shouldBe c

            // BUG underscore https://youtrack.jetbrains.com/issue/KT-2964

            a = Ulong("9_000_000_000_000_000_000")
            b = Ulong(2)
            c = Ulong("18_000_000_000_000_000_000")

            a * b shouldBe c
            a * 2 shouldBe c

            c / b shouldBe a
            c / 2 shouldBe a

            b = Ulong("17_000_000_000_000_000_000")
            c = Ulong("8_000_000_000_000_000_000")

            b % a shouldBe c
            b % "9_000_000_000_000_000_000".L shouldBe c

            a = Ulong("1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010", 2)
            b = Ulong("0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111", 2)
            c = Ulong("0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010", 2)

            a and b shouldBe c
            a and "0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111".bL shouldBe c

            // 1010101010101010101010101010101010101010101010101010101010101010
            // 0000111100001111000011110000111100001111000011110000111100001111
            // 1010111110101111101011111010111110101111101011111010111110101111
            c = Ulong("1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111", 2)

            a or b shouldBe c
            a or "1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111".bL shouldBe c

            c = Ulong("1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101", 2)

            a xor b shouldBe c
            a xor "0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111".bL shouldBe c

            a = Ulong("0100_1100__0111_0000__1111_0000__0111_1100__0000_1111__1100_0000__0111_1111__0000_0000", 2)
            b = Ulong(32)
            c = Ulong("0000_1111__1100_0000__0111_1111__0000_0000__0000_0000__0000_0000__0000_0000__0000_0000", 2)

            a shl b.toInt() shouldBe c
            a shl 32 shouldBe c

            c = Ulong("0000_0000__0000_0000__0000_0000__0000_0000__0100_1100__0111_0000__1111_0000__0111_1100", 2)

            a shr b.toInt() shouldBe c
            a shr 32 shouldBe c

            b = Ulong("1011_0011__1000_1111__0000_1111__1000_0011__1111_0000__0011_1111__1000_0000__1111_1111", 2)

            a.inv() shouldBe b

            a = Ulong("18'000'000'000'000'000'000")

            (a > Ulong("17'999'999'999'999'999'999")) shouldBe true
            (a > "17'999'999'999'999'999'999".L) shouldBe true
            (a >= a) shouldBe true
            (a >= "18'000'000'000'000'000'000".L) shouldBe true

            "ffff_ffff__ffff_ffff".hL + Ulong(1) shouldBe 0L
            "ffff_ffff__ffff_ffff".hL - Ulong(1) shouldBe "ffff_ffff__ffff_fffe".hL
            "9'000'000'000'000'000'000".L * Ulong(2) shouldBe "18'000'000'000'000'000'000".L
            "18'000'000'000'000'000'000".L udiv Ulong(2) shouldBe "9'000'000'000'000'000'000".L
            "17'000'000'000'000'000'000".L urem Ulong("9'000'000'000'000'000'000") shouldBe "8'000'000'000'000'000'000".L

            var d = "1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010".bL
            val e = "0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111__0000_1111".bL

            d and Ulong(e) shouldBe "0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010__0000_1010".bL
            d or Ulong(e) shouldBe "1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111__1010_1111".bL
            d xor Ulong(e) shouldBe "1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101__1010_0101".bL
            d = "0100_1100__0111_0000__1111_0000__0111_1100__0000_1111__1100_0000__0111_1111__0000_0000".bL
            d shl Ulong(32).toInt() shouldBe "0000_1111__1100_0000__0111_1111__0000_0000__0000_0000__0000_0000__0000_0000__0000_0000".bL
            d shr Ulong(32).toInt() shouldBe "0000_0000__0000_0000__0000_0000__0000_0000__0100_1100__0111_0000__1111_0000__0111_1100".bL
            (d ucmp Ulong("1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1011", 2)) shouldBeLessThan 0
            (d ucmp Ulong(d)) shouldBe 0
        }
    }
}