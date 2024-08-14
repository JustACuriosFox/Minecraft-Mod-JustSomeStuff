package net.justacuriosfox.justsomestuff.item;

import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ModBeerItem extends Item{
    public ModBeerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1f, 0.7f);
        if (entity.hasStatusEffect(ModEffects.ALCOHOL_POISONING)) {
            int EffectAmplifier = entity.getStatusEffect(ModEffects.ALCOHOL_POISONING).getAmplifier();
            if (EffectAmplifier == 1) {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING,
                        10 * 60 * 20,
                        EffectAmplifier + 1));
            } else {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING,
                        10 * 60 * 20,
                        EffectAmplifier + 1));
            }
        } else {
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING, 10 * 60 * 20, 1));
        }
        if (!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1f, 0.7f);
        if (user.hasStatusEffect(ModEffects.ALCOHOL_POISONING)) {
            int EffectAmplifier = user.getStatusEffect(ModEffects.ALCOHOL_POISONING).getAmplifier();
            if (EffectAmplifier == 1) {
                user.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING,
                        10 * 60 * 20,
                        EffectAmplifier + 1));
            } else {
                user.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING,
                        10 * 60 * 20,
                        EffectAmplifier + 1));
            }
        } else {
            user.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING, 10 * 60 * 20, 1));
        }
        if (!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}

