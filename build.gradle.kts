import kr.entree.spigradle.attribute.Load

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("kr.entree.spigradle") version "1.2.4"
}

group = "net.aradiata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

val shade: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(kotlin("scripting-common"))
    implementation(kotlin("scripting-jvm"))
    implementation(kotlin("scripting-jvm-host"))
    implementation(kotlin("script-runtime"))
    implementation(kotlinx("serialization-json", "1.3.2"))
    implementation(kotlinx("coroutines-core", "1.6.0"))
    compileOnly("org.spigotmc:spigot-api:1.18-R0.1-SNAPSHOT")
}

spigot {
    authors = listOf("sndy")
    apiVersion = "1.18"
    load = Load.STARTUP
    commands {
        create("setrank") {
            description = "Sets a player's rank"
            permission = "aradiata.command.setrank"
            permissionMessage = "You do not have permission!"
            usage = "/setrank <player> <rank>"
        }
        create("items") {
            description = "gives u an item lol"
            permission = "none.lol"
            permissionMessage = "You do not have permission!"
            usage = "/items [reload |get <id>]"
        }
    }
    permissions {
        create("aradiata.command.setrank") {
            description = "Allows player to set ranks."
            defaults = "false"
        }
    }
}

tasks.withType<Jar> {
    
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    
    from(sourceSets.main.get().output)
    
    dependsOn(configurations.runtimeClasspath)
    from ({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
    
}

fun DependencyHandler.kotlinx(module: String, version: String): String = "org.jetbrains.kotlinx:kotlinx-$module:$version"