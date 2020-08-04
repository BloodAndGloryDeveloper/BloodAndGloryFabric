package net.bloodandglory.common.registry;

public class Registry {
    private Registry() { }

    public static final Registry INSTANCE = new Registry();

    public void registryAll() {
        ItemRegistry.INSTANCE.registryAll();
        BlockRegistry.INSTANCE.registryAll();
    }
}
