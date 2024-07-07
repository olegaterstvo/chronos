package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModItems {

    public static final Item CHRONOS_DYE = registerItem("chronos_dye",
            new Item(new Item.Settings()));
    public static final Item PIPSKIY_DYE = registerItem("pipskiy_dye",
            new Item(new Item.Settings()));
    public static final Item CHRONOS_UPGRADE_SMITHING_TEMPLATE = registerItem("chronos_upgrade_smithing_template",
            new ModSmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.chronos_upgrade.applies_to"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.chronos_upgrade.ingredients"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.chronos_upgrade"))).formatted(Formatting.GRAY),
                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.chronos_upgrade.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.chronos_upgrade.additions_slot_description"))),
                    Identifier.of("item/empty_slot_pickaxe"),
                    Identifier.of("item/empty_slot_chronos_dye")));
    public static final Item CHRONOS_PICKAXE = registerItem("chronos_pickaxe",
            new ModPickaxe(ModToolMaterial.CHRONOS, new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ChronosProject.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_DYE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(PIPSKIY_DYE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_UPGRADE_SMITHING_TEMPLATE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_PICKAXE));

    }

    public static void registerModItems(){
        ChronosProject.LOGGER.info("Registering Mod Items for" + ChronosProject.MOD_ID);

        addItemsToItemGroup();
    }
}
