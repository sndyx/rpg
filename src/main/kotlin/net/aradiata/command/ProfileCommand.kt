package net.aradiata.command

import net.aradiata.player.handle
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ProfileCommand : CommandExecutor {
    
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        val profile = args.singleOrNull()?.toIntOrNull() ?: return false
        sender.handle().data.load(profile)
        return true
    }
    
}