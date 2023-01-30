package net.chronos.chronosproject.block;

import net.chronos.chronosproject.ChronosProject;
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
            new FallingBlock(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(0.5f).hardness(0.5F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE_POWDER = registerBlock("pipskiy_concrete_powder",
            new FallingBlock(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(0.5f).hardness(0.5F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new ModStairsBlock(ModBlocks.CHRONOS_CONCRETE.getDefaultState(),FabricBlockSettings.of(Material.STONE).strength(1.8f).hardness(1.8F)), ModItemGroup.CHRONOSPROJECT);




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
