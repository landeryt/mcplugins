package me.landeryt.landerfestive;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class onBlockBreak implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getPlayer() != null) {
            Player p = e.getPlayer();
            if (p.getGameMode() != GameMode.SURVIVAL) return;
            Material material = e.getBlock().getType();
            if (material.equals(Material.SPRUCE_LOG) | material.equals(Material.DARK_OAK_LOG)
                    | material.equals(Material.GLASS) | material.equals(Material.PACKED_ICE)
                    | material.equals(Material.SNOW_BLOCK) | material.equals(Material.ICE)
                    | material.equals(Material.OAK_LOG) | material.equals(Material.SWEET_BERRY_BUSH)) {
                int num = reward();
                if (num % 1601 == 0) {
                    ItemStack token = new ItemStack(Material.CLOCK, 1);
                    ItemMeta tokenMeta = token.getItemMeta();
                    tokenMeta.setDisplayName(ChatColor.AQUA + "Event Token");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.DARK_PURPLE + "For the very best");
                    tokenMeta.setLore(lore);
                    tokenMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
                    tokenMeta.addEnchant(Enchantment.MENDING, 1, false);
                    token.setItemMeta(tokenMeta);
                    p.sendMessage(ChatColor.AQUA + "Merry Christmas! You found an event token!");
                    p.getInventory().addItem(token);
                } else if (num % 191 == 0) {
                    p.giveExp(1);
                }
            }
        }
    }
    private int reward() {
        Random random = new Random();
        return random.nextInt(1, 10000);
    }
}
