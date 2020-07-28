package net.bloodandglory.registry;

import net.minecraft.util.Identifier;

/**
 * 负责定义注册器
 * @param <T> 要注册的类型
 */
public interface IRegistry<T> {
    /**
     * 定义如何注册物品的逻辑
     * @param registryThing 要注册的项目
     * @param identifier    资源路径
     */
    void registry(T registryThing, Identifier identifier);

    /**
     * 调用这个方法会一次性注册注册器下面所有物品
     */
    void registryAll();
}
