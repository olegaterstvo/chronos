package net.chronos.chronosproject.block;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.block.custom.ModConcretePowderBlock;
import net.chronos.chronosproject.block.custom.ModStairsBlock;
import net.chronos.chronosproject.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
