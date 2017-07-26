package unsigned

import and
import io.kotlintest.KTestJUnitRunner
import io.kotlintest.matchers.beLessThan
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import minus
import or
import org.junit.runner.RunWith
import plus
import times
import toUBigInt
import ucmp
import udiv
import urem
import xor
import java.math.BigInteger
import kotlin.experimental.inv

/**
 * Created by elect on 15/10/16.
 */

@RunWith(KTestJUnitRunner::class)
class Unsigned : StringSpec() {

    val Int.b
        get() = toByte()
    val Int.s
        get() = toShort()
    val Long.b
        get() = toByte()
    val Long.s
        get() = toShort()
    val Long.i
        get() = toInt()
    val BigInteger.L
        get() = toLong()

    /**
     * BUG, 0xffffffffffffffff is outside Long range
     * https://youtrack.jetbrains.com/issue/KT-4749
     */
    val String.hL: Long
        get() = java.lang.Long.parseUnsignedLong(filter { it != '_' && it != '\'' }, 16)

    val String.L: Long
        get() = java.lang.Long.parseUnsignedLong(filter { it != '_' && it != '\'' })

    val String.bL: Long
        get() = java.lang.Long.parseUnsignedLong(filter { it != '_' && it != '\'' }, 2)

    init {

        "primitive" {

            250.b udiv 50.b shouldBe 5.b
            250.b urem 200.b shouldBe 50.b
            250.b ucmp 251.b should beLessThan(1)
            (250.b ucmp 250.b) shouldBe 0
            0b1010_1010.b ushr 4 shouldBe 0b1010.b

            65500.s udiv 500.s shouldBe 131.s
            65500.s urem 65000.s shouldBe 500.s
            65500.s ucmp 65501.s should beLessThan(1)
            65500.s ucmp 65500.s shouldBe 0
            0b0100_1100_0011_1101.s ushr 8 shouldBe 0b100_1100.s

            4_000_000_000.i udiv 2 shouldBe 2_000_000_000
            2_750_000_000.i urem 2_000_000_000 shouldBe 750_000_000
            4_000_000_000.i ucmp 4_000_000_001.i should beLessThan(1)
            4_000_000_000.i ucmp 4_000_000_000.i shouldBe 0

            "18_000_000_000_000_000_000".L udiv 2L shouldBe "9'000'000'000'000'000'000".L
            "17'000'000'000'000'000'000".L urem "9'000'000'000'000'000'000".L shouldBe "8'000'000'000'000'000'000".L
            "18'000'000'000'000'000'000".L ucmp "18'000'000'000'000'000'001".L should beLessThan(1)
            "18'000'000'000'000'000'001".L ucmp "18'000'000'000'000'000'001".L shouldBe 0
        }

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

        "ulong" {

            val max = "ffff_ffff__ffff_ffff".hL

            Ulong(Ulong.Companion.MAX_VALUE).v shouldBe max
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
            (d ucmp Ulong("1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1010__1010_1011", 2)) should beLessThan(0)
            (d ucmp Ulong(d)) shouldBe 0
        }

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

        "string format" {
            Ubyte(0xff).v.toString() shouldBe "-1"
            Ubyte(0xff).toString() shouldBe "255"
            Ushort(0xffff).v.toString() shouldBe "-1"
            Ushort(0xffff).toString() shouldBe "65535"
            Uint(0xffff_ffff).v.toString() shouldBe "-1"
            Uint(0xffff_ffff).toString() shouldBe "4294967295"
            Ulong(Ulong.MAX_VALUE).v.toString() shouldBe "-1"
            Ulong(Ulong.MAX_VALUE).toString() shouldBe "18446744073709551615"
        }
    }
}
