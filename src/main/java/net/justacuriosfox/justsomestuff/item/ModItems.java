package net.justacuriosfox.justsomestuff.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.item.custom.ReapingSwordItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final ReapingSwordItem REAPING_SWORD = (ReapingSwordItem) registerItem("reaping_sword",
            new ReapingSwordItem(ToolMaterials.NETHERITE, 5, -2.4F, new FabricItemSettings()
                    .maxCount(1)
                    .fireproof()
            ));
    public static final ReapingSwordItem REAPING_SWORD_UPGRADE = (ReapingSwordItem) registerItem("reaping_sword_upgrade",
            new ReapingSwordItem(ToolMaterials.DIAMOND, 16, -2.4F, new FabricItemSettings()
                    .maxCount(1)
            ));
    public static final Item HOP_JUICE = registerItem("hop_juice",
            new Item(new FabricItemSettings()
            ));
    public static final Item HOPS = registerItem("hops",
            new AliasedBlockItem(ModBlocks.HOP_CROP, new FabricItemSettings()
            ));
    public static final Item WASTEROOT_ITEM = registerItem("wasteroot_item",
            new Item(new FabricItemSettings()
            ));
    public static final Item ENHANCED_WASTEROOT = registerItem("enhanced_wasteroot",
            new Item(new FabricItemSettings()
            ));
    public static final Item BLOOD_ORB = registerItem("blood_orb",
            new Item(new FabricItemSettings()
            ));
    public static final Item WASTEROOT_HANDLE = registerItem("wasteroot_handle",
            new Item(new FabricItemSettings()
            ));
    public static final Item WASTEROOT_BLADE = registerItem("wasteroot_blade",
            new Item(new FabricItemSettings()
            ));
    public static final Item BEER = registerItem("beer",
            new ModBeerItem(new FabricItemSettings()
                    .maxCount(1)
            ));
    public static final Item LSD = registerItem("lsd",
            new LSDItem(new FabricItemSettings()
                    .maxCount(64)
            ));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JustSomeStuffMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JustSomeStuffMod.LOGGER.info("Registering Mod Items for " + JustSomeStuffMod.MOD_ID);
    }
}
