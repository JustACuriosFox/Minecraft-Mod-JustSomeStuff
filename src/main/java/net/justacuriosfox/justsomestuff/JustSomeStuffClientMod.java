package net.justacuriosfox.justsomestuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class JustSomeStuffClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOP_CROP, RenderLayer.getCutout());
    }
}
