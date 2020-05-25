package unsigned

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger
import kotlin.experimental.inv

class `Ushort test` : StringSpec() {

    init {
        "ushort" {

            Ushort(0xffff).v shouldBe 0xffff.s
            Ushort(0b1111111111111111.s).v shouldBe 0xffff.s
            Ushort("65535").v shouldBe 0xffff.s

            var a = Ushort(0xffff)

            a.toBigInt() shouldBe BigInteger.valueOf(0xffff)
            a.toDouble() shouldBe 0xffff.toDouble()
            a.toFloat() shouldBe 0xffff.toFloat()
            a.toLong() shouldBe 0xffff.toLong()
            a.toInt() shouldBe 0xffff.toInt()
            a.toChar() shouldBe 0xffff.toChar()
            a.toShort() shouldBe 0xffff.s
            a.toByte() shouldBe 0xffff.b

            a.toUlong() shouldBe Ulong(0xffff)
            a.toUint() shouldBe Uint(0xffff)
            a.toUbyte() shouldBe Ubyte(0xffff)

            var b = Ushort(1)
            var c = Ushort(0)

            assert(a >= b)

            a + b shouldBe c
            a + 1.s shouldBe c
            a + 1 shouldBe c

            c = Ushort(0xfffe)

            a - b shouldBe c
            a - 1.s shouldBe c
            a - 1 shouldBe c

            a = Ushort(30_000)
            b = Ushort(2)
            c = Ushort(60_000)

            a * b shouldBe c
            a * 2.s shouldBe c
            a * 2 shouldBe c

            c / b shouldBe a
            c / 2.s shouldBe a
            c / 2 shouldBe a

            b = Ushort(50_000)
            c = Ushort(20_000)

            b % a shouldBe c
            b % 30000.s shouldBe c
            b % 30000 shouldBe c

            a = Ushort(0b1010_1010__1010_1010)
            b = Ushort(0b0000_1111__0000_1111)
            c = Ushort(0b0000_1010__0000_1010)

            a and b shouldBe c
            a and 0b0000_1111__0000_1111.s shouldBe c
            a and 3_855 shouldBe c

            c = Ushort(0b1010111110101111)

            a or b shouldBe c
            a or 0b1010_1111__1010_1111.s shouldBe c
            a or 44_975 shouldBe c

            c = Ushort(0b1010_0101__1010_0101)

            a xor b shouldBe c
            a xor 0b0000_1111__0000_1111.s shouldBe c
            a xor 3855 shouldBe c

            a = Ushort(0b0100_1100__0011_1101)
            b = Ushort(8)
            c = Ushort(0b0011_1101__0000_0000)

            a shl b shouldBe c
            a shl 8.s shouldBe c
            a shl 8 shouldBe c

            c = Ushort(0b0000_0000__0100_1100)

            a shr b shouldBe c
            a shr 8.s shouldBe c
            a shr 8 shouldBe c

            b = Ushort(0b1011_0011__1100_0010)

            a.inv() shouldBe b

            a = Ushort(65_500)

            (a > Ushort(65_499)) shouldBe true
            (a > 65499.s) shouldBe true
            (a > 65499) shouldBe true
            (a >= a) shouldBe true
            (a >= 65500.s) shouldBe true
            (a >= 65500) shouldBe true

            0xffff.s + Ushort(1) shouldBe 0.s
            0xffff.s - Ushort(1) shouldBe 0xfffe.s
            30_000.s * Ushort(2) shouldBe 60_000.s
            60_000.s udiv Ushort(2) shouldBe 30_000.s
            65_000.s urem Ushort(10_000) shouldBe 5_000.s
            0b1010_1010__1010_1010.s and Ushort(0b0000_1111__0000_1111) shouldBe 0b0000_1010__0000_1010.s
            0b1010_1010__1010_1010.s or Ushort(0b0000_1111__0000_1111) shouldBe 0b1010_1111__1010_1111.s
            0b1010_1010__1010_1010.s xor Ushort(0b0000_1111__0000_1111) shouldBe 0b1010_0101_1010_0101.s
            0b0100_1100__0011_1101.s shl Ushort(8) shouldBe 0b0011_1101__0000_0000.s
            0b0100_1100__0011_1101.s ushr Ushort(8) shouldBe 0b0000_0000__0100_1100.s
            0b0100_1100__0011_1101.s.inv() shouldBe 0b1011_0011__1100_0010.s
            ((65_500.s ucmp Ushort(65_499)) > 0) shouldBe true
            (65_500.s ucmp Ushort(65_500)) shouldBe 0

            0xffff + Ushort(1) shouldBe 0b1000_0000__0000_00000
            0xffff - Ushort(1) shouldBe 0xfffe
            30_000 * Ushort(2) shouldBe 60_000
            60_000 udiv Ushort(2) shouldBe 30_000
            65_000 urem Ushort(10_000) shouldBe 5_000
            0b1010_1010__1010_1010 and Ushort(0b0000_1111__0000_1111) shouldBe 0b0000_1010__0000_1010
            0b1010_1010__1010_1010 or Ushort(0b0000_1111__0000_1111) shouldBe 0b1010_1111__1010_1111
            0b1010_1010__1010_1010 xor Ushort(0b0000_1111__0000_1111) shouldBe 0b1010_0101__1010_0101
            0b0100_1100__0011_1101 shl Ushort(8) shouldBe 0b0100_1100__0011_1101__0000_0000
            0b0100_1100__0011_1101 ushr Ushort(8) shouldBe 0b100_1100
            ((65_500 ucmp Ushort(65_499)) > 0) shouldBe true
            (65_500 ucmp Ushort(65_500)) shouldBe 0
        }
    }
}