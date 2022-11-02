package net.aradiata.script;

import java.lang.System;

@ItemDsl
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lnet/aradiata/script/AxeFile;", "Lnet/aradiata/script/ItemFile;", "Lnet/aradiata/item/Axe;", "()V", "power", "", "getPower", "()Ljava/lang/Integer;", "setPower", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "speed", "getSpeed", "setSpeed", "build", "id", "", "plugin"})
@kotlin.script.experimental.annotations.KotlinScript(fileExtension = "pickaxe.kts", compilationConfiguration = net.aradiata.script.ItemCompilationConfiguration.class)
public abstract class AxeFile extends net.aradiata.script.ItemFile<net.aradiata.item.Axe> {
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer speed;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer power;
    
    public AxeFile() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getSpeed() {
        return null;
    }
    
    public final void setSpeed(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getPower() {
        return null;
    }
    
    public final void setPower(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Axe build(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}