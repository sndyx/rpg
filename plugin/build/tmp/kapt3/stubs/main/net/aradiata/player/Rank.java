package net.aradiata.player;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lnet/aradiata/player/Rank;", "", "colorCode", "", "(Ljava/lang/String;IC)V", "getColorCode", "()C", "Default", "Helper", "Moderator", "Admin", "plugin"})
public enum Rank {
    /*public static final*/ Default /* = new Default('\u0000') */,
    /*public static final*/ Helper /* = new Helper('\u0000') */,
    /*public static final*/ Moderator /* = new Moderator('\u0000') */,
    /*public static final*/ Admin /* = new Admin('\u0000') */;
    private final char colorCode = '\u0000';
    
    Rank(char colorCode) {
    }
    
    public final char getColorCode() {
        return '\u0000';
    }
}