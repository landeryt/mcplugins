package me.landeryt.spawnjoinleave;

import me.landeryt.spawnjoinleave.Commands.SetMessage;
import me.landeryt.spawnjoinleave.Commands.SetSpawnCommand;
import me.landeryt.spawnjoinleave.Commands.SpawnCommand;
import me.landeryt.spawnjoinleave.Listeners.JoinEvent;
import me.landeryt.spawnjoinleave.Listeners.RespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn_Join_Leave extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setmessage").setExecutor(new SetMessage(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);
        saveDefaultConfig();
        getConfig().options().copyDefaults();

    }

}
