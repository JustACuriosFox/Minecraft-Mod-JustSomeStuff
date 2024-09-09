package net.justacuriosfox.justsomestuff.entity.client;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer BLOODLEACH =
            new EntityModelLayer(new Identifier(JustSomeStuffMod.MOD_ID, "bloodleach"), "main");
}
