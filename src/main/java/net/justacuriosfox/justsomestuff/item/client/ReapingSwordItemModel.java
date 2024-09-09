package net.justacuriosfox.justsomestuff.item.client;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.item.custom.ReapingSwordItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ReapingSwordItemModel extends GeoModel<ReapingSwordItem> {

    @Override
    public Identifier getModelResource(ReapingSwordItem animatable) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "geo/reaper_scythe.geo.json");
    }

    @Override
    public Identifier getTextureResource(ReapingSwordItem animatable) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "textures/item/reaper_scythe.png");
    }

    @Override
    public Identifier getAnimationResource(ReapingSwordItem animatable) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "animations/reaper_scythe.animation.json");
    }
}
