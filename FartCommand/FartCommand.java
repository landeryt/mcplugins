package me.landeryt.playertargetcmd.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class FartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "You farted on yourself");
                Location location = p.getLocation();
                p.getWorld().spawnEntity(location, EntityType.PIG);
                double health = p.getHealth();
                p.setHealth(health - 5);
            } else {
                String playerName = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);
                if (target == null) {
                    p.sendMessage("Unknown player.");
                } else {
                    target.sendMessage(ChatColor.AQUA + "You have been farted on!");
                    Location location = target.getLocation();
                    target.getWorld().spawnEntity(location, EntityType.PIG);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                    target.getWorld().spawnEntity(location, EntityType.FIREWORK);
                    double health = target.getHealth();
                    target.setHealth(health - 2);
                }
            }
        }
        return true;
    }
}
