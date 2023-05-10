package uk.jamieisgeek.backpacks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager {
    private final Backpacks plugin;
    public GUIManager(Backpacks plugin) {
        this.plugin = plugin;
    }

    /**
     * @param player The player who opened the backpack
     * @param backpack The backpack item
     */
    public void openGUI(Player player, ItemStack backpack) {
        Inventory gui = plugin.getServer().createInventory(null, 27, ChatColor.GOLD + "Backpack");
        player.openInventory(gui);
    }
}
