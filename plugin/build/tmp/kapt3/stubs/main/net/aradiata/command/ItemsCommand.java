package net.aradiata.command;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0005H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lnet/aradiata/command/ItemsCommand;", "Lorg/bukkit/command/CommandExecutor;", "Lorg/bukkit/event/Listener;", "()V", "itemMenus", "", "Lorg/bukkit/inventory/Inventory;", "[Lorg/bukkit/inventory/Inventory;", "onCommand", "", "sender", "Lorg/bukkit/command/CommandSender;", "command", "Lorg/bukkit/command/Command;", "label", "", "args", "(Lorg/bukkit/command/CommandSender;Lorg/bukkit/command/Command;Ljava/lang/String;[Ljava/lang/String;)Z", "onInventoryClick", "", "event", "Lorg/bukkit/event/inventory/InventoryClickEvent;", "plugin"})
public final class ItemsCommand implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener {
    @org.jetbrains.annotations.NotNull
    public static final net.aradiata.command.ItemsCommand INSTANCE = null;
    private static final org.bukkit.inventory.Inventory[] itemMenus = null;
    
    private ItemsCommand() {
        super();
    }
    
    @java.lang.Override
    public boolean onCommand(@org.jetbrains.annotations.NotNull
    org.bukkit.command.CommandSender sender, @org.jetbrains.annotations.NotNull
    org.bukkit.command.Command command, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String[] args) {
        return false;
    }
    
    @org.bukkit.event.EventHandler
    public final void onInventoryClick(@org.jetbrains.annotations.NotNull
    org.bukkit.event.inventory.InventoryClickEvent event) {
    }
}