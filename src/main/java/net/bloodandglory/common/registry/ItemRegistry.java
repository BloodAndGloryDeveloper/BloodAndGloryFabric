package net.bloodandglory.common.registry;

import javafx.scene.control.Tab;
import net.bloodandglory.BloodAndGlory;
import net.bloodandglory.client.TabBAG;
import net.bloodandglory.common.item.ToolMaterialBAG;
import net.bloodandglory.common.item.tool.AxeBAG;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
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
    public static final Item MITHRIL_AXE = new AxeBAG(ToolMaterialBAG.MITHRIL,11.0F,-0.9F,TabBAG.GROUP_ITEM);

    @Override
    public void registry(Item registryThing,Identifier identifier) {
        ITEMS.add(registryThing);
        Registry.register(Registry.ITEM,identifier,registryThing);
    }

    @Override
    public void registryAll() {
        for (Field field : ItemRegistry.class.getDeclaredFields()) {
            try {
                    if (field.get(null) instanceof Item) {
                        Item item = (Item) field.get(null);
                        String itemName = field.getName().toLowerCase(Locale.ENGLISH);

                        Identifier identifier = new Identifier(BloodAndGlory.MOD_ID,itemName);
                        registry(item,identifier);
                    }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
