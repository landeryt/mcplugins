package me.landeryt.week3halloween;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class Easy implements Listener {
    private final Week3_Halloween plugin;

    public Easy(Week3_Halloween plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSheepKill (EntityDeathEvent e) {
        if (plugin.getConfig().getBoolean("orange-sheep")) {
            Player p = e.getEntity().getKiller();
            Entity entity = e.getEntity();
            if (entity.getType() == EntityType.SHEEP) {
                Sheep sheep = (Sheep) entity;
                DyeColor color = sheep.getColor();
                if (p != null && p.getGameMode() != GameMode.CREATIVE
                        && color == DyeColor.ORANGE) {
                        p.sendMessage(ChatColor.GREEN + "You have found an EASY task: " +
                                "Kill an orange sheep. Happy Halloween!");
                        plugin.getServer().getConsoleSender().sendMessage
                                (ChatColor.GREEN + "Player " + p.getName() + " killed an orange sheep");
                }
            }
        }
    }
    @EventHandler
    public void onEatBeets (PlayerItemConsumeEvent e) {
        if (plugin.getConfig().getBoolean("eat-beets")) {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            if (p.getGameMode() != GameMode.CREATIVE && item.getType() == Material.BEETROOT) {
                p.sendMessage(ChatColor.GREEN + "You have found a EASY task: " +
                        "Eat a beetroot. Happy Halloween! (beetroot is sweet)");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.GREEN + "Player " + p.getName() + " ate a beetroot");
            }
        }
    }
    @EventHandler
    public void onWaterBottle (PlayerInteractEvent e) {
        if (plugin.getConfig().getBoolean("cauldron")) {
            Player p = e.getPlayer();
            Block block = e.getClickedBlock();
            Action action = e.getAction();
            ItemStack item = p.getInventory().getItemInMainHand();
            if (p.getGameMode() != GameMode.CREATIVE && block != null
                    && block.getType() == Material.WATER_CAULDRON
                    && action == Action.RIGHT_CLICK_BLOCK
                    && item.getType() == Material.GLASS_BOTTLE) {
                p.sendMessage(ChatColor.GREEN + "You have found an EASY task: " +
                        "Get water bottle from cauldron. Happy Halloween!");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.GREEN + "Player " + p.getName() + " got water bottle from a cauldron");
            }
        }
    }
    @EventHandler
    public void onBeingKilledByEndermite (PlayerDeathEvent e) {
        if (plugin.getConfig().getBoolean("killed-by-endermite")) {
            Player p = e.getEntity();
            if (p.getGameMode() != GameMode.CREATIVE
                    && e.getDeathMessage().equalsIgnoreCase(p.getName() + " was slain by Endermite")) {
                p.sendMessage(ChatColor.GREEN + "You have found an EASY task: " +
                        "Die to an endermite");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.GREEN + "Player " + p.getName() + " has been killed by an Endermite");
            }
        }
    }
    @EventHandler
    public void onCakeEat (PlayerInteractEvent e) {
        if (plugin.getConfig().getBoolean("eat-cake")) {
            Player p = e.getPlayer();
            Action action = e.getAction();
            Block block = e.getClickedBlock();
            if (block != null && p.getGameMode() != GameMode.CREATIVE
                    && action == Action.RIGHT_CLICK_BLOCK
                    && block.getType() == Material.CAKE
                    && p.getFoodLevel() <= 19) {
                p.sendMessage(ChatColor.GREEN + "You have found an EASY task: " +
                        "Eat a cake slice. Happy Halloween! (birthday)");
                plugin.getServer().getConsoleSender().sendMessage
                        (ChatColor.GREEN + "Player " + p.getName() + " ate a slice of cake");
            }
        }
    }
}
