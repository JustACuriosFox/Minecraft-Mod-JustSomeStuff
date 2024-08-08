package net.justacuriosfox.justsomestuff.enchantment;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

import java.util.Collection;

public class AffectingEnchantment extends Enchantment {
    protected AffectingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            LivingEntity Ltarget = (LivingEntity) target;
            Collection<StatusEffectInstance> effects = user.getStatusEffects();
            for (StatusEffectInstance i : effects) {
                Ltarget.addStatusEffect(i);
            }
            user.clearStatusEffects();
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.isOf(ModItems.REAPING_SWORD)){
            return super.isAcceptableItem(stack);
        }
        else {
            return false;
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
        return 1;
    }
}
