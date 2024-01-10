package me.landeryt.birthdayevent1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokensReloadCommand implements CommandExecutor {
    private final BirthdayEvent1 plugin;

    public TokensReloadCommand(BirthdayEvent1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("tokens.reload")) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Tokens config reloaded!");
                plugin.getLogger().info("Tokens config reloaded!");
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            }
        } else {
            plugin.reloadConfig();
            plugin.getLogger().info("Tokens config reloaded!");
        }

        return true;
    }
}
