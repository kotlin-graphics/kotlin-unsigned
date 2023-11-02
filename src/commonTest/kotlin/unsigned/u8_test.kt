package unsigned

import uns.*
import kotlin.test.Test
import kotlin.test.assertTrue

class u8_test() {

    @Test
    fun u8() {

        U8(0xFF).v `==` 0xFF.ub
        U8(0b11111111.i8).v `==` 0xFF.ub
        U8("1111_1111", 2).v `==` 0xFF.ub
        U8("377", 8).v `==` 0xFF.ub
        U8("255").v `==` 0xFF.ub
        U8("FF", 16).v `==` 0xFF.ub

        var a = U8.MAX

        a.bigInt `==` BigInt(0xFF)
        a.f64 `==` 0xFF.f64
        a.f64 `==` 255.0
        a.f `==` 0xFF.f
        a.f `==` 255f
        a.L `==` 0xFF.L
        a.L `==` 255L
        a.i `==` 0xFF
        a.i `==` 255
        a.i.toChar() `==` 0xFF.toChar()
        a.i16 `==` 0xFF.i16
        a.i16 `==` 255.toShort()
        a.i8 `==` 0xFF.i8
        a.i8 `==` 255.toByte()

        a.us `==` U16(0xFF).v
        a.ui `==` U32(0xFF).v
        a.ul `==` U64(0xFF).v

        var b = U8(1)
        var c = U8(0)

        assertTrue { a > b && b > c}

        a + b `==` c
        a + 1.i8 `==` c
        a + 1 `==` 255 + 1

        c = U8(0xFE)

        a - b `==` c
        a - 1.i8 `==` c
        a - 1 `==` c.i

        a = U8(100)
        b = U8(2)
        c = U8(200)

        a * b `==` c
        a * 2.i8 `==` c
        a * 2 `==` c.i

        c / b `==` a
        c / 2.i8 `==` a
        c / 2 `==` a.i

        b = U8(175)
        c = U8(75)

        b % a `==` c
        b % 100.i8 `==` c
        b % 100 `==` c.i

        a = U8(0b1010_1010)
        b = U8(0b0000_1111)
        c = U8(0b0000_1010)

        a and b `==` c
        a and 15.i8 `==` c
        a and 15 `==` c

        c = U8(0b1010_1111)

        a or b `==` c
        a or 175.i8 `==` c
        a or 175 `==` c

        c = U8(0b1010_0101)

        a xor b `==` c
        a xor 15.i8 `==` c
        a xor 15 `==` c

        b = U8(4)
        c = U8(0b1010_0000)

        a shl b `==` c
        a shl 4.i8 `==` c
        a shl 4 `==` c

        c = U8(0b0000_1010)

        a shr b `==` c
        a shr 4.i8 `==` c
        a shr 4 `==` c

        b = U8(0b0101_0101)

        a.inv() `==` b

        a = U8(250)

        a compareTo U8(249) `==` 1
        a compareTo 249.ub `==` 1
        a compareTo 249.ui `==` 1
        a compareTo a `==` 0
        a compareTo 250.ub `==` 0
        a compareTo 250.ui `==` 0

        0xFF.i8 + U8(1) `==` 0.u8
        0xFF.i8 - U8(1) `==` 0xFE.u8
        100.i8 * U8(2) `==` 200.u8
        200.i8 / U8(2) `==` 100.u8
        175.i8 % U8(100) `==` 75.u8
        0b1010_1010.i8 and U8(0b0000_1111) `==` 0b1010.i8
        0b1010_1010.i8 or U8(0b0000_1111) `==` 0b1010_1111.i8
        0b1010_1010.i8 xor U8(0b0000_1111) `==` 0b1010_0101.i8
        0b1010_1010.i8 shl U8(4) `==` 0b1010_0000.i8
        0b1010_1010.i8 shr U8(4) `==` 0b1010.i8
//        0b1010_1010.i8.inv() `==` 0b0101_0101.ub
        200.ub compareTo U8(199) `==` 1
        200.ub compareTo U8(200) `==` 0

        0xFF + U8(1) `==` 0b1_0000_0000
        0xFF - U8(1) `==` 0xFE
        100 * U8(2) `==` 200
        200 / U8(2) `==` 100
        175 % U8(100) `==` 75
        0b1010_1010 and U8(0b0000_1111) `==` 0b1010
        0b1010_1010 or U8(0b0000_1111) `==` 0b1010_1111
        0b1010_1010 xor U8(0b0000_1111) `==` 0b1010_0101
        0b1010_1010 shl U8(4) `==` 0b1010_1010_0000
        0b1010_1010 shr U8(4) `==` 0b1010
        200.ub compareTo U8(199) `==` 1
        200.ub compareTo U8(200) `==` 0
    }
}