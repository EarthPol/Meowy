package com.earthpol.meowy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class MeowCommand implements CommandExecutor {
    private HashMap<UUID, Long> cooldowns = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        UUID playerID = player.getUniqueId();
        long timeNow = System.currentTimeMillis();
        long cooldownTime = 20 * 1000; // 20 seconds in milliseconds

        if (cooldowns.containsKey(playerID)) {
            long lastUsed = cooldowns.get(playerID);
            if (timeNow - lastUsed < cooldownTime) {
                // Check if the player is an OP or has the bypass permission
                if (!player.isOp() && !player.hasPermission("earthpol.meowy.bypass")) {
                    player.sendMessage("You've got to be kitten me! Wait a bit before meowing again.");
                    return true;
                }
            }
        }

        cooldowns.put(playerID, timeNow);

        Sound sound = Sound.ENTITY_CAT_AMBIENT; // Default sound
        String action = "meowed."; // Default action

        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "meow":
                    sound = Sound.ENTITY_CAT_AMBIENT;
                    break;
                case "beg":
                    sound = Sound.ENTITY_CAT_BEG_FOR_FOOD;
                    action = "begged for food.";
                    break;
                case "hiss":
                    sound = Sound.ENTITY_CAT_HISS;
                    action = "hissed.";
                    break;
                case "hurt":
                    sound = Sound.ENTITY_CAT_HURT;
                    action = "sounded hurt.";
                    break;
                case "purr":
                    sound = Sound.ENTITY_CAT_PURR;
                    action = "purred.";
                    break;
                case "purreow":
                    sound = Sound.ENTITY_CAT_PURREOW;
                    action = "made a purreow sound.";
                    break;
                default:
                    player.sendMessage("Unknown sound. Playing default meow.");
            }
        }

        player.getWorld().playSound(player.getLocation(), sound, 1.0f, 1.0f);
        String message = player.getName() + " has " + action + ".";
        Bukkit.getOnlinePlayers().stream().filter(p -> p.getLocation().distance(player.getLocation()) <= 15).forEach(p -> p.sendMessage(message));


        return true;
    }
}
