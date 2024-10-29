package me.eccentric_nz.setentityvelocity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SetEntityVelocityCommand implements CommandExecutor {

    private final SetEntityVelocity plugin;

    public SetEntityVelocityCommand(SetEntityVelocity plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setentityvelocity")) {
            if (args.length < 3) {
                return true;
            }
            if (sender instanceof Player player) {

                // get floats from args
                float x = Float.parseFloat(args[0]);
                float y = Float.parseFloat(args[1]);
                float z = Float.parseFloat(args[2]);
                // spawn an armour stand at player's location
                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                stand.setGravity(false);
                plugin.setStand(stand);
                Vector v = new Vector();
                v.setX(x);
                v.setY(y);
                v.setZ(z);
                stand.setVelocity(v);
            }
            return true;
        }
        return false;
    }
}
