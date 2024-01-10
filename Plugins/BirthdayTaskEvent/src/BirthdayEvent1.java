package me.landeryt.birthdayevent1;

import org.bukkit.plugin.java.JavaPlugin;

public final class BirthdayEvent1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Tasks(this), this);
        getCommand("tokens").setExecutor(new TokensCommand(this));
        getCommand("tokensreload").setExecutor(new TokensReloadCommand(this));
    }
}
