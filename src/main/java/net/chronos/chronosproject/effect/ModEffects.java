package net.chronos.chronosproject.effect;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChronosProject.MOD_ID);

    public static final RegistryObject<MobEffect> PARANOIA = MOB_EFFECTS.register("psychosis",
            () -> new ParanoiaEffect(MobEffectCategory.HARMFUL, 0x010101));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

