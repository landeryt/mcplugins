package me.landeryt.week1;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onPlaceDarkOakLeaves (BlockPlaceEvent e) {
        Material material = e.getBlock().getType();
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            if (material == Material.DARK_OAK_LEAVES) {
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 300.0F, 1.0F);
                e.getPlayer().sendMessage(ChatColor.GREEN + "You have found the EASY hidden task!");
            }
        }
    }
    @EventHandler
    public void onHatchEgg (PlayerEggThrowEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            if (e.isHatching()) {
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 300.0F, 1.0F);
                e.getPlayer().sendMessage(ChatColor.YELLOW + "You have found the MEDIUM hidden task!");
            }
        }
    }
    @EventHandler
    public void onWardenKill (EntityDeathEvent e) {

        if (e.getEntity().getType() == EntityType.WARDEN) {
            if (e.getEntity().getKiller() != null) {
                if (e.getEntity().getKiller().getGameMode() != GameMode.CREATIVE) {
                    e.getEntity().getKiller().playSound(e.getEntity().getKiller().getLocation(), Sound.ENTITY_VILLAGER_YES, 300.0F, 1.0F);
                    Player p = e.getEntity().getKiller();
                    p.sendMessage(ChatColor.RED + "You have found the HARD hidden task");
                }
            }
        }
    }
}
