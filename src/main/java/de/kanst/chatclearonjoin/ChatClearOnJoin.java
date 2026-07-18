package de.kanst.chatclearonjoin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatClearOnJoin extends JavaPlugin implements Listener {

    private int delaySeconds;
    private int clearLines;
    private boolean clearForAll;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("ChatClearOnJoin v1.0.0 enabled - delay: " + delaySeconds + "s");
    }

    private void loadConfig() {
        delaySeconds = getConfig().getInt("delay-seconds", 1);
        clearLines = getConfig().getInt("clear-lines", 100);
        clearForAll = getConfig().getBoolean("clear-for-all", true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        long delayTicks = delaySeconds * 20L;
        // 1 second = 20 ticks
        Bukkit.getScheduler().runTaskLater(this, () -> clearChat(e.getPlayer()), delayTicks);
    }

    private void clearChat(Player joinedPlayer) {
        String empty = " ".repeat(1);
        // Build empty message block
        if (clearForAll) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < clearLines; i++) {
                    p.sendMessage(empty);
                }
            }
        } else {
            for (int i = 0; i < clearLines; i++) {
                joinedPlayer.sendMessage(empty);
            }
        }
    }
}