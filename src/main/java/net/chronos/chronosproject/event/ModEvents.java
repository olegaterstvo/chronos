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
import net.minecraftforge.event.entity.living.LivingDamageEvent;
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
    public static int timeout;
    @SubscribeEvent
    public static void applyCustomEffectOnHit(LivingDamageEvent livingDamageEvent) {
        ChronosProject.LOGGER.debug("" + livingDamageEvent);
        if (livingDamageEvent.getEntityLiving().getLastHurtByMob() != null){
            if(livingDamageEvent.getEntityLiving().getLastHurtByMob().getMobType() == MobType.UNDEAD) {
                if (!String.valueOf(livingDamageEvent.getEntityLiving().getActiveEffects()).contains("effect.chronosproject.psychosis")) {
                    int rand = new Random().nextInt(10);
                    if (rand == 0) {
                        timeout = new Random().nextInt(3, 18) * 200;
                        ChronosProject.LOGGER.info(livingDamageEvent.getEntityLiving().getName().getString() + " is infected");
                        livingDamageEvent.getEntityLiving().addEffect(new MobEffectInstance(ModEffects.PARANOIA.get(), 900 + timeout, 10));
                    }
                }
            }
        }

    }

}
