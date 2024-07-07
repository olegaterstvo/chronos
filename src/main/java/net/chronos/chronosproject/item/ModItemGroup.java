package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
//import net.chronos.chronosproject.block.ModBlocks;
//import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
//import net.minecraft.registry.RegistryKeys;
//import net.minecraft.util.Identifier;
//import net.minecraft.text.Text;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

//public class ModItemGroup {
//    public static final RegistryKey<ItemGroup> CHRONOSPROJECT = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ChronosProject.MOD_ID, "chronosproject"));
//
//    public static void registerItemGroups() {
//        Registry.register(Registries.ITEM_GROUP, CHRONOSPROJECT, FabricItemGroup.builder()
//                .icon(() -> new ItemStack(ModBlocks.SLICE_OF_CAKE))
//                .displayName(Text.literal("Chronos Project"))
//                .build()); // build() no longer registers by itself
//    }
//}

public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChronosProject.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHRONOSPROJECT =
        CREATIVE_TABS.register("chronosproject",
                () -> {
                    CreativeModeTab.Builder builder = CreativeModeTab.builder();
                    builder.displayItems((parameters, output) -> {
                        Set<Item> addedItems = new HashSet<>();

                        ModItems.ITEMS.getEntries()
                                .stream()
                                .map((item) -> item.get().asItem())
                                .filter(addedItems::add)
                                .forEach(output::accept);
                    });

                    builder.icon(() -> new ItemStack(ModItems.CHRONOS_DYE.get()));
                    builder.title(Component.translatable("itemGroup.chronosproject.chronosproject"));

                    return builder.build();
                });

    public static void register(IEventBus eventBus){
        CREATIVE_TABS.register(eventBus);
    }
}
