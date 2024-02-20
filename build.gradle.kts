plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources")
            // Hier können Sie weitere Verzeichnisse hinzufügen, falls benötigt
        }
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "at.app.Mainkt"
    }
}