import org.gradle.api.attributes.LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE
import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    java
    kotlin("jvm") version "1.4.0"
    `maven-publish` // Jitpack
    id("org.jetbrains.dokka") version "1.4.0"
}

val group = "com.github.kotlin_graphics"
val moduleName = "$group.kotlin_unsigned"
val kotestVersion = "4.2.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))

    attributesSchema.attribute(LIBRARY_ELEMENTS_ATTRIBUTE).compatibilityRules.add(ModularJarCompatibilityRule::class)
    components { withModule<ModularKotlinRule>(kotlin("stdlib")) }
    components { withModule<ModularKotlinRule>(kotlin("stdlib-jdk8")) }

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
}

java.modularity.inferModulePath.set(true)

tasks {

    val netlifyBadge by registering {
        doLast {
            val index = dokkaHtml.get().outputDirectory.get().resolve("kotlin-unsigned" + File.separatorChar + "index.html")
            val text = index.readText()
            val ofs = text.lastIndexOf("</span>") + 7
            val badge = """                       
              <a href="https://www.netlify.com">
                <img src="https://www.netlify.com/img/global/badges/netlify-color-accent.svg" alt="Deploys by Netlify" style="vertical-align:middle;margin:10px 10px" />
              </a>
            """.trimIndent()
            index.writeText(text.replaceRange(ofs, ofs, badge))
        }
    }

    dokkaHtml {
        dokkaSourceSets.configureEach {
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/kotlin-graphics/kotlin-unsigned/tree/master/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
        }
        finalizedBy(netlifyBadge)
    }

    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs += listOf("-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = "11"
    }

    // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
    compileJava.get().options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")

    withType<Test> { useJUnitPlatform() }
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().outputDirectory.get())
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.get().outputDirectory.get())
    archiveClassifier.set("html-doc")
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks["classes"])
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(dokkaJavadocJar)
    archives(dokkaHtmlJar)
    archives(sourceJar)
}

publishing.publications.register("mavenJava", MavenPublication::class) {
    from(components["java"])
    artifact(sourceJar)
}

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all {
    attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 11)
    val n = name.toLowerCase()
    if (n.endsWith("compileclasspath") || n.endsWith("runtimeclasspath"))
        attributes.attribute(LIBRARY_ELEMENTS_ATTRIBUTE, objects.named("modular-jar"))
    if (n.endsWith("compile") || n.endsWith("runtime"))
        isCanBeConsumed = false
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
                    attribute(LIBRARY_ELEMENTS_ATTRIBUTE, getObjects().named("modular-jar"))
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