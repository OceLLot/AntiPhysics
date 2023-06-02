package net.ocejlot.antiphysics;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class AntiPhysicsConfig {

    private final AntiPhysics plugin;
    private boolean active;
    private boolean fluidFlow;
    private boolean blockFall;
    private List<String> worlds;

    public AntiPhysicsConfig(AntiPhysics plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();
        active = config.getBoolean("Active");
        fluidFlow = config.getBoolean("FluidFlow");
        blockFall = config.getBoolean("BlockFall");
        worlds = config.getStringList("worlds");
    }

    public boolean isActive() {
        return !active;
    }

    public boolean isFluidFlow() {
        return fluidFlow;
    }

    public boolean isBlockFall() {
        return blockFall;
    }

    public List<String> getWorlds() {
        return worlds;
    }

    public boolean allowedInAllWorlds() {
        return worlds.contains("all");
    }
}

