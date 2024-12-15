plugins {
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0") // Replace with your Kotlin version

    // Testing dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") // Coroutine test library
    testImplementation("junit:junit:4.13.2") // JUnit 4
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // JUnit 5 (Optional)
}

tasks.test {
    useJUnitPlatform() // Enables JUnit 5 platform for test execution
}

/*
sourceSets {
    test {
        kotlin.srcDir("src/test")
    }
}*/
