package me.landeryt.joinleave;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Join_LeavePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }

}