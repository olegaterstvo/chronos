package net.chronos.chronosproject.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CHRONOS = "key.category.chronosproject.chronos";
    public static final String KEY_SHARE_COORDS = "key.chronosproject.share_coords";

    public static KeyBinding shareCoords;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(shareCoords.wasPressed()){
                if(client.player != null){
                    client.player.networkHandler.sendChatMessage(client.player.getBlockX() + " " + client.player.getBlockY() + " " + client.player.getBlockZ());
                }
            }
        });
    }


    public static void register(){
        shareCoords = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SHARE_COORDS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                KEY_CATEGORY_CHRONOS
        ));

        registerKeyInputs();
    }

}
