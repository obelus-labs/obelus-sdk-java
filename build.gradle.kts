plugins {
    `java-library`
    idea
}

group = "io.obelus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_12
    targetCompatibility = JavaVersion.VERSION_12
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}