package net.bloodandglory.common.item.tool;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

import java.util.Set;

public class ShovelBAG extends ShovelItem {
    public ShovelBAG(ToolMaterial toolMaterial,float attackDamage, float attackSpend,Settings settings) {
        super(toolMaterial,attackDamage,attackSpend,settings);
    }

    public ShovelBAG(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial,1.5F,-3.0F,settings);
    }
}
