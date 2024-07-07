package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.Util;
import java.util.function.Supplier;
import net.minecraft.ChatFormatting;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ChronosProject.MOD_ID);

    public static final DeferredItem<Item> CHRONOS_DYE = registerItem("chronos_dye",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PIPSKIY_DYE = registerItem("pipskiy_dye",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHRONOS_UPGRADE_SMITHING_TEMPLATE = registerItem("chronos_upgrade_smithing_template",
            () -> new ModSmithingTemplateItem(
                    Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.chronos_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.chronos_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.chronos_upgrade"))).withStyle(ChatFormatting.GRAY),
                    Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.chronos_upgrade.base_slot_description"))),
                    Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.chronos_upgrade.additions_slot_description"))),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                    ResourceLocation.withDefaultNamespace("item/empty_slot_chronos_dye")
                ));


    public static final Supplier<PickaxeItem> CHRONOS_PICKAXE = ITEMS.register("chronos_pickaxe", () -> new ModPickaxe(
            // The tier to use.
            ModTier.CHRONOS_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    PickaxeItem.createAttributes(
                            // The tier to use.
                            ModTier.CHRONOS_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.8f
                    )
            )
    ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    private static <T extends Item> DeferredItem<Item> registerItem(String name, Supplier<T> item){
        return ITEMS.register(name, item);
    }

}
