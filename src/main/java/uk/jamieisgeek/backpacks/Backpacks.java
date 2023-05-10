package uk.jamieisgeek.backpacks;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import uk.jamieisgeek.backpacks.Commands.GiveBackpack;
import uk.jamieisgeek.backpacks.Listeners.RightClickListener;

public final class Backpacks extends JavaPlugin {
    private GUIManager guiManager;
    private ItemManager itemManager;

    @Override
    public void onEnable() {
        this.guiManager = new GUIManager(this);
        this.itemManager = new ItemManager(this);

        this.getCommand("givebackpack").setExecutor(new GiveBackpack(this));
        this.getServer().getPluginManager().registerEvents(new RightClickListener(guiManager), this);
        getLogger().info(ChatColor.GREEN + "Backpacks has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "Backpacks has been disabled!");
    }

    public GUIManager getGUIManager() {
        return guiManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
