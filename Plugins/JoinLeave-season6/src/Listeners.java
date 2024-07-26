package me.landeryt.joinleaveseason6;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (p.hasPlayedBefore()) {
            Random random = new Random();
            int choice = random.nextInt(1, 4);

            switch(choice) {
                case 1:
                    e.setJoinMessage(ChatColor.YELLOW + "A wild " + p.getDisplayName()
                            + ChatColor.YELLOW + " appeared!");
                    break;

                case 2:
                    e.setJoinMessage(p.getDisplayName() + ChatColor.YELLOW + " parachuted in, 10/10 landing!");
                    break;
                case 3:
                    e.setJoinMessage(p.getDisplayName() + ChatColor.YELLOW + " has entered the mortal plane.");
                    break;

                case 4:
                    e.setJoinMessage(p.getDisplayName() + ChatColor.YELLOW + " was dragged in by Lander.");
                    break;

                default:
                    e.setJoinMessage(p.getDisplayName() + ChatColor.YELLOW + " has joined the LanderYT SMP!");


            }
        }

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Random random = new Random();
        int choice = random.nextInt(1, 3);

        switch(choice) {
            case 1:
                e.setQuitMessage(p.getDisplayName()
                        + ChatColor.YELLOW + " is jumping out, do a flip!");
                break;

            case 2:
                e.setQuitMessage(p.getDisplayName() + ChatColor.YELLOW + " went back to reality");
                break;
            case 3:
                e.setQuitMessage(p.getDisplayName() + ChatColor.YELLOW + " has gone to touch grass.");
                break;

            default:
                e.setQuitMessage(p.getDisplayName() + ChatColor.YELLOW + " has left the server.");

        }
    }
}
