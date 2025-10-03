plugins {
    id("io.micronaut.application") version "4.5.4"
    id("com.gradleup.shadow") version "8.3.7"
}
version = "0.1"
group = "example.micronaut"
repositories {
    mavenCentral()
    maven {
        url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        mavenContent {
            snapshotsOnly()
        }
    }
}
dependencies {
    annotationProcessor("io.micronaut:micronaut-graal")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.mcp:micronaut-mcp-server-java-sdk:0.0.8")
    annotationProcessor("io.micronaut.jsonschema:micronaut-json-schema-processor:1.7.2")
    implementation("io.micronaut.jsonschema:micronaut-json-schema-annotations:1.7.2")
    implementation("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("org.skyscreamer:jsonassert:1.5.3")

}
application {
    mainClass = "example.micronaut.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}
graalvmNative.toolchainDetection = false
micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
}
tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}
