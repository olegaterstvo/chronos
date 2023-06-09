package net.chronos.chronosproject;

import com.mojang.logging.LogUtils;
import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.potion.ModPotions;
import net.chronos.chronosproject.sound.ModSounds;
import net.chronos.chronosproject.utils.BetterBrewingRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ChronosProject.MOD_ID)
public class ChronosProject
{
    public static final String MOD_ID = "chronosproject";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ChronosProject()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModPotions.register(eventBus);
        ModSounds.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.COCOA_BEANS, ModPotions.HASTE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HASTE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HASTE_POTION.get(), Items.REDSTONE, ModPotions.LONG_HASTE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.NAUTILUS_SHELL, Potions.LUCK));

        });
    }
}
