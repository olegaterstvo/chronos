//package net.chronos.chronosproject.enchantment;
//
//import net.chronos.chronosproject.ChronosProject;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentTarget;
//import net.minecraft.entity.EquipmentSlot;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//public class ModEnchantments {
//
//    public static Enchantment DEEP_MINER = register("deep_miner",
//            new DeepMinerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND));
//
//    private static Enchantment register(String name, Enchantment enchantment){
//        return Registry.register(Registries.ENCHANTMENT, new Identifier(ChronosProject.MOD_ID, name), enchantment);
//    }
//
//    public static void registerModEnchantments(){
//        System.out.println("Registering Enchantments for " + ChronosProject.MOD_ID);
//    }
//}
