package net.justacuriosfox.justsomestuff.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

import java.util.Arrays;
import java.util.List;

public class KarluPickaxeItem extends PickaxeItem {
    public KarluPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Block[] glass_blocks = {
                Blocks.GLASS,
                Blocks.GRAY_STAINED_GLASS,
                Blocks.BLACK_STAINED_GLASS,
                Blocks.GREEN_STAINED_GLASS,
                Blocks.BLUE_STAINED_GLASS,
                Blocks.BROWN_STAINED_GLASS,
                Blocks.CYAN_STAINED_GLASS,
                Blocks.LIGHT_BLUE_STAINED_GLASS,
                Blocks.LIGHT_GRAY_STAINED_GLASS,
                Blocks.LIME_STAINED_GLASS,
                Blocks.MAGENTA_STAINED_GLASS,
                Blocks.ORANGE_STAINED_GLASS,
                Blocks.PINK_STAINED_GLASS,
                Blocks.RED_STAINED_GLASS,
                Blocks.WHITE_STAINED_GLASS,
                Blocks.YELLOW_STAINED_GLASS,
                Blocks.TINTED_GLASS,

                Blocks.GLASS_PANE,
                Blocks.GRAY_STAINED_GLASS_PANE,
                Blocks.BLACK_STAINED_GLASS_PANE,
                Blocks.GREEN_STAINED_GLASS_PANE,
                Blocks.BLUE_STAINED_GLASS_PANE,
                Blocks.BROWN_STAINED_GLASS_PANE,
                Blocks.CYAN_STAINED_GLASS_PANE,
                Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
                Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,
                Blocks.LIME_STAINED_GLASS_PANE,
                Blocks.MAGENTA_STAINED_GLASS_PANE,
                Blocks.ORANGE_STAINED_GLASS_PANE,
                Blocks.PINK_STAINED_GLASS_PANE,
                Blocks.RED_STAINED_GLASS_PANE,
                Blocks.WHITE_STAINED_GLASS_PANE,
                Blocks.YELLOW_STAINED_GLASS_PANE,
                };

        List<Block> glass_block_list = Arrays.asList(glass_blocks);
        Block block = context.getWorld().getBlockState(context.getBlockPos()).getBlock();
        if (!context.getWorld().isClient())
        {
            if (glass_block_list.contains(block)){
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });
                context.getPlayer().dropItem(block.asItem());
                context.getWorld().setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
            }
        }
        if (glass_block_list.contains(block))
        {
            context.getPlayer().playSound(SoundEvents.BLOCK_GLASS_BREAK, 1, 1);
        }
        return super.useOnBlock(context);
    }
}
