package me.landeryt.inwater;

import org.bukkit.plugin.java.JavaPlugin;

public final class InWater extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("inwater").setExecutor(new WaterCommand());

    }


}
