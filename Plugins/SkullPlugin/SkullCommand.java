package me.landeryt.skullplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            ItemStack item = p.getInventory().getItemInMainHand();
            int amount = item.getAmount();
            Material material = item.getType();
            // Check if player is holding a player skull or a mob skull (not zombie, skelly or creeper)
            if (material != null && material == Material.PLAYER_HEAD) {
                ItemStack skull = new ItemStack(Material.PLAYER_HEAD, amount);
                SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                // Gets OfflinePlayer object using p's UUID method.
                OfflinePlayer pp = Bukkit.getOfflinePlayer(p.getUniqueId());
                skullMeta.setOwningPlayer(pp);

                skull.setItemMeta(skullMeta);
                // Replacing the old skull
                p.getInventory().remove(item);
                p.getInventory().setItemInMainHand(skull);
            } else {
                p.sendMessage(ChatColor.AQUA + "You must hold a player/mob skull to use this command.");
            }
        } else sender.sendMessage("You may not execute this command");
        return true;
    }
}
