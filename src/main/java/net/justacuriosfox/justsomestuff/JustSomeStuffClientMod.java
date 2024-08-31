package net.justacuriosfox.justsomestuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.justacuriosfox.justsomestuff.block.ModBlocks;
import net.justacuriosfox.justsomestuff.client.DrunkHudOverlay;
import net.justacuriosfox.justsomestuff.entity.ModEntities;
import net.justacuriosfox.justsomestuff.entity.client.PoliceRenderer;
import net.justacuriosfox.justsomestuff.screen.LSDFurnaceScreen;
import net.justacuriosfox.justsomestuff.screen.LSDFurnaceScreenHandler;
import net.justacuriosfox.justsomestuff.screen.ModScreenHandlers;
import net.minecraft.client.render.RenderLayer;

public class JustSomeStuffClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOP_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LSDFURNACE, RenderLayer.getCutout());

        HudRenderCallback.EVENT.register(new DrunkHudOverlay());

        EntityRendererRegistry.register(ModEntities.POLICE, PoliceRenderer::new);

        ScreenRegistry.register(ModScreenHandlers.LSDFURNACE_SCREEN_HANDLER, LSDFurnaceScreen::new);
    }
}
