package net.justacuriosfox.justsomestuff.potion;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.justacuriosfox.justsomestuff.item.ModItemGroup;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion HOP_JUICE;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(JustSomeStuffMod.MOD_ID, name),
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
