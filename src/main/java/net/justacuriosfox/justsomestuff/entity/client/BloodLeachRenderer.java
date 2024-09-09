package net.justacuriosfox.justsomestuff.entity.client;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.entity.custom.BloodLeachEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BloodLeachRenderer extends MobEntityRenderer<BloodLeachEntity, BloodLeachModel<BloodLeachEntity>> {
    private static final Identifier TEXTURE = new Identifier(JustSomeStuffMod.MOD_ID, "textures/entity/bloodleach.png");

    public BloodLeachRenderer(EntityRendererFactory.Context context) {
        super(context, new BloodLeachModel<>(context.getPart(ModModelLayers.BLOODLEACH)), 0.6f);
    }

    @Override
    public Identifier getTexture(BloodLeachEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BloodLeachEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
            matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
