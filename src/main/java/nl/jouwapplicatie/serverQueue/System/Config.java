package nl.jouwapplicatie.serverQueue.System;

import net.md_5.bungee.api.ChatColor;
import nl.jouwapplicatie.serverQueue.ServerQueue;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.List;

public class Config {

    public String Prefix;
    public String Queue_Added;
    public String Queue_Move;
    public String Queue_Done;
    public String Bypass_Perm;
    public String pluginversion;
    public List<String> servers;
    public boolean system;

    public void ReloadConfig() {
        this.ReloadConfigData();
        ServerQueue.instance.reloadConfig();
        ServerQueue.instance.getConfig().options().copyDefaults();
        ServerQueue.instance.saveDefaultConfig();
    }

    private void ReloadConfigData() {
        this.Prefix = ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.c.getString("Prefix"));
        this.Queue_Added = ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.c.getString("Queue_Added"));
        this.Queue_Move = ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.c.getString("Queue_Move"));
        this.Queue_Done = ChatColor.translateAlternateColorCodes('&', ServerQueue.instance.c.getString("Queue_Done"));
        this.Bypass_Perm = ServerQueue.instance.c.getString("Bypass_Perm");
        final PluginDescriptionFile pdf = ServerQueue.instance.getDescription();
        this.pluginversion = pdf.getVersion();
        this.servers = (List<String>)ServerQueue.instance.c.getStringList("Servers");
        for (final String servers : ServerQueue.instance.c.getStringList("Servers")) {
            ServerQueue.instance.getQueueManager().addQueue(servers.toLowerCase());
            System.out.println(servers.toLowerCase());
        }
        Registerer.RegisterEvents();
        this.system = true;
    }

}
