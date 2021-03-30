group = "fi.utu.tech"
version = "2.0.0"

plugins {
    java
    kotlin("jvm") version "1.4.31"
    id("org.openjfx.javafxplugin") version "0.0.9"
    id("org.beryx.jlink") version "2.23.5"
    application
}

java {
    modularity.inferModulePath.set(true)
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11

    sourceSets["main"].java {
        srcDir("src/main/java")
    }
    sourceSets["main"].resources {
        srcDir("src/main/resources")
    }
    sourceSets["test"].java {
        srcDir("src/test/java")
    }
    sourceSets["test"].resources {
        srcDir("src/test/resources")
    }
}

javafx {
    version = "16"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.media", "javafx.web")
}

repositories {
    mavenCentral()
    maven("https://ftdev.utu.fi/maven2")
}

dependencies {
    implementation("fi.utu.tech", "hotreload", "2.0.0")
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.4.31")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.7.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-params", "5.7.1")
    testImplementation("org.junit.platform", "junit-platform-commons", "1.7.1")
    testImplementation("net.jqwik", "jqwik", "1.5.0")
}

application{
    modularity.disableEffectiveArgumentsAdjustment()
    mainModule.set("fi.utu.tech.gui.javafx")
    mainClass.set("fi.utu.tech.gui.javafx.Main")
    applicationDefaultJvmArgs = arrayListOf("-ea")
}

tasks {
    test {
        useJUnitPlatform()
    }

    compileJava {
        options.encoding = "UTF-8"
    }
}

jlink{
    launcher {
        name = "launch"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/template-javafx-image.zip"))
}
