package net.chronos.chronosproject.item;

import net.chronos.chronosproject.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
import java.util.List;

public class ModPickaxe extends PickaxeItem {
    public ModPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.getStackInHand(hand).hasNbt()){
            user.getStackInHand(hand).setNbt(new NbtCompound());
        }
        if(user.getStackInHand(hand).getNbt().get("chronosproject.pickaxe_mode") != null){
            switch (user.getStackInHand(hand).getNbt().getInt("chronosproject.pickaxe_mode")) {
                case 1 -> {
                    addNbtToPickaxe(user, 3);
                }
                case 3 -> {
                    addNbtToPickaxe(user, 5);
                }
                case 5 -> {
                    addNbtToPickaxe(user, 7);
                }
                case 7, 0 -> {
                    addNbtToPickaxe(user, 1);
                }
            }
        } else {
            addNbtToPickaxe(user, 1);
        }

        return super.use(world, user, hand);
    }

    private void addNbtToPickaxe(PlayerEntity player, int value){
        if (player.getMainHandStack().getItem() == ModItems.CHRONOS_PICKAXE && player.isSneaking()) {
            ItemStack chronosPickaxe = player.getMainHandStack();

            NbtCompound nbtData = player.getMainHandStack().getNbt();
            nbtData.putInt("chronosproject.pickaxe_mode", value);

            chronosPickaxe.setNbt(nbtData);

            if(player.getWorld().isClient()) {
                player.sendMessage(Text.of(MessageFormat.format("Mode: {0}x{0}", nbtData.getInt("chronosproject.pickaxe_mode"))));
            }
//            player.sendMessage(Text.of(MessageFormat.format("Mode: {0}x{0}", nbtData.getInt("chronosproject.pickaxe_mode"))));
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipType context) {
        if(stack.hasNbt()){
            String pickaxeMode = MessageFormat.format("Mode: §9{0}x{0}§r", stack.getNbt().getInt("chronosproject.pickaxe_mode"));;
            tooltip.add(Text.of(pickaxeMode));
            tooltip.add(Text.of("Shift+RMB to change mode"));
        }
    }

}
