package nl.jouwapplicatie.serverQueue.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Queue {

    private String queueServer;
    private ArrayList<Player> totalQueue;

    public Queue(final String queue) {
        this.queueServer = queue;
        this.totalQueue = new ArrayList<Player>();
    }

    public String getQueueServer() {
        return this.queueServer;
    }

    public ArrayList<Player> getTotalQueue() {
        return this.totalQueue;
    }

    public void RemoveQueue(final Player player) {
        this.totalQueue.remove(player);
    }

    public void AddQueue(final Player player) {
        this.totalQueue.add(player);
    }

}
