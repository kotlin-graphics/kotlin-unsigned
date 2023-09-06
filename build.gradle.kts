import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import java.util.*

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("elect86.magik") version "0.3.3"
    `maven-publish`
    signing
    `jvm-test-suite`
//    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories { mavenCentral() }

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.7.1")
    testImplementation("io.kotest:kotest-assertions-core:5.7.1")
}

kotlin.jvmToolchain { languageVersion.set(JavaLanguageVersion.of(11)) }

tasks {
    withType<KotlinCompile<*>>().all { kotlinOptions { freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn") } }
}

testing.suites {
    val test by getting(JvmTestSuite::class) { useJUnitJupiter() }
}

java {
    withJavadocJar()
    withSourcesJar()
}


configure<PublishingExtension> {
    publications {
        createGithubPublication("Github") {
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
        create<MavenPublication>("mavenCentral") {
            groupId = "io.github.kotlin-graphics"
            artifactId = "kotlin-unsigned"
            from(components["java"])
            versionMapping {
                usage("java-api") { fromResolutionOf("runtimeClasspath") }
                usage("java-runtime") { fromResolutionResult() }
            }
            pom {
                name.set("kotlin-unsigned")
                description.set("unsigned support for Kotlin via boxed types and unsigned operators")
                url.set("https://github.com/kotlin-graphics/kotlin-unsigned")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("elect86")
                        name.set("Giuseppe Barbieri")
                        email.set("elect86@gmail.com")
                    }
                    developer {
                        id.set("bixilon")
                        name.set("Moritz Zwerger")
                        email.set("bixilon@bixilon.de")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/kotlin-graphics/kotlin-unsigned.git")
                    developerConnection.set("scm:git:ssh://git@github.com:kotlin-graphics/kotlin-unsigned.git")
                    url.set("https://github.com/kotlin-graphics/kotlin-unsigned")
                }
            }
        }
    }
    repositories {
        github { domain = "kotlin-graphics/mary" }
        maven {
            name = "mavenCentral"
            credentials {
                username = project.properties["NEXUS_USERNAME"].toString()
                password = project.properties["NEXUS_PASSWORD"].toString()
            }
            url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
        }
    }
}

signing {
    val rawKey = project.properties["SIGNING_KEY"]?.toString() ?: return@signing
    val key = String(Base64.getDecoder().decode(rawKey)) // \n is not working in environment variables
    val password = project.properties["SIGNING_KEY_PASSWORD"]?.toString() ?: ""
    useInMemoryPgpKeys(key, password)
    sign(publishing.publications["mavenCentral"])
}
