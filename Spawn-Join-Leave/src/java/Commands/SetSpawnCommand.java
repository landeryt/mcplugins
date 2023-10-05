package me.landeryt.spawnjoinleave.Commands;
import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private final Spawn_Join_Leave plugin;

    public SetSpawnCommand(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("sjl.setspawn")) {
                Location location = p.getLocation();
                plugin.getConfig().set("spawn", location);
                p.sendMessage(ChatColor.RED + "Spawn location set." );
            } else p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            plugin.saveConfig();
        }

        return true;
    }
}
