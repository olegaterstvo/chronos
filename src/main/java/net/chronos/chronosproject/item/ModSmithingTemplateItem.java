package net.chronos.chronosproject.item;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collections;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, Identifier emptyBaseSlotTextures, Identifier emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, Collections.singletonList(emptyBaseSlotTextures), Collections.singletonList(emptyAdditionsSlotTextures));
    }


}
