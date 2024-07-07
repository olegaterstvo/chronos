package net.chronos.chronosproject.potion;

import net.chronos.chronosproject.ChronosProject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
//import net.minecraft.entity.effect.StatusEffect;
//import net.minecraft.entity.effect.StatusEffectInstance;
//import net.minecraft.entity.effect.StatusEffects;
//import net.minecraft.item.Item;
//import net.minecraft.item.Items;
//import net.minecraft.potion.Potion;
//import net.minecraft.potion.Potions;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import javax.sound.sampled.Port;

//public class ModPotions {
//    public static Potion HASTE_POTION;
//    public static Potion STRONG_HASTE_POTION;
//    public static Potion LONG_HASTE_POTION;
//
//    public static Potion registerPotion(String name, MobEffectInstance effect, Integer duration, Integer amplifier){
//        return Registry.register(Registries.POTION, new Identifier(ChronosProject.MOD_ID, name),
//        new Potion(new StatusEffectInstance(effect, duration, amplifier)));
//    }
//
//    public static  void registerPotions(){
//        HASTE_POTION = registerPotion("haste_potion", StatusEffects.HASTE, 3600, 0);
//        STRONG_HASTE_POTION = registerPotion("strong_haste_potion", StatusEffects.HASTE, 1800, 1);
//        LONG_HASTE_POTION = registerPotion("long_haste_potion", StatusEffects.HASTE, 9600, 0);
//
//        registerPotionRecipes();
//    }
//
//    private static void registerPotionRecipes(){
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.COCOA_BEANS, ModPotions.HASTE_POTION);
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE_POTION);
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.REDSTONE, ModPotions.LONG_HASTE_POTION);
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.NAUTILUS_SHELL, Potions.LUCK);
//
//    }
//}
public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, ChronosProject.MOD_ID);


    public static final DeferredHolder<Potion, Potion> HASTE_POTION = POTIONS.register("haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_HASTE_POTION = POTIONS.register("strong_haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_HASTE_POTION = POTIONS.register("long_haste_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0)));


    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        // Gets the builder to add recipes to
        PotionBrewing.Builder builder = event.getBuilder();

        // Will add brewing recipes for all container potions (e.g. potion, splash potion, lingering potion)
        builder.addMix(Potions.AWKWARD, Items.COCOA_BEANS, ModPotions.HASTE_POTION);
        builder.addMix(ModPotions.HASTE_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE_POTION);
        builder.addMix(ModPotions.HASTE_POTION, Items.REDSTONE, ModPotions.LONG_HASTE_POTION);
        builder.addMix(Potions.AWKWARD, Items.NAUTILUS_SHELL, Potions.LUCK);
    }
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}