package me.landeryt.spawn;

import me.landeryt.spawn.Commands.SetSpawnCommand;
import me.landeryt.spawn.Commands.SpawnCommand;
import me.landeryt.spawn.Listeners.DeathListener;
import me.landeryt.spawn.Listeners.FirstJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {


    @Override
    public void onEnable() {
        //config.yml
        getConfig().options().copyDefaults();
        saveConfig();
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new FirstJoinListener(this), this);
    }

}
