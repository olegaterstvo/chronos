package net.chronos.chronosproject.event;
//
//import net.chronos.chronosproject.ChronosProject;
////import net.chronos.chronosproject.enchantment.ModEnchantments;
//import net.chronos.chronosproject.item.ModItems;
////import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
////import net.minecraft.block.Block;
////import net.minecraft.enchantment.EnchantmentHelper;
////import net.minecraft.enchantment.Enchantments;
////import net.minecraft.entity.Entity;
////import net.minecraft.entity.LivingEntity;
////import net.minecraft.entity.damage.DamageSource;
////import net.minecraft.item.Item;
////import net.minecraft.item.ItemStack;
////import net.minecraft.item.Items;
////import net.minecraft.server.network.ServerPlayerEntity;
////import net.minecraft.text.Text;
////import net.minecraft.util.math.BlockPos;
////import net.minecraft.util.math.Direction;
////import net.minecraft.world.GameMode;
////import net.minecraft.world.World;
////import net.minecraft.world.WorldAccess;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Random;
//


import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.item.ModPickaxe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = ChronosProject.MOD_ID)
public class BlockBreakHandler {
    @SubscribeEvent
    public static void execute(BlockEvent.BreakEvent event){
        Player player = event.getPlayer();
        LevelAccessor world = event.getLevel();
        int x = event.getPos().getX();
        int y = event.getPos().getY();
        int z = event.getPos().getZ();

        if (player.getMainHandItem().getItem() == ModItems.CHRONOS_PICKAXE.get() && !player.isShiftKeyDown()){
            int x_offset = 0;
            int y_offset = 0;
            int y_offset_down = 1;
            int z_offset = 0;
            int count = 0;

            if (!player.getMainHandItem().getComponents().getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).contains("chronosproject.pickaxe_mode")){
                ModPickaxe.addNbtToPickaxe(player, 1);
            }
            int mode = player.getMainHandItem().getComponents().getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).getUnsafe().getInt("chronosproject.pickaxe_mode");
            switch (mode){
                case 1 -> {
                    y_offset_down = 0;
                }
                case 3 ->{
                    x_offset = 1;
                    y_offset = 1;
                    z_offset = 1;
                }
                case 5 ->{
                    x_offset = 2;
                    y_offset = 3;
                    z_offset = 2;
                }
                case 7 ->{
                    x_offset = 3;
                    y_offset = 5;
                    z_offset = 3;
                }
            }

            if ((player.getRotationVector().y > 135 || player.getRotationVector().y < -135 || ((player.getRotationVector().y > -45 && player.getRotationVector().y < 45))) && player.getRotationVector().x < 45 && player.getRotationVector().x > -45) {
                for (int i = x - x_offset; i <= x + x_offset; i++) {
                    for (int j = y - y_offset_down; j <= y + y_offset; j++) {
                        BlockPos _pos = new BlockPos(i, j, z);
                        if (world.getBlockState(_pos).getBlock() != Block.byItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.byItem(Items.AIR)) {
                            count += 1;
                            Block.dropResources(world.getBlockState(_pos), (Level) world, new BlockPos(x, y, z), null, player, player.getMainHandItem());
                            world.destroyBlock(_pos, false);
                        }
                    }
                }
            } else if (((player.getRotationVector().y > -135 && player.getRotationVector().y < -45)||(player.getRotationVector().y > 45 && player.getRotationVector().y < 135)) && player.getRotationVector().x < 45 && player.getRotationVector().x > -45) {
                for (int i = z - z_offset; i <= z + z_offset; i++) {
                    for (int j = y - y_offset_down; j <= y + y_offset; j++) {
                        BlockPos _pos = new BlockPos(x, j, i);
                        if (world.getBlockState(_pos).getBlock() != Block.byItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.byItem(Items.AIR)) {
                            count += 1;
                            Block.dropResources(world.getBlockState(_pos), (Level) world, new BlockPos(x, y, z), null, player, player.getMainHandItem());
                            world.destroyBlock(_pos, false);
                        }
                    }
                }
            } else {
                for (int i = x - x_offset; i <= x + x_offset; i++){
                    for (int j = z - z_offset; j <= z + z_offset; j++){
                        BlockPos _pos = new BlockPos(i, y, j);
                        if (world.getBlockState(_pos).getBlock() != Block.byItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.byItem(Items.AIR)) {
                            count +=1;
                            Block.dropResources(world.getBlockState(_pos), (Level) world, new BlockPos(x, y, z), null, player, player.getMainHandItem());
                            world.destroyBlock(_pos, false);

                        }
                    }
                }
            }

            if (!player.isCreative()) {
                Holder<Enchantment> ench = world.registryAccess().asGetterLookup().get(Enchantments.UNBREAKING.registryKey(), Enchantments.UNBREAKING).get().getDelegate();
                count = (count - 1) / (player.getMainHandItem().getEnchantmentLevel(ench) + 1);
                int damage = player.getMainHandItem().getComponents().get(DataComponents.DAMAGE).intValue() + count;
                player.getMainHandItem().setDamageValue(damage);
            }


        }

    }

}
//
//public class BlockBreakHandler {
//    public static void register() {
//        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockentity) -> {
//            Map<String, Object> dependencies = new HashMap<>();
//            dependencies.put("x", pos.getX());
//            dependencies.put("y", pos.getY());
//            dependencies.put("z", pos.getZ());
//            dependencies.put("px", player.getX());
//            dependencies.put("py", player.getY());
//            dependencies.put("pz", player.getZ());
//            dependencies.put("blockstate", state);
//            dependencies.put("world", world);
//            dependencies.put("entity", player);
//            execute(dependencies);
//            return true;
//        });
//    }
//
//    public static void execute(Map<String, Object> dependencies) {
//        if (dependencies.get("world") == null) {
//            if (!dependencies.containsKey("world"))
//                ChronosProject.LOGGER.warn("Failed to load dependency world for BlockBreakHandler!");
//            return;
//        }
//        if (dependencies.get("x") == null) {
//            if (!dependencies.containsKey("x"))
//                ChronosProject.LOGGER.warn("Failed to load dependency x for BlockBreakHandler!");
//            return;
//        }
//        if (dependencies.get("y") == null) {
//            if (!dependencies.containsKey("y"))
//                ChronosProject.LOGGER.warn("Failed to load dependency y for BlockBreakHandler!");
//            return;
//        }
//        if (dependencies.get("z") == null) {
//            if (!dependencies.containsKey("z"))
//                ChronosProject.LOGGER.warn("Failed to load dependency z for BlockBreakHandler!");
//            return;
//        }
//        if (dependencies.get("entity") == null) {
//            if (!dependencies.containsKey("entity"))
//                ChronosProject.LOGGER.warn("Failed to load dependency entity for BlockBreakHandler!");
//            return;
//        }
//
//        WorldAccess world = (WorldAccess) dependencies.get("world");
//        int x = (int) dependencies.get("x");
//        int y = (int) dependencies.get("y");
//        int z = (int) dependencies.get("z");
//        Entity entity = (Entity) dependencies.get("entity");
//
//        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == ModItems.CHRONOS_PICKAXE && !entity.isSneaky()) {
//            int x_offset = 0;
//            int y_offset = 0;
//            int y_offset_down = 1;
//            int z_offset = 0;
//            int count = 0;
//
//
//            int mode = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().getInt("chronosproject.pickaxe_mode");
//            switch (mode){
//                case 0 -> {
//                    (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().putInt("chronosproject.pickaxe_mode", 1);
//                    y_offset_down = 0;
//                }
//                case 1 -> {
//                    y_offset_down = 0;
//                }
//                case 3 ->{
//                    x_offset = 1;
//                    y_offset = 1;
//                    z_offset = 1;
//                }
//                case 5 ->{
//                    x_offset = 2;
//                    y_offset = 3;
//                    z_offset = 2;
//                }
//                case 7 ->{
//                    x_offset = 3;
//                    y_offset = 5;
//                    z_offset = 3;
//                }
//            }
//            if ((entity.getHorizontalFacing()).getAxis() == Direction.Axis.Z && entity.getPitch() < 45 && entity.getPitch() > -45) {
//                for (int i = x - x_offset; i <= x + x_offset; i++){
//                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
//                        BlockPos _pos = new BlockPos(i, j, z);
//                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
//                            count +=1;
//                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
//                            world.breakBlock(_pos, false);
//                        }
//                    }
//                }
//            } else if ((entity.getHorizontalFacing()).getAxis() == Direction.Axis.X && entity.getPitch() < 45 && entity.getPitch() > -45) {
//                for (int i = z - z_offset; i <= z + z_offset; i++){
//                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
//                        BlockPos _pos = new BlockPos(x, j, i);
//                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
//                            count +=1;
//                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
//                            world.breakBlock(_pos, false);
//                        }
//                    }
//                }
//            } else {
//                for (int i = x - x_offset; i <= x + x_offset; i++){
//                    for (int j = z - z_offset; j <= z + z_offset; j++){
//                        BlockPos _pos = new BlockPos(i, y, j);
//                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
//                            count +=1;
//                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
//                            world.breakBlock(_pos, false);
//
//                        }
//                    }
//                }
//            }
//            if (!Objects.requireNonNull(world.getPlayerByUuid(entity.getUuid())).isCreative()) {
//                count = (count - 1) / (EnchantmentHelper.getEquipmentLevel(Enchantments.UNBREAKING, (LivingEntity) entity) + 1);
//                int damage = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().getInt("Damage") + count;
//                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().putInt("Damage", damage);
//            }
//        }
//    }
//}
