package me.landeryt.week2;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class HardListeners implements Listener {
    private boolean isInLushCaveBiome(Player p) {
        Biome biome = p.getLocation().getBlock().getBiome();
        return biome == Biome.LUSH_CAVES;
    }

    @EventHandler
    public void onAxolotlGrab (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Material material;
        if (e.getClickedBlock() != null && isInLushCaveBiome(p) && p.getGameMode() != GameMode.CREATIVE) {
            material = e.getClickedBlock().getType();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK
                    && material == Material.AXOLOTL_BUCKET) {
                p.sendMessage(ChatColor.RED + "You have found a HARD task: " +
                        "Catch an axolotl in a lush cave");
            }
        }
    }
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player != null && entity.getType() == EntityType.ZOMBIFIED_PIGLIN) {
            if (player.getGameMode() != GameMode.CREATIVE) {
                ItemStack weapon = player.getInventory().getItemInMainHand();
                if (weapon.getType() == Material.GOLDEN_SWORD) {
                    player.sendMessage(ChatColor.RED + "You have found a HARD task: " +
                            "Kill a zombie pigman with a golden sword");
                }
            }
        }
    }
}
