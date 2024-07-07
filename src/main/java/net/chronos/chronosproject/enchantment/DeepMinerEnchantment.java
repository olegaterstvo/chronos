//package net.chronos.chronosproject.enchantment;
//
//import net.chronos.chronosproject.ChronosProject;
//import net.minecraft.core.Holder;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.Enchantments;
//import net.minecraft.world.item.enchantment.ItemEnchantments;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
//
//@EventBusSubscriber(modid = ChronosProject.MOD_ID)
//public class DeepMinerEnchantment {
//    @SubscribeEvent
//    public static void execute(PlayerInteractEvent.LeftClickBlock event){
//        if (event.getEntity().isLocalPlayer()){
//            return;
//        }
//
//        ItemStack itemStack = event.getItemStack();
//        ItemEnchantments enchantments = itemStack.getTagEnchantments();
//
//        if (enchantments.toString().contains("Deep Miner")) {   // ПОХУЙ
//
//            Holder<Enchantment> eff = event.getLevel().registryAccess().asGetterLookup().get(Enchantments.EFFICIENCY.registryKey(), Enchantments.EFFICIENCY).get().getDelegate();
//            int y = event.getEntity().getBlockY();
//
//            if (y < 0 && !enchantments.keySet().contains(eff)){
//                itemStack.enchant(eff, 255);
////                event.getItemStack().set(DataComponents.ENCHANTMENTS);
//            } else if (y >= 0 && enchantments.keySet().contains(eff)) {
//                enchantments.keySet().remove(eff);  // не работает
//            }
//        }
//    }
//}
//
