package nl.jouwapplicatie.serverQueue.data;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserManager {

    private Set<User> users;

    public UserManager() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public User getUser(final Player player) {
        return this.users.stream().filter(user -> user.getUUID().equals(player.getUniqueId())).findAny().orElse(null);
    }

    public User getUser(final UUID uuid) {
        return this.users.stream().filter(user -> user.getUUID().equals(uuid)).findAny().orElse(null);
    }

    public User getUser(final String name) {
        return this.users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }

    public void addUser(final Player player) {
        this.users.add(new User(player));
    }

    public void removeUser(final Player player) {
        this.users.remove(this.getUser(player));
    }

}
