package net.chronos.chronosproject.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.network.chat.Component;
import java.util.Collections;


public class ModSmithingTemplateItem extends SmithingTemplateItem {
    public ModSmithingTemplateItem(Component appliesToText,
                                   Component ingredientsText,
                                   Component titleText,
                                   Component baseSlotDescriptionText,
                                   Component additionsSlotDescriptionText,
                                   ResourceLocation emptyBaseSlotTextures,
                                   ResourceLocation emptyAdditionsSlotTextures) {
        super(appliesToText,
                ingredientsText,
                titleText,
                baseSlotDescriptionText,
                additionsSlotDescriptionText,
                Collections.singletonList(emptyBaseSlotTextures),
                Collections.singletonList(emptyAdditionsSlotTextures));
    }
}
