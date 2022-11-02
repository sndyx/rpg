package net.aradiata.script;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010#J\u001f\u0010\u000b\u001a\u00020$2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$0&\u00a2\u0006\u0002\b\'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lnet/aradiata/script/ItemFile;", "T", "Lnet/aradiata/item/Item;", "Ljava/io/Serializable;", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "events", "Lnet/aradiata/item/ItemEvents;", "getEvents", "()Lnet/aradiata/item/ItemEvents;", "setEvents", "(Lnet/aradiata/item/ItemEvents;)V", "model", "", "getModel", "()Ljava/lang/Integer;", "setModel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "rarity", "Lnet/aradiata/item/Rarity;", "getRarity", "()Lnet/aradiata/item/Rarity;", "setRarity", "(Lnet/aradiata/item/Rarity;)V", "build", "id", "(Ljava/lang/String;)Lnet/aradiata/item/Item;", "", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "plugin"})
public abstract class ItemFile<T extends net.aradiata.item.Item> implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer model;
    @org.jetbrains.annotations.Nullable
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    private net.aradiata.item.Rarity rarity;
    @org.jetbrains.annotations.Nullable
    private java.lang.String description;
    @org.jetbrains.annotations.NotNull
    private net.aradiata.item.ItemEvents events;
    
    public ItemFile() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getModel() {
        return null;
    }
    
    public final void setModel(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final net.aradiata.item.Rarity getRarity() {
        return null;
    }
    
    public final void setRarity(@org.jetbrains.annotations.Nullable
    net.aradiata.item.Rarity p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.item.ItemEvents getEvents() {
        return null;
    }
    
    public final void setEvents(@org.jetbrains.annotations.NotNull
    net.aradiata.item.ItemEvents p0) {
    }
    
    public final void events(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super net.aradiata.item.ItemEvents, kotlin.Unit> builder) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract T build(@org.jetbrains.annotations.NotNull
    java.lang.String id);
}