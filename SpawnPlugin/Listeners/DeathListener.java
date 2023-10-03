package me.landeryt.spawn.Listeners;

import me.landeryt.spawn.Spawn;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {
    private final Spawn plugin;

    public DeathListener(Spawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
