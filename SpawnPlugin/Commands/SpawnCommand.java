package me.landeryt.spawn.Commands;

import me.landeryt.spawn.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final Spawn plugin;

    public SpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("spawn.spawn")) {
                Location location = plugin.getConfig().getLocation("spawn");
                if (args.length == 0) {
                    if (location != null) {
                        p.teleport(location);
                        p.sendMessage(ChatColor.AQUA + "Teleported you to spawn.");
                    } else p.sendMessage(ChatColor.RED + "No spawn location found.");
                } else {
                    String text = args[0];
                    Player target = Bukkit.getPlayerExact(text);
                    if (target != null && location != null) {
                        target.teleport(location);
                        target.sendMessage(ChatColor.RED + "You have been teleported to spawn");
                        p.sendMessage(ChatColor.AQUA + "Successfully teleported " + ChatColor.YELLOW + target.getDisplayName() + ChatColor.AQUA + " to spawn.");
                    } else p.sendMessage(ChatColor.RED + "Unknown/Offline player or unknown spawn location.");

                }


            }
        }
        return true;
    }
}
