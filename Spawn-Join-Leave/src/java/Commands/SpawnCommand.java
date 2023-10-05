package me.landeryt.spawnjoinleave.Commands;

import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final Spawn_Join_Leave plugin;

    public SpawnCommand(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("sjl.spawn")) {
                Location location = plugin.getConfig().getLocation("spawn");
                if (location != null) {
                    if (args.length == 0) {
                        p.teleport(location);
                        p.sendMessage(ChatColor.GREEN + "Successfully teleported you to spawn");
                    } else if (p.hasPermission("sjl.spawn.others")){
                        String player = args[0];
                        Player target = Bukkit.getPlayerExact(player);
                        if (target != null) {
                            target.teleport(location);
                            target.sendMessage(ChatColor.DARK_GREEN + "You have been teleported to spawn");
                        } else p.sendMessage(ChatColor.DARK_RED + "Unknown/Offline player");
                    } else p.sendMessage(ChatColor.RED + "You don't have permission to use this");
                } else p.sendMessage(ChatColor.RED + "Spawn location not set");
            } else p.sendMessage(ChatColor.RED + "You don't have permission to use this command");
        }
        return true;
    }
}
