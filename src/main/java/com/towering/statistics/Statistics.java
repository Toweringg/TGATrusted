package com.towering.statistics;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Statistics {

    public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity().getPlayer();
        int deaths = player.getStatistic(Statistic.DEATHS);
    }
}
