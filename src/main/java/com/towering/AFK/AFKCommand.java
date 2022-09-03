package com.towering.AFK;

import com.towering.TGATrusted;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKCommand implements CommandExecutor {




    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (label.equalsIgnoreCase("afk")){
            if (sender instanceof Player player) {
                if (!TGATrusted.getInstance().getAfkUsers().contains(player.getUniqueId())) {
                    player.sendMessage(ChatColor.YELLOW + "AFK Mode will activate in 10 seconds, do not move!");
                    new AFKTask(TGATrusted.getInstance(), player).runTaskTimer(TGATrusted.getInstance(), 0, 10L);
                    return true;

                }
                TGATrusted.getInstance().getAfkUsers().remove(player.getUniqueId());
                player.sendMessage(ChatColor.RED + "You are no longer AFK!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "This command cannot be run through console.");
            }
        }
        return false;
    }
}
