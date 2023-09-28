package me.landeryt.joinleavedup;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class JoinLeaveClass implements Listener {
    @EventHandler
    //Join event that makes player drops diamonds, if that's held in their main hand. (Only for already joined players)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.RED + player.getDisplayName() + ChatColor.YELLOW + ", welcome back!");
            PlayerInventory inventory = player.getInventory();
            ItemStack itemstack = inventory.getItemInMainHand();
            // Turn ItemStack into Materials, before comparing.
            Material item = itemstack.getType();
            if (item.equals(Material.DIAMOND)) {
                player.dropItem(true);
            }

        } else e.setJoinMessage(ChatColor.AQUA + player.getDisplayName() + ChatColor.YELLOW + " has joined the server for the first time");
    }
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + player.getDisplayName() + " has disconnected");
    }
}
