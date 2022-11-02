package net.aradiata;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lnet/aradiata/Config;", "", "()V", "lineLength", "", "threadCount", "plugin"})
public final class Config {
    @org.jetbrains.annotations.NotNull
    public static final net.aradiata.Config INSTANCE = null;
    
    /**
     * The amount of threads the plugin will use.
     */
    public static final int threadCount = 4;
    
    /**
     * The max line length of item lore.
     */
    public static final int lineLength = 30;
    
    private Config() {
        super();
    }
}