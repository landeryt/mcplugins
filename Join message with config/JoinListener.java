package me.landeryt.configurations;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class JoinListener implements Listener {
    private final Configurations plugin;

    public JoinListener(Configurations plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        String message = plugin.getConfig().getString("join-message");
        if (message != null) {
            message = message.replace("%player%", e.getPlayer().getDisplayName());
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
        boolean feedPlayers = plugin.getConfig().getBoolean("feed-players");
        if (feedPlayers) {
            e.getPlayer().setFoodLevel(20);
            e.getPlayer().setSaturation(10);
        }
        List<String> drinks = plugin.getConfig().getStringList("drinks");
        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "Your favorite drinks are: "));
        for (String drink : drinks){
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a- " + drink));
        }
    }
}
