package net.justacuriosfox.justsomestuff.effect;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ALCOHOL_POISONING;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(JustSomeStuffMod.MOD_ID, name),
                new AlcoholPoisoningEffect(StatusEffectCategory.HARMFUL, 12624973));
    }

    public static void registerEffects() {
        JustSomeStuffMod.LOGGER.info("loading Status Effects");
        ALCOHOL_POISONING = registerStatusEffect("alcohol_poisoning");
    }
}
