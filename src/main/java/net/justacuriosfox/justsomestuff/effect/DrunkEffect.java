package net.justacuriosfox.justsomestuff.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DrunkEffect extends StatusEffect {
    public DrunkEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) {
            if (Math.random() > (0.9 - (amplifier * .1))) {
                entity.addVelocity(Math.random() / 2 - .25, 0,  Math.random() / 2 -.25);
                float randomF = (float) Math.random();
                entity.setHeadYaw(entity.getHeadYaw() + ((randomF * 20) - 10));

            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
