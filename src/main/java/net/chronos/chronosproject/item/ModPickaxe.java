package net.chronos.chronosproject.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
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

import java.text.MessageFormat;
import java.util.List;

public class ModPickaxe extends PickaxeItem {
    public ModPickaxe(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if(itemStack.get(DataComponentTypes.CUSTOM_DATA) == null){
            itemStack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(new NbtCompound()));
        }
        if(itemStack.get(DataComponentTypes.CUSTOM_DATA).copyNbt().contains("chronosproject.pickaxe_mode")){
            switch (itemStack.get(DataComponentTypes.CUSTOM_DATA).copyNbt().getInt("chronosproject.pickaxe_mode")) {
                case 1 -> {
                    addNbtToPickaxe(user, 2);
                }
                case 2 -> {
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

    public static void addNbtToPickaxe(PlayerEntity player, int value){
        if (player.getMainHandStack().getItem() == ModItems.CHRONOS_PICKAXE && player.isSneaking()) {
            ItemStack chronosPickaxe = player.getMainHandStack();

            NbtCompound nbtData;
            if (chronosPickaxe.get(DataComponentTypes.CUSTOM_DATA) != null){
                nbtData = chronosPickaxe.get(DataComponentTypes.CUSTOM_DATA).copyNbt();
            } else {
                nbtData = new NbtCompound();
            }
            nbtData.putInt("chronosproject.pickaxe_mode", value);

            NbtComponent component = NbtComponent.of(nbtData);

            chronosPickaxe.set(DataComponentTypes.CUSTOM_DATA, component);

            if(player.getWorld().isClient()) {
                if (value == 2){
                    player.sendMessage(Text.of("Mode: 1x2"));
                } else {
                    player.sendMessage(Text.of(MessageFormat.format("Mode: {0}x{0}", value)));
                }
            }
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.get(DataComponentTypes.CUSTOM_DATA) != null){
            if (stack.get(DataComponentTypes.CUSTOM_DATA).contains("chronosproject.pickaxe_mode")){
                String pickaxeMode;
                if (stack.get(DataComponentTypes.CUSTOM_DATA).copyNbt().getInt("chronosproject.pickaxe_mode") == 2){
                    pickaxeMode = "Mode §91x2§r";
                }else {
                    pickaxeMode = MessageFormat.format("Mode: §9{0}x{0}§r", stack.get(DataComponentTypes.CUSTOM_DATA).copyNbt().getInt("chronosproject.pickaxe_mode"));
                }
                tooltip.add(Text.of(pickaxeMode));
            }
        }
        tooltip.add(Text.of("Shift+RMB to change mode"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
