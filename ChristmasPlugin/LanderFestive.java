package me.landeryt.landerfestive;

import org.bukkit.plugin.java.JavaPlugin;

public final class LanderFestive extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("christmas").setExecutor(new ChristmasCommand());
        getServer().getPluginManager().registerEvents(new onBlockBreak(), this);
    }
}
