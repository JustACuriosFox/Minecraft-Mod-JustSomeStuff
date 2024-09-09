package net.justacuriosfox.justsomestuff.item.client;

import net.justacuriosfox.justsomestuff.item.custom.ReapingSwordItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ReapingSwordItemRenderer extends GeoItemRenderer<ReapingSwordItem> {
    public ReapingSwordItemRenderer() {
        super(new ReapingSwordItemModel());
    }
}
