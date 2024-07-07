package net.chronos.chronosproject.trade;

import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.Optional;

public class ModTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 16),
                            Optional.of(new TradedItem(Items.CAKE, 1)),
                            new ItemStack(ModBlocks.SLICE_OF_CAKE, 1),
                            1,512,0.02f));
                });
    }

    public static void registerCustomWanderingTrades(){
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1),
                            Optional.of(new TradedItem(ModItems.CHRONOS_DYE, 16)),
                            new ItemStack(ModItems.CHRONOS_UPGRADE_SMITHING_TEMPLATE, 1),
                            1, 512, 0.01f));
                });
    }
}
