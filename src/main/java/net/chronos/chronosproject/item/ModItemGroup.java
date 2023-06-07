package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> CHRONOSPROJECT = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ChronosProject.MOD_ID, "chronosproject"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, CHRONOSPROJECT, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.CHRONOS_DYE))
                .displayName(Text.literal("Chronos Project"))
                .build()); // build() no longer registers by itself
    }
}
