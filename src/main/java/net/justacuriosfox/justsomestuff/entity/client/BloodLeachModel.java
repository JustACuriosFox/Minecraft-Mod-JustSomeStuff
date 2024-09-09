// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.justacuriosfox.justsomestuff.entity.client;

import net.justacuriosfox.justsomestuff.entity.custom.BloodLeachEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class BloodLeachModel<T extends BloodLeachEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bloodleach;

    public BloodLeachModel(ModelPart root) {
		this.bloodleach = root.getChild("bloodleach");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bloodleach = modelPartData.addChild("bloodleach", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body1 = bloodleach.addChild("body1", ModelPartBuilder.create().uv(12, 7).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -7.0F));

		ModelPartData body2 = bloodleach.addChild("body2", ModelPartBuilder.create().uv(10, 11).cuboid(-2.0F, 0.5F, -1.0F, 4.0F, 2.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -5.0F));

		ModelPartData body3 = bloodleach.addChild("body3", ModelPartBuilder.create().uv(1, 0).cuboid(-2.0F, 1.0F, -1.5F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -2.5F));

		ModelPartData body4 = bloodleach.addChild("body4", ModelPartBuilder.create().uv(0, 7).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.5F));

		ModelPartData body5 = bloodleach.addChild("body5", ModelPartBuilder.create().uv(0, 13).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 3.5F));

		ModelPartData body6 = bloodleach.addChild("body6", ModelPartBuilder.create().uv(15, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 6.0F));

		ModelPartData body7 = bloodleach.addChild("body7", ModelPartBuilder.create().uv(8, 16).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 8.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(BloodLeachEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bloodleach.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bloodleach;
	}
}