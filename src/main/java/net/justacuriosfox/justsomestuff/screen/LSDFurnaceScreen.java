package net.justacuriosfox.justsomestuff.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LSDFurnaceScreen extends HandledScreen<LSDFurnaceScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(JustSomeStuffMod.MOD_ID, "textures/gui/lsdfurnace_gui.png");

    public LSDFurnaceScreen(LSDFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 84, y + 22, 176, 14, handler.getScaledProgress(), 36);
        }

        if(handler.hasFuel()) {
            context.drawTexture(TEXTURE, x + 18, y + 33 + 14 - handler.getScaledFuelProgress(), 176,
                    14 - handler.getScaledFuelProgress(), 14, handler.getScaledFuelProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
