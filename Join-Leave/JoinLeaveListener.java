package me.landeryt.joinleave;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.AQUA + "Howdy" + player.getDisplayName());
        } else e.setJoinMessage(ChatColor.AQUA + player.getDisplayName() + "has joined the server for the first time");
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + player.getDisplayName() + "has disconnected");
    }
}
