package me.landeryt.commandarguments.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {
    // /repeat bob is really cool
    // ["bob", "is", "really", "cool"]
    //args[0] --> bob
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("commandarguments.repeat")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Unfinished command.");
                    p.sendMessage(ChatColor.RED + "/repeat <message>");
                } else if (args.length == 1){
                    String words = args[0];
                    p.sendMessage(ChatColor.GREEN + "Message: " + ChatColor.WHITE + words);
                } else {
                    StringBuilder words = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        words.append(args[i]);
                        words.append(" ");
                    }
                    String finalMessage = words.toString();
                    p.sendMessage(ChatColor.GREEN + "Message: " + ChatColor.WHITE + finalMessage);
                }
            } else p.sendMessage(ChatColor.RED + "You don't have the permission to use this command.");

        }
        return true;
    }
}
