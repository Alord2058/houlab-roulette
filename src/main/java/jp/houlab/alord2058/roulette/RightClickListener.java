package jp.houlab.alord2058.roulette;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class RightClickListener implements Listener {

    private final Roulette plugin;

    public RightClickListener(Roulette plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Material getMaterial = event.getMaterial();

        int count = 100;

        if (event.getHand() == EquipmentSlot.HAND) {
            if (event.getAction().isRightClick()) {
                if (getMaterial.equals(Material.CLOCK) && player.getCooldown(getMaterial) == 0) {
                    player.setCooldown(getMaterial,20*10);
                    new rouletteTask(plugin, count).runTaskTimer(plugin,0,1);
                }
            }
        }
    }
}


