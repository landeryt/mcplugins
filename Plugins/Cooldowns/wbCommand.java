package me.landeryt.cooldowns;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class wbCommand implements CommandExecutor {
    private final HashMap<UUID, Long> cooldown;

    public wbCommand() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (!cooldown.containsKey(p.getUniqueId())
                    || System.currentTimeMillis() - cooldown.get(p.getUniqueId()) >= 5000) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                p.sendMessage("Welcome back!");
            } else {
                p.sendMessage(ChatColor.YELLOW + "You have to wait " + ChatColor.RED
                        + (double)(5000 - (System.currentTimeMillis() - cooldown.get(p.getUniqueId())))/1000
                        + ChatColor.YELLOW + " seconds before you can do this command.");
            }
        }
        return true;
    }
}
