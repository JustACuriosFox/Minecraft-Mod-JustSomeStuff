package net.justacuriosfox.justsomestuff.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import java.math.*;

public class ReapingSwordItem extends SwordItem {
    public ReapingSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(user.getStackInHand(hand).getItem())) {
            double x = entity.getX() - user.getX();
            double z = entity.getZ() - user.getZ();
            double y = Math.min(((user.getPitch() * 0.05) * .75), 1.2);
            double factor = Math.min(Math.sqrt((x*x) + (z*z)) * .6, 1.4);
            entity.addVelocity(x, y * factor, z);
            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(), 50);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
