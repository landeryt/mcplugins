package me.landeryt.spawnjoinleave.Commands;
import me.landeryt.spawnjoinleave.Spawn_Join_Leave;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessage implements CommandExecutor {
    private final Spawn_Join_Leave plugin;

    public SetMessage(Spawn_Join_Leave plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("sjl.setmessage")) {
                if (args.length >= 1) {
                    if (args[0] == "join") {
                        StringBuilder message = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]);
                        }
                        plugin.getConfig().set("join-message", message.toString());
                    } else if (args[0] == "leave") {
                        StringBuilder message = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]);
                        }
                        plugin.getConfig().set("leave-message", message.toString());
                    } else {
                        p.sendMessage(ChatColor.DARK_AQUA + "Unknown command arguments, please try 'join' or 'leave'");
                    }
                } else {
                    p.sendMessage(ChatColor.YELLOW + "Please add command arguments 'join' or 'leave'");
                }
            } else {
                p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            }
            plugin.saveConfig();
        }
        return true;
    }
}
