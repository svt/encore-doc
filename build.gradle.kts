plugins {
    `java-library`
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    id("org.openapi.generator") version "7.0.1"
}

repositories {
    mavenCentral()
}

// OpenAPI Generator configuration
tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generateApiDocs") {
    generatorName.set("asciidoc")
    inputSpec.set("${projectDir}/src/docs/openapi/swagger2.json")
    outputDir.set("${projectDir}/build/generated/openapi")
    configOptions.set(mapOf(
        "specDir" to "src/docs/openapi",
        "markupLanguage" to "asciidoc",
        "headerAttributes" to "false",
        "useMethodAndPath" to "true",
        "skipOverview" to "true"
    ))
    
    // Process the generated file to remove the top-level heading and Operation Id lines
    doLast {
        val generatedFile = file("${projectDir}/build/generated/openapi/index.adoc")
        if (generatedFile.exists()) {
            var content = generatedFile.readText()
            
            // Remove the first heading and abstract, since we add our own
            val headingPattern = """(?s)^= .*?(?=\n==)""".toRegex()
            content = content.replace(headingPattern, "")
            
            // Remove Operation Id lines
            val operationIdPattern = """Operation Id:: .*\n+""".toRegex()
            content = content.replace(operationIdPattern, "")

            // Fix problems with tables in openapi docs
            content = content.replace("asc|desc", "asc\\|desc")
            
            // Write back to file
            generatedFile.writeText(content)
        }
        
        // Copy the processed file to the asciidoc directory
        copy {
            from("${projectDir}/build/generated/openapi")
            into("${projectDir}/src/docs/asciidoc/openapi")
            include("**/*.adoc")
        }
    }
}

tasks {
    "asciidoctor"(org.asciidoctor.gradle.jvm.AsciidoctorTask::class) {
        dependsOn("generateApiDocs")
        logDocuments = true

        baseDirFollowsSourceDir()
        sources(delegateClosureOf<PatternSet> {
            include("encore-documentation.adoc")
            include("openapi.adoc")
        })

        resources {
            from("${projectDir}/src/") {
                include("img/**")
            }

            from("${projectDir}/src/") {
                include("js/**", "css/**", "examples/**")
            }
        }

        attributes(
            mapOf(
                "allow-uri-read" to "",
                "source-highlighter" to "highlight.js",
                "highlightjsdir" to "js/highlight",
                "highlightjs-theme" to "darcula",
                "stylesheet" to "css/clean.css"
            )
        )

        doLast {
            file("${outputDir}/encore-documentation.html").renameTo(file("${outputDir}/index.html"))
        }
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.2"
}