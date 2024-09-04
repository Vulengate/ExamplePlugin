package com.github.vulengate.exampleplugin;

import com.github.cozyplugins.cozylibrary.CozyPlugin;
import com.github.cozyplugins.cozylibrary.command.CommandManager;
import com.github.cozyplugins.cozylibrary.command.command.command.ProgrammableCommand;
import com.github.cozyplugins.cozylibrary.command.datatype.CommandStatus;
import com.github.cozyplugins.cozylibrary.placeholder.Placeholder;
import com.github.cozyplugins.cozylibrary.placeholder.PlaceholderManager;
import com.github.vulengate.exampleplugin.command.TestCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExamplePlugin extends CozyPlugin<ExamplePluginLoader> {

    public ExamplePlugin(@NotNull ExamplePluginLoader plugin) {
        super(plugin);
    }

    @Override
    public boolean isCommandTypesEnabled() {
        // Command types are not the same as commands.
        // It lets the admins choose what commands they want.
        // We just define what certain commands do, and they chose which ones they want.
        //
        // This will enable to feature.
        // When the plugin loads it will create a commands directory
        // where the command configuration will be located.
        return false;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoadCommands(@NotNull CommandManager commandManager) {

        // Here you can add your custom commands.
        // For example:
        commandManager.addCommand(new ProgrammableCommand("test") // "/test"
                .setDescription("This will message the player 'hello world'.")
                .setSyntax("/test")
                .setPlayer((user, arguments) -> {
                    user.sendMessage("Hello world!");
                    return new CommandStatus();
                })
        );

        // Or if you want to have a class dedicated to the command:
        commandManager.addCommand(new TestCommand());
    }

    @Override
    public void onLoadPlaceholders(@NotNull PlaceholderManager<ExamplePluginLoader> placeholderManager) {

        // Here you can add custom placeholders, this will be registered
        // with the PlaceholderAPI plugin.
        //
        // For example:
        // %ExamplePlugin_test% will be replaced with test.
        placeholderManager.addPlaceholder(new Placeholder() {
            @Override
            public @NotNull String getIdentifier() {
                return "test";
            }

            @Override
            public @NotNull String getValue(@Nullable Player player, @NotNull String params) {
                return "test";
            }
        });
    }
}
