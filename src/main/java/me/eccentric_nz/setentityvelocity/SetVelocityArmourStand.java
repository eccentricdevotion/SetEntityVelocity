package me.eccentric_nz.setentityvelocity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SetVelocityArmourStand extends ArmorStand {

    private final Player player;

    public SetVelocityArmourStand(EntityType<? extends ArmorStand> entitytypes, Level world, Player player) {
        super(entitytypes, world);
        this.player = player;
        this.setNoGravity(false);
    }

    @Override
    public void travel(Vec3 vec3d) {
        if (super.isNoGravity()) {
            super.travel(vec3d);
        } else {
            Vector direction;
            if (this.onGround() && player.getLocation().getDirection().getY() < 0) {
                direction = new Vector(0, 0, 0);
            } else {
                direction = player.getLocation().getDirection();
            }
            move(MoverType.SELF, new Vec3(direction.getX()/2, direction.getY()/2, direction.getZ()/2));
        }
    }
}
