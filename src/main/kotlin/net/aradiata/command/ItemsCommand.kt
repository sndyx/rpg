package net.aradiata.command

import net.aradiata.dsl.menu
import net.aradiata.item.Items
import net.aradiata.utility.colored
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

object ItemsCommand : CommandExecutor, Listener {

    private val itemMenus = Array(Items.registry.size / 27 + 1) {
        menu(4, "Items | Page ${it + 1}") {
            Items.registry.values.drop(27 * it).take(27).forEachIndexed { index, item ->
                slot(index + 9, item.new())
            }
            if (it != 0) {
                slot(3, ItemStack(Material.ARROW).apply {
                    val meta = itemMeta!!
                    meta.setDisplayName("&fPrevious Page".colored())
                    itemMeta = meta
                })
            }
            if (it != Items.registry.size / 27) {
                slot(5, ItemStack(Material.ARROW).apply {
                    val meta = itemMeta!!
                    meta.setDisplayName("&fNext Page".colored())
                    itemMeta = meta
                })
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            sender.openInventory(itemMenus.first())
        }
        return true
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        event.isCancelled = true
        val page = itemMenus.indexOf(event.inventory)
        if (page == -1) return
        if (event.slot == 3 && page != 0) event.whoClicked.openInventory(itemMenus[page - 1])
        else if (event.slot == 5 && page != itemMenus.size - 1) event.whoClicked.openInventory(itemMenus[page + 1])
        else if (event.currentItem != null) event.whoClicked.setItemOnCursor(event.currentItem)
    }

}