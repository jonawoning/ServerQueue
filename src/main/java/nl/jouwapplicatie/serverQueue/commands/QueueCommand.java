package nl.jouwapplicatie.serverQueue.commands;

import nl.jouwapplicatie.serverQueue.ServerQueue;
import nl.jouwapplicatie.serverQueue.System.Bungeecord;
import nl.jouwapplicatie.serverQueue.data.Queue;
import nl.jouwapplicatie.serverQueue.data.User;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class QueueCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (!ServerQueue.instance.getConfigC().system) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.getConfigC().Prefix + "&cThe queue is at the moment paused, please try again later.."));
                return true;
            }
            if (args.length > 1) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.getConfigC().Prefix + "&cYou need to fill in a server, /queue (server)"));
                return true;
            }
            if (args.length > 0) {
                final User user = ServerQueue.instance.getUserManager().getUser(player);
                if (user.getPosition() != 0) {
                    player.sendMessage(ServerQueue.instance.getConfigC().Prefix + ChatColor.translateAlternateColorCodes('&', "You are already in a queue."));
                }
                else {
                    final String argument1 = args[0].toLowerCase();
                    if (ServerQueue.instance.getQueueManager().getQueue(argument1) != null) {
                        if (!player.hasPermission(ServerQueue.instance.getConfigC().Bypass_Perm)) {
                            final Queue queues = ServerQueue.instance.getQueueManager().getQueue(argument1);
                            queues.AddQueue(player);
                            user.setQueue(argument1);
                            final int queuesize = queues.getTotalQueue().size();
                            user.setPosition(queuesize);
                            player.sendMessage(ServerQueue.instance.getConfigC().Prefix + ServerQueue.instance.getConfigC().Queue_Added.replace("%position%", String.valueOf(queuesize)).replace("%maxpos%", String.valueOf(queuesize)));
                        }
                        else {
                            player.sendMessage(ServerQueue.instance.getConfigC().Prefix + ServerQueue.instance.getConfigC().Queue_Done);
                            Bungeecord.sendPlayerToServer(player, argument1);
                        }
                    }
                    else {
                        player.sendMessage(ServerQueue.instance.getConfigC().Prefix + ChatColor.translateAlternateColorCodes('&', "This server is not in a queue."));
                    }
                }
            }
        }
        else {
            sender.sendMessage("You have to be a player to do this.");
        }
        return false;
    }

}
