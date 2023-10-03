package me.landeryt.spawn.Listeners;

import me.landeryt.spawn.Spawn;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListener implements Listener {
    private final Spawn plugin;

    public FirstJoinListener(Spawn plugin) {
        this.plugin = plugin;
    }
    public void onPlayerJoin (PlayerJoinEvent e) {
        Location location = plugin.getConfig().getLocation("spawn");
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            if (location != null) p.teleport(location);
        }
    }
}
