package unsigned

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger

class `Uint test` : StringSpec() {

    init {
        "uint" {

            /**
             * BUG, 0xffffffff is interpreted as Long
             * https://youtrack.jetbrains.com/issue/KT-2780
             * https://youtrack.jetbrains.com/issue/KT-4749
             */

            Uint(0xffff_ffff).v shouldBe 0xffff_ffff.i
            Uint("4294967295").v shouldBe 0xffff_ffff.i

            var a = Uint(0xffff_ffff)

            a.toBigInt() shouldBe BigInteger.valueOf(0xffff_ffff)
            a.toDouble() shouldBe 0xffff_ffff.toDouble()
            a.toFloat() shouldBe 0xffff_ffff.toFloat()
            a.toLong() shouldBe 0xffff_ffff.toLong()
            a.toInt() shouldBe 0xffff_ffff.toInt()
            a.toChar() shouldBe 0xffff_ffff.toChar()
            a.toShort() shouldBe 0xffff_ffff.s
            a.toByte() shouldBe 0xffff_ffff.b

            a.toUbyte() shouldBe Ubyte(0xffff_ffff)
            a.toUshort() shouldBe Ushort(0xffff_ffff)
            a.toUlong() shouldBe Ulong(0xffff_ffff)

            var b = Uint(1)
            var c = Uint(0)

            a + b shouldBe c
            a + 1 shouldBe c

            c = Uint(0xffff_fffe)

            a - b shouldBe c
            a - 1 shouldBe c

            // TODO underscore https://youtrack.jetbrains.com/issue/KT-2964

            a = Uint(2_000_000_000)
            b = Uint(2)
            c = Uint(4_000_000_000)

            a * b shouldBe c
            a * 2 shouldBe c

            c / b shouldBe a
            c / 2 shouldBe a

            b = Uint(2_750_000_000)
            c = Uint(750_000_000)

            b % a shouldBe c
            b % 2_000_000_000 shouldBe c

            a = Uint(0b1010_1010__1010_1010__1010_1010__1010_1010)
            b = Uint(0b0000_1111__0000_1111__0000_1111__0000_1111)
            c = Uint(0b0000_1010__0000_1010__0000_1010__0000_1010)

            a and b shouldBe c
            a and 0b0000_1111__0000_1111__0000_1111__0000_1111 shouldBe c

            c = Uint(0b1010_1111__1010_1111__1010_1111__1010_1111)

            a or b shouldBe c
            a or 0b1010_1111__1010_1111__1010_1111__1010_1111.i shouldBe c

            c = Uint(0b1010_0101__1010_0101__1010_0101__1010_0101)

            a xor b shouldBe c
            a xor 0b0000_1111__0000_1111__0000_1111__0000_1111 shouldBe c

            a = Uint(0b0100_1100__0111_0000__1111_0000__0111_1101)
            b = Uint(16)
            c = Uint(0b1111_0000__0111_1101__0000_0000__0000_0000)

            a shl b shouldBe c
            a shl 16 shouldBe c

            c = Uint(0b0000_0000__0000_0000__0100_1100__0111_0000)

            a shr b shouldBe c
            a shr 16 shouldBe c

            b = Uint(0b1011_0011__1000_1111__0000_1111__1000_0010)

            a.inv() shouldBe b

            a = Uint(2_000_000_000)

            (a > Uint(2_000_000_000 - 1)) shouldBe true
            (a > (2_000_000_000 - 1)) shouldBe true
            (a >= a) shouldBe true
            (a >= 2_000_000_000) shouldBe true

            0xffff_ffff.i + Uint(1) shouldBe 0
            0xffff_ffff.i - Uint(1) shouldBe 0xffff_fffe.i
            2_000_000_000 * Uint(2) shouldBe 4_000_000_000.i
            4_000_000_000.i udiv Uint(2) shouldBe 2_000_000_000
            3_750_000_000.i urem Uint(1000000000) shouldBe 750_000_000

            val d = 0b0100_1100__0111_0000__1111_0000__0111_1101
            val e = 0b0101_0101__0101_0101__0101_0101__0101_0101
            // 0b01001100011100001111000001111101
            // 0b01010101010101010101010101010101
            // 0b01000100010100000101000001010101
            d and Uint(e) shouldBe 0b0100_0100__0101_0000__0101_0000__0101_0101
            // 0b01001100011100001111000001111101
            // 0b01010101010101010101010101010101
            // 0b01011101011101011111010101111101
            d or Uint(e) shouldBe 0b0101_1101__0111_0101__1111_0101__0111_1101
            // 0b01001100011100001111000001111101
            // 0b01010101010101010101010101010101
            // 0b00011001001001011010010100101000
            d xor Uint(e) shouldBe 0b0001_1001__0010_0101__1010_0101__0010_1000
            d shl Uint(16) shouldBe 0b1111_0000__0111_1101__0000_0000__0000_0000.i
            d ushr Uint(16) shouldBe 0b0000_0000__0000_0000__0100_1100__0111_0000
            ((d ucmp Uint(d - 1) > 0)) shouldBe true
            (d ucmp Uint(d)) shouldBe 0
        }
    }
}