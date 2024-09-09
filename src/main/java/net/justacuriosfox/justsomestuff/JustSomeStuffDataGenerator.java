package net.justacuriosfox.justsomestuff;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.justacuriosfox.justsomestuff.datagen.ModPoiTagProvider;
import net.justacuriosfox.justsomestuff.datagen.ModWorldGenerator;
import net.justacuriosfox.justsomestuff.world.ModConfiguredFeatures;
import net.justacuriosfox.justsomestuff.world.ModOrePlacement;
import net.justacuriosfox.justsomestuff.world.ModPlacedFeatures;
import net.justacuriosfox.justsomestuff.world.biome.ModBiomes;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JustSomeStuffDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModPoiTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
    }

}
