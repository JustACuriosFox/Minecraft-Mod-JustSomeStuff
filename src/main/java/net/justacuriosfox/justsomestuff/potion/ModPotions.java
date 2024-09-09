package net.justacuriosfox.justsomestuff.potion;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModPotions {
    public static Potion HOP_JUICE;

    public static Potion registerPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(JustSomeStuffMod.MOD_ID, name),
                new Potion
                        (new StatusEffectInstance(StatusEffects.POISON, 5*20, 3)));
    }

    public static void registerPotions() {
        HOP_JUICE = registerPotion("hop_juice");

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.THICK, ModItems.HOPS, ModPotions.HOP_JUICE);
    }
}
