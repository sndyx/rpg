package net.aradiata.player;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lnet/aradiata/player/PlayerManager;", "Lorg/bukkit/event/Listener;", "()V", "players", "", "Lnet/aradiata/player/PlayerHandle;", "getPlayers", "()Ljava/util/List;", "onJoin", "", "event", "Lorg/bukkit/event/player/PlayerJoinEvent;", "onQuit", "Lorg/bukkit/event/player/PlayerQuitEvent;", "plugin"})
public final class PlayerManager implements org.bukkit.event.Listener {
    @org.jetbrains.annotations.NotNull
    public static final net.aradiata.player.PlayerManager INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<net.aradiata.player.PlayerHandle> players = null;
    
    private PlayerManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<net.aradiata.player.PlayerHandle> getPlayers() {
        return null;
    }
    
    public final void onJoin(@org.jetbrains.annotations.NotNull
    org.bukkit.event.player.PlayerJoinEvent event) {
    }
    
    public final void onQuit(@org.jetbrains.annotations.NotNull
    org.bukkit.event.player.PlayerQuitEvent event) {
    }
}