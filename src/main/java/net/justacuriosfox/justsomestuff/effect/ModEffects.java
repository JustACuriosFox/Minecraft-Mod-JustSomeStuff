package net.justacuriosfox.justsomestuff.effect;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEffects {
    public static StatusEffect ALCOHOL_POISONING = registerStatusEffect("alcohol_poisoning",
            new AlcoholPoisoningEffect(
                    StatusEffectCategory.HARMFUL,
                    10092288));
    public static StatusEffect DRUNK = registerStatusEffect("drunk",
            new DrunkEffect(
                    StatusEffectCategory.NEUTRAL,
                    12));
    public static StatusEffect HIGH_LSD = registerStatusEffect("high_lsd",
            new LSDEffect(
                    StatusEffectCategory.HARMFUL,
                    784932
            ));

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(JustSomeStuffMod.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        JustSomeStuffMod.LOGGER.info("loading Status Effects");

    }
}
