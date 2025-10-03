plugins {
    id("java")
    id("com.gradleup.shadow") version "9.2.2"
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass = "com.example.Main"
}

dependencies {
    implementation("io.modelcontextprotocol.sdk:mcp:0.14.0")
}
