package uns

import org.gradle.configurationcache.extensions.capitalized
import uns.gen.generate

fun extensions() {

    generate("extensions") {

        imports += "com.ionspin.kotlin.bignum.integer.toBigInteger"

        for (receiver in intTypeInfos + kotlinUnsTypeInfo) {
            val ReceiverType = receiver.type
            for (extInfo in intTypeInfos + kotlinUnsTypeInfo + floatingTypes) {
                val ext = extInfo.extension
                val extType = extInfo.type
                val ExtType = when {
                    extInfo.isKotlinUns -> extInfo.type
                    else -> ext.capitalized()
                }
                val toType = when {
                    ReceiverType == "BigInt" -> when {
                        extInfo.isUx -> "$ExtType(${extInfo.counterType.lowercase()}Value())"
                        else -> extInfo.type.lowercase() + "Value()"
                    }
                    extInfo.isUx -> "$ExtType(this)"
                    extInfo.type == "BigInt" -> if (receiver.isUx) "toBigInt()" else "toBigInteger()"
                    else -> "to$extType()"
                }
                if (ReceiverType != extType) {
                    +"""
                        inline val $ReceiverType.$ext: $ExtType
                            get() = $toType
                        """
                    fun alias(alias: Char) = +"""
                        inline val $ReceiverType.$alias: $ExtType
                            get() = $ext"""
                    when (ext) {
                        "i32" -> alias('i')
                        "i64" -> alias('L')
                        "f32" -> alias('f')
                    }
                }
            }
        }
    }
}