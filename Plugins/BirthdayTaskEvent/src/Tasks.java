package me.landeryt.birthdayevent1;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;


public class Tasks implements Listener {
    private final BirthdayEvent1 plugin;

    private boolean tokenCheck(Player p, int weight) {
        int num = plugin.getConfig().getInt("tokens." + p.getUniqueId(), 0);
        if (num + weight <= 6) {
            plugin.getConfig().set("tokens." + p.getUniqueId(), num + weight);
            plugin.saveConfig();
            return true;
        } else {
            return false;
        }
    }

    private void output(Player p, String task) {
        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);
        p.giveExp(100);
        plugin.getLogger().info(task + " disabled!");
        plugin.getConfig().set(task, false);
        plugin.saveConfig();
    }

    public boolean check(String config, Player p) {
        boolean a = plugin.getConfig().getBoolean(config);
        return p.getGameMode() != GameMode.SURVIVAL || !a;
    }

    Tasks(BirthdayEvent1 plugin) {
        this.plugin = plugin;
    }

    // TODO Easy
    @EventHandler
    public void onCakeJump(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (check("cakeJump", p)) return;

        double currentY = e.getTo().getY();
        double previousY = e.getFrom().getY();
        double currentX = e.getTo().getX();
        double previousX = e.getFrom().getX();
        double currentZ = e.getTo().getZ();
        double previousZ = e.getFrom().getZ();
        Block block = e.getFrom().getBlock();
        if (currentX == previousX && currentZ == previousZ && currentY > previousY
                && block.getType() == Material.CAKE) {
            if (tokenCheck(p, 1)) {
                output(p, "cakeJump");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                        + " has completed the EASY task: Jump on a cake!");
                p.sendMessage(ChatColor.GREEN + "Congrats! You have completed an easy task, jump on a cake");
            }
        }
    }

    @EventHandler
    public void onCopperWax(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (check("copperWax", p)) return;

        Block block = e.getClickedBlock();
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || block == null) return;

        Material item = e.getMaterial();
        if (item == Material.HONEYCOMB && block.getType() == Material.EXPOSED_COPPER) {
            if (tokenCheck(p, 1)) {
                output(p, "copperWax");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                        + " has completed the EASY task: Wax exposed copper!");
                p.sendMessage(ChatColor.GREEN + "Congrats! You have completed an easy task, wax exposed copper!");
            }
        }
    }

    // Hard
    @EventHandler
    public void onUnhinged(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (check("unhinged", p)) return;

        String message = e.getMessage();
        if (message.contains("unhinged")) {
            if (tokenCheck(p, 3)) {
                output(p, "unhinged");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Chat something that has the word 'unhinged'");
                p.sendMessage(ChatColor.RED + "Congrats! You have completed a hard task, " +
                        "Chat something that has the word 'unhinged'");
            }
        }
    }

    @EventHandler
    public void onCandlePlace(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (check("candlePlace", p)) return;

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();
            if (block == null) return;
            Material item = e.getMaterial();
            if (item == Material.LIGHT_BLUE_CANDLE && block.getType() == Material.CAKE) {
                if (tokenCheck(p, 1)) {
                    output(p, "candlePlace");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                            + " has completed the EASY task: Place a light blue candle on a cake");
                }
            }
        }
    }

    @EventHandler
    public void onBedSleep(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        if (check("bedSleep", p)) return;

        Block bed = e.getBed();
        if (bed.getType() == Material.LIGHT_BLUE_BED) {
            if (tokenCheck(p, 1)) {
                output(p, "bedSleep");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                        + " has completed the EASY task: Sleep on a light blue bed.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onCornflowerBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (check("cornflowerBreak", p)) return;

        if (p == null) return;
        Biome biome = p.getLocation().getBlock().getBiome();
        if (e.getBlock().getType().equals(Material.CORNFLOWER) && biome.equals(Biome.FLOWER_FOREST)) {
            if (tokenCheck(p, 2)) {
                output(p, "cornflowerBreak");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Break a cornflower in a flower forest.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onArmorBreak(PlayerItemBreakEvent e) {
        Player p = e.getPlayer();
        if (check("armorBreak", p)) return;

        ItemStack item = e.getBrokenItem();

        if (item.getType().equals(Material.CHAINMAIL_LEGGINGS)) {
            if (tokenCheck(p, 2)) {
                output(p, "armorBreak");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Break chainmail leggings");
            }
        }
    }


    // Medium
    @EventHandler
    public void onWolfDye(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (check("wolfDye", p)) return;

        if (e.getRightClicked() instanceof Wolf) {
            if (p.getInventory().getItemInMainHand().getType().equals(Material.LIGHT_BLUE_DYE)) {
                if (tokenCheck(p, 2)) {
                    output(p, "wolfDye");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                            + " has completed the MEDIUM task: Dye a wolf collar light blue.");
                }
            }
        }
    }

    // Easy
    @EventHandler
    public void onPotatoCampfire(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (check("potatoCampfire", p)) return;

        Block block = e.getClickedBlock();
        Material item = e.getMaterial();
        if (block == null || item != Material.POTATO || e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (block.getType().equals(Material.CAMPFIRE) || block.getType().equals(Material.SOUL_CAMPFIRE)) {
            if (tokenCheck(p, 1)) {
                output(p, "potatoCampfire");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                        + " has completed the EASY task: Cook potato on a campfire.");
            }
        }
    }

    // Easy
    @EventHandler
    public void onNautilusCatch(PlayerFishEvent e) {
        Player p = e.getPlayer();
        if (check("nautilusCatch", p)) return;

        if (e.getCaught() != null && e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Item item = (Item) e.getCaught();
            if (item.getItemStack().getType() == Material.NAUTILUS_SHELL) {
                if (tokenCheck(p, 1)) {
                    output(p, "nautilusCatch");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                            + " has completed the EASY task: Catch a nautilus shell from fishing.");
                }
            }
        }
    }

    // Medium
    @EventHandler
    public void onFireworkDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (check("fireworkDeath", p) || p.getLastDamageCause() == null
                || e.getDeathMessage() == null) return;

        if (p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION
                && (e.getDeathMessage().contains("Firework") || e.getDeathMessage().contains("firework")
                || e.getDeathMessage().contains("bang"))) {
            if (tokenCheck(p, 2)) {
                output(p, "fireworkDeath");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Die to a firework.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onGoatHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player p && e.getDamager() instanceof Goat) {
            if (check("goatHit", p)) return;
            if (tokenCheck(p, 2)) {
                output(p, "goatHit");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Get hit by a goat.");
            }
        }
    }

    // Easy
    @EventHandler
    public void onSnowDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (check("snowDeath", p)) return;
        String message = e.getDeathMessage();
        if (message != null && message.contains("froze")) {
            if (tokenCheck(p, 1)) {
                output(p, "snowDeath");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                        + " has completed the EASY task: Die to frostbite.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onInvisDoor(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (check("invisDoor", p)) return;
        Material door = e.getBlock().getType();
        if (p.isInvisible() && (door == Material.OAK_DOOR
                || door == Material.BIRCH_DOOR || door == Material.SPRUCE_DOOR
                || door == Material.DARK_OAK_DOOR || door == Material.ACACIA_DOOR
                || door == Material.JUNGLE_DOOR || door == Material.CHERRY_DOOR
                || door == Material.MANGROVE_DOOR || door == Material.CRIMSON_DOOR
                || door == Material.WARPED_DOOR || door == Material.BAMBOO_DOOR)) {
            if (tokenCheck(p, 3)) {
                output(p, "invisDoor");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Break a door whilst invisible!");
            }
        }
    }

    // Medium
    @EventHandler
    public void onWitchDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (check("witchDeath", p)) return;
        String message = e.getDeathMessage();
        if (message == null) return;
        if (message.contains("Witch")) {
            if (tokenCheck(p, 2)) {
                output(p, "witchDeath");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Die to a witch.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onFurnanceSavannah(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (check("furnaceSavannah", p)) return;
        Material block = e.getBlock().getType();
        Biome biome = p.getLocation().getBlock().getBiome();
        if ((block.equals(Material.FURNACE) || block.equals(Material.SMOKER)
                || block.equals(Material.BLAST_FURNACE)) && (biome.equals(Biome.SAVANNA))
                || biome.equals(Biome.SAVANNA_PLATEAU) || biome.equals(Biome.WINDSWEPT_SAVANNA)) {
            if (tokenCheck(p, 2)) {
                output(p, "furnaceSavannah");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Place a furnace in a savannah.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onGoldBadlands(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (check("goldBadlands", p)) return;
        Material block = e.getBlock().getType();
        Biome biome = p.getLocation().getBlock().getBiome();
        if (block.equals(Material.GOLD_BLOCK) && (biome.equals(Biome.BADLANDS)
                || biome.equals(Biome.ERODED_BADLANDS) || biome.equals(Biome.WOODED_BADLANDS))) {
            if (tokenCheck(p, 3)) {
                output(p, "goldBadlands");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Mine a gold block in badlands biome.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onNotchEat(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (check("notchEat", p)) return;
        Material item = e.getItem().getType();
        if (item.equals(Material.ENCHANTED_GOLDEN_APPLE)) {
            if (tokenCheck(p, 3)) {
                output(p, "notchEat");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Eat a notch apple.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onMyceliumPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (check("myceliumPlace", p)) return;
        Material block = e.getBlock().getType();
        if (block.equals(Material.MYCELIUM)) {
            if (tokenCheck(p, 2)) {
                output(p, "myceliumPlace");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Place a mycelium block.");
            }
        }
    }

    // Easy
    @EventHandler
    public void onEndermanDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Enderman && e.getEntity().getKiller() != null) {
            Player p = e.getEntity().getKiller();
            if (!check("endermanKill", p)) {
                if (tokenCheck(p, 1)) {
                    output(p, "endermanKill");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GREEN
                            + " has completed the EASY task: Kill an enderman.");
                }
            }
        }
    }

    // Medium
    @EventHandler
    public void onSilkGlass(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (check("silkGlass", p)) return;
        Material block = e.getBlock().getType();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.containsEnchantment(Enchantment.SILK_TOUCH) && (block.toString().contains("GLASS"))
                && block != Material.TINTED_GLASS) {
            if (tokenCheck(p, 2)) {
                output(p, "silkGlass");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Break glass with silk touch.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onNetheriteBlock(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (check("netheriteBlock", p)) return;
        Material block = e.getBlock().getType();
        if (block.equals(Material.NETHERITE_BLOCK)) {
            if (tokenCheck(p, 3)) {
                output(p, "netheriteBlock");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Place a netherite block.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onVietnam(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (check("vietnam", p)) return;
        String message = e.getMessage();
        if (message.contains("Vietnam") || message.contains("vietnam")) {
            if (tokenCheck(p, 3)) {
                output(p, "vietnam");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Chat something that has 'Vietnam'");
            }
        }
    }

    // Medium
    @EventHandler
    public void onTerracottaGrab(FurnaceExtractEvent e) {
        Player p = e.getPlayer();
        if (check("terracottaGrab", p)) return;
        Material item = e.getItemType();
        if (item.equals(Material.TERRACOTTA)) {
            if (tokenCheck(p, 2)) {
                output(p, "terracottaGrab");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Extract terracotta from a furnace.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onStalaciteDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (check("stalaciteDeath", p)) return;
        String message = e.getDeathMessage();
        if (message == null || p.getEquipment() == null
                || p.getEquipment().getHelmet() == null) return;
        if (message.contains("skewered")
                && p.getEquipment().getHelmet().getType() == Material.DIAMOND_HELMET) {
            if (tokenCheck(p, 3)) {
                output(p, "stalaciteDeath");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Die to a falling stalacite while" +
                        " wearing a diamond helmet.");
            }
        }
    }

    // Hard
    @EventHandler
    public void onSnowmanKill(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null && e.getEntity() instanceof Snowman) {
            Player p = e.getEntity().getKiller();
            if (p == null || check("snowmanKill", p)) return;
            Biome biome = p.getLocation().getBlock().getBiome();
            if (biome.equals(Biome.DESERT)) {
                if (tokenCheck(p, 3)) {
                    output(p, "snowmanKill");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                            + " has completed the HARD task: Kill a snowman on a desert");
                }
            }
        }
    }

    // Hard
    @EventHandler
    public void onLuckBarrel(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (check("luckBarrel", p) || e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = e.getClickedBlock();
        if (block == null) return;
        if (p.hasPotionEffect(PotionEffectType.LUCK) && block.getType().equals(Material.BARREL)) {
            if (tokenCheck(p, 3)) {
                output(p, "luckBarrel");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.RED
                        + " has completed the HARD task: Open a barrel/fishing crate while" +
                        " having the luck effect.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onStoneShovel(PlayerFishEvent e) {
        Player p = e.getPlayer();
        if (check("stoneShovel", p)) return;
        if (e.getCaught() != null && e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Item item = (Item) e.getCaught();
            if (item.getItemStack().getType() == Material.STONE_SHOVEL) {
                if (tokenCheck(p, 2)) {
                    output(p, "stoneShovel");
                    Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                            + " has completed the MEDIUM task: Catch a stone shovel from fishing.");
                }
            }
        }
    }

    // Medium
    @EventHandler
    public void onEnderchestBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (check("enderchestBreak", p)) return;
        Material block = e.getBlock().getType();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (block.equals(Material.ENDER_CHEST) && item != null && !item.containsEnchantment(Enchantment.SILK_TOUCH)) {
            if (tokenCheck(p, 2)) {
                output(p, "enderchestBreak");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Break an e-chest without silk touch.");
            }
        }
    }

    // Medium
    @EventHandler
    public void onChorusFruit(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (check("chorusFruit", p)) return;
        Material food = e.getItem().getType();
        if (food.equals(Material.CHORUS_FRUIT)) {
            if (tokenCheck(p, 2)) {
                output(p, "chorusFruit");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Eat a chorus fruit!");
            }
        }
    }

    // Medium
    @EventHandler
    public void onPurpur(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (check("purpur", p)) return;
        Material block = e.getBlock().getType();
        if (block.equals(Material.PURPUR_BLOCK)) {
            if (tokenCheck(p, 2)) {
                output(p, "purpur");
                Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.YELLOW
                        + " has completed the MEDIUM task: Place a purpur block.");
            }
        }
    }
}
