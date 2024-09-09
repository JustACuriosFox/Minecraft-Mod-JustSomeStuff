package net.justacuriosfox.justsomestuff.item.custom;

import net.justacuriosfox.justsomestuff.item.client.ReapingSwordItemRenderer;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.event.GeoRenderEvent;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReapingSwordItem extends SwordItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public ReapingSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        if (!user.getItemCooldownManager().isCoolingDown(user.getStackInHand(context.getHand()).getItem())) {
            user.playSound(SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, 1f, 1.2f);
            double x = (pos.getX() - user.getX()) * (-1);
            double z = (pos.getZ() - user.getZ()) * (-1);
            double y = Math.min(((user.getPitch() * 0.05) * .75), 1.2);
            double factor = Math.min(Math.sqrt((x*x) + (z*z)) * .6, 2);
            user.addVelocity(x, y * factor, z);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 50, 0, false, false, false));
            user.getItemCooldownManager().set(user.getStackInHand(context.getHand()).getItem(), 50);
        }
        return super.useOnBlock(context);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(user.getStackInHand(hand).getItem())) {
            user.playSound(SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, 1f, .5f);
            double x = entity.getX() - user.getX();
            double z = entity.getZ() - user.getZ();
            double y = Math.min(((user.getPitch() * 0.05) * .75), 1.2);
            double factor = Math.min(Math.sqrt((x*x) + (z*z)) * .6, 2);
            entity.addVelocity(x, y * factor, z);
            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(), 50);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private final ReapingSwordItemRenderer renderer = new ReapingSwordItemRenderer();

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.reaper_scythe.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
