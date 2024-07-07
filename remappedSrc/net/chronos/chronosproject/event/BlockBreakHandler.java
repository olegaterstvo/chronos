package net.chronos.chronosproject.event;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.enchantment.ModEnchantments;
import net.chronos.chronosproject.item.ModItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class BlockBreakHandler {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockentity) -> {
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("x", pos.getX());
            dependencies.put("y", pos.getY());
            dependencies.put("z", pos.getZ());
            dependencies.put("px", player.getX());
            dependencies.put("py", player.getY());
            dependencies.put("pz", player.getZ());
            dependencies.put("blockstate", state);
            dependencies.put("world", world);
            dependencies.put("entity", player);
            execute(dependencies);
            return true;
        });
    }

    public static void execute(Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                ChronosProject.LOGGER.warn("Failed to load dependency world for BlockBreakHandler!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                ChronosProject.LOGGER.warn("Failed to load dependency x for BlockBreakHandler!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                ChronosProject.LOGGER.warn("Failed to load dependency y for BlockBreakHandler!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                ChronosProject.LOGGER.warn("Failed to load dependency z for BlockBreakHandler!");
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                ChronosProject.LOGGER.warn("Failed to load dependency entity for BlockBreakHandler!");
            return;
        }

        WorldAccess world = (WorldAccess) dependencies.get("world");
        int x = (int) dependencies.get("x");
        int y = (int) dependencies.get("y");
        int z = (int) dependencies.get("z");
        Entity entity = (Entity) dependencies.get("entity");

        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == ModItems.CHRONOS_PICKAXE && !entity.isSneaky()) {
            int x_offset = 0;
            int y_offset = 0;
            int y_offset_down = 1;
            int z_offset = 0;
            int count = 0;


            int mode = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().getInt("chronosproject.pickaxe_mode");
            switch (mode){
                case 0 -> {
                    (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().putInt("chronosproject.pickaxe_mode", 1);
                    y_offset_down = 0;
                }
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
            if ((entity.getHorizontalFacing()).getAxis() == Direction.Axis.Z && entity.getPitch() < 45 && entity.getPitch() > -45) {
                for (int i = x - x_offset; i <= x + x_offset; i++){
                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
                        BlockPos _pos = new BlockPos(i, j, z);
                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
                            count +=1;
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
                            world.breakBlock(_pos, false);
                        }
                    }
                }
            } else if ((entity.getHorizontalFacing()).getAxis() == Direction.Axis.X && entity.getPitch() < 45 && entity.getPitch() > -45) {
                for (int i = z - z_offset; i <= z + z_offset; i++){
                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
                        BlockPos _pos = new BlockPos(x, j, i);
                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
                            count +=1;
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
                            world.breakBlock(_pos, false);
                        }
                    }
                }
            } else {
                for (int i = x - x_offset; i <= x + x_offset; i++){
                    for (int j = z - z_offset; j <= z + z_offset; j++){
                        BlockPos _pos = new BlockPos(i, y, j);
                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
                            count +=1;
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, entity, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY));
                            world.breakBlock(_pos, false);

                        }
                    }
                }
            }
            if (!Objects.requireNonNull(world.getPlayerByUuid(entity.getUuid())).isCreative()) {
                count = (count - 1) / (EnchantmentHelper.getEquipmentLevel(Enchantments.UNBREAKING, (LivingEntity) entity) + 1);
                int damage = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().getInt("Damage") + count;
                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getNbt().putInt("Damage", damage);
            }
        }
    }
}
