plugins {
    kotlin("jvm") version "1.3.72"
    java
}

val moduleName = "com.github.kotlin_graphics.kotlin_unsigned"
val kot = "org.jetbrains.kotlin:kotlin"
val kotlintest_version = "3.4.2"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    attributesSchema.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE).compatibilityRules.add(ModularJarCompatibilityRule::class)
    components { withModule<ModularKotlinRule>(kotlin("stdlib-jdk8")) }

    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlintest_version")
}

java {
    modularity.inferModulePath.set(true)
}

//java {
//    withJavadocJar()
//    withSourcesJar()
//}

//task sourcesJar(type: Jar, dependsOn: classes) {
//    archiveClassifier = 'sources'
//    from sourceSets.main.allSource
//}
//
//task javadocJar(type: Jar, dependsOn: javadoc) {
//    archiveClassifier = 'javadoc'
//    from javadoc.destinationDir
//}
//
//artifacts {
//    archives sourcesJar
////    archives javadocJar
//}
//

tasks.compileKotlin {
    // Enable Kotlin compilation to Java 8 class files with method parameter name metadata
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
//        javaParameters = true
    }
    // As per https://stackoverflow.com/a/47669720
    // See also https://discuss.kotlinlang.org/t/kotlin-support-for-java-9-module-system/2499/9
//    destinationDir = compileJava.destinationDir
}

tasks.compileTestKotlin {
    kotlinOptions {
        jvmTarget = "11"
//        javaParameters = true
    }
}

tasks.compileJava {
    // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
    options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
}


//test.useJUnitPlatform()

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all {
    if (name.toLowerCase().endsWith("compileclasspath") || name.toLowerCase().endsWith("runtimeclasspath")) {
        attributes.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named("modular-jar"))
    }
    if (name.toLowerCase().endsWith("compile") || name.toLowerCase().endsWith("runtime")) {
        isCanBeConsumed = false
    }
}

abstract class ModularJarCompatibilityRule : AttributeCompatibilityRule<LibraryElements> {
    override fun execute(details: CompatibilityCheckDetails<LibraryElements>): Unit = details.run {
        if (producerValue?.name == LibraryElements.JAR && consumerValue?.name == "modular-jar")
            compatible()
    }
}

abstract class ModularKotlinRule : ComponentMetadataRule {

    @javax.inject.Inject
    abstract fun getObjects(): ObjectFactory

    override fun execute(ctx: ComponentMetadataContext) {
        val id = ctx.details.id
        listOf("compile", "runtime").forEach { baseVariant ->
            ctx.details.addVariant("${baseVariant}Modular", baseVariant) {
                attributes {
                    attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, getObjects().named("modular-jar"))
                }
                withFiles {
                    removeAllFiles()
                    addFile("${id.name}-${id.version}-modular.jar")
                }
                withDependencies {
                    clear() // 'kotlin-stdlib-common' and  'annotations' are not modules and are also not needed
                }
            }
        }
    }
}