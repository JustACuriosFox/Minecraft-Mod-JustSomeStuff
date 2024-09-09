package net.justacuriosfox.justsomestuff.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.entity.custom.BloodLeachEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BloodLeachEntity> BLOOD_LEACH = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JustSomeStuffMod.MOD_ID, "bloodleach"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BloodLeachEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

}
