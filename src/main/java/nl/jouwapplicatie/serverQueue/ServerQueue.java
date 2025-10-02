package nl.jouwapplicatie.serverQueue;

import nl.jouwapplicatie.serverQueue.System.Config;
import nl.jouwapplicatie.serverQueue.checkers.QueueChecker;
import nl.jouwapplicatie.serverQueue.data.QueueManager;
import nl.jouwapplicatie.serverQueue.data.UserManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerQueue extends JavaPlugin
{
    public static ServerQueue instance;
    public FileConfiguration c;
    private Config config;
    private UserManager userManager;
    private QueueManager queueManager;

    public void onEnable() {
        ServerQueue.instance = this;
        this.c = this.getConfig();
        this.config = new Config();
        this.userManager = new UserManager();
        this.queueManager = new QueueManager();
        this.config.ReloadConfig();
        System.out.println("\u001b[36m[ServerQueue] \u001b[32mThe plugin is succesfully enabled.\u001b[0m");
        QueueChecker.QueueLoop(this.config.servers);
    }

    public void onDisable() {
        System.out.println("\u001b[36m[ServerQueue] \u001b[32mThe plugin is succesfully disabled.\u001b[0m");
    }

    public Config getConfigC() {
        return this.config;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public QueueManager getQueueManager() {
        return this.queueManager;
    }
}
