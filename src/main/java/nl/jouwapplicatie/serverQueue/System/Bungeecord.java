package nl.jouwapplicatie.serverQueue.System;

import net.md_5.bungee.api.ChatColor;
import nl.jouwapplicatie.serverQueue.ServerQueue;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class Bungeecord {

    public static void sendPlayerToServer(final Player player, final String server) {
        try {
            final ByteArrayOutputStream b = new ByteArrayOutputStream();
            final DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage(ServerQueue.instance, "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.RED + "Error when trying to connect to " + server);
        }
    }

}
