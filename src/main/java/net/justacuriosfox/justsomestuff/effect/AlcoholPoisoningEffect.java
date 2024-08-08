package net.justacuriosfox.justsomestuff.effect;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.RegistryKey;

public class AlcoholPoisoningEffect extends StatusEffect {
    public AlcoholPoisoningEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.world.isClient()) {
            if (pLivingEntity.isAlive()) {
                pLivingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.ALCOHOL_POISONING, 40, pAmplifier));
                if (pAmplifier >= 30) {
                    pLivingEntity.kill();
                    pLivingEntity.sendSystemMessage(new LiteralText("You drank too much alcohol nad died of Alcohol poisoning."), Util.NIL_UUID);
                    pLivingEntity.removeStatusEffect(ModEffects.ALCOHOL_POISONING);
                }

                if (pAmplifier >= 20) {
                    if (!pLivingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {
                        pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 20, 1));
                    }
                    pLivingEntity.setHealth(pLivingEntity.getMaxHealth() / 2);
                }
                if (pAmplifier >= 25){
                    if (!pLivingEntity.hasStatusEffect(StatusEffects.POISON)) {
                        pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 20, 10));
                    }
                }
                if (pAmplifier >= 15) {
                    if (!pLivingEntity.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
                        pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, 1));
                    } if (!pLivingEntity.hasStatusEffect(StatusEffects.SLOWNESS)) {
                        pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 1));
                    }
                }
                if (pAmplifier >= 7) {
                    if (!pLivingEntity.hasStatusEffect(StatusEffects.NAUSEA)){
                        pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20, 3));
                    }
                }
                if (pAmplifier >= 3) {
                    if (pAmplifier <= 7) {
                        if (!pLivingEntity.hasStatusEffect(StatusEffects.NAUSEA)) {
                            pLivingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20, 1));
                        }
                    }
                }
            } else if (pLivingEntity.isDead()) {
                pLivingEntity.removeStatusEffect(ModEffects.ALCOHOL_POISONING);
            }
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }


}
