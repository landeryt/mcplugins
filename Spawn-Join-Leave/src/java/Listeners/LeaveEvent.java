package me.landeryt.spawnjoinleave.Listeners;

import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    private final Spawn_Join_Leave plugin;

    public LeaveEvent(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        String message = plugin.getConfig().getString("leave-message");
        Player p = e.getPlayer();
        if (message != null) {
            message = message.replace("%player%", p.getDisplayName());
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
}
