//package net.chronos.chronosproject.enchantment;
////
////import net.chronos.chronosproject.ChronosProject;
////import net.minecraft.core.Registry;
////import net.minecraft.world.item.enchantment.Enchantment;
//////import net.minecraft.enchantment.Enchantment;
//////import net.minecraft.enchantment.EnchantmentTarget;
//////import net.minecraft.entity.EquipmentSlot;
//////import net.minecraft.registry.Registries;
//////import net.minecraft.registry.Registry;
//////import net.minecraft.util.Identifier;
////
////public class ModEnchantments {
////
////    public static Enchantment DEEP_MINER = register("deep_miner",
////            new DeepMinerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND));
////
////    private static Enchantment register(String name, Enchantment enchantment){
////        return Registry.register(Registries.ENCHANTMENT, new Identifier(ChronosProject.MOD_ID, name), enchantment);
////    }
////
////    public static void registerModEnchantments(){
////        System.out.println("Registering Enchantments for " + ChronosProject.MOD_ID);
////    }
////}
//
//import net.chronos.chronosproject.ChronosProject;
//import net.minecraft.core.component.DataComponentType;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.registries.DeferredRegister;
//import net.neoforged.neoforge.registries.NeoForgeRegistries;
//
//import java.util.function.Supplier;
//
//public class ModEnchantments {
//    public static final DeferredRegister<DataComponentType<?>> ENCHANTMENTS =
//            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, ChronosProject.MOD_ID);
//    public static Supplier<Enchantment> DEEP_MINER =
//            ENCHANTMENTS.register("deep_miner",
//                    () -> new DeepMinerEnchantment(Component.literal("Deep Miner"), new Enchantment.EnchantmentDefinition()));
//
//    public static void register(IEventBus eventBus){
//        ENCHANTMENTS.register(eventBus);
//    }
//}