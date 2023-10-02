package me.landeryt.playertargetcmd;

import me.landeryt.playertargetcmd.commands.FartCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTargetCmd extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fart").setExecutor(new FartCommand());
    }

}
