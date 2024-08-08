package net.justacuriosfox.justsomestuff.item;

import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.Objects;

public class ModBeerItem extends Item{
    public ModBeerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1f, 0.7f);
        if (user.hasStatusEffect(ModEffects.ALCOHOL_POISONING)) {
            user.sendMessage(new LiteralText("used Item with effect"), true);
            int EffectAmplifier = Objects.requireNonNull(user.getStatusEffect(ModEffects.ALCOHOL_POISONING)).getAmplifier();
            user.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING,
                    10,
                    EffectAmplifier + 1));
        } else {
            user.sendMessage(new LiteralText("used Item without effect"), true);
            user.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING, 10, 1));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}

