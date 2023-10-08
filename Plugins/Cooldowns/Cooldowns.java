package me.landeryt.cooldowns;

import org.bukkit.plugin.java.JavaPlugin;

public final class Cooldowns extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("wb").setExecutor(new wbCommand());

    }
}
