package me.landeryt.givetoken;

import org.bukkit.plugin.java.JavaPlugin;

public final class Givetoken extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("givetoken").setExecutor(new GiveTokenCommand());
    }
}
