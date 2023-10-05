package me.landeryt.spawnjoinleave.Listeners;

import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEvent implements Listener {
    private final Spawn_Join_Leave plugin;

    public RespawnEvent(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerRespawn (PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
