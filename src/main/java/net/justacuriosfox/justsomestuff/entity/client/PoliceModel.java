package net.justacuriosfox.justsomestuff.entity.client;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.justacuriosfox.justsomestuff.entity.custom.PoliceEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PoliceModel extends AnimatedGeoModel<PoliceEntity> {
    @Override
    public Identifier getModelLocation(PoliceEntity object) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "geo/police.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PoliceEntity object) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "textures/entity/police/police.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PoliceEntity animatable) {
        return new Identifier(JustSomeStuffMod.MOD_ID, "animations/police.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(PoliceEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        IBone nose = this.getAnimationProcessor().getBone("nose");
        IBone headwear = this.getAnimationProcessor().getBone("headwear");
        IBone headwear2 = this.getAnimationProcessor().getBone("headwear2");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
        if (nose != null) {
            nose.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
        if (headwear != null) {
            headwear.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
        if (headwear2 != null) {
            headwear2.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
