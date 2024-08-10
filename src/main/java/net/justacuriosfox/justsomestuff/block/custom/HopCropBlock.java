package net.justacuriosfox.justsomestuff.block.custom;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;

public class HopCropBlock extends CropBlock {
    public HopCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HOPS;
    }
}
