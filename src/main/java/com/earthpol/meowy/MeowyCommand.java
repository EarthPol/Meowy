package com.earthpol.meowy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MeowyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + "----=== Meowy ===----");
        player.sendMessage(ChatColor.AQUA + "Meowy is a plugin that lets you /meow");
        player.sendMessage(ChatColor.AQUA + "This idea was created by Fruitloopins for EarthMC");
        player.sendMessage(ChatColor.AQUA + "We shamelessly recreated it because it's awesome.");
        return true;
    }
}
