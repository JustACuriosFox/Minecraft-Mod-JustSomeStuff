package net.justacuriosfox.justsomestuff.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;

public class PowerlessCurseEnchantment extends Enchantment {
    protected PowerlessCurseEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return false;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Hand hand = user.getActiveHand();
        ItemStack stack = user.getStackInHand(hand);
        if (!user.getWorld().isClient()){
            stack.decrement(stack.getCount());
            user.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1f, 0.5f);
            
        }

        super.onTargetDamaged(user, target, level);
    }


    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}
