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

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("script-runtime"))
    implementation(kotlinx("serialization-json", "1.3.2"))
    implementation(kotlinx("coroutines-core", "1.6.0"))
    implementation("org.spigotmc:spigot-api:1.18-R0.1-SNAPSHOT")
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
    }
    permissions {
        create("aradiata.command.setrank") {
            description = "Allows player to set ranks."
            defaults = "false"
        }
    }
}

fun DependencyHandler.kotlinx(module: String, version: String): String = "org.jetbrains.kotlinx:kotlinx-$module:$version"