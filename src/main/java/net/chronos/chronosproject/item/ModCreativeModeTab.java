package net.chronos.chronosproject.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public  static  final CreativeModeTab CHRONOS_TAB = new CreativeModeTab("chronosproject") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CHRONOS_DYE.get());
        }
    };
}
