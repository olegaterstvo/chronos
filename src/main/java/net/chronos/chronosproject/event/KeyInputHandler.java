package net.chronos.chronosproject.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CHRONOS = "key.category.chronosproject.chronos";
    public static final String KEY_SHARE_COORDS = "key.chronosproject.share_coords";

    public static KeyMapping shareCoords;
    // Key mapping is lazily initialized, so it doesn't exist until it is registered
    public static final Lazy<KeyMapping> CHRONOS_MAPPING = Lazy.of(() ->
            shareCoords = new KeyMapping(
                KEY_SHARE_COORDS, // Will be localized using this translation key
                InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
                GLFW.GLFW_KEY_X, // Default key
                KEY_CATEGORY_CHRONOS // Mapping will be in the misc category
            ));

    // Event is on the mod event bus only on the physical client
    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(CHRONOS_MAPPING.get());
    }

    public static void onClientTick(ClientTickEvent.Post event) {
        while (CHRONOS_MAPPING.get().consumeClick()) {
            // Execute logic to perform on click here
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                localPlayer.connection.sendChat(localPlayer.getBlockX() + " " + localPlayer.getBlockY() + " " + localPlayer.getBlockZ());
            }
        }
    }

//    public static void registerKeyInputs(){
//        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            if(shareCoords.wasPressed()){
//                if(client.player != null){
//                    client.player.networkHandler.sendChatMessage(client.player.getBlockX() + " " + client.player.getBlockY() + " " + client.player.getBlockZ());
//                }
//            }
//        });
//    }


//    public static void register(){
////        shareCoords = KeyBindingHelper.registerKeyBinding(new KeyMapping(
////                KEY_SHARE_COORDS,
////                InputUtil.Type.KEYSYM,
////                GLFW.GLFW_KEY_X,
////                KEY_CATEGORY_CHRONOS
////        ));
//
//
//        registerKeyInputs();
//    }
//    // Event is on the NeoForge event bus only on the physical client
//
}
