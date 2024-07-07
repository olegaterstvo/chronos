package net.chronos.chronosproject.trade;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;
import java.util.Optional;

@EventBusSubscriber(modid = ChronosProject.MOD_ID)
public class ModTrades {
    @SubscribeEvent
    public static void registerCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD_BLOCK, 16),
                    Optional.of(new ItemCost(Items.CAKE, 1)),
                    new ItemStack(ModBlocks.SLICE_OF_CAKE.get(), 1),
                    1,512,0.02f
            ));
        }
    }
    @SubscribeEvent
    public static void registerCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,1),
                Optional.of(new ItemCost(ModItems.CHRONOS_DYE.get(), 16)),
                new ItemStack(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE.get(), 1),
                1,512,0.01f
        ));
    }
}
