package me.landeryt.commands2;

import me.landeryt.commands2.commands.FeedCommand;
import me.landeryt.commands2.commands.GodCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Commands2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
    }

}
