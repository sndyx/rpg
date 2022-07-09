package net.aradiata.command

import net.aradiata.dsl.menu
import net.aradiata.item.Items
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ItemsCommand : CommandExecutor {

    val itemMenus = Array(Items.registry.size / 27 + 1) {
        menu(4) {
            Items.registry.values.drop(27 * it).take(27).forEachIndexed { index, item ->
                slot(index + 9, item.new())
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {

            if (item == null) {
                sender.sendMessage("Invalid item bro.")
                return false
            }
            val itemStack = item.create()
            sender.openInv
        }
        return true
    }

}