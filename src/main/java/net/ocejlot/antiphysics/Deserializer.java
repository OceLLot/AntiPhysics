package net.ocejlot.antiphysics;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Deserializer extends JavaPlugin {

    public static void deserializeHelp(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize( """
                
                <#f5d142>AntiPhysics commands:
                <#66e39c>/ap reload <#a7e366>Reloads the config
                <#66e39c>/ap v <#a7e366>Version and info
                <#66e39c>/ap help <#a7e366>Help with commands"""));

    }

    public static void deserializeInfo(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize( """
                
                <#29f25f>You are running <#fabd52>AntiPhysics <#29f25f>version <#a7faf4>1.2 <#29f25f>build <#a7faf4>15
                <#29f25f>By <#fabd52>OceJlot <#29f25f>(<underlined><#d4ff8a>Craftoriya<reset> <#29f25f>team)"""));
    }
}
