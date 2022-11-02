package net.aradiata.script;

import java.lang.System;

@ItemDsl
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u001d\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0002\b\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lnet/aradiata/script/ArmorFile;", "Lnet/aradiata/script/ItemFile;", "Lnet/aradiata/item/Armor;", "()V", "stats", "", "Lnet/aradiata/item/ArmorStat;", "type", "Lnet/aradiata/item/ArmorType;", "getType", "()Lnet/aradiata/item/ArmorType;", "setType", "(Lnet/aradiata/item/ArmorType;)V", "build", "id", "", "", "builder", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "plugin"})
@kotlin.script.experimental.annotations.KotlinScript(fileExtension = "armor.kts", compilationConfiguration = net.aradiata.script.ItemCompilationConfiguration.class)
public final class ArmorFile extends net.aradiata.script.ItemFile<net.aradiata.item.Armor> {
    @org.jetbrains.annotations.Nullable
    private net.aradiata.item.ArmorType type;
    private final java.util.List<net.aradiata.item.ArmorStat> stats = null;
    
    public ArmorFile() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final net.aradiata.item.ArmorType getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    net.aradiata.item.ArmorType p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<net.aradiata.item.ArmorStat> stats(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<net.aradiata.item.ArmorStat>, kotlin.Unit> builder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Armor build(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}