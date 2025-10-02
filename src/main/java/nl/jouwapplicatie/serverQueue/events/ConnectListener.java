package nl.jouwapplicatie.serverQueue.events;

import nl.jouwapplicatie.serverQueue.ServerQueue;
import nl.jouwapplicatie.serverQueue.data.Queue;
import nl.jouwapplicatie.serverQueue.data.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {

    @EventHandler
    private void onPlayerJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        ServerQueue.instance.getUserManager().addUser(player);
        final User user = ServerQueue.instance.getUserManager().getUser(player);
    }

    @EventHandler
    private void onPlayerQuit(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        final User user = ServerQueue.instance.getUserManager().getUser(player);
        if (user.getPosition() != 0) {
            final int postione = user.getPosition();
            final Queue queue = ServerQueue.instance.getQueueManager().getQueue(user.getQueue());
            queue.RemoveQueue(player);
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                final User user2 = ServerQueue.instance.getUserManager().getUser(player2);
                if (user2.getPosition() != 1 && user2.getPosition() >= postione && user2.getQueue().equalsIgnoreCase(queue.getQueueServer())) {
                    final int Position = user2.getPosition() - 1;
                    user2.setPosition(Position);
                    player2.sendMessage(ServerQueue.instance.getConfigC().Prefix + ServerQueue.instance.getConfigC().Queue_Move.replace("%position%", String.valueOf(Position)).replace("%maxpos%", String.valueOf(queue.getTotalQueue().size())));
                }
            }
        }
        ServerQueue.instance.getUserManager().removeUser(player);
    }
}
