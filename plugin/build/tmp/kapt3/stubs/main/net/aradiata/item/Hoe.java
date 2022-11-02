package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lnet/aradiata/item/Hoe;", "Lnet/aradiata/item/Tool;", "id", "", "model", "", "name", "rarity", "Lnet/aradiata/item/Rarity;", "description", "events", "Lnet/aradiata/item/ItemEvents;", "harvest", "(Ljava/lang/String;ILjava/lang/String;Lnet/aradiata/item/Rarity;Ljava/lang/String;Lnet/aradiata/item/ItemEvents;I)V", "getHarvest", "()I", "writeDetails", "", "lore", "", "plugin"})
public final class Hoe extends net.aradiata.item.Tool {
    private final int harvest = 0;
    
    public Hoe(@org.jetbrains.annotations.NotNull
    java.lang.String id, int model, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Rarity rarity, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.NotNull
    net.aradiata.item.ItemEvents events, int harvest) {
        super(null, 0, null, null, null, null);
    }
    
    public final int getHarvest() {
        return 0;
    }
    
    @java.lang.Override
    public void writeDetails(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> lore) {
    }
}