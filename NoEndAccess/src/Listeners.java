package me.landeryt.noend;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listeners implements Listener {
    private final NoEnd plugin;

    public Listeners(NoEnd plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onThrowEye (PlayerInteractEvent e) {
        Material eye = e.getMaterial();
        String message = plugin.getConfig().getString("warn-message");
        if (!plugin.getConfig().getBoolean("allowed")) {
            if (message != null) {
                message = message.replace("%player%", e.getPlayer().getDisplayName());
                if (!e.getPlayer().isOp()) {
                    if (eye == Material.ENDER_EYE) {
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlacePortal (BlockPlaceEvent e) {
        Material block = e.getBlock().getType();
        String message = plugin.getConfig().getString("warn-message");
        if (!plugin.getConfig().getBoolean("allowed")) {
            if (message != null) {
                message = message.replace("%player%", e.getPlayer().getDisplayName());
                if (!e.getPlayer().isOp()) {
                    if (block == Material.END_PORTAL_FRAME) {
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                    }
                }
            }
        }
    }
}
