package net.aradiata.player;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0013\u001a\u0002H\u0014\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0082\b\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J&\u0010\u001a\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u0002H\u0014H\u0082\b\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lnet/aradiata/player/PlayerData;", "", "player", "Lorg/bukkit/entity/Player;", "(Lorg/bukkit/entity/Player;)V", "folder", "Ljava/nio/file/Path;", "meta", "Lnet/aradiata/player/PlayerMeta;", "getMeta", "()Lnet/aradiata/player/PlayerMeta;", "setMeta", "(Lnet/aradiata/player/PlayerMeta;)V", "profile", "Lnet/aradiata/player/Profile;", "getProfile", "()Lnet/aradiata/player/Profile;", "setProfile", "(Lnet/aradiata/player/Profile;)V", "readJsonFromFolder", "T", "fileName", "", "(Ljava/lang/String;)Ljava/lang/Object;", "save", "", "writeJsonToFolder", "obj", "(Ljava/lang/String;Ljava/lang/Object;)V", "plugin"})
public final class PlayerData {
    private final java.nio.file.Path folder = null;
    @org.jetbrains.annotations.NotNull
    private net.aradiata.player.PlayerMeta meta;
    @org.jetbrains.annotations.NotNull
    private net.aradiata.player.Profile profile;
    
    public PlayerData(@org.jetbrains.annotations.NotNull
    org.bukkit.entity.Player player) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.player.PlayerMeta getMeta() {
        return null;
    }
    
    public final void setMeta(@org.jetbrains.annotations.NotNull
    net.aradiata.player.PlayerMeta p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.aradiata.player.Profile getProfile() {
        return null;
    }
    
    public final void setProfile(@org.jetbrains.annotations.NotNull
    net.aradiata.player.Profile p0) {
    }
    
    public final void save() {
    }
}