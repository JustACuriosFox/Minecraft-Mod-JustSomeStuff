package net.justacuriosfox.justsomestuff.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCustomTrades();
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.HOPS, 9),
                            8,1,0.02f)));
                });
    }
}
