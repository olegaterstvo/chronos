package net.chronos.chronosproject.util;

import net.chronos.chronosproject.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ABANDONED_MINESHAFT_ID =
            Identifier.of("minecraft","chests/abandoned_mineshaft");
    private static final Identifier ANCIENT_CITY_ID =
            Identifier.of("minecraft","chests/ancient_city");
    private static final Identifier END_CITY_TREASURE_ID =
            Identifier.of("minecraft","chests/end_city_treasure");
    private static final Identifier BASTION_TREASURE_ID =
            Identifier.of("minecraft","chests/bastion_treasure");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, ABANDONED_MINESHAFT_ID).equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))     //chance
                        .with(ItemEntry.builder(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, ANCIENT_CITY_ID).equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))     //chance
                        .with(ItemEntry.builder(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, BASTION_TREASURE_ID).equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.07f))     //chance
                        .with(ItemEntry.builder(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, END_CITY_TREASURE_ID).equals(key)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))     //chance
                        .with(ItemEntry.builder(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

    }
}
