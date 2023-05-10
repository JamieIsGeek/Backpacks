package uk.jamieisgeek.backpacks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemManager {
    private final Backpacks plugin;
    public ItemManager(Backpacks plugin) {
        this.plugin = plugin;
    }

    public void Give(Player player) {
        player.getInventory().addItem(makeBackpack());
    }

    private ItemStack makeBackpack() {
        ItemStack backpack = new ItemStack(Material.BLAZE_POWDER, 1);
        backpack.setItemMeta(setMeta(backpack));

        return backpack;
    }

    private ItemMeta setMeta(ItemStack backpack) {
        ItemMeta meta = backpack.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Backpack");
        meta.setLore(List.of(ChatColor.WHITE + "Right click to open!"));

        meta.setCustomModelData(getRandomNumber());
        return meta;
    }

    private Integer getRandomNumber() {
        return (int) (Math.random() * 999999999);
    }
}
