package net.chronos.chronosproject;

import com.mojang.logging.LogUtils;
import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.config.ChronosProjectClientConfigs;
import net.chronos.chronosproject.config.ChronosProjectCommonConfigs;
import net.chronos.chronosproject.item.ModItemGroup;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.loot.ModLootModifiers;
import net.chronos.chronosproject.potion.ModPotions;
import net.chronos.chronosproject.sound.ModSounds;
import net.chronos.chronosproject.event.KeyInputHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(ChronosProject.MOD_ID)
public class ChronosProject{
	public static final String MOD_ID = "chronosproject";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ChronosProject(IEventBus eventBus, ModContainer modContainer)
	{
		modContainer.registerConfig(ModConfig.Type.CLIENT, ChronosProjectClientConfigs.SPEC,"chronosproject-client.toml");
		modContainer.registerConfig(ModConfig.Type.COMMON, ChronosProjectCommonConfigs.SPEC,"chronosproject-common.toml");

		ModItems.register(eventBus);
		ModBlocks.register(eventBus);
		ModItemGroup.register(eventBus);
		ModPotions.register(eventBus);
		ModSounds.register(eventBus);
		ModLootModifiers.register(eventBus);


		NeoForge.EVENT_BUS.addListener(KeyInputHandler::onClientTick);
		NeoForge.EVENT_BUS.addListener(ModPotions::registerBrewingRecipes);
	}

}
