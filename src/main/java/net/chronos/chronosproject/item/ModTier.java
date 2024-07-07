package net.chronos.chronosproject.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
public class ModTier {
    public static final Tier CHRONOS_TIER = new SimpleTier(
            // The tag that determines what blocks this tool cannot break. See below for more information.
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            // Determines the durability of the tier.
            10000,
                    // Determines the mining speed of the tier. Unused by swords.
                    32f,
                    // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
                    // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords, respectively; our sword does 5.5 damage now.
                    3f,
                    // Determines the enchantability of the tier. This represents how good the enchantments on this tool will be.
                    // Gold uses 22, we put copper slightly below that.
                    26,
                    // Determines the repair ingredient of the tier. Use a supplier for lazy initializing.
                    () -> Ingredient.of(ModItems.CHRONOS_DYE.get())
            );

}
