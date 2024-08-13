package net.justacuriosfox.justsomestuff.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class ReapingSwordItem extends SwordItem {
    public ReapingSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(user.getStackInHand(hand).getItem())) {
            double x = (entity.getX() - user.getX()) * 1;
            double z = (entity.getZ() - user.getZ()) * 1;
            double y = Math.min(((user.getPitch() * 0.05) * .75), 1.2);
            entity.addVelocity(x, y, z);
            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(), 50);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
