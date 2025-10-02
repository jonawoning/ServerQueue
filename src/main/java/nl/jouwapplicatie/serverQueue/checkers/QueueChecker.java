package nl.jouwapplicatie.serverQueue.checkers;

import nl.jouwapplicatie.serverQueue.ServerQueue;
import nl.jouwapplicatie.serverQueue.System.Bungeecord;
import nl.jouwapplicatie.serverQueue.data.Queue;
import nl.jouwapplicatie.serverQueue.data.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class QueueChecker {

    public static void QueueLoop(final List<String> servers) {
        new BukkitRunnable() {
            public void run() {
                if (ServerQueue.instance.getConfigC().system) {
                    for (final String s : servers) {
                        final Queue queue = ServerQueue.instance.getQueueManager().getQueue(s.toLowerCase());
                        for (final Player player : Bukkit.getOnlinePlayers()) {
                            if (queue.getTotalQueue().contains(player)) {
                                final User user = ServerQueue.instance.getUserManager().getUser(player);
                                if (user.getPosition() != 1) {
                                    continue;
                                }
                                user.setQueue("");
                                user.setPosition(0);
                                player.sendMessage(ServerQueue.instance.getConfigC().Prefix + ServerQueue.instance.getConfigC().Queue_Done);
                                Bungeecord.sendPlayerToServer(player, queue.getQueueServer());
                                queue.RemoveQueue(player);
                                for (final Player player2 : Bukkit.getOnlinePlayers()) {
                                    final User user2 = ServerQueue.instance.getUserManager().getUser(player2);
                                    if (user2.getQueue().equalsIgnoreCase(queue.getQueueServer())) {
                                        final int Position = user2.getPosition() - 1;
                                        user2.setPosition(Position);
                                        player2.sendMessage(ServerQueue.instance.getConfigC().Prefix + ServerQueue.instance.getConfigC().Queue_Move.replace("%position%", String.valueOf(Position)).replace("%maxpos%", String.valueOf(queue.getTotalQueue().size())));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimerAsynchronously(ServerQueue.instance, 0L, 120L);
    }

}
