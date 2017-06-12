package com.mason.gmcheck;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCheckCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.hasPermission("gmcheck.check") || player.isOp()) {
                    if (player.getGameMode().equals(GameMode.CREATIVE)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» &7Your current gamemode is &aCreative"));
                    } else if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» &7Your current gamemode is &cSurvival"));
                    } else if (player.getGameMode().equals(GameMode.ADVENTURE)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» &7Your current gamemode is &eAdventure"));
                    } else if (player.getGameMode().equals(GameMode.SPECTATOR)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» &7Your current gamemode is &8Spectator"));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
                }
            } else if (args.length == 1) {
                if (player.hasPermission("gmcheck.others") || player.isOp()) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target.getGameMode().equals(GameMode.CREATIVE)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» " + ChatColor.RED + target.getName() + "'s &7current gamemode is &aCreative"));
                    } else if (target.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» " + ChatColor.RED + target.getName() + "'s &7current gamemode is &cSurvival"));
                    } else if (target.getGameMode().equals(GameMode.ADVENTURE)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» " + ChatColor.RED + target.getName() + "'s &7current gamemode is &eAdventure"));
                    } else if (target.getGameMode().equals(GameMode.SPECTATOR)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGMCheck &8» " + ChatColor.RED + target.getName() + "'s &7current gamemode is &8Spectator"));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cIncorrect Usage! &7/gmcheck (target)"));
            }
        }

        return false;
    }

}
