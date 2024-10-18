package net.justacuriosfox.justsomestuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerItemGroups() {
        JustSomeStuffMod.LOGGER.info("registering item groups");
    }

    public static final ItemGroup ALCOHOL = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JustSomeStuffMod.MOD_ID, "alcohol"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.justsomestuff.alcohol"))
                    .icon(() -> new ItemStack(ModItems.BEER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BEER);
                        entries.add(ModItems.HOPS);
                        entries.add(ModItems.HOP_JUICE);
                        entries.add(ModItems.LSD);
                        entries.add(ModBlocks.LSDFURNACE);
                    }).build());

    public static final ItemGroup WEAPONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JustSomeStuffMod.MOD_ID, "weapons"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.justsomestuff.weapons"))
                    .icon(() -> new ItemStack(ModItems.REAPING_SWORD_UPGRADE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.REAPING_SWORD);
                        entries.add(ModItems.REAPING_SWORD_UPGRADE);
                    }).build());

    public static final ItemGroup WASTELAND_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JustSomeStuffMod.MOD_ID, "wasteland_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.justsomestuff.wasteland_items"))
                    .icon(() -> new ItemStack(ModBlocks.WASTEROOT)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.REAPERCORE);
                        entries.add(ModBlocks.WASTEROOT);
                        entries.add(ModBlocks.WASTE_GRASS);
                        entries.add(ModBlocks.BLOODSTONE);
                        entries.add(ModItems.WASTEROOT_ITEM);
                        entries.add(ModItems.ENHANCED_WASTEROOT);
                        entries.add(ModItems.BLOOD_ORB);
                        entries.add(ModItems.WASTEROOT_HANDLE);
                        entries.add(ModItems.WASTEROOT_BLADE);
                        entries.add(ModBlocks.ASHEN_SAPLING);
                        entries.add(ModBlocks.ASHEN_LEAVES);
                        entries.add(ModBlocks.ASHEN_LOG);
                        entries.add(ModBlocks.ASHEN_WOOD);
                        entries.add(ModBlocks.STRIPPED_ASHEN_LOG);
                        entries.add(ModBlocks.STRIPPED_ASHEN_WOOD);
                        entries.add(ModBlocks.ASHEN_PLANKS);
                    }).build());

    public static final ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JustSomeStuffMod.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.justsomestuff.tools"))
                    .icon(() -> new ItemStack(ModItems.KARLU_PICKAXE_ITEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KARLU_PICKAXE_ITEM);
                    }).build());
}
