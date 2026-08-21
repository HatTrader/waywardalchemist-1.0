package hat.waywardalchemist.block;

import com.mojang.serialization.MapCodec;
import hat.waywardalchemist.block.entity.BoilingBrewerBlockEntity;
import hat.waywardalchemist.block.entity.WaywardAlchemistBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

public class BoilingBrewerBlock extends BlockWithEntity {
    public static final MapCodec<hat.waywardalchemist.block.BoilingBrewerBlock> CODEC = createCodec(hat.waywardalchemist.block.BoilingBrewerBlock::new);
    public static final BooleanProperty[] BOTTLE_PROPERTIES;
    private static final VoxelShape SHAPE;

    public MapCodec<hat.waywardalchemist.block.BoilingBrewerBlock> getCodec() {
        return CODEC;
    }

    public BoilingBrewerBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BOTTLE_PROPERTIES[0], false)).with(BOTTLE_PROPERTIES[1], false)).with(BOTTLE_PROPERTIES[2], false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoilingBrewerBlockEntity(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient() ? null : validateTicker(type, WaywardAlchemistBlockEntities.BOILING_BREWER_BE , BoilingBrewerBlockEntity::tick);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity wa1 = world.getBlockEntity(pos);
            if (wa1 instanceof BoilingBrewerBlockEntity) {
                BoilingBrewerBlockEntity boilingBrewerBlockEntity = (BoilingBrewerBlockEntity) wa1;
                player.openHandledScreen(boilingBrewerBlockEntity);
            }
        }

        return ActionResult.SUCCESS;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.4 + (double)random.nextFloat() * 0.2;
        double e = (double)pos.getY() + 0.7 + (double)random.nextFloat() * 0.3;
        double f = (double)pos.getZ() + 0.4 + (double)random.nextFloat() * 0.2;
        world.addParticleClient(ParticleTypes.COPPER_FIRE_FLAME, d, e, f, 0.0, 0.0, 0.0);
    }

    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        ItemScatterer.onStateReplaced(state, world, pos);
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BOTTLE_PROPERTIES[0], BOTTLE_PROPERTIES[1], BOTTLE_PROPERTIES[2]});
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        BOTTLE_PROPERTIES = new BooleanProperty[]{Properties.HAS_BOTTLE_0, Properties.HAS_BOTTLE_1, Properties.HAS_BOTTLE_2};
        SHAPE = VoxelShapes.union(Block.createColumnShape(2.0, 2.0, 14.0), Block.createColumnShape(14.0, 0.0, 2.0));
    }
}

