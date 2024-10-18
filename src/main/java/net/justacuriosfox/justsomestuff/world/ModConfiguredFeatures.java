package net.justacuriosfox.justsomestuff.world;

import com.mojang.datafixers.util.Either;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WASTEROOT_KEY = registerKey("wasteroot_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOODSTONE_KEY = registerKey("bloodstone_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHENTREE_KEY = registerKey("ashentree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAGMA_TREE_KEY = registerKey("magma_tree");

    public  static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> wastelandWasteroot =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.WASTEROOT.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.WASTEROOT.getDefaultState()));

        register(context, WASTEROOT_KEY, Feature.ORE, new OreFeatureConfig(wastelandWasteroot, 10));

        List<OreFeatureConfig.Target> wastelandBloodstone =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BLOODSTONE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BLOODSTONE.getDefaultState()));

        register(context, BLOODSTONE_KEY, Feature.ORE, new OreFeatureConfig(wastelandBloodstone, 10));


        register(context, ASHENTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASHEN_LOG),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(ModBlocks.ASHEN_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1,0,2)).build());

        register(context, MAGMA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.TARGET),
                new ForkingTrunkPlacer(2, 1, 3),

                BlockStateProvider.of(Blocks.BLUE_WOOL),
                new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1,0,2)).build());
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(JustSomeStuffMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
