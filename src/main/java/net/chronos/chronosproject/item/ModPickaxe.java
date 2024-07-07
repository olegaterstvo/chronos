package net.chronos.chronosproject.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

public class ModPickaxe extends PickaxeItem{
    public ModPickaxe(Tier tier, Properties properties) {
        super(tier, properties);
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(pStack.get(DataComponents.CUSTOM_DATA) != null){
            if (Objects.requireNonNull(pStack.get(DataComponents.CUSTOM_DATA)).contains("chronosproject.pickaxe_mode")){
                String pickaxeMode;
                if (pStack.get(DataComponents.CUSTOM_DATA).getUnsafe().getInt("chronosproject.pickaxe_mode") == 2){
                    pickaxeMode = "Mode: §91x2§r";
                }else {
                    pickaxeMode = MessageFormat.format("Mode: §9{0}x{0}§r", pStack.get(DataComponents.CUSTOM_DATA).getUnsafe().getInt("chronosproject.pickaxe_mode"));
                }
                pTooltipComponents.add(Component.literal(pickaxeMode));
            }
        }
        pTooltipComponents.add(Component.literal("Shift+RMB to change mode"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getMainHandItem();
        if (itemStack.getItem() == ModItems.CHRONOS_PICKAXE.get()){
            if (itemStack.getComponents().get(DataComponents.CUSTOM_DATA) == null){
                itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(new CompoundTag()));
            }
            if (itemStack.getComponents().get(DataComponents.CUSTOM_DATA).contains("chronosproject.pickaxe_mode")){
                switch (itemStack.getComponents().get(DataComponents.CUSTOM_DATA).getUnsafe().getInt("chronosproject.pickaxe_mode")) {
                    case 1 -> {
                        addNbtToPickaxe(player, 2);
                    }
                    case 2 -> {
                        addNbtToPickaxe(player, 3);
                    }
                    case 3 -> {
                        addNbtToPickaxe(player, 5);
                    }
                    case 5 -> {
                        addNbtToPickaxe(player, 7);
                    }
                    case 7, 0 -> {
                        addNbtToPickaxe(player, 1);
                    }
                }
            } else {
                addNbtToPickaxe(player, 1);
            }
        }

        return super.use(world, player, hand);
    }

    public static void addNbtToPickaxe(Player player, int value){
        if (player.getMainHandItem().getItem() == ModItems.CHRONOS_PICKAXE.get() && player.isShiftKeyDown()){
            ItemStack pickaxe = player.getMainHandItem();

            CompoundTag nbtData = new CompoundTag();
            nbtData.putInt("chronosproject.pickaxe_mode", value);

            CustomData data = CustomData.of(nbtData);

            pickaxe.set(DataComponents.CUSTOM_DATA, data);

            if (player.isLocalPlayer()){
                if (value == 2) {
                    player.sendSystemMessage(Component.literal("Mode: 1x2"));
                } else {
                    player.sendSystemMessage(Component.literal(MessageFormat.format("Mode: {0}x{0}", value)));
                }
            }
        }
    }

}
