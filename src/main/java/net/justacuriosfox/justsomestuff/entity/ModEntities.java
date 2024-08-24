package net.justacuriosfox.justsomestuff.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.entity.custom.PoliceEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<PoliceEntity> POLICE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(JustSomeStuffMod.MOD_ID, "police"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PoliceEntity::new)
                    .dimensions(EntityDimensions.fixed(.4f, 1.8f)).build());
}
