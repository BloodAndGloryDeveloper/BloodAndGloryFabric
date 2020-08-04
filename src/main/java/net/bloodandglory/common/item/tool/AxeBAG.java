package net.bloodandglory.common.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AxeBAG extends AxeItem {
    public AxeBAG(ToolMaterial toolMaterial,float attackDamaged,float attackSpend,Settings settings) {
        super(toolMaterial,attackDamaged,attackSpend,settings);
    }

    public AxeBAG(ToolMaterial toolMaterial,Settings settings) {
        super(toolMaterial,4.0F,-3.1F,settings);
    }
}
