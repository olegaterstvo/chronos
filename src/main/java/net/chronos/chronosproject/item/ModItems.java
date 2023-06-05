package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHRONOS_DYE = registerItem("chronos_dye",
            new Item(new FabricItemSettings()));
    public static final Item PIPSKIY_DYE = registerItem("pipskiy_dye",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ChronosProject.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_DYE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(PIPSKIY_DYE));

    }

    public static void registerModItems(){
        ChronosProject.LOGGER.debug("Registering Mod Items for" + ChronosProject.MOD_ID);

        addItemsToItemGroup();
    }
}
