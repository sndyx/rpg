plugins {
    kotlin("jvm") version "1.5.10"
    id("kr.entree.spigradle") version "1.2.4"
}

group = "net.aradiata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.spigotmc:spigot-api:1.18-R0.1-SNAPSHOT")
}