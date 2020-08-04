package net.bloodandglory.common.item.tool;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBAG extends PickaxeItem {
    public PickaxeBAG(ToolMaterial toolMaterial,int attackDamage,float attackSpeed,Settings settings) {
        super(toolMaterial,attackDamage,attackSpeed,settings);
    }

    public PickaxeBAG(ToolMaterial toolMaterial,Settings settings) {
        super(toolMaterial,1,-2.6F,settings);
    }
}
