package uns

val intTypeInfos = listOf(TypeInfo("Byte", "i8"),
                          TypeInfo("Short", "i16"),
                          TypeInfo("Int", "i32"),
                          TypeInfo("Long", "i64"),
                          TypeInfo("U8", "u8"),
                          TypeInfo("U16", "u16"),
                          TypeInfo("U32", "u32"),
                          TypeInfo("U64", "u64"),
                          TypeInfo("BigInt", "bigInt"))
val signedTypeInfos = intTypeInfos.filter { !it.isU }
val typeInfos = intTypeInfos + TypeInfo("Float", "f") + TypeInfo("Double", "d")
val kotlinUnsTypeInfo = listOf(TypeInfo("UByte"), TypeInfo("UShort"), TypeInfo("UInt"), TypeInfo("ULong"))
val unsTypeInfo = intTypeInfos.filter { it.isU } + kotlinUnsTypeInfo
val floatingTypes = listOf(TypeInfo("Float", "f32"), TypeInfo("Double", "f64"))
val extensionsToInformation = intTypeInfos.associateBy { it.extension }
val typeToInformation = intTypeInfos.associateBy { it.type }
val intPromotedTypes = listOf("Byte", "Short", "UByte", "UShort")
val intTypes = intTypeInfos.map { it.type }
val unsInfos = intTypeInfos.filter { it.type[0] == 'U' }
val unsTypes = unsInfos.map { it.type }

data class TypeInfo(val type: String, val extension: String = type.take(2).lowercase()) {

    val isU
        get() = type[0] == 'U'
    val isKotlinUns
        get() = isU && type[1].isUpperCase()

    val isUx
        get() = isU && !isKotlinUns
    val bits: Int
        get() = when (type) {
            "UByte", "Byte", "U8", "I8" -> 8
            "UShort", "Short", "U16", "I16" -> 16
            "UInt", "Int", "U32", "I32" -> 32
            "ULong", "Long", "U64", "I64" -> 64
            else -> 65 // BigInteger
        }

    val isPromoted: Boolean
        get() = when(type) {
            "U8", "Byte", "UByte", "U16", "Short", "UShort" -> true
            else -> false
        }

    val counterType: String
        get() = counterInfo.type
    val counterInfo: TypeInfo
        get() = (intTypeInfos + kotlinUnsTypeInfo).first {
            it.type == when (type) {
                "U8" -> "UByte"
                "U16" -> "UShort"
                "U32" -> "UInt"
                "U64" -> "ULong"
                "I8" -> "Byte"
                "I16" -> "Short"
                "I32" -> "Int"
                "I64" -> "Long"
                "UByte" -> "Byte"
                "UShort" -> "Short"
                "UInt" -> "Int"
                "ULong" -> "Long"
                else -> error("invalid type: `$type`")
            }
        }

    val promotedType: String
        get() = promotedInfo.type
    val promotedInfo: TypeInfo
        get() = (intTypeInfos + kotlinUnsTypeInfo).first {
            it.type == when (type) {
                "U8", "U16" -> "U32"
                "I8", "I16" -> "I32"
                "UByte", "UShort" -> "UInt"
                "U32" -> "U64"
                "I32" -> "I64"
                "UInt" -> "ULong"
                "U64", "I64", "ULong" -> "BigInt"
                else -> error("invalid type: `$type`")
            }
        }

    val isPrimitive: Boolean
        get() = when (type) {
            "I8", "I16", "I32", "I64", "UByte", "UShort", "UInt", "ULong" -> true
            else -> false
        }

//    val paddedType: String
//        get() = when(type) {
//            "Ubyte", "Ushort" ->
//        }
}

operator fun Iterable<TypeInfo>.minus(types: Iterable<String>) = types.toSet().let { typeSet -> this.filter { it.type !in typeSet } }