package net.justacuriosfox.justsomestuff.world.dimension;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> WASTELAND_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(JustSomeStuffMod.MOD_ID, "wasteland"));
    public static final RegistryKey<World> WASTELAND_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(JustSomeStuffMod.MOD_ID, "wasteland"));
    public static final RegistryKey<DimensionType> WASTELAND_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(JustSomeStuffMod.MOD_ID, "wasteland_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(WASTELAND_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                true, // ultraWarm
                true, // natural
                4.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_NETHER, // infiniburn
                DimensionTypes.THE_NETHER_ID, // effectsLocation
                0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
    
    public static void register() {
        JustSomeStuffMod.LOGGER.debug("Registering Dimensions");

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.BLACKSTONE)
                .destDimID(WASTELAND_KEY.getValue())
                .tintColor(204, 0, 0)
                .lightWithFluid(Fluids.LAVA)
                .onlyLightInOverworld()
                .registerPortal();
    }

}
