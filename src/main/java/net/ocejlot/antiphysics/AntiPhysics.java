package net.ocejlot.antiphysics;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class AntiPhysics extends JavaPlugin implements Listener, CommandExecutor, TabCompleter {

    private AntiPhysicsConfig config;

    @Override
    public void onEnable() {
        config = new AntiPhysicsConfig(this);
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("ap")).setExecutor(this);
        Objects.requireNonNull(getCommand("ap")).setTabCompleter(this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onBlockPhysics(EntityChangeBlockEvent event) {
        if (config.isActive()) return;
        if(config.isBlockFall()) return;
        if (config.allowedInAllWorlds()){
            event.setCancelled(true);
        }
        String worldName = event.getBlock().getWorld().getName();
        if (!event.getBlock().getType().hasGravity() || !config.getWorlds().contains(worldName)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onFluidFlow(BlockFromToEvent event){
        if (config.isActive()) return;
        if(config.isFluidFlow()) return;
        if (config.allowedInAllWorlds()){
            event.setCancelled(true);
        }
        String worldName = event.getBlock().getWorld().getName();
        if (event.getBlock().getType().isSolid() || !config.getWorlds().contains(worldName)) return;
        event.setCancelled(true);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ap")) {
            if (!sender.hasPermission("antiphysics.all")) return false;
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                config.loadConfig();
                sender.sendMessage(MiniMessage.miniMessage().deserialize("<#96f250>AntiPhysics configuration reloaded."));
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("v")) {
                reloadConfig();
                config.loadConfig();
                Deserializer.deserializeInfo((Player) sender);
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                reloadConfig();
                config.loadConfig();
                Deserializer.deserializeHelp((Player) sender);
                return true;
            }

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("ap")) {
            if (args.length == 1) {
                List<String> completions = new ArrayList<>();
                completions.add("reload");
                completions.add("v");
                completions.add("help");
                return completions;
            }
        }
        return null;
    }
}

