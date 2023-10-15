package me.landeryt.week3halloween;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class Hard implements Listener {
    private final Week3_Halloween plugin;

    public Hard(Week3_Halloween plugin) {
        this.plugin = plugin;
    }
    private boolean atSnowySlopes(Player p) {
        Biome biome = p.getLocation().getBlock().getBiome();
        return biome == Biome.SNOWY_SLOPES;
    }
    private boolean intheNether(Player p) {
        Biome biome = p.getLocation().getBlock().getBiome();
        return biome == Biome.WARPED_FOREST || biome == Biome.NETHER_WASTES
                || biome == Biome.CRIMSON_FOREST || biome == Biome.BASALT_DELTAS
                || biome == Biome.SOUL_SAND_VALLEY;
    }
    @EventHandler
    public void onSnowmanShear (PlayerShearEntityEvent e) {
        Player p = e.getPlayer();
        Entity entity = e.getEntity();
        if (plugin.getConfig().getBoolean("snowman-shear")) {
            if (entity.getType() == EntityType.SNOWMAN) {
                Snowman snowman = (Snowman) entity;
                if (!snowman.isDerp() && p.getGameMode() != GameMode.CREATIVE
                        && atSnowySlopes(p)) {
                    p.sendMessage(ChatColor.RED + "You have found a HARD task: " +
                            "Shear a snowman on snowy slopes biome. Happy Halloween!");
                    plugin.getServer().getConsoleSender().sendMessage
                            (ChatColor.RED + "Player " + p.getName()
                                    + " sheared a snowman on a snowy slopes biome");
                }
            }
        }
    }
    @EventHandler
    public void onNetherPhantomKill (EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();
        if (plugin.getConfig().getBoolean("phantom-kill")) {
            if (p != null && p.getGameMode() != GameMode.CREATIVE
                    && entity.getType() == EntityType.PHANTOM
                    && intheNether(p)
                    && p.getInventory().getItemInMainHand().getType() == Material.CROSSBOW) {
                p.sendMessage(ChatColor.RED + "You have found a HARD task: " +
                        "Kill a phantom with a crossbow in the nether. Happy Halloween!");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "Player " + p.getName()
                                + " killed a phantom with a crossbow in the nether");
            }
        }
    }
    @EventHandler
    public void onEndermanKill (EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();

        if (plugin.getConfig().getBoolean("enderman-kill")) {
            if (p != null && p.getGameMode() != GameMode.CREATIVE
                    && p.getLocation().getBlockY() >= 179
                    && entity.getType() == EntityType.ENDERMAN
                    && p.getInventory().getItemInMainHand().getType() == Material.CARVED_PUMPKIN) {
                p.sendMessage(ChatColor.DARK_PURPLE + "You have found an INSANE task: " +
                        "Kill an enderman with a carved pumpkin while above y179. Happy Halloween!");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "Player " + p.getName()
                                + " killed an enderman with a carved pumpkin while above y179");
            }
        }
    }
}
