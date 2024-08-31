package net.justacuriosfox.justsomestuff.recipe;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(JustSomeStuffMod.MOD_ID, LSDFurnaceRecipe.Serializer.ID),
                LSDFurnaceRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(JustSomeStuffMod.MOD_ID, LSDFurnaceRecipe.Type.ID),
                LSDFurnaceRecipe.Type.INSTANCE);
    }
}
