package me.landeryt.permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player p) {

            if (p.hasPermission("permission.test")) {
                p.sendMessage(ChatColor.AQUA + "This is a test command");
            } else p.sendMessage(ChatColor.RED + "You don't have permission to do this command.");
        }
        return true;
    }
}
