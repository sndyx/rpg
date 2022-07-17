package net.aradiata.command

import net.aradiata.block.queue.DefaultRegenQueue
import net.aradiata.block.queue.StoneRegenQueue
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object RegenAllCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player && sender.isOp) {
            DefaultRegenQueue.regenAll()
            StoneRegenQueue.regenAll()
        }

        return true
    }
}