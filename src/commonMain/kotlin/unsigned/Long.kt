package unsigned


//import com.ionspin.kotlin.bignum.integer.BigInteger
//import com.ionspin.kotlin.bignum.integer.toBigInteger
//
//
//// Created by GBarbieri on 31.01.2017.
//
//fun Long.toUbyte(): Ubyte = Ubyte(this)
//fun Long.toUshort(): Ushort = Ushort(this)
//fun Long.toUint(): Uint = Uint(this)
//fun Long.toUlong(): Ulong = Ulong(this)
//
//fun Long.toBigInt(): BigInteger = BigInteger.fromLong(this)
//fun Long.toUBigInt(): BigInteger = BigInteger.fromULong(toULong())
//
//val Long.ub
//    get() = toUbyte()
//val Long.ui
//    get() = toUint()
//val Long.ul
//    get() = toUlong()
//val Long.us
//    get() = toUshort()
//
//infix fun Long.udiv(b: Byte): Long = (toUBigInt() / b.toUBigInt()).longValue()
//infix fun Long.urem(b: Byte): Long = (toUBigInt() % b.toUBigInt()).longValue()
//infix fun Long.ucmp(b: Byte): Int = toUBigInt().compareTo(b.toUBigInt())
//infix fun Long.ushr(b: Byte): Long = (toUBigInt() shr b.toUInt()).longValue()
//
//infix fun Long.udiv(b: Short) = (toUBigInt() / b.toUBigInt()).toLong()
//infix fun Long.urem(b: Short) = (toUBigInt() % b.toUBigInt()).toLong()
//infix fun Long.ucmp(b: Short) = toUBigInt().compareTo(b.toUBigInt())
//infix fun Long.ushr(b: Short) = (toUBigInt() ushr b.toUInt()).toLong()
//
//infix fun Long.udiv(b: Int) = (toUBigInt() / b.toUBigInt()).toLong()
//infix fun Long.urem(b: Int) = (toUBigInt() % b.toUBigInt()).toLong()
//infix fun Long.ucmp(b: Int) = toUBigInt().compareTo(b.toUBigInt())
//// Long.ushr(b: Int) offered by Kotlin lib

infix fun Long.udiv(b: Long): Long = (toULong() / b.toULong()).toLong()
infix fun Long.urem(b: Long): Long = (toULong() % b.toULong()).toLong()
infix fun Long.ucmp(b: Long): Int = toULong().compareTo(b.toULong())
// no Long ushr Long
//
//
//operator fun Long.plus(b: Ubyte) = this + b.v
//operator fun Long.minus(b: Ubyte) = this - b.v
//operator fun Long.times(b: Ubyte) = this * b.v
//infix fun Long.and(b: Ubyte) = this and b.toLong()
//infix fun Long.or(b: Ubyte) = this or b.toLong()
//infix fun Long.xor(b: Ubyte) = this xor b.toLong()
//infix fun Long.shl(b: Ubyte) = this shl b.toInt()
//
//infix fun Long.udiv(b: Ubyte) = (toUBigInt() / b.toBigInt()).toLong()
//infix fun Long.urem(b: Ubyte) = (toUBigInt() % b.toBigInt()).toLong()
//infix fun Long.ucmp(b: Ubyte) = toUBigInt().compareTo(b.toBigInt())
//infix fun Long.ushr(b: Ubyte) = this ushr b.toInt()
//
//
//operator fun Long.plus(b: Ushort) = this + b.v
//operator fun Long.minus(b: Ushort) = this - b.v
//operator fun Long.times(b: Ushort) = this * b.v
//infix fun Long.and(b: Ushort) = this and b.toLong()
//infix fun Long.or(b: Ushort) = this or b.toLong()
//infix fun Long.xor(b: Ushort) = this xor b.toLong()
//infix fun Long.shl(b: Ushort) = this shl b.toInt()
//
//infix fun Long.udiv(b: Ushort) = (toUBigInt() / b.toBigInt()).toLong()
//infix fun Long.urem(b: Ushort) = (toUBigInt() % b.toBigInt()).toLong()
//infix fun Long.ucmp(b: Ushort) = toUBigInt().compareTo(b.toBigInt())
//infix fun Long.ushr(b: Ushort) = (toUBigInt() ushr b.toInt()).toLong()
//
//
//operator fun Long.plus(b: Uint) = this + b.v
//operator fun Long.minus(b: Uint) = this - b.v
//operator fun Long.times(b: Uint) = this * b.v
//infix fun Long.and(b: Uint) = this and b.toLong()
//infix fun Long.or(b: Uint) = this or b.toLong()
//infix fun Long.xor(b: Uint) = this xor b.toLong()
//infix fun Long.shl(b: Uint) = this shl b.v
//
//infix fun Long.udiv(b: Uint) = (toUBigInt() / b.toBigInt()).toLong()
//infix fun Long.urem(b: Uint) = (toUBigInt() % b.toBigInt()).toLong()
//infix fun Long.ucmp(b: Uint) = toUBigInt().compareTo(b.toBigInt())
//infix fun Long.ushr(b: Uint) = (toUBigInt() ushr b.toInt()).toLong()
//
//
//operator fun Long.plus(b: Ulong) = this + b.v
//operator fun Long.minus(b: Ulong) = this - b.v
//operator fun Long.times(b: Ulong) = this * b.v
//infix fun Long.and(b: Ulong) = this and b.toLong()
//infix fun Long.or(b: Ulong) = this or b.toLong()
//infix fun Long.xor(b: Ulong) = this xor b.toLong()
//infix fun Long.shl(b: Ulong) = this shl b.toInt()
//
//infix fun Long.udiv(b: Ulong) = (toUBigInt() / b.toBigInt()).toLong()
//infix fun Long.urem(b: Ulong) = (toUBigInt() % b.toBigInt()).toLong()
//infix fun Long.ucmp(b: Ulong) = toUBigInt().compareTo(b.toBigInt())
//// no Int ushr Ulong
//
//
//infix fun Long.toUnsignedString(radix: Int): String = java.lang.Long.toUnsignedString(this, radix)
//
//fun Long.toUnsignedBigInteger(): BigInteger = when {
//    this >= 0L -> BigInteger.valueOf(this)
//    else -> {
//        val upper = ushr(32).toInt()
//        val lower = toInt()
//
//        // return (upper << 32) + lower
//        BigInteger.valueOf(upper.toLong() and 0xffffffffL).shiftLeft(32) + BigInteger.valueOf(lower.toLong() and 0xffffffffL)
//    }
//}
//
///** no-radix version has a different codepath */
//val Long.toUnsignedString: String
//    get() = toULong().toBigInteger().toString()
//
//fun String.parseUnsignedLong(radix: Int = 10): Ulong = BigInteger.parseString(this, radix).longValue().ul
//
//infix fun Long.compareUnsigned(b: Long): Int = compare(this + Long.MIN_VALUE, b + Long.MIN_VALUE)
//fun compare(x: Long, y: Long): Int = if (x < y) -1 else if (x == y) 0 else 1
//
//infix fun Long.divideUnsigned(divisor: Long): Long = when {
//    divisor < 0L -> if (compareUnsigned(divisor) < 0) 0L else 1L
//    this > 0L -> this / divisor
//    else -> (toUnsignedBigInteger() / divisor.toUnsignedBigInteger()).longValue()
//}
//
//infix fun Long.remainderUnsigned(divisor: Long): Long = when {
//    this > 0L && divisor > 0L -> this % divisor
//    compareUnsigned(divisor) < 0 -> this
//    else -> (toUnsignedBigInteger() % divisor.toUnsignedBigInteger()).longValue()
//}
//
//
//
