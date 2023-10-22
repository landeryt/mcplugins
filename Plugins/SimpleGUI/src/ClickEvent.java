package me.landeryt.guimenus.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Custom GUI")) {
            switch (e.getCurrentItem().getType()) {
                case IRON_SWORD:
                    p.closeInventory();
                    p.setHealth(0);
                    p.sendMessage(ChatColor.RED + "You died!");
                    break;
                case CAKE:
                    p.closeInventory();
                    p.setFoodLevel(20);
                    p.setSaturation(10);
                    p.sendMessage(ChatColor.YELLOW + "Fed.");
                    break;
                case DIAMOND_SWORD:
                    p.closeInventory();
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
                    p.sendMessage(ChatColor.AQUA + "Swordy");
                    break;
            }
            e.setCancelled(true);
        }

    }
}
