package net.aradiata.command

import net.aradiata.dsl.loadAllItems
import net.aradiata.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ItemsCommand : CommandExecutor {
    
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args[0] == "reload") {
            plugin.items = loadAllItems()
        } else if (args[0] == "get") {
            if (sender is Player) {
                val item = plugin.items[args[1]]
                if (item == null) {
                    sender.sendMessage("Invalid item bro.")
                    return false
                }
                val itemStack = item.create()
                sender.inventory.addItem(itemStack)
            }
        }
        return true
    }
    
}