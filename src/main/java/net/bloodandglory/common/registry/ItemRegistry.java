package net.bloodandglory.common.registry;

import net.bloodandglory.BloodAndGlory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
    public static final Item.Settings GROUP_MISC = new Item.Settings().group(ItemGroup.MISC);

    public static final Item MITHRIL = new Item(GROUP_MISC);

    @Override
    public void registry(Item registryThing,Identifier identifier) {
        ITEMS.add(registryThing);
        Registry.register(Registry.ITEM,identifier,registryThing);
    }

    @Override
    public void registryAll() {
        try {
            for (Field field : ItemRegistry.class.getDeclaredFields()) {
                if (field.get(null) instanceof Item) {
                    Item item = (Item) field.get(null);
                    String itemName = field.getName().toLowerCase(Locale.ENGLISH);

                    Identifier identifier = new Identifier(BloodAndGlory.MOD_ID,itemName);
                    registry(item,identifier);
                }
            }
            System.out.println("Items have readied");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
