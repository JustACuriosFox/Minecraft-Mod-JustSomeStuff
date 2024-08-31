package net.justacuriosfox.justsomestuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<LSDFurnaceBlockEntity> LSDFURNACE;

    public static void registerAllBlockEntities() {
        LSDFURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(JustSomeStuffMod.MOD_ID, "lsdfurnace"),
                FabricBlockEntityTypeBuilder.create(LSDFurnaceBlockEntity::new,
                        ModBlocks.LSDFURNACE).build(null));
    }
}
