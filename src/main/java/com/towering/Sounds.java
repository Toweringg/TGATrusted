package com.towering;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class Sounds implements Listener {

    @EventHandler
    public void onPackLoad(PlayerResourcePackStatusEvent e){
        PlayerResourcePackStatusEvent.Status packStatus = e.getStatus();

        if (packStatus == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED){
            Player player = e.getPlayer();
            player.playSound(player.getLocation(), "audio1", 1f, 1f);
        }
    }

}
