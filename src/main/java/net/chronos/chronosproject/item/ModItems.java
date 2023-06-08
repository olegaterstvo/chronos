package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChronosProject.MOD_ID);

    public static final RegistryObject<Item> CHRONOS_DYE = ITEMS.register("chronos_dye",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHRONOS_TAB)));
    public static final RegistryObject<Item> PIPSKIY_DYE = ITEMS.register("pipskiy_dye",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHRONOS_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
