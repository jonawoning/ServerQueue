package nl.jouwapplicatie.serverQueue.commands;

import net.md_5.bungee.api.ChatColor;
import nl.jouwapplicatie.serverQueue.ServerQueue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SystemCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!sender.hasPermission("queue.system")) {
            sender.sendMessage(ServerQueue.instance.getConfigC().Prefix + "Sorry but for this you need the permission: '" + ChatColor.RED + "queue.system" + ChatColor.GRAY + "'!");
            return true;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("on")) {
            ServerQueue.instance.getConfigC().system = true;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.getConfigC().Prefix + "&7The queue system is succesfully &aonline&7!"));
            return true;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("off")) {
            ServerQueue.instance.getConfigC().system = false;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.getConfigC().Prefix + "&7The queue system is succesfully &coffline&7!"));
            return true;
        }
        sender.sendMessage(ServerQueue.instance.getConfigC().Prefix + ChatColor.RED + "/qlsystem (on/off)");
        return false;
    }

}
