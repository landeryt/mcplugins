package me.landeryt.teleportbow;

import me.landeryt.teleportbow.Commands.giveBowCommand;
import me.landeryt.teleportbow.Listeners.BowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("givebow").setExecutor(new giveBowCommand(this));
        getServer().getPluginManager().registerEvents(new BowListener(this), this);
    }
}
