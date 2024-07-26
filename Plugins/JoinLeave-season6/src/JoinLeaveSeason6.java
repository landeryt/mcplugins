package me.landeryt.joinleaveseason6;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveSeason6 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }
}
