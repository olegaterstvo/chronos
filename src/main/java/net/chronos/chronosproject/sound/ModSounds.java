package net.chronos.chronosproject.sound;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ChronosProject.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> EAT_SLICE_OF_CAKE = SOUND_EVENTS.register(
            "eat_slice_of_cake", // must match the resource location on the next line
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ChronosProject.MOD_ID, "eat_slice_of_cake"))
    );

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}