package net.justacuriosfox.justsomestuff.world;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WASTEROOT_KEY = registerKey("wasteroot_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOODSTONE_KEY = registerKey("bloodstone_ore");

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

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(JustSomeStuffMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
