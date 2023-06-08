package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static ItemGroup CHRONOSPROJECT;

    public static void registerItemGroups(){
        CHRONOSPROJECT = FabricItemGroup.builder(new Identifier(ChronosProject.MOD_ID, "chronosproject"))
                .displayName(Text.literal("Chronos Project"))
                .icon(() -> new ItemStack(ModItems.CHRONOS_DYE))
                .build();
    }
}
