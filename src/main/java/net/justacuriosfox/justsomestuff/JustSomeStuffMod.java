package net.justacuriosfox.justsomestuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.justacuriosfox.justsomestuff.enchantment.ModEnchantements;
import net.justacuriosfox.justsomestuff.entity.ModEntities;
import net.justacuriosfox.justsomestuff.entity.custom.BloodLeachEntity;
import net.justacuriosfox.justsomestuff.item.ModItemGroups;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.potion.ModPotions;
import net.justacuriosfox.justsomestuff.screen.ModScreenHandlers;
import net.justacuriosfox.justsomestuff.util.ModRegistries;
import net.justacuriosfox.justsomestuff.villager.ModVillagers;
import net.justacuriosfox.justsomestuff.world.biome.ModBiomes;
import net.justacuriosfox.justsomestuff.world.dimension.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustSomeStuffMod implements ModInitializer {
	public static final String MOD_ID = "justsomestuff";
	public static final Logger LOGGER = LoggerFactory.getLogger("justsomestuff");

	@Override
	public void onInitialize() {
		LOGGER.info(JustSomeStuffMod.MOD_ID + " loading");
		LOGGER.info("registering stuff");
		ModItems.registerModItems();
		ModEffects.registerEffects();
		ModRegistries.registerModStuffs();
		ModPotions.registerPotions();
		ModEnchantements.registerModEnchantments();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModVillagers.registerVillagers();
		ModScreenHandlers.registerAllScreenHandlers();
		ModDimensions.register();
		FabricDefaultAttributeRegistry.register(ModEntities.BLOOD_LEACH, BloodLeachEntity.createBloodLeachAttributes());

		StrippableBlockRegistry.register(ModBlocks.ASHEN_LOG, ModBlocks.STRIPPED_ASHEN_LOG);
		StrippableBlockRegistry.register(ModBlocks.ASHEN_WOOD, ModBlocks.STRIPPED_ASHEN_WOOD);
	}
}
