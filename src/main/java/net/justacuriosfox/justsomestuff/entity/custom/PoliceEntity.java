package net.justacuriosfox.justsomestuff.entity.custom;

import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.function.Predicate;

public class PoliceEntity extends PassiveEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public PoliceEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0);
    }

    private class TargetLSDGoal extends ActiveTargetGoal {

        public TargetLSDGoal(MobEntity mob, Class targetClass, boolean checkVisibility) {
            super(mob, targetClass, checkVisibility);
        }

        @Override
        public boolean canStart() {
            if (this.reciprocalChance > 0 && this.mob.getRandom().nextInt(this.reciprocalChance) != 0) {
                return false;
            } else {
                this.findClosestTarget();
                return this.targetEntity != null;
            }
        }

        @Override
        protected void findClosestTarget() {
            PlayerEntity nearestPlayer = this.mob.world.getClosestPlayer(this.mob, 12);
            if (nearestPlayer.hasStatusEffect(ModEffects.HIGH_LSD)) {
                this.targetEntity = nearestPlayer;
            } else {
                this.targetEntity = null;
            }
            super.findClosestTarget();
        }
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AttackGoal(this));
        this.targetSelector.add(1, new TargetLSDGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 12f));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1f, 50));
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.isAttacking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.attack", true));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
