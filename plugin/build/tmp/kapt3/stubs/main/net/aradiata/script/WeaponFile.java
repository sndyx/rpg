package net.aradiata.script;

import java.lang.System;

@ItemDsl
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\b\u0010J\u0006\u0010\u0007\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lnet/aradiata/script/WeaponFile;", "Lnet/aradiata/script/ItemFile;", "Lnet/aradiata/item/Weapon;", "()V", "stats", "", "Lnet/aradiata/item/WeaponStat;", "suppressMeleeDamage", "", "build", "id", "", "", "builder", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "plugin"})
@kotlin.script.experimental.annotations.KotlinScript(fileExtension = "weapon.kts", compilationConfiguration = net.aradiata.script.ItemCompilationConfiguration.class)
public abstract class WeaponFile extends net.aradiata.script.ItemFile<net.aradiata.item.Weapon> {
    private boolean suppressMeleeDamage = false;
    private final java.util.List<net.aradiata.item.WeaponStat> stats = null;
    
    public WeaponFile() {
        super();
    }
    
    public final void suppressMeleeDamage() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<net.aradiata.item.WeaponStat> stats(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<net.aradiata.item.WeaponStat>, kotlin.Unit> builder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Weapon build(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}