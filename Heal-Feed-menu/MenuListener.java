package me.landeryt.inventoriesanditems.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Lander Time")) {
           if (e.getCurrentItem() == null) {
               return;
           }
           if (e.getCurrentItem().getType().equals(Material.CORNFLOWER)) {
               e.getWhoClicked().sendMessage(ChatColor.AQUA + "You clicked on Lander's flower");
               e.getWhoClicked().sendMessage(ChatColor.AQUA + "Enjoy some healing!");
               e.getWhoClicked().setHealth(20);
           } else if (e.getCurrentItem().getType().equals(Material.COOKED_BEEF)) {
               e.getWhoClicked().setFoodLevel(20);
               e.getWhoClicked().setSaturation(5);
               e.getWhoClicked().sendMessage(ChatColor.YELLOW + "You have been fed");
           }
            e.setCancelled(true);
            e.getWhoClicked().closeInventory();
        }

    }
}
