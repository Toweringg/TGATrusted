package com.towering;

import com.towering.AFK.AFKCommand;
import com.towering.AFK.AFKListener;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class TGATrusted extends JavaPlugin implements Listener {

    @Getter
    private static TGATrusted instance;

    @Getter
    private Set<UUID> afkUsers = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("TGATrusted has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Coordinate(), this);
        getServer().getPluginManager().registerEvents(new Sounds(), this);
        getServer().getPluginManager().registerEvents(new AFKListener(), this);
        getCommand("afk").setExecutor(new AFKCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("TGATrusted has been disabled.");
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().setResourcePack("");
    }
}
