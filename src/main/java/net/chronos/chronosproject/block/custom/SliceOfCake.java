package net.chronos.chronosproject.block.custom;

import net.chronos.chronosproject.config.ModConfigs;
import net.chronos.chronosproject.sound.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CandleBlock;
import net.minecraft.block.CandleCakeBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class SliceOfCake extends Block {
    public static final int MAX_BITES = 6;
    public static final IntProperty BITES = Properties.BITES;
    public static final int DEFAULT_COMPARATOR_OUTPUT = SliceOfCake.getComparatorOutput(0);
    protected static final float field_31047 = 1.0f;
    protected static final float field_31048 = 2.0f;
    protected static final VoxelShape[] BITES_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(3.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(5.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(7.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(9.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(11.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.createCuboidShape(13.0, 0.0, 1.0, 15.0, 8.0, 15.0)};

    public SliceOfCake(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[state.get(BITES)];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Block block;
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (itemStack.isIn(ItemTags.CANDLES) && state.get(BITES) == 0 && (block = Block.getBlockFromItem(item)) instanceof CandleBlock) {
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            world.playSound(null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(pos, CandleCakeBlock.getCandleCakeFromCandle(block));
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_CHANGE, pos);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ActionResult.SUCCESS;
        }
        if (world.isClient) {
            if (SliceOfCake.tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }
            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return SliceOfCake.tryEat(world, pos, state, player);
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
//        if (!player.canConsume(false)) {
//            return ActionResult.PASS;
//        }
        player.incrementStat(Stats.EAT_CAKE_SLICE);
        player.playSound(ModSounds.EAT_SLICE_OF_CAKE, 1f,1f);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, ModConfigs.CAKE_HUST_DURATION, ModConfigs.CAKE_HUST_AMPLIFIER));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, ModConfigs.CAKE_SWIFTNESS_DURATION, ModConfigs.CAKE_SWIFTNESS_AMPLIFIER));
//        player.getHungerManager().add(2, 0.1f);
        int i = state.get(BITES);
        world.emitGameEvent((Entity)player, GameEvent.EAT, pos);
        if (ModConfigs.CAKE_IS_CONSUMABLE) {
            if (i < 6) {
                world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), Block.NOTIFY_ALL);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent((Entity) player, GameEvent.BLOCK_DESTROY, pos);
            }
        }
        return ActionResult.SUCCESS;

    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return SliceOfCake.getComparatorOutput(state.get(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (7 - bites) * 2;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
