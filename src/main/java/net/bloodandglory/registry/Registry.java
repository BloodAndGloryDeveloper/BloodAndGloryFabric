package net.bloodandglory.registry;

public class Registry {
    private Registry() { }

    public static final Registry INSTANCE = new Registry();

    public void registryAll() {
        ItemRegistry.INSTANCE.registryAll();
    }
}
