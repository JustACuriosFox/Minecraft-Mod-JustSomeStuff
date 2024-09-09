package net.justacuriosfox.justsomestuff.enchantment;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public class YeetEnchantment extends Enchantment {
    protected YeetEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient()) {
            LivingEntity Ltarget = (LivingEntity) target;
            Ltarget.setVelocity(new Vec3d(Ltarget.getVelocity().x, .5*level, Ltarget.getVelocity().z));
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        if (other == Enchantments.KNOCKBACK || other == ModEnchantements.PULL || other == Enchantments.BINDING_CURSE){
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
