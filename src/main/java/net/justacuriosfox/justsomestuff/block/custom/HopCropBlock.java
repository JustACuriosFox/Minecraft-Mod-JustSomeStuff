package net.justacuriosfox.justsomestuff.block.custom;

import net.justacuriosfox.justsomestuff.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class HopCropBlock extends CropBlock {
    public HopCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HOPS;
    }
}
