package net.justacuriosfox.justsomestuff.enchantment;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.item.custom.ReapingSwordItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class LifestealEnchantment extends Enchantment {
    protected LifestealEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.getWorld().isClient()) {
            user.heal(0.34f*level);
        }
        super.onTargetDamaged(user, target, level);
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
