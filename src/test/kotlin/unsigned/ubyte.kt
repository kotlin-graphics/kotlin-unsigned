package unsigned

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.math.BigInteger
import kotlin.experimental.inv

class `Ubyte test` : StringSpec() {

    init {
        "ubyte" {

            Ubyte(0xff).v shouldBe 0xff.b
            Ubyte(0b11111111.b).v shouldBe 0xff.b
            Ubyte("255").v shouldBe 0xff.b

            var a = Ubyte(0xff)

            a.toBigInt() shouldBe BigInteger.valueOf(0xff)
            a.toDouble() shouldBe 0xff.toDouble()
            a.toFloat() shouldBe 0xff.toFloat()
            a.toLong() shouldBe 0xff.toLong()
            a.toInt() shouldBe 0xff.toInt()
            a.toChar() shouldBe 0xff.toChar()
            a.toShort() shouldBe 0xff.s
            a.toByte() shouldBe 0xff.b

            a.toUshort() shouldBe Ushort(0xff)
            a.toUint() shouldBe Uint(0xff)
            a.toUlong() shouldBe Ulong(0xff)

            var b = Ubyte(1)
            var c = Ubyte(0)

            a + b shouldBe c
            a + 1.b shouldBe c
            a + 1 shouldBe c

            c = Ubyte(0xfe)

            a - b shouldBe c
            a - 1.b shouldBe c
            a - 1 shouldBe c

            a = Ubyte(100)
            b = Ubyte(2)
            c = Ubyte(200)

            a * b shouldBe c
            a * 2.b shouldBe c
            a * 2 shouldBe c

            c / b shouldBe a
            c / 2.b shouldBe a
            c / 2 shouldBe a

            b = Ubyte(175)
            c = Ubyte(75)

            b % a shouldBe c
            b % 100.b shouldBe c
            b % 100 shouldBe c

            a = Ubyte(0b1010_1010)
            b = Ubyte(0b0000_1111)
            c = Ubyte(0b0000_1010)

            a and b shouldBe c
            a and 15.b shouldBe c
            a and 15 shouldBe c

            c = Ubyte(0b1010_1111)

            a or b shouldBe c
            a or 175.b shouldBe c
            a or 175 shouldBe c

            c = Ubyte(0b1010_0101)

            a xor b shouldBe c
            a xor 15.b shouldBe c
            a xor 15 shouldBe c

            b = Ubyte(4)
            c = Ubyte(0b1010_0000)

            a shl b shouldBe c
            a shl 4.b shouldBe c
            a shl 4 shouldBe c

            c = Ubyte(0b0000_1010)

            a shr b shouldBe c
            a shr 4.b shouldBe c
            a shr 4 shouldBe c

            b = Ubyte(0b0101_0101)

            a.inv() shouldBe b

            a = Ubyte(250)

            (a > Ubyte(249)) shouldBe true
            (a > 249.b) shouldBe true
            (a > 249) shouldBe true
            (a >= a) shouldBe true
            (a >= 250.b) shouldBe true
            (a >= 250) shouldBe true

            0xff.b + Ubyte(1) shouldBe 0.b
            0xff.b - Ubyte(1) shouldBe 0xfe.b
            100.b * Ubyte(2) shouldBe 200.b
            200.b udiv Ubyte(2) shouldBe 100.b
            175.b urem Ubyte(100) shouldBe 75.b
            0b1010_1010.b and Ubyte(0b0000_1111) shouldBe 0b1010.b
            0b1010_1010.b or Ubyte(0b0000_1111) shouldBe 0b1010_1111.b
            0b1010_1010.b xor Ubyte(0b0000_1111) shouldBe 0b1010_0101.b
            0b1010_1010.b shl Ubyte(4) shouldBe 0b1010_0000.b
            0b1010_1010.b ushr Ubyte(4) shouldBe 0b1010.b
            0b1010_1010.b.inv() shouldBe 0b0101_0101.b
            ((200.b ucmp Ubyte(199)) > 0) shouldBe true
            (200.b ucmp Ubyte(200)) shouldBe 0

            0xff + Ubyte(1) shouldBe 0b1_0000_0000
            0xff - Ubyte(1) shouldBe 0xfe
            100 * Ubyte(2) shouldBe 200
            200 udiv Ubyte(2) shouldBe 100
            175 urem Ubyte(100) shouldBe 75
            0b1010_1010 and Ubyte(0b0000_1111) shouldBe 0b1010
            0b1010_1010 or Ubyte(0b0000_1111) shouldBe 0b1010_1111
            0b1010_1010 xor Ubyte(0b0000_1111) shouldBe 0b1010_0101
            0b1010_1010 shl Ubyte(4) shouldBe 0b1010_1010_0000
            0b1010_1010 ushr Ubyte(4) shouldBe 0b1010
            ((200.b ucmp Ubyte(199)) > 0) shouldBe true
            ((200.b ucmp Ubyte(200)) == 0) shouldBe true
        }
    }
}