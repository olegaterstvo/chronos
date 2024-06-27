package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModItems {

    public static final Item CHRONOS_DYE = registerItem("chronos_dye",
            new Item(new FabricItemSettings()));
    public static final Item PIPSKIY_DYE = registerItem("pipskiy_dye",
            new Item(new FabricItemSettings()));
    public static final Item CHRONOS_UPGRADE_SMITHING_TEMPLATE = registerItem("chronos_upgrade_smithing_template",
            new ModSmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.chronos_upgrade.applies_to"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.chronos_upgrade.ingredients"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.chronos_upgrade"))).formatted(Formatting.GRAY),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.chronos_upgrade.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.chronos_upgrade.additions_slot_description"))),
                    new Identifier("item/empty_slot_pickaxe"),
                    new Identifier("item/empty_slot_chronos_dye")));
    public static final Item CHRONOS_PICKAXE = registerItem("chronos_pickaxe",
            new ModPickaxe(ModToolMaterial.CHRONOS, 2,2f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ChronosProject.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_DYE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(PIPSKIY_DYE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_UPGRADE_SMITHING_TEMPLATE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CHRONOSPROJECT).register(entries -> entries.add(CHRONOS_PICKAXE));

    }

    public static void registerModItems(){
        ChronosProject.LOGGER.debug("Registering Mod Items for" + ChronosProject.MOD_ID);

        addItemsToItemGroup();
    }
}
