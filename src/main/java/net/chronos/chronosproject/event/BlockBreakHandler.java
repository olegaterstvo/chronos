package net.chronos.chronosproject.event;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.item.ModPickaxe;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


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
            dependencies.put("player", player);
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
        if (dependencies.get("player") == null) {
            if (!dependencies.containsKey("entity"))
                ChronosProject.LOGGER.warn("Failed to load dependency entity for BlockBreakHandler!");
            return;
        }

        WorldAccess world = (WorldAccess) dependencies.get("world");
        int x = (int) dependencies.get("x");
        int y = (int) dependencies.get("y");
        int z = (int) dependencies.get("z");
        PlayerEntity player = (PlayerEntity) dependencies.get("player");

        if (player.getMainHandStack().getItem() == ModItems.CHRONOS_PICKAXE && !player.isSneaky()) {
            int x_offset = 0;
            int y_offset = 0;
            int y_offset_down = 1;
            int z_offset = 0;
            int count = 0;

            if (!player.getMainHandStack().getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).contains("chronosproject.pickaxe_mode")){
                ModPickaxe.addNbtToPickaxe(player, 1);
            }
            int mode = player.getMainHandStack().getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getInt("chronosproject.pickaxe_mode");
            switch (mode){
                case 1, 0 -> {
                    y_offset_down = 0;
                }
                case 2 -> {

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
            if ((player.getHorizontalFacing()).getAxis() == Direction.Axis.Z && player.getPitch() < 45 && player.getPitch() > -45) {
                for (int i = x - x_offset; i <= x + x_offset; i++){
                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
                        BlockPos _pos = new BlockPos(i, j, z);
                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
                            count +=1;
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, player, player.getMainHandStack());
                            world.breakBlock(_pos, false);
                        }
                    }
                }
            } else if ((player.getHorizontalFacing()).getAxis() == Direction.Axis.X && player.getPitch() < 45 && player.getPitch() > -45) {
                for (int i = z - z_offset; i <= z + z_offset; i++){
                    for (int j = y - y_offset_down; j <= y + y_offset; j++){
                        BlockPos _pos = new BlockPos(x, j, i);
                        if (world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.BEDROCK) && world.getBlockState(_pos).getBlock() != Block.getBlockFromItem(Items.AIR)) {
                            count +=1;
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, player, player.getMainHandStack());
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
                            Block.dropStacks(world.getBlockState(_pos), (World) world, new BlockPos(x, y, z), null, player, player.getMainHandStack());
                            world.breakBlock(_pos, false);

                        }
                    }
                }
            }
            if (!player.isCreative()) {
                Set<RegistryEntry<Enchantment>> enchantments = EnchantmentHelper.getEnchantments(player.getMainHandStack()).getEnchantments();
                int unbreakingLevel = 0;

                for (RegistryEntry<Enchantment> enchantment: enchantments) {
                    if (enchantment.matchesId(Identifier.ofVanilla("unbreaking"))){
                        unbreakingLevel = EnchantmentHelper.getLevel(enchantment, player.getMainHandStack());
                    }
                }
                count = (count - 1) / (unbreakingLevel + 1);
                int damage = player.getMainHandStack().get(DataComponentTypes.DAMAGE).intValue() + count;
                player.getMainHandStack().setDamage(damage);
            }
        }
    }
}
