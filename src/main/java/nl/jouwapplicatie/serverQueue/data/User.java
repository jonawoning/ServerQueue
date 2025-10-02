package nl.jouwapplicatie.serverQueue.data;

import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private Player player;
    private String name;
    private UUID uuid;
    private int position;
    private String queue;

    public User(final Player player) {
        this.player = player;
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        this.position = 0;
        this.queue = "";
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getQueue() {
        return this.queue;
    }

    public void setPosition(final int position1) {
        this.position = position1;
    }

    public void setQueue(final String queue1) {
        this.queue = queue1;
    }

}
