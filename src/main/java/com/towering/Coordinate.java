package com.towering;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Coordinate implements Listener {

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e){

        String message = e.getMessage();

        if (message.contains("[c]")){
            String player = e.getPlayer().getName();
            Player name = Bukkit.getPlayer(player);
            Location location = null;
            if (name != null) {
                location = name.getLocation();
            }
            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();
            String world = location.getWorld().toString();
            String formattedWorld;
            if (world.equals("CraftWorld{name=world}")) {
                formattedWorld = "Overworld";
            }else if (world.equals("CraftWorld{name=world_nether}")){
                formattedWorld = "Nether";
            }else {
                formattedWorld = "End";
            }
            String formattedMessage = "&f&l<<&r&b" + formattedWorld + " X: " + Math.round(x) + " Y: " + Math.round(y) + " Z: " + Math.round(z) + "&f&l>>&r";
            String newMessage = (ChatColor.translateAlternateColorCodes('&', formattedMessage));
            message = message.replace("[c]", ""+newMessage);
            e.setMessage(message);
        }

    }
}