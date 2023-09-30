package me.landeryt.permissions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class HaybaleEvent implements Listener {
    @EventHandler
    public void onHaybaleBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.HAY_BLOCK) {
            if (e.getPlayer().hasPermission("permissions.haybale")) {
                e.getPlayer().sendMessage(ChatColor.GREEN + "You can break a hay bale");
            } else {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.RED + "You can not break a hay bale");
            }
        }

    }
}
