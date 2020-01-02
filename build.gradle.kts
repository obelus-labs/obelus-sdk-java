plugins {
    `java-library`
    idea
    id("io.franzbecker.gradle-lombok") version "3.2.0"
}

group = "io.obelus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:okhttp:4.2.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

lombok {
    version = "1.18.10"
    sha256 = ""
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}