package uk.jamieisgeek.backpacks.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import uk.jamieisgeek.backpacks.GUIManager;

public class RightClickListener implements Listener {
    private final GUIManager guiManager;

    /**
     * @param guiManager The GUIManager instance
     */
    public RightClickListener(GUIManager guiManager) {
        this.guiManager = guiManager;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getItem() == null) return;
            if(!event.getItem().hasItemMeta()) return;
            if(!event.getItem().getItemMeta().hasCustomModelData()) return;

            if(!event.getItem().getType().equals(Material.BLAZE_POWDER)) return;
            if(!event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Backpack")) return;
            guiManager.openGUI(event.getPlayer(), event.getItem());
        }
    }
}
