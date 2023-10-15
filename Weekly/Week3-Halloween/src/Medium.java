package me.landeryt.week3halloween;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;

public class Medium implements Listener {
    private final Week3_Halloween plugin;

    public Medium(Week3_Halloween plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBatKill (EntityDeathEvent e) {
        if (plugin.getConfig().getBoolean("bat-kill")) {
            Player p = e.getEntity().getKiller();
            Entity entity = e.getEntity();
            if (p != null
                    && p.getGameMode() != GameMode.CREATIVE
                    && entity.getType() == EntityType.BAT
                    && p.getInventory().getItemInMainHand().getType() == Material.CROSSBOW) {
                p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                        "Kill a bat with a crossbow");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.YELLOW + "Player " + p.getName() + " killed a bat with a crossbow");
            }
        }
    }
    @EventHandler
    public void onInvisDie(PlayerDeathEvent e) {
        if (plugin.getConfig().getBoolean("invis-death")) {
            Player p = e.getEntity();
            if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)
                    && e.getDeathMessage().equalsIgnoreCase(p.getName() + " was shot by Stray")) {
                p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                        "Die to a stray while being invisible. Happy Halloween!");
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Player " + p.getName()
                        + " died to a stray while being invisible");
            }
        }
    }
    @EventHandler
    public void onDecoration (BlockPlaceEvent e) {
        if (plugin.getConfig().getBoolean("moss-lantern")) {
            Player p = e.getPlayer();
            Block block = e.getBlock();
            Block blocky = e.getBlockAgainst();
            if (p.getGameMode() != GameMode.CREATIVE
                    && block.getType() == Material.MOSS_CARPET
                    && blocky.getType() == Material.JACK_O_LANTERN) {
                p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                        "Place a moss carpet against a jack'o lantern. Happy Halloween!");
                p.sendMessage(ChatColor.YELLOW + "I know this doesn't make any sense" +
                        " but it's not my problem lol.");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.YELLOW + "Player " + p.getName()
                                + " placed a moss carpet against a jack'o lantern");
            }
        }
    }
}
