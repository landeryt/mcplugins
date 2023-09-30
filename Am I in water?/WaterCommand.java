package me.landeryt.inwater;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WaterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player p) {
            Location l = p.getLocation();
            Block block = l.getBlock();
            if (block.getType() == Material.WATER) {
                p.sendMessage(ChatColor.AQUA + "You are in water.");
            } else p.sendMessage(ChatColor.YELLOW + "You are not in water.");
        }
        return true;
    }
}
