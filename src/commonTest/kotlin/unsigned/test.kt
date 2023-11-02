package unsigned

import com.ionspin.kotlin.bignum.integer.toBigInteger
import uns.*
import kotlin.test.Test

/**
 * Created by elect on 15/10/16.
 */

//val Int.b
//    get() = toByte()
//val Int.s
//    get() = toShort()
//val Long.b
//    get() = toByte()
//val Long.s
//    get() = toShort()
//val Long.i
//    get() = toInt()
//val BigInteger.L
//    get() = toLong()
//
//
///**
// * BUG, 0xffffffffffffffff is outside Long range
// * https://youtrack.jetbrains.com/issue/KT-4749
// */
//val String.hL: Long
//    get() = java.lang.Long.parseUnsignedLong(filter { it != '_' && it != '\'' }, 16)
//
val String.L: Long
    get() = filter { it != '_' && it != '\'' }.toBigInteger().longValue(false)
//
//val String.bL: Long
//    get() = java.lang.Long.parseUnsignedLong(filter { it != '_' && it != '\'' }, 2)


class Unsigned {

    @Test
    fun primitive() {

        250.i8 udiv 50 `==` 5
        250.i8 urem 200.i8 `==` 50
        250.i8 ucmp 251.i8 `==` -1
        250.i8 ucmp 250.i8 `==` 0
        0b1010_1010.i8 ushr 4 `==` 0b1010

        65500.i16 udiv 500 `==` 131
        65500.i16 urem 65000.i16 `==` 500
        65500.i16 ucmp 65501.i16 `==` -1
        65500.i16 ucmp 65500.i16 `==` 0
        0b0100_1100_0011_1101.i16 ushr 8 `==` 0b100_1100

        4_000_000_000.i32 udiv 2 `==` 2_000_000_000
        2_750_000_000.i32 urem 2_000_000_000 `==` 750_000_000
        4_000_000_000.i32 ucmp 4_000_000_001.i32 `==` -1
        4_000_000_000.i32 ucmp 4_000_000_000.i32 `==` 0

        "18_000_000_000_000_000_000".L udiv 2L `==` "9'000'000'000'000'000'000".L
        "17'000'000'000'000'000'000".L urem "9'000'000'000'000'000'000".L `==` "8'000'000'000'000'000'000".L
        "18'000'000'000'000'000'000".L ucmp "18'000'000'000'000'000'001".L `==` -1
        "18'000'000'000'000'000'001".L ucmp "18'000'000'000'000'000'001".L `==` 0
    }

    @Test
    fun stringFormat() {

        U8(0xff).v.i8.toString() `==` "-1"
        U8(0xff).toString() `==` "255"
        U16(0xffff).v.i16.toString() `==` "-1"
        U16(0xffff).toString() `==` "65535"
        U32(0xffff_ffff).v.i16.toString() `==` "-1"
        U32(0xffff_ffff).toString() `==` "4294967295"
        U64(ULong.MAX_VALUE).v.i64.toString() `==` "-1"
        U64(ULong.MAX_VALUE).toString() `==` "18446744073709551615"

        U8.MIN.toString(16) `==` "0"
        U8.MAX.toString(16) `==` "ff"
        U16.MIN.toString(16) `==` "0"
        U16.MAX.toString(16) `==` "ffff"
        U32.MIN.toString(16) `==` "0"
        U32.MAX.toString(16) `==` "ffffffff"
        U64.MIN.toString(16) `==` "0"
        U64.MAX.toString(16) `==` "ffffffffffffffff"

        (-71777214294589696).ul.toString(2) `==` "1111111100000000111111110000000011111111000000001111111100000000"
    }
}
