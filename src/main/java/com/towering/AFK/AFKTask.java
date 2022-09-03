package com.towering.AFK;

import com.towering.TGATrusted;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AFKTask extends BukkitRunnable{

    int countdown = 0;
    TGATrusted plugin;
    Player player;
    Location location;

    public AFKTask(TGATrusted plugin, Player player){
        this.plugin = plugin;
        this.player = player;
        this.location = player.getLocation();
    }

    @Override
    public void run() {
        countdown++;
        if (!sameLocation(location, player.getLocation())) {
        cancel();
        player.sendMessage(ChatColor.RED + "You moved! AFK is no longer warming up.");
        }
        if (countdown == 20){
            cancel();
            plugin.getAfkUsers().add(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "You're now AFK!");
        }
    }
    private boolean sameLocation (Location location1, Location location2){
        return location1.getX() == location2.getX() && location1.getY() == location2.getY() && location1.getZ() == location2.getZ();
    }
}
