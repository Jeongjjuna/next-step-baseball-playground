plugins {
    kotlin("jvm") version "1.8.0"
}

group = "org.freak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
    runtimeOnly("io.kotest:kotest-framework-datatest-jvm:5.6.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}