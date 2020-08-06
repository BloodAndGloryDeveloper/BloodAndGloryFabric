package net.bloodandglory.common.registry;

import net.bloodandglory.BloodAndGlory;
import net.bloodandglory.client.TabBAG;
import net.bloodandglory.common.item.armor.ArmorMaterialsBAG;
import net.bloodandglory.common.item.tool.ToolMaterialsBAG;
import net.bloodandglory.common.item.tool.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ItemRegistry implements IRegistry<Item> {
    private ItemRegistry() { }

    public static final ItemRegistry INSTANCE = new ItemRegistry();
    public static final Set<Item> ITEMS = new HashSet<>();

    public static final Item MITHRIL = new Item(TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_AXE = new AxeBAG(ToolMaterialsBAG.MITHRIL,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_HOE = new HoeBAG(ToolMaterialsBAG.MITHRIL,0.1F,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_SWORD = new SwordBAG(ToolMaterialsBAG.MITHRIL,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_SHOVEL = new ShovelBAG(ToolMaterialsBAG.MITHRIL,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_PICKAXE = new PickaxeBAG(ToolMaterialsBAG.MITHRIL,TabBAG.GROUP_ITEM);
    //Helmet——头盔，Chestplate——胸甲，Leggings——护腿，Boots——靴子
    public static final Item MITHRIL_HELMET = new ArmorItem(ArmorMaterialsBAG.MITHRIL,EquipmentSlot.HEAD,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_CHESTPLATE = new ArmorItem(ArmorMaterialsBAG.MITHRIL,EquipmentSlot.CHEST,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_LEGGINGS = new ArmorItem(ArmorMaterialsBAG.MITHRIL,EquipmentSlot.LEGS,TabBAG.GROUP_ITEM);
    public static final Item MITHRIL_BOOTS = new ArmorItem(ArmorMaterialsBAG.MITHRIL,EquipmentSlot.FEET,TabBAG.GROUP_ITEM);

    public static final Item BRONZE = new Item(TabBAG.GROUP_ITEM);
    public static final Item BRONZE_AXE = new AxeBAG(ToolMaterialsBAG.BRONZE,TabBAG.GROUP_ITEM);
    public static final Item BRONZE_HOE = new HoeBAG(ToolMaterialsBAG.BRONZE,0.2F,TabBAG.GROUP_ITEM);
    public static final Item BRONZE_SWORD = new SwordBAG(ToolMaterialsBAG.BRONZE,TabBAG.GROUP_ITEM);
    public static final Item BRONZE_SHOVEL = new ShovelBAG(ToolMaterialsBAG.BRONZE,TabBAG.GROUP_ITEM);
    public static final Item BRONZE_PICKAXE = new PickaxeBAG(ToolMaterialsBAG.BRONZE,TabBAG.GROUP_ITEM);
    public static final Item BRONZE_HELMET = new ArmorItem(ArmorMaterialsBAG.MITHRIL,EquipmentSlot.HEAD,TabBAG.GROUP_ITEM);

    @Override
    public void registry(Item registryThing,Identifier identifier) {
        ITEMS.add(registryThing);
        Registry.register(Registry.ITEM,identifier,registryThing);
    }

    @Override
    public void registryAll() {
        for (Field field : ItemRegistry.class.getDeclaredFields()) {
            try {
                    //获取公共对象字段并判断类型
                    if (field.get(null) instanceof Item) {
                        Item item = (Item) field.get(null);
                        //字段名称转换成小写
                        String itemName = field.getName().toLowerCase(Locale.ENGLISH);

                        Identifier identifier = new Identifier(BloodAndGlory.MOD_ID,itemName);
                        registry(item,identifier);
                        BloodAndGlory.getLogger().info(item.getTranslationKey() + ": be done");
                    }
            } catch (Exception ex) {
                //field.get(null)会抛出异常
                ex.printStackTrace();
            }
        }
    }

    /*public void registryArmor(Item material,Item.Settings settings,ArmorMaterial armorMaterial) {
        String path = material.getTranslationKey();
        registry(new ArmorItem(armorMaterial,EquipmentSlot.HEAD,settings),new Identifier());
    }*/
}
