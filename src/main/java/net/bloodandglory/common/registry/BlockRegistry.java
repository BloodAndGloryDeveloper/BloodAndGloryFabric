package net.bloodandglory.common.registry;

import net.bloodandglory.BloodAndGlory;
import net.bloodandglory.client.TabBAG;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class BlockRegistry implements IRegistry<Block>{
    private BlockRegistry() { }

    public static final BlockRegistry INSTANCE = new BlockRegistry();
    public static final Set<Block> BLOCKS = new HashSet<>();

    public static final Block MITHRIL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(true).build());
    public static final Block MITHRIL_ORE = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(false)
            .breakByTool(FabricToolTags.PICKAXES,2).build());

    @Override
    public void registry(Block registryThing, Identifier identifier) {
        BLOCKS.add(registryThing);
        //注册物品自然要用物品的注册方法啊（暴论）
        ItemRegistry.INSTANCE.registry(new BlockItem(registryThing,TabBAG.GROUP_BLOCK),identifier);
        Registry.register(Registry.BLOCK,identifier,registryThing);
    }

    @Override
    public void registryAll() {
        for (Field field : BlockRegistry.class.getDeclaredFields()) {
            try {
                //获取公共对象字段并判断类型
                if (field.get(null) instanceof Block) {
                    //字段名称转换成小写
                    String blockName = field.getName().toLowerCase(Locale.ENGLISH);
                    Identifier identifier = new Identifier(BloodAndGlory.MOD_ID,blockName);

                    registry((Block)field.get(null),identifier);
                }
            } catch (Exception ex) {
                //field.get(null)会抛出异常
                ex.printStackTrace();
            }
        }
    }
}
