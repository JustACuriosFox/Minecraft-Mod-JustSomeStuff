package net.justacuriosfox.justsomestuff;

import net.fabricmc.api.ModInitializer;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.justacuriosfox.justsomestuff.enchantment.ModEnchantements;
import net.justacuriosfox.justsomestuff.item.ModBeerItem;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.potion.ModPotions;
import net.justacuriosfox.justsomestuff.util.ModRegistries;
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
	}
}
