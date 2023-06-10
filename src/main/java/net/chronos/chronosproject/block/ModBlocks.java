package net.chronos.chronosproject.block;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.block.custom.ModConcretePowderBlock;
import net.chronos.chronosproject.block.custom.ModStairsBlock;
import net.chronos.chronosproject.block.custom.SliceOfCake;
import net.chronos.chronosproject.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block CHRONOS_CONCRETE = registerBlock("chronos_concrete",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE = registerBlock("pipskiy_concrete",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CHRONOS_CONCRETE_POWDER = registerBlock("chronos_concrete_powder",
            new ModConcretePowderBlock(ModBlocks.CHRONOS_CONCRETE, FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(0.5f).hardness(0.5F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_POWDER = registerBlock("pipskiy_concrete_powder",
            new ModConcretePowderBlock(ModBlocks.PIPSKIY_CONCRETE, FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(0.5f).hardness(0.5F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CHRONOS_CONCRETE_SLAB = registerBlock("chronos_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_SLAB = registerBlock("pipskiy_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);

    public static final Block WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_TERRACOTTA_SLAB = registerBlock("magenta_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_TERRACOTTA_SLAB = registerBlock("light_blue_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_TERRACOTTA_SLAB = registerBlock("lime_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_TERRACOTTA_SLAB = registerBlock("pink_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_TERRACOTTA_SLAB = registerBlock("gray_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_TERRACOTTA_SLAB = registerBlock("cyan_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_TERRACOTTA_SLAB = registerBlock("purple_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_TERRACOTTA_SLAB = registerBlock("blue_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_TERRACOTTA_SLAB = registerBlock("green_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_TERRACOTTA_SLAB = registerBlock("black_terracotta_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);

    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new ModStairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(),FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            new ModStairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            new ModStairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            new ModStairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            new ModStairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            new ModStairsBlock(Blocks.LIME_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            new ModStairsBlock(Blocks.PINK_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            new ModStairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            new ModStairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            new ModStairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            new ModStairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            new ModStairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            new ModStairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            new ModStairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            new ModStairsBlock(Blocks.RED_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            new ModStairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CHRONOS_CONCRETE_STAIRS = registerBlock("chronos_concrete_stairs",
            new ModStairsBlock(ModBlocks.CHRONOS_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_STAIRS = registerBlock("pipskiy_concrete_stairs",
            new ModStairsBlock(ModBlocks.PIPSKIY_CONCRETE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);


    public static final Block WHITE_TERRACOTTA_STAIRS = registerBlock("white_terracotta_stairs",
            new ModStairsBlock(Blocks.WHITE_TERRACOTTA.getDefaultState(),FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_TERRACOTTA_STAIRS = registerBlock("orange_terracotta_stairs",
            new ModStairsBlock(Blocks.ORANGE_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_TERRACOTTA_STAIRS = registerBlock("magenta_terracotta_stairs",
            new ModStairsBlock(Blocks.MAGENTA_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlock("light_blue_terracotta_stairs",
            new ModStairsBlock(Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_TERRACOTTA_STAIRS = registerBlock("yellow_terracotta_stairs",
            new ModStairsBlock(Blocks.YELLOW_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_TERRACOTTA_STAIRS = registerBlock("lime_terracotta_stairs",
            new ModStairsBlock(Blocks.LIME_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_TERRACOTTA_STAIRS = registerBlock("pink_terracotta_stairs",
            new ModStairsBlock(Blocks.PINK_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_TERRACOTTA_STAIRS = registerBlock("gray_terracotta_stairs",
            new ModStairsBlock(Blocks.GRAY_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlock("light_gray_terracotta_stairs",
            new ModStairsBlock(Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_TERRACOTTA_STAIRS = registerBlock("cyan_terracotta_stairs",
            new ModStairsBlock(Blocks.CYAN_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_TERRACOTTA_STAIRS = registerBlock("purple_terracotta_stairs",
            new ModStairsBlock(Blocks.PURPLE_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_TERRACOTTA_STAIRS = registerBlock("blue_terracotta_stairs",
            new ModStairsBlock(Blocks.BLUE_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_TERRACOTTA_STAIRS = registerBlock("brown_terracotta_stairs",
            new ModStairsBlock(Blocks.BROWN_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_TERRACOTTA_STAIRS = registerBlock("green_terracotta_stairs",
            new ModStairsBlock(Blocks.GREEN_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_TERRACOTTA_STAIRS = registerBlock("red_terracotta_stairs",
            new ModStairsBlock(Blocks.RED_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_TERRACOTTA_STAIRS = registerBlock("black_terracotta_stairs",
            new ModStairsBlock(Blocks.BLACK_TERRACOTTA.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25F)), ModItemGroup.CHRONOSPROJECT);

    public static final Block WHITE_CONCRETE_PRESSURE_PLATE = registerBlock("white_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_CONCRETE_PRESSURE_PLATE = registerBlock("orange_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_CONCRETE_PRESSURE_PLATE = registerBlock("magenta_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("light_blue_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_CONCRETE_PRESSURE_PLATE = registerBlock("yellow_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_CONCRETE_PRESSURE_PLATE = registerBlock("lime_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_CONCRETE_PRESSURE_PLATE = registerBlock("pink_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("gray_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_CONCRETE_PRESSURE_PLATE = registerBlock("light_gray_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_CONCRETE_PRESSURE_PLATE = registerBlock("cyan_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_CONCRETE_PRESSURE_PLATE = registerBlock("purple_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_CONCRETE_PRESSURE_PLATE = registerBlock("blue_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_CONCRETE_PRESSURE_PLATE = registerBlock("brown_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_CONCRETE_PRESSURE_PLATE = registerBlock("green_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_CONCRETE_PRESSURE_PLATE = registerBlock("red_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_CONCRETE_PRESSURE_PLATE = registerBlock("black_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CHRONOS_CONCRETE_PRESSURE_PLATE = registerBlock("chronos_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_PRESSURE_PLATE = registerBlock("pipskiy_concrete_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block WHITE_TERRACOTTA_PRESSURE_PLATE = registerBlock("white_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_TERRACOTTA_PRESSURE_PLATE = registerBlock("orange_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_TERRACOTTA_PRESSURE_PLATE = registerBlock("magenta_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_blue_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_TERRACOTTA_PRESSURE_PLATE = registerBlock("yellow_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_TERRACOTTA_PRESSURE_PLATE = registerBlock("lime_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_TERRACOTTA_PRESSURE_PLATE = registerBlock("pink_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("gray_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_gray_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_TERRACOTTA_PRESSURE_PLATE = registerBlock("cyan_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_TERRACOTTA_PRESSURE_PLATE = registerBlock("purple_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("blue_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_TERRACOTTA_PRESSURE_PLATE = registerBlock("brown_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_TERRACOTTA_PRESSURE_PLATE = registerBlock("green_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_TERRACOTTA_PRESSURE_PLATE = registerBlock("red_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_TERRACOTTA_PRESSURE_PLATE = registerBlock("black_terracotta_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);

    public static final Block WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CHRONOS_CONCRETE_WALL = registerBlock("chronos_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_WALL = registerBlock("pipskiy_concrete_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);

    public static final Block WHITE_TERRACOTTA_WALL = registerBlock("white_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block ORANGE_TERRACOTTA_WALL = registerBlock("orange_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block MAGENTA_TERRACOTTA_WALL = registerBlock("magenta_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_BLUE_TERRACOTTA_WALL = registerBlock("light_blue_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block YELLOW_TERRACOTTA_WALL = registerBlock("yellow_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIME_TERRACOTTA_WALL = registerBlock("lime_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PINK_TERRACOTTA_WALL = registerBlock("pink_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GRAY_TERRACOTTA_WALL = registerBlock("gray_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block LIGHT_GRAY_TERRACOTTA_WALL = registerBlock("light_gray_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block CYAN_TERRACOTTA_WALL = registerBlock("cyan_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PURPLE_TERRACOTTA_WALL = registerBlock("purple_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLUE_TERRACOTTA_WALL = registerBlock("blue_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BROWN_TERRACOTTA_WALL = registerBlock("brown_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block GREEN_TERRACOTTA_WALL = registerBlock("green_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block RED_TERRACOTTA_WALL = registerBlock("red_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block BLACK_TERRACOTTA_WALL = registerBlock("black_terracotta_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4.2f).hardness(1.25f)), ModItemGroup.CHRONOSPROJECT);

    public static final Block SLICE_OF_CAKE = registerBlock("slice_of_cake",
            new SliceOfCake(FabricBlockSettings.of(Material.CAKE).strength(2.0f)), ModItemGroup.CHRONOSPROJECT, "tooltip.chronosproject.block.slice_of_cake", 1);



    private static Block registerBlock(String name, Block block, ItemGroup tab, String tooltipKey, Integer stackSize){
        registerBlockItem(name, block, tab, tooltipKey, stackSize);
        return Registry.register(Registry.BLOCK, new Identifier(ChronosProject.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab, String tooltipKey, Integer stackSize){
        Item item = Registry.register(Registry.ITEM, new Identifier(ChronosProject.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab).maxCount(stackSize)){
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }

                });
        return item;
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockitem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(ChronosProject.MOD_ID, name), block);
    }

    private static Item registerBlockitem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(ChronosProject.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks(){
        ChronosProject.LOGGER.debug("Registering ModBlocks for " + ChronosProject.MOD_ID);
    }
}
