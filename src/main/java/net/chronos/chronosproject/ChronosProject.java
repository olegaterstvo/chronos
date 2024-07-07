package net.chronos.chronosproject;

import com.mojang.logging.LogUtils;
import net.chronos.chronosproject.block.ModBlocks;
//import net.chronos.chronosproject.config.ModConfigs;
//import net.chronos.chronosproject.enchantment.ModEnchantments;
//import net.chronos.chronosproject.event.BlockBreakHandler;
import net.chronos.chronosproject.config.ChronosProjectClientConfigs;
import net.chronos.chronosproject.config.ChronosProjectCommonConfigs;
//import net.chronos.chronosproject.enchantment.ModEnchantments;
import net.chronos.chronosproject.item.ModItemGroup;
import net.chronos.chronosproject.item.ModItems;
import net.chronos.chronosproject.loot.ModLootModifiers;
import net.chronos.chronosproject.potion.ModPotions;
import net.chronos.chronosproject.sound.ModSounds;
import net.chronos.chronosproject.event.KeyInputHandler;
//import net.chronos.chronosproject.trade.ModTrades;
//import net.chronos.chronosproject.util.ModLootTableModifiers;
//import net.chronos.chronosproject.util.ModLootModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
//import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
//import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Mod(ChronosProject.MOD_ID)
public class ChronosProject{
	public static final String MOD_ID = "chronosproject";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ChronosProject(IEventBus eventBus, ModContainer modContainer)
	{
//		IEventBus eventBus = ModLoadingContext.get().getActiveContainer().getEventBus();
		modContainer.registerConfig(ModConfig.Type.CLIENT, ChronosProjectClientConfigs.SPEC,"chronosproject-client.toml");
		modContainer.registerConfig(ModConfig.Type.COMMON, ChronosProjectCommonConfigs.SPEC,"chronosproject-common.toml");

		ModItems.register(eventBus);
		ModBlocks.register(eventBus);
		ModItemGroup.register(eventBus);
		ModPotions.register(eventBus);
		ModSounds.register(eventBus);
		ModLootModifiers.register(eventBus);
//		ModEnchantments.register(eventBus);


		NeoForge.EVENT_BUS.addListener(KeyInputHandler::onClientTick);
		NeoForge.EVENT_BUS.addListener(ModPotions::registerBrewingRecipes);

//
//		eventBus.addListener(this::setup);


		// Register ourselves for server and other game events we are interested in
//		NeoForge.EVENT_BUS.register(this);
	}


//	private void setup(final FMLCommonSetupEvent event)
//	{
////		event.enqueueWork(() -> {
////			BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.COCOA_BEANS, ModPotions.HASTE_POTION.get()));
////			BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HASTE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE_POTION.get()));
////			BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HASTE_POTION.get(), Items.REDSTONE, ModPotions.LONG_HASTE_POTION.get()));
////			BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.NAUTILUS_SHELL, Potions.LUCK));
////			BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.WEAKNESS, Items.ENDER_EYE, ModPotions.PSYCHOSIS_POTION.get()));
////
//////            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of((ItemLike)Potions.AWKWARD), Ingredient.of(new ItemStack(Items.COCOA_BEANS)), new ItemStack((ItemLike) ModPotions.HASTE_POTION.get())));
//////            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of((ItemLike)ModPotions.HASTE_POTION.get()), Ingredient.of(Items.GLOWSTONE_DUST), new ItemStack((ItemLike) ModPotions.STRONG_HASTE_POTION.get())));
//////            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of((ItemLike)ModPotions.HASTE_POTION.get()), Ingredient.of(Items.REDSTONE), new ItemStack((ItemLike) ModPotions.LONG_HASTE_POTION.get())));
//////            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of((ItemLike)Potions.AWKWARD), Ingredient.of(Items.NAUTILUS_SHELL), new ItemStack((ItemLike) Potions.LUCK)));
////		});
//	}
//	@Override
//	public void onInitialize() {
//
//		ModConfigs.registerConfigs();
//
//		ModItemGroup.registerItemGroups();
//		ModItems.registerModItems();
//		ModBlocks.registerModBlocks();
//		ModPotions.registerPotions();
//		ModSounds.registerModSounds();
//		ModTrades.registerCustomTrades();
//
//		BlockBreakHandler.register();
//		ModEnchantments.registerModEnchantments();
//
//		ModLootTableModifiers.modifyLootTables();
//	}
}
