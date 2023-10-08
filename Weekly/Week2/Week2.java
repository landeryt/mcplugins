package me.landeryt.week2;

import org.bukkit.plugin.java.JavaPlugin;

public final class Week2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getServer().getPluginManager().registerEvents(new MediumListeners(), this);
        getServer().getPluginManager().registerEvents(new HardListeners(), this);
        getServer().getPluginManager().registerEvents(new InsaneListener(), this);
    }


}
