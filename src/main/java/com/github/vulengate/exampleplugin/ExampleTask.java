package com.github.vulengate.exampleplugin;

import com.github.cozyplugins.cozylibrary.task.TaskContainer;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ExampleTask extends TaskContainer {

    public void run() {

        // Execute some code every x ticks.
        this.runTaskLoop("IDENTIFIER", () -> {

            for (Player player : Bukkit.getOnlinePlayers()) {
                new PlayerUser(player).sendMessage("Hi!");
            }

        }, 20); // Every second.
    }

    public void stop() {
        this.stopTask("IDENTIFIER");
    }
}
