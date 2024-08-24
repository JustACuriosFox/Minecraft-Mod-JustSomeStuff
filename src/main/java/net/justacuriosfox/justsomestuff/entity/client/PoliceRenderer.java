package net.justacuriosfox.justsomestuff.entity.client;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.entity.custom.PoliceEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PoliceRenderer extends GeoEntityRenderer<PoliceEntity> {
    public PoliceRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PoliceModel());
    }

    @Override
    public Identifier getTextureLocation(PoliceEntity instance) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "textures/entity/police/police.png");
    }
}
