package com.towering.AFK;

import com.towering.TGATrusted;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class AFKListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if (TGATrusted.getInstance().getAfkUsers().contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot do that while AFK!");
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if (TGATrusted.getInstance().getAfkUsers().contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You cannot do that while AFK!");
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {

            if (e.getEntity() instanceof Player player) {
                if (TGATrusted.getInstance().getAfkUsers().contains(player.getUniqueId()))
                e.setCancelled(true);
            }
    }
    @EventHandler
    public void onEntityTargetEvent(EntityTargetEvent e) {
            if (e.getTarget() instanceof Player player) {
                if (TGATrusted.getInstance().getAfkUsers().contains(player.getUniqueId()))
                e.setCancelled(true);
            }
    }
    @EventHandler
    public void onHungerChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player player) {
            if (TGATrusted.getInstance().getAfkUsers().contains(player.getUniqueId()))
                e.setCancelled(true);
        }
    }
}
