package me.landeryt.spawn.Commands;

import me.landeryt.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private final Spawn plugin;

    public SetSpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p ) {
            if (p.hasPermission("spawn.setspawn")) {
                Location location = p.getLocation();
                // 1 - save each value of the location (x,y,z, world name)
            /* plugin.getConfig().set("spawn.x", location.getX());
            plugin.getConfig().set("spawn.y", location.getY());
            plugin.getConfig().set("spawn.z", location.getZ());
            plugin.getConfig().set("spawn.worldname", location.getWorld().getName()); */
                // 2 - save the location object directly
                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                p.sendMessage(ChatColor.GREEN + "Spawn location has been set");
            } else p.sendMessage(ChatColor.RED + "You may not use this command");
        }
        return true;
    }
}
