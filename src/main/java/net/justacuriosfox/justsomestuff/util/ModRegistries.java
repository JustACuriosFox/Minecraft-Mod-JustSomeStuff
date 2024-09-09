package net.justacuriosfox.justsomestuff.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.justacuriosfox.justsomestuff.enchantment.ModEnchantements;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.justacuriosfox.justsomestuff.villager.ModVillagers;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCustomTrades();
        registerAttributes();
    }

    private static void registerAttributes() {

    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.HOPS, 9),
                            8,1,0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.REAPER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 47),
                            new ItemStack(Items.END_CRYSTAL, 2),
                            8,1,0.02f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.NETHERITE_INGOT, 1),
                            new ItemStack(Items.EMERALD, 96),
                            3, 3, 0.02f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.REAPER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 24),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantements.PULL, 1)),
                            4, 2, 0.02f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantements.YEET, 1)),
                            4,2,0.02f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.REAPER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 48),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantements.LIFESTEAL, 1)),
                            4,3,0.02f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantements.AFFECTING, 1)),
                            1,3,0.02f));
                });
    }


}
