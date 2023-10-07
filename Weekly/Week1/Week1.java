package me.landeryt.week1;

import org.bukkit.plugin.java.JavaPlugin;

public final class Week1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

}
