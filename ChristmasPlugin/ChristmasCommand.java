package me.landeryt.landerfestive;

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
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class ChristmasCommand implements CommandExecutor {
    private final HashMap<UUID, Long> cooldown;
    public ChristmasCommand() {
        this.cooldown = new HashMap<>();
    }
    private String convert(long time) {
        long hours = time / 3600000;
        long minutes = (time % 3600000) / 60000;
        long seconds = ((time % 3600000) % 60000) / 1000;

        StringBuilder timeBuilder = new StringBuilder();
        timeBuilder.append(hours).append(" hours, ");
        timeBuilder.append(minutes).append(" minutes, ");
        timeBuilder.append(seconds).append(" seconds");

        return timeBuilder.toString();
    }
    private ItemStack gift(Player p) {
        Random random = new Random();
        int num = random.nextInt(1, 10);
        switch (num) {
            case 1:
                ItemStack item = new ItemStack(Material.DIAMOND, 3);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you wealth!");
                return item;
            case 2:
                ItemStack item2 = new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you protection!");
                return item2;
            case 3:
                ItemStack item3 = new ItemStack(Material.CAKE, 1);
                p.sendMessage(ChatColor.RED + "Happy bir- Christmas!");
                return item3;
            case 4:
                ItemStack item4 = new ItemStack(Material.GOLD_BLOCK, 8);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you.. gold?");
                return item4;
            case 5:
                ItemStack item5 = new ItemStack(Material.EMERALD_BLOCK, 8);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you villager stuff");
                return item5;
            case 6:
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
                return token;
            case 7:
                ItemStack item7 = new ItemStack(Material.SHULKER_BOX, 1);
                p.sendMessage(ChatColor.AQUA + "Merry Christmas! You found a shulker box!");
                return item7;
            case 8:
                ItemStack item8 = new ItemStack(Material.DIRT);
                p.sendMessage(ChatColor.YELLOW + "LOL");
                return item8;
            case 9:
                ItemStack item9 = new ItemStack(Material.CHERRY_WOOD, 200);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you... cherry wood?");
                return item9;
            case 10:
                ItemStack item10 = new ItemStack(Material.GOLDEN_CARROT, 64);
                p.sendMessage(ChatColor.RED + "Merry christmas! We wish you fulfilment!");
                return item10;
        }
        return new ItemStack(Material.CAKE);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (!this.cooldown.containsKey(p.getUniqueId())) {
                this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                ItemStack item = gift(p);
                p.getInventory().addItem(item);
                p.sendMessage(ChatColor.GREEN + "Happy holidays!");

            } else {
                long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());
                long placeholder = timeElapsed / 1000 / 60 / 60 / 24;
                if (placeholder >= 1) {
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                    ItemStack item = gift(p);
                    p.getInventory().addItem(item);
                    p.sendMessage(ChatColor.GREEN + "Happy holidays!");
                } else {
                    String msg = convert(86400000 - timeElapsed);
                    p.sendMessage(ChatColor.AQUA + "You need to wait " + ChatColor.RED + msg);
                }
            }
        }
        return true;
    }
}
