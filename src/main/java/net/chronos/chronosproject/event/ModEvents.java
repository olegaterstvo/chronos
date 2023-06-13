package net.chronos.chronosproject.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.config.ChronosProjectCommonConfigs;
import net.chronos.chronosproject.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = ChronosProject.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(ChronosProjectCommonConfigs.CAKE_SHOULD_SELL.get()) {
            if (event.getType() == VillagerProfession.FARMER) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.SLICE_OF_CAKE.get(), 1);
                int villagerLevel = 5;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD_BLOCK, ChronosProjectCommonConfigs.CAKE_PRICE.get()), new ItemStack(Items.CAKE, 1),
                        stack, 1, 80, 0.02F));
            }
        }
    }
    private static float lastHealth = -1;
    private static float ticks = new Random().nextInt(3,12) * 200;
    private static boolean infected = Boolean.FALSE;
    @SubscribeEvent
    public static void applyCustomEffect(PlayerEvent playerEvent){
        if (lastHealth < 0.1){
            lastHealth = playerEvent.getPlayer().getHealth();
            infected = Boolean.FALSE;
        }
        if (playerEvent.getPlayer().getLastHurtByMob() != null){
            if(playerEvent.getPlayer().getHealth() < lastHealth ) {
                lastHealth = playerEvent.getPlayer().getHealth();
                if(playerEvent.getPlayer().getLastHurtByMob().getMobType() == MobType.UNDEAD){
                    int rand = new Random().nextInt(10);
                    if (rand == 0) {
                        infected = Boolean.TRUE;
                        ChronosProject.LOGGER.info(playerEvent.getPlayer().getName().getString() +" is infected");
                    }
                }
            }
        }
        if(infected){
            ticks = ticks - 1;
            if (ticks == 0) {
                playerEvent.getPlayer().addEffect(new MobEffectInstance(ModEffects.PARANOIA.get(), 1200, 0));
                infected = Boolean.FALSE;
                ticks = new Random().nextInt(3,18) * 200;
            }
        }
        if (playerEvent.getPlayer().getActiveEffects().contains(new MobEffectInstance(ModEffects.PARANOIA.get()))){
            playerEvent.getPlayer().removeEffect(ModEffects.PARANOIA.get());
        }
        if (lastHealth < playerEvent.getPlayer().getHealth()) {
            lastHealth = playerEvent.getPlayer().getHealth();
        }
    }
}
