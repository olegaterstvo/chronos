package net.chronos.chronosproject.item;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.config.ChronosProjectCommonConfigs;
import net.chronos.chronosproject.item.ModItems;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.item.TooltipContext;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.PickaxeItem;
//import net.minecraft.item.ToolMaterial;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.text.Text;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.network.chat.Component;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
import java.util.List;
import java.util.function.Supplier;

import static net.chronos.chronosproject.item.ModItems.ITEMS;
@EventBusSubscriber(modid = ChronosProject.MOD_ID)
public class ModPickaxe extends PickaxeItem{
    public static final Tier CHRONOS_TIER = new SimpleTier(
            // The tag that determines what blocks this tool cannot break. See below for more information.
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            // Determines the durability of the tier.
            10000,
            // Determines the mining speed of the tier. Unused by swords.
            32f,
            // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
            // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords, respectively; our sword does 5.5 damage now.
            3f,
            // Determines the enchantability of the tier. This represents how good the enchantments on this tool will be.
            // Gold uses 22, we put copper slightly below that.
            26,
            // Determines the repair ingredient of the tier. Use a supplier for lazy initializing.
            () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE)
    );

    public ModPickaxe(Tier tier, Properties properties) {
        super(tier, properties);
    }

//    @Override
//    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
//        ChronosProject.LOGGER.info("123123123");
//        addNbtToPickaxe(player, 1);
//        if (player.getMainHandItem().getComponents().get(DataComponents.CUSTOM_DATA) == null){
//            player.getMainHandItem().set(DataComponents.CUSTOM_DATA, CustomData.of(new CompoundTag()));
//        }
//        ChronosProject.LOGGER.info(player.getMainHandItem().getComponents().get(DataComponents.CUSTOM_DATA).toString());
//
//
//        return super.use(world, player, hand);
//    }

    @SubscribeEvent
    public static void onUse(PlayerInteractEvent.RightClickItem event){
        if (event.getItemStack().getItem() == ModItems.CHRONOS_PICKAXE.get()){
            if (event.getItemStack().getComponents().get(DataComponents.CUSTOM_DATA) == null){
                event.getItemStack().set(DataComponents.CUSTOM_DATA, CustomData.of(new CompoundTag()));
            }
            if (event.getItemStack().getComponents().get(DataComponents.CUSTOM_DATA).contains("chronosproject.pickaxe_mode")){
                switch (event.getItemStack().getComponents().get(DataComponents.CUSTOM_DATA).getUnsafe().getInt("chronosproject.pickaxe_mode")) {
                    case 1 -> {
                        addNbtToPickaxe(event.getEntity(), 3);
                    }
                    case 3 -> {
                        addNbtToPickaxe(event.getEntity(), 5);
                    }
                    case 5 -> {
                        addNbtToPickaxe(event.getEntity(), 7);
                    }
                    case 7, 0 -> {
                        addNbtToPickaxe(event.getEntity(), 1);
                    }
                }
            } else {
                addNbtToPickaxe(event.getEntity(), 1);
            }
        }
    }

    public static void addNbtToPickaxe(Player player, int value){
        if (player.getMainHandItem().getItem() == ModItems.CHRONOS_PICKAXE.get() && player.isShiftKeyDown()){
            ItemStack pickaxe = player.getMainHandItem();

            CompoundTag nbtData = new CompoundTag();
            nbtData.putInt("chronosproject.pickaxe_mode", value);

            CustomData data = CustomData.of(nbtData);

            pickaxe.set(DataComponents.CUSTOM_DATA, data);

            if (player.isLocalPlayer()){
                player.sendSystemMessage(Component.literal(MessageFormat.format("Mode: {0}x{0}", value)) );
            }
        }
    }

    //    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        if(!user.getStackInHand(hand).hasNbt()){
//            user.getStackInHand(hand).setNbt(new NbtCompound());
//        }
//        if(user.getStackInHand(hand).getNbt().get("chronosproject.pickaxe_mode") != null){
//            switch (user.getStackInHand(hand).getNbt().getInt("chronosproject.pickaxe_mode")) {
//                case 1 -> {
//                    addNbtToPickaxe(user, 3);
//                }
//                case 3 -> {
//                    addNbtToPickaxe(user, 5);
//                }
//                case 5 -> {
//                    addNbtToPickaxe(user, 7);
//                }
//                case 7, 0 -> {
//                    addNbtToPickaxe(user, 1);
//                }
//            }
//        } else {
//            addNbtToPickaxe(user, 1);
//        }
//
//        return super.use(world, user, hand);
//    }
//
//    private void addNbtToPickaxe(Player player, int value){
//        if (player.getMainHandItem().getItem() == ModItems.CHRONOS_PICKAXE && player.isShiftKeyDown()) {
//            ItemStack chronosPickaxe = player.getMainHandItem();
//
//            CompoundTag nbtData = new CompoundTag();
//            nbtData.putInt("chronosproject.pickaxe_mode", value);
//
//            chronosPickaxe.set(DataComponents.CUSTOM_DATA, nbtData)
//
//            if(player.getWorld().isClient()) {
//                player.sendMessage(Text.of(MessageFormat.format("Mode: {0}x{0}", nbtData.getInt("chronosproject.pickaxe_mode"))));
//            }
////            player.sendMessage(Text.of(MessageFormat.format("Mode: {0}x{0}", nbtData.getInt("chronosproject.pickaxe_mode"))));
//        }
//
//    }
//
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        if(stack.hasNbt()){
//            String pickaxeMode = MessageFormat.format("Mode: §9{0}x{0}§r", stack.getNbt().getInt("chronosproject.pickaxe_mode"));;
//            tooltip.add(Text.of(pickaxeMode));
//            tooltip.add(Text.of("Shift+RMB to change mode"));
//        }
//    }

}
