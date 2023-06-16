package net.chronos.chronosproject.event;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.utils.KeyBinding;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ChronosProject.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if(KeyBinding.SHARE_COORDINATES_KEY.consumeClick()) {
                assert Minecraft.getInstance().player != null;
//                Minecraft.getInstance().player.sendMessage(new TextComponent("test"), Minecraft.getInstance().player.getUUID());
                Minecraft.getInstance().player.chat((int)Minecraft.getInstance().player.getX() + " " +
                        (int)Minecraft.getInstance().player.getY() + " " +
                        (int)Minecraft.getInstance().player.getZ());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = ChronosProject.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(FMLClientSetupEvent event) {
            ClientRegistry.registerKeyBinding(KeyBinding.SHARE_COORDINATES_KEY);
        }
    }
}
