//PLEASE DONT REMOVE SWAGGER2MARKUP, THIS IS JUST WAITING FOR NEXT RELEASE TO BE USED
//import io.github.swagger2markup.tasks.Swagger2MarkupTask

buildscript {
    dependencies {
        classpath("io.github.swagger2markup:swagger2markup-gradle-plugin:1.3.3")
        classpath("io.github.swagger2markup:swagger2markup-import-files-ext:1.3.3")
    }
}

plugins {
    `java-library`
    id("org.asciidoctor.jvm.convert") version "3.2.0"
//    id("org.asciidoctor.jvm.gems") version "3.3.1"
}

apply(plugin = "io.github.swagger2markup")

tasks.withType<io.github.swagger2markup.tasks.Swagger2MarkupTask> {

    swaggerInput = "${projectDir}/src/docs/openapi/swagger2.json"
    outputDir = file("${projectDir}/src/docs/asciidoc/openapi/")
    config = mapOf(
        "swagger2markup.extensions.dynamicPaths.contentPath" to file("asciidoc/extensions/paths").absolutePath
    )
}

repositories {
    mavenCentral()
}
dependencies {
    //implementation("io.github.swagger2markup:swagger2markup-gradle-plugin:1.3.3") //waiting for new release that supports
    //   asciidoctorGems("rubygems:rouge:3.26.0")
}

tasks {
    "asciidoctor"(org.asciidoctor.gradle.jvm.AsciidoctorTask::class) {
        //dependsOn convertSwagger2markup

        logDocuments = true

        baseDirFollowsSourceDir()
        sources(delegateClosureOf<PatternSet> {
            include("encore-documentation.adoc")
            include("openapi.adoc")
        })

        resources {
            from("${projectDir}") {

                include("img/**")
            }
            into("./")

            from("${projectDir}/src/") {

                include("js/**", "css/**", "examples/**")
            }
        }

        attributes(
            mapOf(
                "allow-uri-read" to "",
                // use provided highlighter
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
    gradleVersion = "7.0"
}
/*

asciidoctor {
    baseDirFollowsSourceFile()

    attributes \
    'build-gradle': file('build.gradle'),
    'sourcedir': project.sourceSets.main.java.srcDirs[0],
    'endpoint-url': 'http://example.org',
    'imagesdir': 'images',
    'toc': 'left',
    'icons': 'font',
    'setanchors': '',
    'idprefix': '',
    'idseparator': '-',
    'docinfo': 'shared'

    doLast {
      file("${outputDir}/encore-documentation.html").rename('index.html')
    }
}
