package net.chronos.chronosproject.sound;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent EAT_SLICE_OF_CAKE;

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(ChronosProject.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds(){
        EAT_SLICE_OF_CAKE = registerSoundEvent("eat_slice_of_cake");
    }

}
