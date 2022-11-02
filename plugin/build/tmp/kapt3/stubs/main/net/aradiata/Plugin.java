package net.aradiata;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lnet/aradiata/Plugin;", "Lorg/bukkit/plugin/java/JavaPlugin;", "()V", "onEnable", "", "Companion", "plugin"})
public final class Plugin extends org.bukkit.plugin.java.JavaPlugin {
    @org.jetbrains.annotations.NotNull
    public static final net.aradiata.Plugin.Companion Companion = null;
    public static net.aradiata.Plugin instance;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.coroutines.CoroutineContext coroutineContext = null;
    
    public Plugin() {
        super();
    }
    
    @java.lang.Override
    public void onEnable() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lnet/aradiata/Plugin$Companion;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "instance", "Lnet/aradiata/Plugin;", "getInstance", "()Lnet/aradiata/Plugin;", "setInstance", "(Lnet/aradiata/Plugin;)V", "plugin"})
    public static final class Companion implements kotlinx.coroutines.CoroutineScope {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final net.aradiata.Plugin getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull
        net.aradiata.Plugin p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public kotlin.coroutines.CoroutineContext getCoroutineContext() {
            return null;
        }
        
        @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
        @java.lang.Override
        @java.lang.Deprecated
        public static void getCoroutineContext$annotations() {
        }
    }
}