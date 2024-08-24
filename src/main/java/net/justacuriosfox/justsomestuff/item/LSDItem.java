package net.justacuriosfox.justsomestuff.item;

import net.justacuriosfox.justsomestuff.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LSDItem extends Item {
    public LSDItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.addStatusEffect(new StatusEffectInstance(ModEffects.HIGH_LSD, 180 * 20, 1));

        if (!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
        }

        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        entity.addStatusEffect(new StatusEffectInstance(ModEffects.HIGH_LSD, 180 * 20, 1));

        if (!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
        }

        return super.useOnEntity(stack, user, entity, hand);
    }
}
