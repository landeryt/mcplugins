package me.landeryt.commands1;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Commands1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("die")) {
            // In java 16, you can just declare Player p inside the if statement, instead of separately down there
            if (sender instanceof Player p) {
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "You have opted to die");
            } else if (sender instanceof ConsoleCommandSender) {
                System.out.println("This command was run by the console");
            } else if (sender instanceof BlockCommandSender) {
                System.out.println("This command was run by a command block");
            }
        }
        return true;
    }
}
