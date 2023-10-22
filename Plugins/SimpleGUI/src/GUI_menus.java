package me.landeryt.guimenus;

import me.landeryt.guimenus.commands.GUIcommand;
import me.landeryt.guimenus.events.ClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUI_menus extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gui").setExecutor(new GUIcommand());
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
    }
}
