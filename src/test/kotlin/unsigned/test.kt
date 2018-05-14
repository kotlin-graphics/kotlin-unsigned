package unsigned

import io.kotlintest.matchers.beLessThan
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import ucmp
import udiv
import unsigned.java_1_7.toBinaryString
import urem
import java.math.BigInteger

/**
 * Created by elect on 15/10/16.
 */

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


class Unsigned : StringSpec() {

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

        "string format" {

            Ubyte(0xff).v.toString() shouldBe "-1"
            Ubyte(0xff).toString() shouldBe "255"
            Ushort(0xffff).v.toString() shouldBe "-1"
            Ushort(0xffff).toString() shouldBe "65535"
            Uint(0xffff_ffff).v.toString() shouldBe "-1"
            Uint(0xffff_ffff).toString() shouldBe "4294967295"
            Ulong(Ulong.MAX_VALUE).v.toString() shouldBe "-1"
            Ulong(Ulong.MAX_VALUE).toString() shouldBe "18446744073709551615"

            (-71777214294589696L).toBinaryString() shouldBe "1111111100000000111111110000000011111111000000001111111100000000"
        }
    }
}
