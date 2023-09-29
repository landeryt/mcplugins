package me.landeryt.commands2.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player p) {
            p.setFoodLevel(20);
            p.setSaturation(10);
            p.sendMessage(ChatColor.RED + "You have been fed and saturated");
        }
        return true;
    }
}
