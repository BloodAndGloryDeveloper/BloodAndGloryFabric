package net.bloodandglory.common.item.tool;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBAG extends SwordItem {
    public SwordBAG(ToolMaterial toolMaterial,int attackDamage,float attackSpeed,Settings settings) {
        super(toolMaterial,attackDamage,attackSpeed,settings);
    }

    public SwordBAG(ToolMaterial toolMaterial,Settings settings) {
        super(toolMaterial,6,-2.3F,settings);
    }
}
