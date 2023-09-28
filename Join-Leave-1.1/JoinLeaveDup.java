package me.landeryt.joinleavedup;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveDup extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinLeaveClass(), this);

    }
}


