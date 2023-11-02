package uns

import uns.gen.generate

fun operators() {

    generate("operators") {

        nothingToInline = true

        for (receiver in signedTypeInfos + kotlinUnsTypeInfo) {

            val RecType = receiver.type

            for ((sign, op) in operators) {

                for (u in unsInfos) {

                    val UType = u.type
                    val base = "inline infix operator fun $RecType.$op(other: $UType): "
                    when {
                        receiver.isU -> when {
                            receiver.bits <= u.bits -> +"$base$UType = $UType(this $sign other.v)"
                            RecType == "UShort" -> +"$base$RecType = (this $sign other.v).toUShort()"
                            else -> +"$base$RecType = this $sign other.v"
                        }
                        receiver.bits <= u.bits -> +"$base$UType = $UType(this.toU$RecType() $sign other.v)"
                        RecType == "Short" -> +"$base$RecType = (this $sign other.to$RecType()).toShort()"
                        else -> +"$base$RecType = this $sign other.to$RecType()"
                    }
                }
            }
        }

        imports += "com.ionspin.kotlin.bignum.integer.toBigInteger"

        for (receiver in signedTypeInfos + kotlinUnsTypeInfo) {

            val RecType = receiver.type

            for (op in bitwiseOperators) {

                for (u in unsInfos) {

                    if (op == "inv") continue

                    val UType = u.type
                    val base = "inline infix fun $RecType.$op(other: $UType): $RecType = "
                    if (RecType == "BigInt") {
                        val type = if (op.startsWith("sh")) "Int" else "BigInteger"
                        +"${base}this $op other.v.to$type()"
                    } else when (op) {
                        "shl", "shr" -> when {
                            receiver.isPromoted -> {
                                val maybeToU = if (receiver.isU) "" else ".toU$RecType()"
                                +"$base(this$maybeToU.toUInt() $op other.v.toInt()).to$RecType()"
                            }
                            else -> +"${base}this $op other.v.toInt()"
                        }
                        else -> when {
                            receiver.isU -> {
                                val maybeTo = if (u.counterType != RecType) ".to$RecType()" else ""
                                +"${base}this $op other.v$maybeTo"
                            }
                            receiver.bits >= u.bits -> {
                                val maybeTo = if (u.counterType == "U$RecType") "" else ".toU$RecType()"
                                +"${base}(this.toU$RecType() $op other.v$maybeTo).to$RecType()"
                            }
                            else -> +"${base}(this.toU$RecType() $op other.v.toU$RecType()).to$RecType()"
                        }
                    }
                }
            }

            for (u in unsInfos) {
                if (!receiver.isU)
                    continue
                val UType = u.type
                when {
                    RecType == "BigInt" -> +"infix operator fun BigInt.compareTo(other: $UType): Int = compareTo(other.v.toBigInteger())"
                    receiver.isU -> +"infix operator fun $RecType.compareTo(other: $UType): Int = to$RecType().compareTo(other.v)"
                    else -> +"infix operator fun $RecType.compareTo(other: $UType): Int = toU$RecType().compareTo(other.v)"
                }
            }
        }
    }
}