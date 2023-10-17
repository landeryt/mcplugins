package me.landeryt.givetoken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GiveTokenCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        ItemStack token = new ItemStack(Material.CLOCK, 1);
        ItemMeta tokenMeta = token.getItemMeta();
        tokenMeta.setDisplayName(ChatColor.AQUA + "Event Token");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "For the very best");
        tokenMeta.setLore(lore);
        tokenMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        tokenMeta.addEnchant(Enchantment.MENDING, 1, false);
        token.setItemMeta(tokenMeta);

        if (sender instanceof Player p) {
            if (p.hasPermission("givetoken.give")) {
                p.getInventory().addItem(token);
                p.sendMessage(ChatColor.GREEN + "Given 1 event token.");
                Bukkit.getLogger().info("Player " + p.getDisplayName()
                        + " executed the givetoken command.");
            } else p.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
        }
        return true;
    }
}
