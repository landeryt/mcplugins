package me.landeryt.skullplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SkullPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("skull").setExecutor(new SkullCommand());
    }
}
