package uns.gen

import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.file.ProjectLayout
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import uns.arrays
import uns.extensions
import uns.operators
import uns.types
import javax.inject.Inject

abstract class GenerateCode : DefaultTask() {

    init {
        group = "build"
        description = "Generate code"
    }

    @get:Inject
    abstract val layout: ProjectLayout

    @get:Inject
    abstract val files: FileSystemOperations

    @get:OutputDirectory
    val targetDir: Directory = layout.projectDirectory.dir("src/commonMain/kotlinGen")

    @TaskAction
    fun generate() {
        files.delete { delete(targetDir) }
        Generator.targetDir = targetDir.asFile
        arrays()
        types()
        extensions()
        operators()
    }
}

fun generate(file: String, block: Generator.() -> Unit) {
    Generator().apply {
        block()
        if (imports.isNotEmpty())
            builder.insert(0, '\n')
        for (import in imports)
            builder.insert(0, "import $import\n")
        //        if (`package`.isNotEmpty())
        val f = file.replace('/', '.').substringBefore('.', "")
        val pack = if (f.isEmpty()) "uns" else "uns.$f"
        builder.insert(0, "package $pack\n\n")
        if (experimentals.isNotEmpty()) {
            val list = experimentals.joinToString { "${it.pkg}.Experimental${it.name}::class" }
            builder.insert(0, "@file:OptIn($list)\n")
        }
        if (disableNameShadowing)
            builder.insert(0, "@file:Suppress(\"NAME_SHADOWING\")\n")
        if (nothingToInline)
            builder.insert(0, "@file:Suppress(\"NOTHING_TO_INLINE\")\n")
        write(file)
    }
}

