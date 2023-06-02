package net.ocejlot.antiphysics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiPhysics extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onBlockPhysics(EntityChangeBlockEvent event) {
        if (event.getBlock().getType().hasGravity())
            event.setCancelled(true);
        }
    }
