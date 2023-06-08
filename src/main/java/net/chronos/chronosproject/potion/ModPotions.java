package net.chronos.chronosproject.potion;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ChronosProject.MOD_ID);


    public static final RegistryObject<Potion> HASTE_POTION = POTIONS.register("haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    public static final RegistryObject<Potion> HASTE2_POTION = POTIONS.register("haste2_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)));
    public static final RegistryObject<Potion> HASTE_PLUS_POTION = POTIONS.register("haste_plus_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0)));



    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
