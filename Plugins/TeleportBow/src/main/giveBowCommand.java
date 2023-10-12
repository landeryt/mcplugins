package me.landeryt.teleportbow.Commands;

import me.landeryt.teleportbow.TeleportBow;
import me.landeryt.teleportbow.Ultilities.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveBowCommand implements CommandExecutor {
    private final TeleportBow plugin;
    private final BowUtils bowUtils;

    public giveBowCommand(TeleportBow plugin) {
        this.plugin = plugin;
        bowUtils = new BowUtils(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("tpbow.givebow")) {
                ItemStack bow = bowUtils.createBow();
                ItemStack arrow = new ItemStack(Material.ARROW, 1);
                if (args.length > 0) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        target.getInventory().addItem(bow);
                        target.getInventory().addItem(arrow);
                        target.sendMessage(ChatColor.AQUA + "You have been given a teleport bow");

                    } else {
                        p.sendMessage(ChatColor.RED + "Unknown/Offline player");
                    }
                } else {
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(arrow);
                    p.sendMessage(ChatColor.AQUA + "You have been given a teleport bow");
                }
            } else p.sendMessage(ChatColor.RED + "You cannot use this command");
        }
        return true;
    }
}
