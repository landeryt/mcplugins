package me.landeryt.flylanderyt.Commands;

import me.landeryt.flylanderyt.FlyLanderYT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private final FlyLanderYT plugin;
    private ArrayList<Player> flyList = new ArrayList<>();

    public FlyCommand(FlyLanderYT plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String onMessage = plugin.getConfig().getString("on-message");
        String offMessage = plugin.getConfig().getString("off-message");
        if (sender instanceof Player p) {
            if (p.hasPermission("flylanderyt.fly") && onMessage != null && offMessage != null) {
                if (args.length > 0 && p.hasPermission("flylanderyt.fly.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                            onMessage = onMessage.replace("%player%", target.getDisplayName());
                            offMessage = offMessage.replace("%player%", target.getDisplayName());
                        if (flyList.contains(target)) {
                            target.setAllowFlight(false);
                            flyList.remove(target);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', offMessage));
                        } else {
                            target.setAllowFlight(true);
                            flyList.add(target);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', onMessage));
                        }
                    }
                } else if (args.length > 0 && !p.hasPermission("flylanderyt.fly.others")) {
                    p.sendMessage(ChatColor.RED + "You don't have permission to use this type");
                } else {
                        onMessage = onMessage.replace("%player%", p.getDisplayName());
                        offMessage = offMessage.replace("%player%", p.getDisplayName());
                    if (flyList.contains(p)) {
                        p.setAllowFlight(false);
                        flyList.remove(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', offMessage));
                    } else {
                        flyList.add(p);
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', onMessage));
                    }
                }
            } else p.sendMessage(ChatColor.DARK_RED + "You don't have permissions to use this command");
        }
        return true;
    }
}
