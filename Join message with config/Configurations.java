package me.landeryt.configurations;

import org.bukkit.plugin.java.JavaPlugin;

public final class Configurations extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getCommand("setjoinmessage").setExecutor(new SetMessageCommand(this));
    }
}
