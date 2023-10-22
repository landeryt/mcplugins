package me.landeryt.guimenus.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Array;
import java.util.ArrayList;

public class GUIcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            Inventory gui = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Custom GUI");
            ItemStack death = new ItemStack(Material.IRON_SWORD, 1);
            ItemStack feed = new ItemStack(Material.CAKE, 1);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);

            ItemMeta deathMeta = death.getItemMeta();
            ItemMeta feedMeta = feed.getItemMeta();
            ItemMeta swordMeta = sword.getItemMeta();
            deathMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            deathMeta.setDisplayName(ChatColor.RED + "Kill yourself");
            ArrayList<String> deathLore = new ArrayList<>();
            deathLore.add(ChatColor.RED + "Die!");
            deathMeta.setLore(deathLore);
            feedMeta.setDisplayName(ChatColor.YELLOW + "Refreshments");
            feedMeta.setUnbreakable(true);
            ArrayList<String> feedLore = new ArrayList<>();
            feedLore.add(ChatColor.GREEN + "Help yourself!");
            feedMeta.setLore(feedLore);
            swordMeta.setDisplayName(ChatColor.AQUA + "Free sword!");
            swordMeta.addEnchant(Enchantment.KNOCKBACK, 2, false);
            ArrayList<String> swordLore = new ArrayList<>();
            swordLore.add(ChatColor.DARK_GREEN + "Grab it now!");
            swordMeta.setLore(swordLore);
            death.setItemMeta(deathMeta);
            feed.setItemMeta(feedMeta);
            sword.setItemMeta(swordMeta);

            ItemStack[] menuItems = {death, feed, sword};
            gui.setContents(menuItems);
            p.openInventory(gui);
        }
        return true;
    }
}
