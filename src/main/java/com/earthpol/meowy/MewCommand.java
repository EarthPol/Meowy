package com.earthpol.meowy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MewCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Determine if the player gains rizz or no rizz
            Random random = new Random();
            boolean hasRizz = random.nextBoolean();

            if (hasRizz) {
                player.sendMessage(ChatColor.GREEN + "You have gained rizz!");
            } else {
                player.sendMessage(ChatColor.RED + "No rizz for you!");
            }
            return true;
        } else {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
    }

    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return java.util.Collections.emptyList(); // No tab completion for this command
    }
}

