import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import uns.gen.GenerateCode
import java.util.*

plugins {
    kotlin("multiplatform") version embeddedKotlinVersion
    id("elect86.magik") version "0.3.3"
    `maven-publish`
    signing
    `jvm-test-suite`
    //    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories { mavenCentral() }

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.ionspin.kotlin:bignum:0.3.8")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        //        val jsMain by getting
        //        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

tasks {
    val generateCode by registering(GenerateCode::class)
    kotlin.sourceSets.commonMain { kotlin.srcDir(generateCode) }
    withType<KotlinCompile<*>>().all { kotlinOptions { freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn") } }
}

testing.suites {
    val test by getting(JvmTestSuite::class) { useJUnitJupiter() }
}

//java {
//    withJavadocJar()
//    withSourcesJar()
//}


publishing {
//    publications {
//        withType<MavenPublication> {
//            groupId = "io.github.kotlin-graphics"
//            artifactId = "kotlin-unsigned"
////            from(components["java"])
////            versionMapping {
////                usage("java-api") { fromResolutionOf("runtimeClasspath") }
////                usage("java-runtime") { fromResolutionResult() }
////            }
//            pom {
//                name = "kotlin-unsigned"
//                description = "unsigned support for Kotlin via boxed types and unsigned operators"
//                url = "https://github.com/kotlin-graphics/kotlin-unsigned"
//                licenses { license { name = "MIT"; url = "https://choosealicense.com/licenses/mit/" } }
//                developers {
//                    developer { id = "elect86"; name = "Giuseppe Barbieri"; email = "elect86@gmail.com" }
//                    developer { id = "bixilon"; name = "Moritz Zwerger"; email = "bixilon@bixilon.de" }
//                }
//                scm {
//                    connection = "scm:git:https://github.com/kotlin-graphics/kotlin-unsigned.git"
//                    developerConnection = "scm:git:ssh://git@github.com:kotlin-graphics/kotlin-unsigned.git"
//                    url = "https://github.com/kotlin-graphics/kotlin-unsigned"
//                }
//            }
//        }
//    }
    repositories {
        github { domain = "kotlin-graphics/mary" }
//        maven {
//            name = "mavenCentral"
//            credentials {
//                username = project.properties["NEXUS_USERNAME"].toString()
//                password = project.properties["NEXUS_PASSWORD"].toString()
//            }
//            url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
//        }
    }
}

signing {
    val rawKey = project.properties["SIGNING_KEY"]?.toString() ?: return@signing
    val key = String(Base64.getDecoder().decode(rawKey)) // \n is not working in environment variables
    val password = project.properties["SIGNING_KEY_PASSWORD"]?.toString() ?: ""
    useInMemoryPgpKeys(key, password)
    sign(publishing.publications["mavenCentral"])
}
