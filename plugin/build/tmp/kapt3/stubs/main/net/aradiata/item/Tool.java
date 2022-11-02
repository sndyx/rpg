package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lnet/aradiata/item/Tool;", "Lnet/aradiata/item/Item;", "id", "", "model", "", "name", "rarity", "Lnet/aradiata/item/Rarity;", "description", "events", "Lnet/aradiata/item/ItemEvents;", "(Ljava/lang/String;ILjava/lang/String;Lnet/aradiata/item/Rarity;Ljava/lang/String;Lnet/aradiata/item/ItemEvents;)V", "material", "Lorg/bukkit/Material;", "getMaterial", "()Lorg/bukkit/Material;", "plugin"})
public abstract class Tool extends net.aradiata.item.Item {
    @org.jetbrains.annotations.NotNull
    private final org.bukkit.Material material = org.bukkit.Material.STICK;
    
    public Tool(@org.jetbrains.annotations.NotNull
    java.lang.String id, int model, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Rarity rarity, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.NotNull
    net.aradiata.item.ItemEvents events) {
        super(null, 0, null, null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.bukkit.Material getMaterial() {
        return null;
    }
}