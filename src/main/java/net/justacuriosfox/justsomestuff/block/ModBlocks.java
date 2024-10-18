package net.justacuriosfox.justsomestuff.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.custom.HopCropBlock;
import net.justacuriosfox.justsomestuff.block.custom.LSDFurnaceBlock;
import net.justacuriosfox.justsomestuff.item.ModItemGroups;
import net.justacuriosfox.justsomestuff.world.tree.AshenSaplingGenerator;
import net.justacuriosfox.justsomestuff.world.tree.MagmaSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    public static final Block HOP_CROP = registerBlockWithoutBlockItem("hop_crop",
            new HopCropBlock(FabricBlockSettings
                    .copyOf(Blocks.WHEAT))
            , ModItemGroups.ALCOHOL);
    public static final Block LSDFURNACE = registerBlock("lsdfurnace",
            new LSDFurnaceBlock(FabricBlockSettings.create()
                    .nonOpaque()
                    .strength(6.0f)
                    .requiresTool())
            , ModItemGroups.ALCOHOL);
    public static final Block WASTEROOT = registerBlock("wasteroot",
            new Block(FabricBlockSettings.create()
                    .requiresTool()
                    .strength(3.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block REAPERCORE = registerBlock("reapercore",
            new Block(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)
                    .requiresTool()
                    .strength(3.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block WASTE_GRASS = registerBlock("wastegrass",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)
                    .requiresTool()
                    .strength(1.5f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block BLOODSTONE = registerBlock("bloodstone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)
                    .requiresTool()
                    .strength(1.0f))


            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block ASHEN_LOG = registerBlock("ashen_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)
                    .strength(4.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block ASHEN_WOOD = registerBlock("ashen_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)
                    .strength(4.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block STRIPPED_ASHEN_LOG = registerBlock("stripped_ashen_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)
                    .strength(4.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block STRIPPED_ASHEN_WOOD = registerBlock("stripped_ashen_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)
                    .strength(4.0f))
            , ModItemGroups.WASTELAND_ITEMS);

    public static final Block ASHEN_PLANKS = registerBlock("ashen_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(4.0f))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block ASHEN_LEAVES = registerBlock("ashen_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)
                    .strength(4.0f)
                    .nonOpaque())
            , ModItemGroups.WASTELAND_ITEMS);

    public static final Block ASHEN_SAPLING = registerBlock("ashen_sapling",
            new SaplingBlock(new AshenSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING))
            , ModItemGroups.WASTELAND_ITEMS);
    public static final Block MAGMA_SAPLING = registerBlock("magma_sapling",
            new SaplingBlock(new MagmaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING))
            , ModItemGroups.WASTELAND_ITEMS);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(JustSomeStuffMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(JustSomeStuffMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        super.appendTooltip(stack, world, tooltip, context);
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.BLOCK, new Identifier(JustSomeStuffMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(JustSomeStuffMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(JustSomeStuffMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        JustSomeStuffMod.LOGGER.info("Registering ModBlocks for " + JustSomeStuffMod.MOD_ID);
    }
}
