package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lnet/aradiata/item/Armor;", "Lnet/aradiata/item/Item;", "id", "", "model", "", "name", "rarity", "Lnet/aradiata/item/Rarity;", "description", "events", "Lnet/aradiata/item/ItemEvents;", "type", "Lnet/aradiata/item/ArmorType;", "stats", "", "Lnet/aradiata/item/ArmorStat;", "(Ljava/lang/String;ILjava/lang/String;Lnet/aradiata/item/Rarity;Ljava/lang/String;Lnet/aradiata/item/ItemEvents;Lnet/aradiata/item/ArmorType;Ljava/util/List;)V", "material", "Lorg/bukkit/Material;", "getMaterial", "()Lorg/bukkit/Material;", "getStats", "()Ljava/util/List;", "getType", "()Lnet/aradiata/item/ArmorType;", "writeDetails", "", "lore", "", "plugin"})
public final class Armor extends net.aradiata.item.Item {
    @org.jetbrains.annotations.NotNull
    private final net.aradiata.item.ArmorType type = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<net.aradiata.item.ArmorStat> stats = null;
    @org.jetbrains.annotations.NotNull
    private final org.bukkit.Material material = null;
    
    public Armor(@org.jetbrains.annotations.NotNull
    java.lang.String id, int model, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Rarity rarity, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.NotNull
    net.aradiata.item.ItemEvents events, @org.jetbrains.annotations.NotNull
    net.aradiata.item.ArmorType type, @org.jetbrains.annotations.NotNull
    java.util.List<net.aradiata.item.ArmorStat> stats) {
        super(null, 0, null, null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.item.ArmorType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<net.aradiata.item.ArmorStat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.bukkit.Material getMaterial() {
        return null;
    }
    
    @java.lang.Override
    public void writeDetails(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> lore) {
    }
}