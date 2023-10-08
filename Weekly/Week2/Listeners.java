package me.landeryt.week2;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onWalkOn (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location blockLocation = p.getLocation().clone().subtract(0,1,0);
        Material block = blockLocation.getBlock().getType();
        if (p.getGameMode() != GameMode.CREATIVE) {
            if (block == Material.POINTED_DRIPSTONE) {
                p.sendMessage(ChatColor.GREEN + "You have found an EASY task: Walk on Dripstone");
            }
        }
    }
    @EventHandler
    public void onBreedHorse (EntityBreedEvent e) {
        EntityType father = e.getFather().getType();
        EntityType mother = e.getMother().getType();
        LivingEntity livingentity = e.getBreeder();
        if (((father == EntityType.HORSE) && (mother == EntityType.DONKEY))
                | ((father == EntityType.DONKEY) && (mother == EntityType.HORSE))) {
            if (livingentity instanceof Player p) {
                if (p.getGameMode() != GameMode.CREATIVE) {
                    p.sendMessage(ChatColor.GREEN + "You have found an EASY task: Breed a mule");
                }
            }
        }
    }
    @EventHandler
    public void onCatchItem (PlayerFishEvent e) {
        Player p = e.getPlayer();
        if ((e.getState() == PlayerFishEvent.State.CAUGHT_FISH)
                & (p.getGameMode() != GameMode.CREATIVE)) {
            if (e.getCaught() != null) {
                Item item = (Item) e.getCaught();
                if (item.getItemStack().getType() == Material.BONE) {
                    p.sendMessage(ChatColor.GREEN + "You have found an EASY task: Fish a bone");
                }
            }
        }
    }
    @EventHandler
    public void onDyeSheep(SheepDyeWoolEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE
            && e.getColor() == DyeColor.LIGHT_BLUE) {
            p.sendMessage(ChatColor.GREEN + "You have found an EASY task: Dye a sheep aqua");
        }
    }
    @EventHandler
    public void onNetherBrick (FurnaceExtractEvent e) {
        Player p = e.getPlayer();
        if ((p.getGameMode() != GameMode.CREATIVE)
            & (e.getItemType() == Material.NETHER_BRICK)) {
            p.sendMessage(ChatColor.GREEN + "You have found an EASY task: Obtain nether brick from furnace");
        }
    }
}
