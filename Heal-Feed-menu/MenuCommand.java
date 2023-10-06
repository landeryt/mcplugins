package me.landeryt.inventoriesanditems.commands;

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

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("iai.menu")) {
                Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.RED + "Lander Time");
                ItemStack beefy = new ItemStack(Material.COOKED_BEEF, 16);
                ItemMeta beefyMeta = beefy.getItemMeta();
                beefyMeta.setDisplayName("Free food");
                beefy.setItemMeta(beefyMeta);
                inventory.setItem(0, beefy);

                ItemStack flower = new ItemStack(Material.CORNFLOWER);
                ItemMeta flowerMeta = flower.getItemMeta();
                flowerMeta.setDisplayName(ChatColor.AQUA + "Lander flower");
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.AQUA + "LanderYT");
                lore.add(ChatColor.RED + "loves");
                lore.add(ChatColor.GREEN + "this healing flower");
                //Lore set
                flowerMeta.setLore(lore);
                flowerMeta.addEnchant(Enchantment.MENDING, 10, true);
                flower.setItemMeta(flowerMeta);
                inventory.setItem(1, flower);

                p.openInventory(inventory);
            } else p.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command");

        }

        return true;
    }
}
