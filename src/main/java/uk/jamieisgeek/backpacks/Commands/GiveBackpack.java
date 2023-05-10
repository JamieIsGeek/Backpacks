package uk.jamieisgeek.backpacks.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.jamieisgeek.backpacks.Backpacks;

public class GiveBackpack implements CommandExecutor {
    private final Backpacks plugin;
    public GiveBackpack(Backpacks plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            plugin.getLogger().warning("Only players can use this command!");
            return true;
        }

        if(args.length == 0) {
            plugin.getItemManager().Give(player);
        } else {
            if(Bukkit.getPlayerExact(args[0]) == null) {
                player.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }

            Player target = Bukkit.getPlayerExact(args[0]);
            plugin.getItemManager().Give(target);
            target.sendMessage(ChatColor.GREEN + "You have received a backpack!");
        }

        player.sendMessage(ChatColor.GREEN + "Backpack given!");
        return true;
    }
}
