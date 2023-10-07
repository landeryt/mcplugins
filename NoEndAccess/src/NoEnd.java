package me.landeryt.noend;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoEnd extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Listeners(this), this);
    }


}
