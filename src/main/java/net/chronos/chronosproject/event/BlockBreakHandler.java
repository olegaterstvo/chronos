package net.chronos.chronosproject.event;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.item.ModPickaxe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
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
