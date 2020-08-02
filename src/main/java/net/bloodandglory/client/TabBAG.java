package net.bloodandglory.client;

import net.bloodandglory.BloodAndGlory;
import net.bloodandglory.common.registry.ItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TabBAG {
    public static final ItemGroup BAG_ITEM = FabricItemGroupBuilder.build(new Identifier(BloodAndGlory.MOD_ID,"item"),
            () -> new ItemStack(ItemRegistry.MITHRIL));

    public static final Item.Settings GROUP_ITEM = new Item.Settings().group(BAG_ITEM);
}