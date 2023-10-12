package me.landeryt.teleportbow.Ultilities;

import me.landeryt.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BowUtils {

    private final TeleportBow plugin;

    public BowUtils(TeleportBow plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBow(){
        String bowname = plugin.getConfig().getString("bow-name");
        String bowdesc = plugin.getConfig().getString("bow-description");
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        if (bowname != null && bowdesc != null) {
            bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', bowname));
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.translateAlternateColorCodes('&', bowdesc));
            bowMeta.setLore(lore);
            bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
            bow.setItemMeta(bowMeta);
        } else {
            bowMeta.setDisplayName(ChatColor.AQUA + "Teleport bow");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "Teleports you where the arrow lands");
            bowMeta.setLore(lore);
            bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
            bow.setItemMeta(bowMeta);
        }
        return bow;
    }
}
