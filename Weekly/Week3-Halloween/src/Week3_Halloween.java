package me.landeryt.week3halloween;

import org.bukkit.plugin.java.JavaPlugin;

public final class Week3_Halloween extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Easy(this), this);
        getServer().getPluginManager().registerEvents(new Medium(this), this);
        getServer().getPluginManager().registerEvents(new Hard(this), this);

    }
}
