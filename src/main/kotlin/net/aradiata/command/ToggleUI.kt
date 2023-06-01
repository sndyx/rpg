package net.aradiata.command

import net.aradiata.player.controller
import net.aradiata.ui.FixedComponent
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ToggleUI : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): Boolean {
        if (sender !is Player) return true
        if (args.size != 1) sender.sendMessage("§cUsage: /toggleui <element>")
        val className = args[0]
        runCatching {
            val constructor = Class.forName("net.aradiata.ui.$className")
                .getConstructor(Player::class.java)
            val stack = sender.controller.ui.stack
            return@runCatching if (stack.hasComponent(constructor.declaringClass.kotlin)) {
                stack.removeComponent(constructor.declaringClass.kotlin)
                false
            } else {
                val element = constructor.newInstance(sender) as FixedComponent
                stack.addComponent(element)
                true
            }
        }.onFailure {
            sender.sendMessage("§cClass not found!")
        }.onSuccess {
            sender.sendMessage("§a$className toggled ${if (it) "on" else "off"}.")
        }
        return true
    }

}