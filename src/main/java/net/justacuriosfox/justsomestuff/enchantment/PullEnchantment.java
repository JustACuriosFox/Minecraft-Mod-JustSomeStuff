package net.justacuriosfox.justsomestuff.enchantment;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class PullEnchantment extends Enchantment {
    protected PullEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.world.isClient()){
            double x = target.getX() - user.getX();
            double z = target.getZ() - user.getZ();
            x = (x * -0.05) * level;
            z = (z * -0.05) * level;
            target.addVelocity(x, 0, z);
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        if (other == Enchantments.KNOCKBACK || other == ModEnchantements.YEET){
            return false;
        } else {
            return super.canAccept(other);
        }
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() == ModItems.REAPING_SWORD){
            return true;
        } else {
            return stack.getItem() == ModItems.REAPING_SWORD_UPGRADE;
        }
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
