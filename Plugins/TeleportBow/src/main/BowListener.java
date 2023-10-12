package me.landeryt.teleportbow.Listeners;

import me.landeryt.teleportbow.TeleportBow;
import me.landeryt.teleportbow.Ultilities.BowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class BowListener implements Listener {
    private final TeleportBow plugin;
    private final BowUtils bowUtils;

    public BowListener(TeleportBow plugin) {
        this.plugin = plugin;
        bowUtils = new BowUtils(plugin);
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e) {
        //check which bow shot the arrow
        if (e.getEntity().getShooter() instanceof Player p) {
            ItemStack bowShot = p.getInventory().getItemInMainHand();
            if (bowShot.getItemMeta().getDisplayName()
                    .equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',
                            plugin.getConfig().getString("bow-name")))) {
                if (e.getEntity().getLocation() != null) {
                    Location location = e.getEntity().getLocation();
                    p.teleport(location);
                    p.playSound(p, Sound.ENTITY_ENDER_EYE_LAUNCH, 1.0f, 1.0f);
                    String tpmsg = plugin.getConfig().getString("teleport-message");
                    if (tpmsg != null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', tpmsg));
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("give-on-join")) {
            Player p = e.getPlayer();
            p.getInventory().addItem(bowUtils.createBow());
            ItemStack arrow = new ItemStack(Material.ARROW, 1);
            p.getInventory().addItem(arrow);
        }
    }
}
