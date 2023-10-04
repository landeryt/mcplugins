package me.landeryt.configurations;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessageCommand implements CommandExecutor {
    private final Configurations plugin;

    public SetMessageCommand(Configurations plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p){
            if (args.length > 0) {
                StringBuilder message = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    message.append(args[i]);
                }
                plugin.getConfig().set("join-message", message.toString());
                plugin.saveConfig();
                p.sendMessage(ChatColor.GREEN + "Join message set!");
            } else p.sendMessage(ChatColor.YELLOW + "You have to add a join message.");
        }
        return true;
    }
}
