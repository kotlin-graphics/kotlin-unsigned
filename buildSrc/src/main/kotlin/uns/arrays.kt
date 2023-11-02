package uns

import uns.gen.Generator
import uns.gen.generate

fun arrays() {
    generate("arrays") {
        imports += "kotlin.jvm.JvmInline"
        imports += "kotlin.jvm.JvmName"
        imports += "kotlin.experimental.ExperimentalTypeInference"
        experimentals += Generator.Experimentals.UnsignedTypes
        experimentals += Generator.Experimentals.TypeInference
        for (info in unsInfos) {
            val Type = info.type
            val TypeArray = Type + "Array"
            val CounterArray = info.counterType + "Array"
            val CounterType = info.counterType
            +"""
                @JvmInline
                value class $TypeArray(val data: $CounterArray) {
                
                    operator fun get(index: I32): $Type = $Type(data[index])
                
                    operator fun set(index: I32, value: $Type) { data[index] = value.v }
                    
                    val indices: IntRange
                        get() = data.indices
                }
                
                fun $TypeArray(size: I32): $TypeArray = $TypeArray($CounterArray(size))
                @OverloadResolutionByLambdaReturnType
                @JvmName("$TypeArray$CounterType")
                inline fun $TypeArray(size: I32, init: (I32) -> $CounterType): $TypeArray = $TypeArray($CounterArray(size, init))
                @OverloadResolutionByLambdaReturnType
                @JvmName("$TypeArray$Type")
                inline fun $TypeArray(size: I32, init: (I32) -> $Type): $TypeArray {
                    val array = $TypeArray($CounterArray(size))
                    for (i in array.indices)
                        array[i] = init(i)
                    return array
                }"""
            if (info.bits != 32)
                +"""
                    @OverloadResolutionByLambdaReturnType
                    @JvmName("${TypeArray}I32")
                    inline fun $TypeArray(size: I32, init: (I32) -> I32): $TypeArray {
                        val array = $TypeArray($CounterArray(size))
                        for (i in array.indices)
                            array.data[i] = init(i).to$CounterType()
                        return array
                    }
                    @OverloadResolutionByLambdaReturnType
                    @JvmName("${TypeArray}U32")
                    inline fun $TypeArray(size: I32, init: (I32) -> U32): $TypeArray {
                        val array = $TypeArray($CounterArray(size))
                        for (i in array.indices)
                            array.data[i] = init(i).to$CounterType()
                        return array
                    }"""
        }
    }
}

