package me.landeryt.week2;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class InsaneListener implements Listener {
    @EventHandler
    public void onStriderFish (PlayerFishEvent e) {
        Entity entity = e.getCaught();
        Player p = e.getPlayer();
        Location location = p.getLocation();
        if (entity != null) {
            if (p.getGameMode() != GameMode.CREATIVE && entity.getType() == EntityType.STRIDER) {
                if (isWarpedForest(location.getBlock().getBiome()) && location.getBlockY() >= 90) {
                    p.sendMessage(ChatColor.DARK_PURPLE + "How did you even pull this off: " +
                            "Hook a strider while in warped forest biome, while above y90");
                }
            }
        }

    }
    private boolean isWarpedForest(Biome biome) {
        return biome == Biome.WARPED_FOREST;
    }
}
