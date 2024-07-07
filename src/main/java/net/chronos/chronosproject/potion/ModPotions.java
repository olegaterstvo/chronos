package net.chronos.chronosproject.potion;

import net.chronos.chronosproject.ChronosProject;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


public class ModPotions {
    public static RegistryEntry<Potion> HASTE_POTION;
    public static RegistryEntry<Potion> STRONG_HASTE_POTION;
    public static RegistryEntry<Potion> LONG_HASTE_POTION;

    public static RegistryEntry<Potion> registerPotion(String name, RegistryEntry<StatusEffect> effect, Integer duration, Integer amplifier){
        return Registry.registerReference(Registries.POTION, Identifier.of(ChronosProject.MOD_ID, name),
                new Potion(new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static  void registerPotions(){
        HASTE_POTION = registerPotion("haste_potion", StatusEffects.HASTE, 3600, 0);
        STRONG_HASTE_POTION = registerPotion("strong_haste_potion", StatusEffects.HASTE, 1800, 1);
        LONG_HASTE_POTION = registerPotion("long_haste_potion", StatusEffects.HASTE, 9600, 0);

        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        FabricBrewingRecipeRegistryBuilder.BUILD.register((builder) -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(Items.COCOA_BEANS), ModPotions.HASTE_POTION);
            builder.registerPotionRecipe(ModPotions.HASTE_POTION, Ingredient.ofItems(Items.GLOWSTONE_DUST), ModPotions.STRONG_HASTE_POTION);
            builder.registerPotionRecipe(ModPotions.HASTE_POTION, Ingredient.ofItems(Items.REDSTONE), ModPotions.LONG_HASTE_POTION);
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(Items.NAUTILUS_SHELL), Potions.LUCK);
        });

    }
}
