package net.justacuriosfox.justsomestuff.datagen;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.block.custom.HopCropBlock;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REAPERCORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WASTEROOT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WASTE_GRASS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTONE);

        //blockStateModelGenerator.registerCrop(ModBlocks.HOP_CROP, HopCropBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerSimpleState(ModBlocks.LSDFURNACE);

        blockStateModelGenerator.registerLog(ModBlocks.ASHEN_LOG).log(ModBlocks.ASHEN_LOG).wood(ModBlocks.ASHEN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ASHEN_LOG).log(ModBlocks.STRIPPED_ASHEN_LOG).wood(ModBlocks.STRIPPED_ASHEN_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASHEN_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASHEN_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ASHEN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BEER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOP_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LSD, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLOOD_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENHANCED_WASTEROOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WASTEROOT_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.WASTEROOT_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WASTEROOT_HANDLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.KARLU_PICKAXE_ITEM, Models.GENERATED);
    }
}
