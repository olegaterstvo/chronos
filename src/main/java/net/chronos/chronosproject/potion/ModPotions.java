package net.chronos.chronosproject.potion;

import net.chronos.chronosproject.ChronosProject;
import net.chronos.chronosproject.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.sound.sampled.Port;

public class ModPotions {
    public static Potion HASTE_POTION;
    public static Potion STRONG_HASTE_POTION;
    public static Potion LONG_HASTE_POTION;

    public static Potion registerPotion(String name, StatusEffect effect, Integer duration, Integer amplifier){
        return Registry.register(Registry.POTION, new Identifier(ChronosProject.MOD_ID, name),
        new Potion(new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static  void registerPotions(){
        HASTE_POTION = registerPotion("haste_potion", StatusEffects.HASTE, 3600, 0);
        STRONG_HASTE_POTION = registerPotion("strong_haste_potion", StatusEffects.HASTE, 1800, 1);
        LONG_HASTE_POTION = registerPotion("long_haste_potion", StatusEffects.HASTE, 9600, 0);

        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.COCOA_BEANS, ModPotions.HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.REDSTONE, ModPotions.LONG_HASTE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.NAUTILUS_SHELL, Potions.LUCK);

    }
}
