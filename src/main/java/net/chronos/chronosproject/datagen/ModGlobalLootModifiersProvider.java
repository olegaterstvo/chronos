package net.chronos.chronosproject.datagen;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ChronosProject.MOD_ID);
    }

    @Override
    protected void start() {
        add("chronos_upgrade_smithing_template_from_abandoned_mineshaft", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.03f).build()},
                ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("chronos_upgrade_smithing_template_from_ancient_city", new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(),
                    LootItemRandomChanceCondition.randomChance(0.15f).build()},
                ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("chronos_upgrade_smithing_template_from_bastion_treasure", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.07f).build()},
                ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("chronos_upgrade_smithing_template_from_end_city_treasure", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()},
                ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE.get()
        ));

    }
}
