package net.ocejlot.antiphysics;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class AntiPhysicsConfig {

    private final AntiPhysics plugin;
    private boolean active;
    private List<String> worlds;

    public AntiPhysicsConfig(AntiPhysics plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();
        active = config.getBoolean("Active");
        worlds = config.getStringList("worlds");
    }

    public boolean isActive() {
        return active;
    }

    public List<String> getWorlds() {
        return worlds;
    }
}

