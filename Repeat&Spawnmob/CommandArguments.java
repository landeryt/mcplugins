package me.landeryt.commandarguments;

import me.landeryt.commandarguments.commands.RepeatCommand;
import me.landeryt.commandarguments.commands.SpawnmobCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandArguments extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("spawnmob").setExecutor(new SpawnmobCommand());
    }


}
