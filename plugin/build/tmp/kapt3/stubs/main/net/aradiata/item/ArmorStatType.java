package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lnet/aradiata/item/ArmorStatType;", "", "isPrimary", "", "displayName", "", "(Ljava/lang/String;IZLjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "()Z", "Melee", "Magic", "Ranged", "Health", "Mana", "Speed", "AttackSpeed", "plugin"})
public enum ArmorStatType {
    /*public static final*/ Melee /* = new Melee(false, null) */,
    /*public static final*/ Magic /* = new Magic(false, null) */,
    /*public static final*/ Ranged /* = new Ranged(false, null) */,
    /*public static final*/ Health /* = new Health(false, null) */,
    /*public static final*/ Mana /* = new Mana(false, null) */,
    /*public static final*/ Speed /* = new Speed(false, null) */,
    /*public static final*/ AttackSpeed /* = new AttackSpeed(false, null) */;
    private final boolean isPrimary = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    
    ArmorStatType(boolean isPrimary, java.lang.String displayName) {
    }
    
    public final boolean isPrimary() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
}