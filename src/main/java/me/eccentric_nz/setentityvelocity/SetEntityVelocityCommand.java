package me.eccentric_nz.setentityvelocity;

import net.minecraft.server.level.ServerLevel;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SetEntityVelocityCommand implements CommandExecutor {

    private final SetEntityVelocity plugin;

    public SetEntityVelocityCommand(SetEntityVelocity plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setentityvelocity")) {
            if (sender instanceof Player player) {
                // spawn a custom armour stand at player's location
                ServerLevel world = ((CraftWorld) player.getWorld()).getHandle();
                net.minecraft.world.entity.Entity entity = new SetVelocityArmourStand(net.minecraft.world.entity.EntityType.ARMOR_STAND, world, player);
                Location location = player.getLocation();
                entity.setPosRaw(location.getX(), location.getY() + 1, location.getZ());
                world.addFreshEntity(entity, CreatureSpawnEvent.SpawnReason.CUSTOM);
                ArmorStand stand = (ArmorStand) entity.getBukkitEntity();
                stand.addPassenger(player);
                plugin.setStand(stand);
            }
            return true;
        }
        return false;
    }
}
