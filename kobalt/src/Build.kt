
import com.beust.kobalt.*

val p = project {
    name = "kotlin-unsigned"
    group = "elect86"
    artifactId = name
    version = "0.1"

    dependenciesTest {
        compile("io.kotlintest:kotlintest:1.3.5")
    }
}

test {         
    include("**/*.class")     
}
