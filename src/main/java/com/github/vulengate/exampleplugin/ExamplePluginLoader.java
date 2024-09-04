package com.github.vulengate.exampleplugin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * The base plugin class.
 * <p>
 * All functionality of the plugin starts here.
 */
public class ExamplePluginLoader extends JavaPlugin {

    private ExamplePlugin plugin;

    @Override
    public void onEnable() {
        this.plugin = new ExamplePlugin(this);
        this.plugin.enable();
    }

    @Override
    public void onDisable() {
        this.plugin.disable();
    }
}
