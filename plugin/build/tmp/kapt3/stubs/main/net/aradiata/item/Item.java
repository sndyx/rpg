package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\b&\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH&R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lnet/aradiata/item/Item;", "", "id", "", "model", "", "name", "rarity", "Lnet/aradiata/item/Rarity;", "description", "events", "Lnet/aradiata/item/ItemEvents;", "(Ljava/lang/String;ILjava/lang/String;Lnet/aradiata/item/Rarity;Ljava/lang/String;Lnet/aradiata/item/ItemEvents;)V", "getDescription", "()Ljava/lang/String;", "getEvents", "()Lnet/aradiata/item/ItemEvents;", "getId", "material", "Lorg/bukkit/Material;", "getMaterial", "()Lorg/bukkit/Material;", "getModel", "()I", "getName", "getRarity", "()Lnet/aradiata/item/Rarity;", "writeDetails", "", "lore", "", "plugin"})
public abstract class Item {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    private final int model = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final net.aradiata.item.Rarity rarity = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final net.aradiata.item.ItemEvents events = null;
    
    public Item(@org.jetbrains.annotations.NotNull
    java.lang.String id, int model, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Rarity rarity, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.NotNull
    net.aradiata.item.ItemEvents events) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    public final int getModel() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.item.Rarity getRarity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.item.ItemEvents getEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract org.bukkit.Material getMaterial();
    
    public abstract void writeDetails(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> lore);
}