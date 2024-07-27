package net.chronos.chronosproject.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.chronos.chronosproject.ChronosProject;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = ChronosProject.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(CHRONOS_MAPPING.get());
    }

    public static void onClientTick(ClientTickEvent.Post event) {
        while (CHRONOS_MAPPING.get().consumeClick()) {
            // Execute logic to perform on click here
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                if(localPlayer.getPermissionLevel() >= 2) {
                    String msg = "tellraw @a [\"\",{\"text\":\"<" +
                            localPlayer.getName().getString() +
                            "> \"},{\"text\":\"" +
                            localPlayer.getBlockX() + " " + localPlayer.getBlockY() + " " + localPlayer.getBlockZ() +
                            "\",\"color\":\"blue\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/tp " +
                            localPlayer.getBlockX() + " " + localPlayer.getBlockY() + " " + localPlayer.getBlockZ() +
                            "\"}}]";
                    localPlayer.connection.sendCommand(msg);
                } else {
                    localPlayer.connection.sendChat(localPlayer.getBlockX() + " " + localPlayer.getBlockY() + " " + localPlayer.getBlockZ());
                }
            }
        }
    }

}
