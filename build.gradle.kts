import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import kr.entree.spigradle.attribute.Load

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("kr.entree.spigradle") version "1.2.4"
}

group = "net.aradiata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    shadow(kotlin("stdlib"))
    shadow(kotlin("reflect"))
    shadow(kotlin("scripting-common"))
    shadow(kotlin("scripting-jvm"))
    shadow(kotlin("scripting-jvm-host"))
    shadow(kotlinx("serialization-json", "1.3.2"))
    shadow(kotlinx("coroutines-core", "1.6.0"))
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

fun DependencyHandler.kotlinx(module: String, version: String): String = "org.jetbrains.kotlinx:kotlinx-$module:$version"