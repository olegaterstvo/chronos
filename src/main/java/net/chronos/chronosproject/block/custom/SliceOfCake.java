package net.chronos.chronosproject.block.custom;

import net.chronos.chronosproject.config.ChronosProjectCommonConfigs;
import net.chronos.chronosproject.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class SliceOfCake extends CakeBlock {
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
//    public static final int DEFAULT_COMPARATOR_OUTPUT = SliceOfCake.getComparatorOutput(0);
    protected static final float AABB_OFFSET = 1.0F;
    protected static final float AABB_SIZE_PER_BITE = 2.0F;
    protected static final VoxelShape[] BITES_TO_SHAPE = new VoxelShape[]{Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(3.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(5.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(7.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(9.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(11.0, 0.0, 1.0, 15.0, 8.0, 15.0), Block.box(13.0, 0.0, 1.0, 15.0, 8.0, 15.0)};

    public SliceOfCake(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BITES_TO_SHAPE[state.getValue(BITES)];
    }


    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        Block block;
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        Item item = itemStack.getItem();
        if (itemStack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0 && (block = Block.byItem(item)) instanceof CandleBlock) {
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            world.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0f, 1.0f);
            world.setBlockAndUpdate(pos, CandleCakeBlock.byCandle((CandleBlock) block));
            world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.SUCCESS;
        }
        if (world.isClientSide) {
            if (SliceOfCake.eat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (itemStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return SliceOfCake.eat(world, pos, state, player);
    }

    protected static InteractionResult eat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
//        if (!player.canConsume(false)) {
//            return ActionResult.PASS;
//        }
        player.awardStat(Stats.EAT_CAKE_SLICE);
        player.playSound(ModSounds.EAT_SLICE_OF_CAKE.get(), 1f,1f);
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, ChronosProjectCommonConfigs.CAKE_HUST_DURATION.get(), ChronosProjectCommonConfigs.CAKE_HUST_AMPLIFIER.get()));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, ChronosProjectCommonConfigs.CAKE_SWIFTNESS_DURATION.get(), ChronosProjectCommonConfigs.CAKE_SWIFTNESS_AMPLIFIER.get()));
//        player.getHungerManager().add(2, 0.1f);
        int i = state.getValue(BITES);
        world.gameEvent(player, GameEvent.EAT, pos);
        if (ChronosProjectCommonConfigs.CAKE_IS_CONSUMABLE.get()) {
            if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
        }
        return InteractionResult.SUCCESS;

    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
//        return pLevel.getBlockState(pPos.below()).getMaterial().isSolid();
        return pLevel.getBlockState(pPos.below()).isSolidRender(pLevel, pPos.below());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BITES);
    }
}
