package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CHRONOSPROJECT = FabricItemGroupBuilder.build(
            new Identifier(ChronosProject.MOD_ID, "chronosproject"), () -> new ItemStack(ModItems.CHRONOS_DYE));
}
