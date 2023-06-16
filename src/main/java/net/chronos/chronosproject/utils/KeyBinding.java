package net.chronos.chronosproject.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_CHRONOS = "key.category.chronosproject";
    public static final String KEY_SHARE_COORDINATES = "key.chronosproject.share_coordinates";

    public static final KeyMapping SHARE_COORDINATES_KEY = new KeyMapping(KEY_SHARE_COORDINATES, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_CHRONOS);

}
