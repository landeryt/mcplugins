package me.landeryt.flylanderyt;

import me.landeryt.flylanderyt.Commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyLanderYT extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
