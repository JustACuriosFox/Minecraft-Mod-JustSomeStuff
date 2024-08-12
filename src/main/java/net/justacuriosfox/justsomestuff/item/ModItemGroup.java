package net.justacuriosfox.justsomestuff.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ALCOHOL = FabricItemGroupBuilder.build(new Identifier(JustSomeStuffMod.MOD_ID, "alcohol"),
            () -> new ItemStack(ModItems.BEER));
    public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(new Identifier(JustSomeStuffMod.MOD_ID, "weapons"),
            () -> new ItemStack(ModItems.REAPING_SWORD));
}
