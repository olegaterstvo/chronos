package net.chronos.chronosproject.trade;

import net.chronos.chronosproject.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK, 16),
                            new ItemStack(Items.CAKE, 1),
                            new ItemStack(ModBlocks.SLICE_OF_CAKE, 1),
                            1,80,0.02f));
                });
    }
}
