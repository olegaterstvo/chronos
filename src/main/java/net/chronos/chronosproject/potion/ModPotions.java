package net.chronos.chronosproject.potion;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ChronosProject.MOD_ID);


    public static final RegistryObject<Potion> HASTE_POTION = POTIONS.register("haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    public static final RegistryObject<Potion> STRONG_HASTE_POTION = POTIONS.register("strong_haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)));
    public static final RegistryObject<Potion> LONG_HASTE_POTION = POTIONS.register("long_haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0)));
    public static final RegistryObject<Potion> PSYCHOSIS_POTION = POTIONS.register("psychosis_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.PARANOIA.get(), 3600, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
