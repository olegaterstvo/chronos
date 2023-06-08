package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CHRONOS_DYE = registerItem("chronos_dye",
            new Item(new FabricItemSettings().group(ModItemGroup.CHRONOSPROJECT)));
    public static final Item PIPSKIY_DYE = registerItem("pipskiy_dye",
            new Item(new FabricItemSettings().group(ModItemGroup.CHRONOSPROJECT)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ChronosProject.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ChronosProject.LOGGER.debug("Registering Mod Items for" + ChronosProject.MOD_ID);
    }
}
