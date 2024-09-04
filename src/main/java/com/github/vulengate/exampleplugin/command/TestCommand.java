package com.github.vulengate.exampleplugin.command;

import com.github.cozyplugins.cozylibrary.command.command.CozyCommand;
import com.github.cozyplugins.cozylibrary.command.command.command.ProgrammableCommand;
import com.github.cozyplugins.cozylibrary.command.datatype.*;
import com.github.cozyplugins.cozylibrary.pool.PermissionPool;
import com.github.cozyplugins.cozylibrary.user.ConsoleUser;
import com.github.cozyplugins.cozylibrary.user.FakeUser;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import com.github.cozyplugins.cozylibrary.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestCommand implements CozyCommand {

    @Override
    public @NotNull String getName() {
        return "test"; // "/test"
    }

    @Override
    public @Nullable CommandAliases getAliases() {
        return null;
    }

    @Override
    public @Nullable String getDescription() {
        return "This will message the player 'hello world'.";
    }

    @Override
    public @Nullable String getSyntax() {
        return "/test";
    }

    @Override
    public @Nullable PermissionPool getPermissionPool() {
        // Here you can add permissions that are required
        // to run the command.
        return new PermissionPool()
                .append("exampleplugin.test");
    }

    @Override
    public @Nullable CommandPool getSubCommands() {
        // Here you can add commands that are accessed from this command.
        // For example:
        // /test command
        return new CommandPool().append(new ProgrammableCommand("command")
                .setDescription("This will message the player 'Hello world 2'.")
                .setSyntax("/test command")
                .setPlayer((user, arguments) -> {
                    user.sendMessage("Hello world 2");
                    return new CommandStatus();
                })
        );
    }

    @Override
    public @Nullable CommandSuggestions getSuggestions(@NotNull User user, @NotNull CommandArguments arguments) {
        // This is where you can customise the tab completion.
        // For example making it suggest numbers for the next argument
        // and then words for the argument after.
        // /test [0-9] [word|test|hello]
        return new CommandSuggestions()
                .append(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"))
                .append(List.of("word", "test", "hello"));
    }

    @Override
    public @Nullable CommandStatus onUser(@NotNull User user, @NotNull CommandArguments arguments) {
        // This will run when anyone runs the command.
        return null;
    }

    @Override
    public @Nullable CommandStatus onPlayerUser(@NotNull PlayerUser user, @NotNull CommandArguments arguments, @NotNull CommandStatus status) {
        // This will run only when players run the command.
        return null;
    }

    @Override
    public @Nullable CommandStatus onFakeUser(@NotNull FakeUser user, @NotNull CommandArguments arguments, @NotNull CommandStatus status) {
        // This is run when a plugin runs the command with no player instance.
        return null;
    }

    @Override
    public @Nullable CommandStatus onConsoleUser(@NotNull ConsoleUser user, @NotNull CommandArguments arguments, @NotNull CommandStatus status) {
        // This is run when the console runs the command.
        return null;
    }
}
