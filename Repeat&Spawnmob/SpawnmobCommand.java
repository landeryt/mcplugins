package me.landeryt.commandarguments.commands;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.loot.LootTable;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;
import java.util.function.Predicate;

public class SpawnmobCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("commandarguments.spawnmob")) {
                Location location = p.getLocation();
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Insufficient command arguments.");
                    p.sendMessage("/spawnmob <mob> (basic animals only)");
                } else {
                    String mob = args[0].toLowerCase();
                    switch (mob) {
                        case "allay":
                            p.getWorld().spawnEntity(location, EntityType.ALLAY);
                            break;
                        case "axolotl":
                            p.getWorld().spawnEntity(location, EntityType.AXOLOTL);
                            break;
                        case "bat":
                            p.getWorld().spawnEntity(location, EntityType.BAT);
                            break;
                        case "camel":
                            p.getWorld().spawnEntity(location, EntityType.CAMEL);
                            break;
                        case "cat":
                            p.getWorld().spawnEntity(location, EntityType.CAT);
                            break;
                        case "chicken":
                            p.getWorld().spawnEntity(location, EntityType.CHICKEN);
                            break;
                        case "cod":
                            p.getWorld().spawnEntity(location, EntityType.COD);
                            break;
                        case "cow":
                            p.getWorld().spawnEntity(location, EntityType.COW);
                            break;
                        case "donkey":
                            p.getWorld().spawnEntity(location, EntityType.DONKEY);
                            break;
                        case "fox":
                            p.getWorld().spawnEntity(location, EntityType.FOX);
                            break;
                        case "frog":
                            p.getWorld().spawnEntity(location, EntityType.FROG);
                            break;
                        case "glowsquid":
                        case "glow_squid":
                            p.getWorld().spawnEntity(location, EntityType.GLOW_SQUID);
                            break;
                        case "horse":
                            p.getWorld().spawnEntity(location, EntityType.HORSE);
                            break;
                        case "mooshroom":
                            p.getWorld().spawnEntity(location, EntityType.MUSHROOM_COW);
                            break;
                        case "mule":
                            p.getWorld().spawnEntity(location, EntityType.MULE);
                            break;
                        case "ocelot":
                            p.getWorld().spawnEntity(location, EntityType.OCELOT);
                            break;
                        case "parrot":
                            p.getWorld().spawnEntity(location, EntityType.PARROT);
                            break;
                        case "pig":
                            p.getWorld().spawnEntity(location, EntityType.PIG);
                            break;
                        case "pufferfish":
                            p.getWorld().spawnEntity(location, EntityType.PUFFERFISH);
                            break;
                        case "rabbit":
                            p.getWorld().spawnEntity(location, EntityType.RABBIT);
                            break;
                        case "salmon":
                            p.getWorld().spawnEntity(location, EntityType.SALMON);
                            break;
                        case "sheep":
                            p.getWorld().spawnEntity(location, EntityType.SHEEP);
                            break;
                        case "skeletonhorse":
                        case "skeleton_horse":
                            p.getWorld().spawnEntity(location, EntityType.SKELETON_HORSE);
                            break;
                        case "sniffer":
                            p.getWorld().spawnEntity(location, EntityType.SNIFFER);
                            break;
                        case "squid":
                            p.getWorld().spawnEntity(location, EntityType.SQUID);
                            break;
                        case "strider":
                            p.getWorld().spawnEntity(location, EntityType.STRIDER);
                            break;
                        case "tadpole":
                        case "tad_pole":
                            p.getWorld().spawnEntity(location, EntityType.TADPOLE);
                            break;
                        case "tropicalfish":
                        case "tropical_fish":
                            p.getWorld().spawnEntity(location, EntityType.TROPICAL_FISH);
                            break;
                        case "turtle":
                            p.getWorld().spawnEntity(location, EntityType.TURTLE);
                            break;
                        case "villager":
                            p.getWorld().spawnEntity(location, EntityType.VILLAGER);
                            break;
                        case "wanderingtrader":
                        case "wandering_trader":
                            p.getWorld().spawnEntity(location, EntityType.WANDERING_TRADER);
                            break;
                        case "zombiehorse":
                        case "zombie_horse":
                            p.getWorld().spawnEntity(location, EntityType.ZOMBIE_HORSE);
                            break;
                        default:
                            p.sendMessage(ChatColor.RED + "Unknown entity.");

                    }
                }
            }
        }
        return true;
    }
}
