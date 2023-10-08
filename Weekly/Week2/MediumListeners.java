package me.landeryt.week2;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;


public class MediumListeners implements Listener {
    @EventHandler
    public void onFreezeDeath (PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getGameMode() != GameMode.CREATIVE && p.getLastDamageCause().getCause()
                == EntityDamageEvent.DamageCause.FREEZE) {
            p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                    "Die to frostbite");
        }
    }
    @EventHandler
    public void onStriderDamage (EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player p) {
            if (p.getGameMode() != GameMode.CREATIVE
                    && e.getEntityType() == EntityType.STRIDER) {
                p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                        "Damage a strider");
            }
        }
    }
    @EventHandler
    public void onTargetBlock (ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();
            if (arrow.getShooter() instanceof Player p) {
                if (p.getGameMode() != GameMode.CREATIVE) {
                    if (e.getHitBlock() != null
                            && e.getHitBlock().getType() == Material.TARGET) {
                        p.sendMessage(ChatColor.YELLOW + "You have found a MEDIUM task: " +
                                "Hit a target block with an arrow");
                    }
                }
            }
        }
    }
}
