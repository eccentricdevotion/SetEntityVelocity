package me.eccentric_nz.setentityvelocity;

import org.bukkit.Input;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInputEvent;

public class SetEntityVelocityListener implements Listener {

    private final SetEntityVelocity plugin;

    public SetEntityVelocityListener(SetEntityVelocity plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInputEvent event) {
        Input input = event.getInput();
        if (plugin.getStand() != null && input.isSneak()) {
            plugin.getStand().remove();
            plugin.setStand(null);
        }
    }
}
