package net.justacuriosfox.justsomestuff.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DrunkHudOverlay implements HudRenderCallback {
    private static final Identifier DRUNK_TEXTURE = new Identifier(JustSomeStuffMod.MOD_ID,
            "textures/drunk/drunk.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width /2;
            y = height;
        }



        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderTexture(0, DRUNK_TEXTURE);
        RenderSystem.setShaderColor(((float) Math.random()), ((float) Math.random()), ((float) Math.random()), ((float) Math.random()));
        if (MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.HIGH_LSD)){
            DrawableHelper.drawTexture(matrixStack, ((int) (0 + (Math.random() * 10))) * (-1),
                    ((int) (0 + (Math.random() * 10))) * (-1),
                    0,0,
                    1000,500,
                    700,400);
        }
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}
