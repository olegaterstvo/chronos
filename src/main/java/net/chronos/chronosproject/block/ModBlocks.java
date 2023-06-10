package net.chronos.chronosproject.block;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.block.custom.ModConcretePowderBlock;
import net.chronos.chronosproject.block.custom.ModStairsBlock;
import net.chronos.chronosproject.block.custom.SliceOfCake;
import net.chronos.chronosproject.item.ModCreativeModeTab;
import net.chronos.chronosproject.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChronosProject.MOD_ID);


    public static final  RegistryObject<Block> CHRONOS_CONCRETE = registerBlock("chronos_concrete",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final  RegistryObject<Block> PIPSKIY_CONCRETE  = registerBlock("pipskiy_concrete",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<ModConcretePowderBlock> CHRONOS_CONCRETE_POWDER = registerBlock("chronos_concrete_powder",
            () -> new ModConcretePowderBlock(ModBlocks.CHRONOS_CONCRETE.get(), BlockBehaviour.Properties.of(Material.SAND).strength(0.5f).explosionResistance(0.5F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<ModConcretePowderBlock> PIPSKIY_CONCRETE_POWDER = registerBlock("pipskiy_concrete_powder",
            () -> new ModConcretePowderBlock(ModBlocks.PIPSKIY_CONCRETE.get(), BlockBehaviour.Properties.of(Material.SAND).strength(0.5f).explosionResistance(0.5F)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CHRONOS_CONCRETE_SLAB = registerBlock("chronos_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PIPSKIY_CONCRETE_SLAB = registerBlock("pipskiy_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_SLAB = registerBlock("magenta_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlock("light_blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_TERRACOTTA_SLAB = registerBlock("lime_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_TERRACOTTA_SLAB = registerBlock("pink_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_SLAB = registerBlock("gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_SLAB = registerBlock("cyan_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_SLAB = registerBlock("purple_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_SLAB = registerBlock("blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_SLAB = registerBlock("green_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_SLAB = registerBlock("black_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            () -> new ModStairsBlock(Blocks.WHITE_CONCRETE.defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            () -> new ModStairsBlock(Blocks.ORANGE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            () -> new ModStairsBlock(Blocks.MAGENTA_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            () -> new ModStairsBlock(Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            () -> new ModStairsBlock(Blocks.YELLOW_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            () -> new ModStairsBlock(Blocks.LIME_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            () -> new ModStairsBlock(Blocks.PINK_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            () -> new ModStairsBlock(Blocks.GRAY_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            () -> new ModStairsBlock(Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            () -> new ModStairsBlock(Blocks.CYAN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            () -> new ModStairsBlock(Blocks.PURPLE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            () -> new ModStairsBlock(Blocks.BLUE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            () -> new ModStairsBlock(Blocks.BROWN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            () -> new ModStairsBlock(Blocks.GREEN_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            () -> new ModStairsBlock(Blocks.RED_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            () -> new ModStairsBlock(Blocks.BLACK_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CHRONOS_CONCRETE_STAIRS = registerBlock("chronos_concrete_stairs",
            () -> new ModStairsBlock(ModBlocks.CHRONOS_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PIPSKIY_CONCRETE_STAIRS = registerBlock("pipskiy_concrete_stairs",
            () -> new ModStairsBlock(ModBlocks.PIPSKIY_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);


    public static final RegistryObject<Block> WHITE_TERRACOTTA_STAIRS = registerBlock("white_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_STAIRS = registerBlock("orange_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.ORANGE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_STAIRS = registerBlock("magenta_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlock("light_blue_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_STAIRS = registerBlock("yellow_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.YELLOW_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_TERRACOTTA_STAIRS = registerBlock("lime_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.LIME_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_TERRACOTTA_STAIRS = registerBlock("pink_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.PINK_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_STAIRS = registerBlock("gray_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.GRAY_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlock("light_gray_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_STAIRS = registerBlock("cyan_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.CYAN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_STAIRS = registerBlock("purple_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.PURPLE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_STAIRS = registerBlock("blue_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.BLUE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_STAIRS = registerBlock("brown_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.BROWN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_STAIRS = registerBlock("green_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.GREEN_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_TERRACOTTA_STAIRS = registerBlock("red_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.RED_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_STAIRS = registerBlock("black_terracotta_stairs",
            () -> new ModStairsBlock(Blocks.BLACK_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25F)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_CONCRETE_PRESSURE_PLATE = registerBlock("white_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_CONCRETE_PRESSURE_PLATE = registerBlock("orange_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_PRESSURE_PLATE = registerBlock("magenta_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("light_blue_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_CONCRETE_PRESSURE_PLATE = registerBlock("yellow_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_CONCRETE_PRESSURE_PLATE = registerBlock("lime_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_CONCRETE_PRESSURE_PLATE = registerBlock("pink_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("gray_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("light_gray_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_CONCRETE_PRESSURE_PLATE = registerBlock("cyan_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_CONCRETE_PRESSURE_PLATE = registerBlock("purple_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("blue_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_CONCRETE_PRESSURE_PLATE = registerBlock("brown_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_CONCRETE_PRESSURE_PLATE = registerBlock("green_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_CONCRETE_PRESSURE_PLATE = registerBlock("red_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_CONCRETE_PRESSURE_PLATE = registerBlock("black_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CHRONOS_CONCRETE_PRESSURE_PLATE = registerBlock("chronos_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PIPSKIY_CONCRETE_PRESSURE_PLATE = registerBlock("pipskiy_concrete_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(1.8f).explosionResistance(1.8F)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> WHITE_TERRACOTTA_PRESSURE_PLATE = registerBlock("white_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_PRESSURE_PLATE = registerBlock("orange_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_PRESSURE_PLATE = registerBlock("magenta_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_blue_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_PRESSURE_PLATE = registerBlock("yellow_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_TERRACOTTA_PRESSURE_PLATE = registerBlock("lime_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_TERRACOTTA_PRESSURE_PLATE = registerBlock("pink_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("gray_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_gray_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_PRESSURE_PLATE = registerBlock("cyan_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_PRESSURE_PLATE = registerBlock("purple_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("blue_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_PRESSURE_PLATE = registerBlock("brown_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_PRESSURE_PLATE = registerBlock("green_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_TERRACOTTA_PRESSURE_PLATE = registerBlock("red_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_PRESSURE_PLATE = registerBlock("black_terracotta_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CHRONOS_CONCRETE_WALL = registerBlock("chronos_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PIPSKIY_CONCRETE_WALL = registerBlock("pipskiy_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);

    public static final RegistryObject<Block> WHITE_TERRACOTTA_WALL = registerBlock("white_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_WALL = registerBlock("orange_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_WALL = registerBlock("magenta_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_WALL = registerBlock("light_blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_WALL = registerBlock("yellow_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIME_TERRACOTTA_WALL = registerBlock("lime_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PINK_TERRACOTTA_WALL = registerBlock("pink_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_WALL = registerBlock("gray_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_WALL = registerBlock("light_gray_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_WALL = registerBlock("cyan_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_WALL = registerBlock("purple_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_WALL = registerBlock("blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_WALL = registerBlock("brown_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_WALL = registerBlock("green_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> RED_TERRACOTTA_WALL = registerBlock("red_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_WALL = registerBlock("black_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.2f).explosionResistance(1.25f)), ModCreativeModeTab.CHRONOS_TAB);


    public static final RegistryObject<Block> SLICE_OF_CAKE = registerBlock("slice_of_cake",
            () -> new SliceOfCake(BlockBehaviour.Properties.of(Material.CAKE).strength(2.0F)), ModCreativeModeTab.CHRONOS_TAB, "tooltip.chronosproject.block.slice_of_cake", 1);






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipKey, Integer stackSize){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey, stackSize);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey, Integer stackSize){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).stacksTo(stackSize)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
