//package net.chronos.chronosproject.enchantment;
//
//import net.chronos.chronosproject.ChronosProject;
//import net.minecraft.core.Holder;
//import net.minecraft.core.component.DataComponents;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentHelper;
//import net.minecraft.world.item.enchantment.Enchantments;
//import net.minecraft.world.item.enchantment.ItemEnchantments;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
//
//import java.util.Objects;
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
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////import net.minecraft.core.Holder;
////import net.minecraft.core.HolderSet;
////import net.minecraft.core.component.DataComponentMap;
////import net.minecraft.network.chat.Component;
////import net.minecraft.server.level.ServerLevel;
////import net.minecraft.world.entity.Entity;
////import net.minecraft.world.item.ItemStack;
////import net.minecraft.world.item.enchantment.*;
////import net.minecraft.world.level.block.state.BlockState;
////import net.minecraft.world.phys.Vec3;
////
//////public class DeepMinerEnchantment extends EnchantmentInstance {
//////
//////    public DeepMinerEnchantment(Holder<Enchantment> enchantment, int level) {
//////        super(enchantment, level);
//////    }
//////}
////
////public class DeepMinerEnchantment extends Enchantment{
////    public DeepMinerEnchantment(Component description, EnchantmentDefinition definition, HolderSet<Enchantment> exclusiveSet, DataComponentMap effects) {
////        Enc
////        super(description, definition, exclusiveSet, effects);
////
////    }
////
////    @Override
////    public int getMaxLevel() {
////        return 1;
////    }
////
////    @Override
////    public boolean canEnchant(ItemStack pStack) {
////        return super.canEnchant(pStack) && !pStack.getTagEnchantments().keySet().contains(Enchantments.EFFICIENCY);
////    }
////
////    @Override
////    public void onHitBlock(ServerLevel serverLevel, int p_346193_, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3, BlockState blockState) {
//////        super.onHitBlock(serverLevel, p_346193_, enchantedItemInUse, entity, vec3, blockState);
////        if (vec3.y < 0 && EnchantmentHelper.getEnchantmentLevel(ModEnchantments.DEEP_MINER, entity) != 0) {
////
////        }
////    }
////}
////
////
////
////
////
//////import com.mojang.serialization.Codec;
//////import net.chronos.chronosproject.ChronosProject;
//////import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
//////import net.minecraft.block.Block;
//////import net.minecraft.block.BlockState;
//////import net.minecraft.enchantment.Enchantment;
//////import net.minecraft.enchantment.EnchantmentHelper;
//////import net.minecraft.enchantment.EnchantmentTarget;
//////import net.minecraft.enchantment.Enchantments;
//////import net.minecraft.entity.Entity;
//////import net.minecraft.entity.EquipmentSlot;
//////import net.minecraft.entity.LivingEntity;
//////import net.minecraft.item.ItemStack;
//////import net.minecraft.item.Items;
//////import net.minecraft.nbt.NbtCompound;
//////import net.minecraft.nbt.NbtList;
//////import net.minecraft.resource.ResourcePack;
//////import net.minecraft.text.Text;
//////import net.minecraft.util.ActionResult;
//////import net.minecraft.util.math.BlockPos;
//////import net.minecraft.world.WorldAccess;
//////
//////import javax.xml.transform.Result;
//////import java.sql.ResultSet;
//////import java.util.HashMap;
//////import java.util.Map;
//////
//////public class DeepMinerEnchantment extends Enchantment {
//////    protected DeepMinerEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
//////        super(weight, target, slotTypes);
//////        AttackBlockCallback.EVENT.register((player, level, hand, pos, direction) -> {
//////            Map<String, Object> dependencies = new HashMap<>();
//////            dependencies.put("world", level);
//////            dependencies.put("entity", player);
//////            dependencies.put("x", pos.getX());
//////            dependencies.put("y", pos.getY());
//////            dependencies.put("z", pos.getZ());
//////            dependencies.put("blockstate", level.getBlockState(pos));
//////            dependencies.put("direction", direction);
//////            execute(dependencies);
//////            return ActionResult.PASS;
//////        });
//////    }
//////
//////    @Override
//////    public int getMaxLevel() {
//////        return 1;
//////    }
//////
//////    public boolean canAccept(Enchantment other) {
//////        return super.canAccept(other) && other != Enchantments.EFFICIENCY;
//////    }
//////    public static void execute(Map<String, Object> dependencies) {
//////        if (dependencies.get("entity") == null) {
//////            if (!dependencies.containsKey("entity"))
//////                ChronosProject.LOGGER.warn("Failed to load dependency entity for procedure Gfx!");
//////            return;
//////        }
//////
//////        WorldAccess world = (WorldAccess) dependencies.get("world");
//////        int x = (int) dependencies.get("x");
//////        int y = (int) dependencies.get("y");
//////        int z = (int) dependencies.get("z");
//////        LivingEntity entity = (LivingEntity) dependencies.get("entity");
//////
//////        if (y < 0 && EnchantmentHelper.getEquipmentLevel(ModEnchantments.DEEP_MINER, entity) != 0) {
//////            if(EnchantmentHelper.getEquipmentLevel(Enchantments.EFFICIENCY, entity)!=100){
////////                NbtCompound nbtData = entity.getMainHandStack().getNbt();
////////                nbtData.putInt("chronosproject.last_efficiency", EnchantmentHelper.getEquipmentLevel(Enchantments.EFFICIENCY, entity));
////////                entity.getMainHandStack().setNbt(nbtData);
//////
////////                if (entity.getMainHandStack().getEnchantments().contains(Enchantments.EFFICIENCY)){
////////                    int i = entity.getMainHandStack().getEnchantments().indexOf(Enchantments.EFFICIENCY);
////////                    if (i < 0 ){
////////                        i = entity.getMainHandStack().getEnchantments().size() + i;
////////                    }
////////                    entity.sendMessage(Text.of("i "+String.valueOf(i)));
////////                    entity.getMainHandStack().getEnchantments().remove(i);
////////                }
////////                NbtList[] ent = {entity.getMainHandStack().getEnchantments().getList(0)};
////////                for (int j=0; j < ent.length; j++){
////////                    entity.sendMessage(Text.of(String.valueOf(j) + " " + String.valueOf(ent[j])));
////////                }
//////////                entity.sendMessage(Text.of(String.valueOf(entity.getMainHandStack().getEnchantments())));
////////                entity.sendMessage(Text.of("level " + String.valueOf(EnchantmentHelper.getEquipmentLevel(Enchantments.EFFICIENCY, entity))));
//////                entity.getMainHandStack().addEnchantment(Enchantments.EFFICIENCY, 100);
//////            }
//////
////////            BlockPos _pos = new BlockPos(x, y, z);
////////            Block.dropStacks(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
////////            if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK)) {
////////                world.breakBlock(_pos, true);
////////            }
////////            entity.sendMessage(Text.of(String.valueOf(entity.getMainHandStack().getNbt())));
//////        } else if (y >= 0 && EnchantmentHelper.getEquipmentLevel(ModEnchantments.DEEP_MINER, entity) != 0) {
//////            if(EnchantmentHelper.getEquipmentLevel(Enchantments.EFFICIENCY, entity)==100){
////////                NbtCompound nbtData = entity.getMainHandStack().getNbt();
////////                entity.getMainHandStack().getEnchantments().remove(Enchantments.EFFICIENCY);
////////                nbtData.remove("{id:\"minecraft:efficiency\",lvl:100s}");
////////                if (world.isClient()){
////////                    entity.sendMessage(Text.of(String.valueOf(entity.getMainHandStack().getEnchantments().indexOf(Enchantments.EFFICIENCY))));
////////                }
//////                int i = entity.getMainHandStack().getEnchantments().indexOf(Enchantments.EFFICIENCY);
////////                if (world.isClient()){
////////                    entity.sendMessage(Text.of(String.valueOf(i)));
////////                }
//////                if (i < 0 ){
//////                    i = entity.getMainHandStack().getEnchantments().size() + i;
//////                }
////////                if (world.isClient()){
////////                    entity.sendMessage(Text.of(String.valueOf(i)));
////////                }
//////                entity.getMainHandStack().getEnchantments().remove(i);
////////                if (nbtData.getInt("chronosproject.last_efficiency") > 0) {
////////                    entity.getMainHandStack().addEnchantment(Enchantments.EFFICIENCY, nbtData.getInt("chronosproject.last_efficiency"));
////////                }
////////                nbtData.remove("chronosproject.last_efficiency");
////////                entity.getMainHandStack().setNbt(nbtData);
//////            }
////////            if (world.isClient()) {
////////                entity.sendMessage(Text.of(String.valueOf(entity.getMainHandStack().getNbt())));
////////            }
//////        }
//////    }
//////
//////
//////
//////}
