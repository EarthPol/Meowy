package com.earthpol.meowy;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Meowy extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("meow")).setExecutor(new MeowCommand());
        Objects.requireNonNull(this.getCommand("meow")).setTabCompleter(new MeowTabCompleter());
        Objects.requireNonNull(this.getCommand("meowy")).setExecutor(new MeowyCommand());
        Objects.requireNonNull(this.getCommand("mew")).setExecutor(new MewCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
