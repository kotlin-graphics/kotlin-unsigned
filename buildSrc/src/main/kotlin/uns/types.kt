package uns

import org.gradle.configurationcache.extensions.capitalized
import uns.gen.generate

fun types() {

    for (typeInfo in unsInfos) {

        val (Type, _) = typeInfo

        generate(Type) {

            for (uns in unsTypes + "BigInt")
                if (uns != Type)
                    imports += "uns.$uns"
            imports += "com.ionspin.kotlin.bignum.integer.BigInteger"

            val signedType = typeInfo.counterType.drop(1).lowercase()
            val counterInfo = typeInfo.counterInfo
            val UType = counterInfo.type

            nothingToInline = true
            for (constrInfo in intTypeInfos) {
                if (constrInfo.isU || constrInfo.type == "BigInt")
                    continue
                val ConstrType = constrInfo.type
                val constrType = ConstrType.lowercase()
                +"inline fun $Type($constrType: $ConstrType): $Type = $Type($constrType.toU$ConstrType())"
                //                val CounterConstrType = constrInfo.counterType
                //                if (counterInfo.type == CounterConstrType) {
                //                    val exactRequired = if (ConstrType == "BigInt") ", exactRequired: Boolean = true" else ""
                //                    if (ConstrType != UType)
                //                        +"inline fun $Type($constrType: $ConstrType$exactRequired) : this(".plus(when (ConstrType) {
                //                                                                                                     "BigInt" -> "$constrType.u${signedType}Value(exactRequired))"
                //                                                                                                     Type -> "$constrType.v)"
                //                                                                                                     else -> "$constrType.to$UType())"
                //                                                                                                 })
                //                }
            }

            "class $Type(var v: $UType = MIN.v) : Number(), Comparable<$Type>" {

                val CounterPromotedType = counterInfo.promotedType
                val counterPromotedType = CounterPromotedType.lowercase()
                val maybeConst = if (typeInfo.isPrimitive) "const " else ""

                "companion object" {

                    val (minValue, maxValue) = when (Type) {
                        "U8" -> "0u" to "0xFFu"
                        "U16" -> "0u" to "0xFFFFu"
                        "U32" -> "0uL" to "0xFFFF_FFFFuL"
                        "U64" -> "BigInteger.ZERO" to "ULong.MAX_VALUE.toBigInteger()"
                        else -> error("invalid type $Type")
                    }
                    val bits = typeInfo.bits
                    +"""
                        /** A $counterPromotedType constant holding the minimum value an `unsigned $signedType` can have, 0. */
                        ${maybeConst}val MIN_$counterPromotedType: $CounterPromotedType = $minValue
                        
                        /** A $counterPromotedType constant holding the maximum value an `unsigned $signedType` can have, 2^$bits-1. */
                        ${maybeConst}val MAX_$counterPromotedType: $CounterPromotedType = $maxValue
                        
                        /** A constant holding the minimum value an `unsigned $signedType` can have, 0.  */
                        val MIN = $Type($UType.MIN_VALUE)
                
                        /** A constant holding the maximum value an `unsigned $signedType` can have, 2^$bits-1. */
                        val MAX = $Type($UType.MAX_VALUE)
                        
                        /** The number of bytes used to represent an instance of UByte in a binary form. */
                        const val SIZE_BYTES: Int = $UType.SIZE_BYTES
                        
                        /** The number of bits used to represent an instance of UByte in a binary form. */
                        const val SIZE_BITS: Int = $UType.SIZE_BITS"""
                    //fun checkSigned(v: Number): Boolean = v.to$valueType() in MIN_VALUE..MAX_VALUE
                }

                for (constrInfo in intTypeInfos + kotlinUnsTypeInfo) {
                    if (!constrInfo.isU && constrInfo.type != "BigInt")
                        continue
                    val ConstrType = constrInfo.type
                    val constrType = ConstrType.lowercase()
                    val exactRequired = if (ConstrType == "BigInt") ", exactRequired: Boolean = true" else ""
                    if (ConstrType != UType) {
                        val base = "constructor($constrType: $ConstrType$exactRequired) : this($constrType"
                        when (ConstrType) {
                            "BigInt" -> +"$base.u${signedType}Value(exactRequired))"
                            Type -> +"$base.v)"
                            else -> +"$base.to$UType())"
                        }
                    }
                }

                +"constructor(string: String, radix: Int = 10) : this(string.filter { it != '_' && it != '\\'' }.to$UType(radix))"

                imports += "com.ionspin.kotlin.bignum.integer.toBigInteger"

                for (intInfo in typeInfos + kotlinUnsTypeInfo) {

                    val IntType = intInfo.type
                    val maybePadding = if (IntType.lowercase() == Type.lowercase() || IntType == UType) "" else ".to$IntType()"
                    val overrideOrInline = if (intInfo.isU || intInfo.type == "BigInt") "inline" else "override"
                    val base = "$overrideOrInline fun to$IntType(): $IntType ="
                    when {
                        intInfo.isKotlinUns -> +"$base v$maybePadding"
                        intInfo.isU -> +"$base $IntType(v)"
                        IntType == "BigInt" -> +"$base v.toBigInteger()"
                        else -> +"$base v.to$IntType()"
                    }
                }
                +"""
                    @Deprecated("Direct conversion to Char is deprecated. Use toInt().toChar() or Char constructor instead.\nIf you override toChar() function in your Number inheritor, it's recommended to gradually deprecate the overriding function and then remove it.\nSee https://youtrack.jetbrains.com/issue/KT-46465 for details about the migration", replaceWith = ReplaceWith("this.toInt().toChar()"))
                    override fun toChar() = toInt().toChar()
                    inline fun copy(): $Type = to$Type()
                    inline operator fun inc(): $Type = $Type(v.inc())
                    inline operator fun dec(): $Type = $Type(v.dec())"""

                for ((sign, op) in operators) {
                    for (arg in typeInfos + kotlinUnsTypeInfo) {
                        val ArgType = arg.type
                        val maybeV = if (arg.isKotlinUns) "" else ".v"
                        val base = "infix inline operator fun $op(b: $ArgType): "
                        when {
                            arg.isU -> when {
                                typeInfo.bits >= arg.bits -> +"$base$Type = $Type(v $sign b$maybeV)"
                                else -> {
                                    val kotlinUnsType = 'U' + ArgType.drop(1).capitalized()
                                    val maybePromoted = if (kotlinUnsType.lowercase() == Type.lowercase()) "" else ".to$kotlinUnsType()"
                                    if (arg.isKotlinUns)
                                        if (arg.isPromoted)
                                            +"$base$ArgType = (v$maybePromoted $sign b$maybeV)$maybePromoted"
                                        else
                                            +"$base$ArgType = v$maybePromoted $sign b$maybeV"
                                    else {
                                        val ArgCounterType = arg.counterType
                                        +"$base$ArgType = $ArgType(v.to$ArgCounterType() $sign b$maybeV)"
                                    }
                                }
                            }
                            typeInfo.bits >= arg.bits -> {
                                val maybeToUnsFirst = if (typeInfo.bits != arg.bits) ".toU$ArgType()" else ""
                                +"$base$Type = $Type(v $sign b$maybeToUnsFirst.to$UType())"
                            }
                            else -> when (ArgType) {
                                "Byte", "Short" -> +"$base$ArgType = (v.to$ArgType() $sign b).to$ArgType()"
                                "BigInt" -> +"$base$ArgType = v.toBigInteger() $sign b"
                                else -> +"$base$ArgType = v.to$ArgType() $sign b"
                            }
                        }
                    }
                }

                for ((sign, o) in operators) {
                    val op = o + "Assign"
                    for (arg in typeInfos + kotlinUnsTypeInfo) {
                        val ArgType = arg.type
                        val maybeV = if (arg.isKotlinUns) "" else ".v"
                        val base = "inline operator fun $op(b: $ArgType) { v "
                        when {
                            arg.isU -> when {
                                typeInfo.bits >= arg.bits -> when {
                                    typeInfo.isPromoted -> +"$base= (v $sign b$maybeV).to$UType() }"
                                    else -> +"$base$sign= b$maybeV }"
                                }
                                else -> {
                                    val kotlinUnsType = 'U' + ArgType.drop(1).capitalized()
                                    val maybePromoted = if (kotlinUnsType.lowercase() == Type.lowercase()) "" else ".to$kotlinUnsType()"
                                    val T = if (typeInfo.isPromoted) UType else "UInt"
                                    if (arg.isKotlinUns)
                                        +"$base= (v$maybePromoted $sign b).to$T() }"
                                    else
                                        +"$base= (v.to${arg.counterType}() $sign b$maybeV).to$T() }"
                                }
                            }
                            typeInfo.bits >= arg.bits -> {
                                val maybeToUnsFirst = if (typeInfo.bits != arg.bits) ".toU$ArgType()" else ""
                                when {
                                    typeInfo.isPromoted && arg.isPromoted -> +"$base= (v $sign b$maybeToUnsFirst.to$UType()).to$UType() }"
                                    else -> +"$base$sign= b$maybeToUnsFirst.to$UType() }"
                                }
                            }
                            else -> when (ArgType) {
                                "BigInt" -> +"$base= (v.toBigInteger() $sign b).u${signedType}Value() }"
                                "Float", "Double" -> {
                                    val pad = when (Type) {
                                        "U8", "U16" -> ".toInt()"
                                        "U64" -> ".toLong()"
                                        else -> ""
                                    }
                                    +"$base= (v.to$ArgType() $sign b)$pad.to$UType() }"
                                }
                                else -> +"$base= (v.to$ArgType() $sign b).to$UType() }"
                            }
                        }
                    }
                }

                for (op in bitwiseOperators) {
                    if (op[0] != 's')
                        imports += "kotlin.experimental.$op"
                    for (info in intTypeInfos + kotlinUnsTypeInfo) {
                        val T = info.type
                        val maybeV = if (info.isUx) ".v" else ""
                        when (op) {
                            "inv" -> {
                                if (Type == T)
                                    +"inline fun inv(): $Type = $Type(v.inv())"
                            }
                            "shl", "shr" -> {
                                val maybePromote = if (typeInfo.isPromoted) ".toUInt()" else ""
                                val maybeToInt = when (T) {
                                    "BigInt" -> ".intValue()"
                                    "Int" -> ""
                                    else -> ".toInt()"
                                }
                                +"inline infix fun $op(b: $T): $Type = $Type(v$maybePromote $op b$maybeV$maybeToInt)"
                            }
                            else -> {
                                val toType = if (T == "BigInt") "u${signedType}Value" else "to$UType"
                                val maybeToType = if (Type == T || UType == T) "" else ".$toType()"
                                val maybeToUnsFirst = if (typeInfo.bits != info.bits && !info.isU && T != "BigInt") ".toU$T()" else ""
                                +"inline infix fun $op(b: $T): $Type = $Type(v $op b$maybeV$maybeToUnsFirst$maybeToType)"
                            }
                        }
                    }
                }
                for (op in bitwiseOperators) {
                    for (info in intTypeInfos + kotlinUnsTypeInfo) {
                        val T = info.type
                        val maybeV = if (info.isUx) ".v" else ""
                        val maybeToType = when (T) {
                            "BigInt" -> ".u${signedType}Value()"
                            UType, Type -> ""
                            else -> ".to$UType()"
                        }
                        when (op) {
                            "inv" -> {
                                if (Type == T)
                                    +"inline fun invAssign() { v = v.inv() }"
                            }
                            "shl", "shr" -> {
                                val maybeToInt = when (T) {
                                    "Int" -> ""
                                    "BigInt" -> ".intValue()"
                                    else -> ".toInt()"
                                }
                                if (typeInfo.isPromoted)
                                    +"inline infix fun ${op}Assign(b: $T) { v = (v.toUInt() $op b$maybeToInt).to$UType() }"
                                else
                                    +"inline infix fun ${op}Assign(b: $T) { v = v $op b${maybeV}$maybeToInt }"
                            }
                            else -> +"inline infix fun ${op}Assign(b: $T) { v = v $op b${maybeV}$maybeToType }"
                        }
                    }
                }

                imports += "uns.format.format"
                for (cmp in unsTypeInfo) {
                    //                    if ()
                    val CmpType = cmp.type
                    val overrideOrInline = if (Type == CmpType) " override" else " inline"
                    val base = "infix$overrideOrInline operator fun compareTo(other: $CmpType): Int = "
                    val receiver = when {
                        Type == CmpType || UType == CmpType -> "v"
                        cmp.isUx -> "to${cmp.counterType}()"
                        else -> "to$CmpType()"
                    }
                    val maybeV = if (Type == CmpType || cmp.isUx) ".v" else ""
                    +"$base$receiver.compareTo(other$maybeV)"
                }
                +"""
                    override fun equals(other: Any?): Boolean = other is $Type && v == other.v
                    override fun hashCode(): Int = v.hashCode()
                    override fun toString(): String = v.toString()
                    inline fun toString(radix: Int): String = v.toString(radix)
                    inline fun toString(format: String): String = format.format(this)"""
            }
        }
    }
}
