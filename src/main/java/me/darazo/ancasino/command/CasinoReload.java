package me.darazo.ancasino.command;

import me.darazo.ancasino.AnCasino;
import org.bukkit.entity.Player;

public class CasinoReload extends AnCommand {

    // casino reload command
    public CasinoReload(AnCasino plugin, String[] args, Player player) {
        super(plugin, args, player);
    }

    public Boolean process() {

        // Permissions
        if (!plugin.permission.isAdmin(player)) {
            noPermission();
            return true;
        }

        plugin.reloadConfig();
        plugin.slotData.loadSlots();
        plugin.typeData.loadTypes();
        sendMessage("Configuration reloaded");
        return true;
    }

}
