package nl.jouwapplicatie.serverQueue.System;

import nl.jouwapplicatie.serverQueue.ServerQueue;
import nl.jouwapplicatie.serverQueue.commands.MainCommand;
import nl.jouwapplicatie.serverQueue.commands.QueueCommand;
import nl.jouwapplicatie.serverQueue.commands.SystemCommand;
import nl.jouwapplicatie.serverQueue.events.ConnectListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Registerer {

    public static void RegisterEvents() {
        ServerQueue.instance.getServer().getPluginManager().registerEvents(new ConnectListener(), ServerQueue.instance);
        ServerQueue.instance.getCommand("serverqueue").setExecutor(new MainCommand());
        ServerQueue.instance.getCommand("queue").setExecutor(new QueueCommand());
        ServerQueue.instance.getCommand("qlsystem").setExecutor(new SystemCommand());
        ServerQueue.instance.getServer().getMessenger().registerOutgoingPluginChannel(ServerQueue.instance, "BungeeCord");
    }

}
