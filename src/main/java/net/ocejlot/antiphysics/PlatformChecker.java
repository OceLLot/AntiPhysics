package net.ocejlot.antiphysics;

import org.bukkit.Bukkit;
public class PlatformChecker {
    public static String getPlatform() {
        return Bukkit.getServer().getName();
    }

    public static Boolean isSpigot() {
        if (getPlatform().equals("Bukkit")) return true;
        return getPlatform().equals("Spigot");
    }

    public static Boolean isPaper() {
        return getPlatform().equals("Paper");
    }
}
