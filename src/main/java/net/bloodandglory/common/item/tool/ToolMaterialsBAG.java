package net.bloodandglory.common.item.tool;

import net.bloodandglory.common.registry.ItemRegistry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ToolMaterialsBAG implements ToolMaterial {
    MITHRIL(2,1009,10.0F,
            4.0F,30,() -> {
        return Ingredient.ofItems(ItemRegistry.MITHRIL);
    }),
    BRONZE(1,759,7.5F,
            3.0F,14,() -> {
        return Ingredient.ofItems(ItemRegistry.BRONZE);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    /**
     *
     * @param miningLevel       采矿级别 最低为0，最高原版为3
     * @param itemDurability    耐久
     * @param miningSpeed       挖掘速度
     * @param attackDamage      攻击伤害
     * @param enchantibility    附魔等级
     * @param repairIngredient  维修这个要什么
     */
    ToolMaterialsBAG(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeed() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
