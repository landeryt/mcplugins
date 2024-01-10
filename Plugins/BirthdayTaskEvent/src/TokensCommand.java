package me.landeryt.birthdayevent1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class TokensCommand implements CommandExecutor {
    private final BirthdayEvent1 plugin;

    public TokensCommand(BirthdayEvent1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                int num = plugin.getConfig().getInt("tokens." + p.getUniqueId(), 0);
                if (num == 0) {
                    p.sendMessage(ChatColor.GREEN + "You have yet to earn any tokens!");
                } else {
                    p.sendMessage(ChatColor.GREEN + "Your tokens: " + ChatColor.YELLOW + num);
                }
                p.sendMessage(ChatColor.RED + "Token limit: 6");
            }
//            else {
//                if (p.hasPermission("tokens.others")) {
//                    String name = args[0];
//                    ConfigurationSection tokens = plugin.getConfig().getConfigurationSection("tokens");
//                    if (tokens == null) {
//                        plugin.getLogger().info("Config section null for /tokens");
//                        return true;
//                    }
//                    tokens.getKeys(false).forEach(uuid_s -> {
//                        // Code to run per UUID
//                        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);
//                    });
//                }
//            }
        }
        return true;
    }
}
