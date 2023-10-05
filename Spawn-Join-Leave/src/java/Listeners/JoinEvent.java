package me.landeryt.spawnjoinleave.Listeners;
import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    private final Spawn_Join_Leave plugin;

    public JoinEvent(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Location location = plugin.getConfig().getLocation("spawn");
        String message = plugin.getConfig().getString("join-message");
        if (plugin.getConfig().getBoolean("feed-player-join")) {
            p.setSaturation(10);
            p.setFoodLevel(20);
        }
        if (plugin.getConfig().getBoolean("heal-player-join")) {
            p.setHealth(20);
        }
        if (message != null) {
            message = message.replace("%player%", e.getPlayer().getDisplayName());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
        if (!p.hasPlayedBefore()) {
            if (location != null) {
                p.teleport(location);
            }
        }

    }
}
