package net.chronos.chronosproject;

import net.chronos.chronosproject.block.ModBlocks;
import net.chronos.chronosproject.item.ModItemGroup;
import net.chronos.chronosproject.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChronosProject implements ModInitializer {
	public static final String MOD_ID = "chronosproject";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
