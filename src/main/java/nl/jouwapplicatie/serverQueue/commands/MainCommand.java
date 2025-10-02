package nl.jouwapplicatie.serverQueue.commands;

import net.md_5.bungee.api.ChatColor;
import nl.jouwapplicatie.serverQueue.ServerQueue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l&m-----&7 &c&lServerQueue &8&l&m-----\n&c/serverqueue help &7- Shows help or information about the plugin.\n&c/serverqueue version &7- Shows the plugin version and author.\n&c/qlsystem (off/on) &7- Sets the queue system online or offline. (A pause)\n&c/queue (server) &7- Join the server queue.\n"));
            return true;
        }
        if (args[0].equalsIgnoreCase("version")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8> &7Plugin Version: &c" + ServerQueue.instance.getConfigC().pluginversion + "\n&8> &7Plugin Author: &cPottenmaker &7/ &cJona#7797\n&8> &7Plugin Discord: &chttps://discord.gg/5AVnvkp66e") + "\n");
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l&m-----&7 &c&lServerQueue &8&l&m-----\n&c/serverqueue help &7- Shows help or information about the plugin.\n&c/serverqueue version &7- Shows the plugin version and author.\n&c/qlsystem (off/on) &7- Sets the queue system online or offline. (A pause)\n&c/queue (server) &7- Join the server queue.\n"));
        }
        return false;
    }

}
