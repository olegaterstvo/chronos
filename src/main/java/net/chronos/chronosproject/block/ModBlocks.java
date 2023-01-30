package net.chronos.chronosproject.block;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block CHRONOS_CONCRETE = registerBlock("chronos_concrete",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f)), ModItemGroup.CHRONOSPROJECT);
    public static final Block PIPSKIY_CONCRETE = registerBlock("pipskiy_concrete",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f)), ModItemGroup.CHRONOSPROJECT);


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
