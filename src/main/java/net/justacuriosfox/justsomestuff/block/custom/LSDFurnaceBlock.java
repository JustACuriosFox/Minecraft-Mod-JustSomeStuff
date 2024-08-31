package net.justacuriosfox.justsomestuff.block.custom;

import net.justacuriosfox.justsomestuff.block.entity.LSDFurnaceBlockEntity;
import net.justacuriosfox.justsomestuff.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class LSDFurnaceBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public LSDFurnaceBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Stream.of(
                    Block.createCuboidShape(2, 0, 0, 14, 2, 14),
                    Block.createCuboidShape(0, 0, 0, 2, 14, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 14, 16),
                    Block.createCuboidShape(2, 0, 14, 14, 14, 16),
                    Block.createCuboidShape(2, 12, 0, 14, 14, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(2, 3, 1, 14, 3.25, 14),
                    Block.createCuboidShape(2, 5, 1, 14, 5.25, 14),
                    Block.createCuboidShape(2, 7, 1, 14, 7.25, 14),
                    Block.createCuboidShape(2, 9, 1, 14, 9.25, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(1.5, 1.5, 0.5, 14.5, 12.5, 0.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Stream.of(
                    Block.createCuboidShape(2, 0, 2, 16, 2, 14),
                    Block.createCuboidShape(0, 0, 0, 16, 14, 2),
                    Block.createCuboidShape(0, 0, 14, 16, 14, 16),
                    Block.createCuboidShape(0, 0, 2, 2, 14, 14),
                    Block.createCuboidShape(2, 12, 2, 16, 14, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(2, 3, 2, 15, 3.25, 14),
                    Block.createCuboidShape(2, 5, 2, 15, 5.25, 14),
                    Block.createCuboidShape(2, 7, 2, 15, 7.25, 14),
                    Block.createCuboidShape(2, 9, 2, 15, 9.25, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
                    Block.createCuboidShape(15.5, 1.5, 1.5, 15.5, 12.5, 14.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Stream.of(
                    Block.createCuboidShape(2, 0, 2, 14, 2, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 14, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 14, 16),
                    Block.createCuboidShape(2, 0, 0, 14, 14, 2),
                    Block.createCuboidShape(2, 12, 2, 14, 14, 16)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(2, 3, 2, 14, 3.25, 15),
                    Block.createCuboidShape(2, 5, 2, 14, 5.25, 15),
                    Block.createCuboidShape(2, 7, 2, 14, 7.25, 15),
                    Block.createCuboidShape(2, 9, 2, 14, 9.25, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
                    Block.createCuboidShape(1.5, 1.5, 15.5, 14.5, 12.5, 15.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Stream.of(
                    Block.createCuboidShape(0, 0, 2, 14, 2, 14),
                    Block.createCuboidShape(0, 0, 14, 16, 14, 16),
                    Block.createCuboidShape(0, 0, 0, 16, 14, 2),
                    Block.createCuboidShape(14, 0, 2, 16, 14, 14),
                    Block.createCuboidShape(0, 12, 2, 14, 14, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(1, 3, 2, 14, 3.25, 14),
                    Block.createCuboidShape(1, 5, 2, 14, 5.25, 14),
                    Block.createCuboidShape(1, 7, 2, 14, 7.25, 14),
                    Block.createCuboidShape(1, 9, 2, 14, 9.25, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
                    Block.createCuboidShape(0.5, 1.5, 1.5, 0.5, 12.5, 14.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof LSDFurnaceBlockEntity) {
                ItemScatterer.spawn(world, pos, (LSDFurnaceBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LSDFurnaceBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.LSDFURNACE, LSDFurnaceBlockEntity::tick);
    }
}
