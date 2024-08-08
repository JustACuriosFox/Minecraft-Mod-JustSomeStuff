package net.justacuriosfox.justsomestuff.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;

public class ReapingSwordItem extends SwordItem {
    public ReapingSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
