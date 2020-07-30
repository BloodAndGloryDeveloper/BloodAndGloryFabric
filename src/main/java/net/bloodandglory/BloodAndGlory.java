package net.bloodandglory;

import net.bloodandglory.common.registry.Registry;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BloodAndGlory implements ModInitializer {
    public static final String  MOD_ID = "bloodandglory";
    private static Logger logger = LogManager.getLogger(BloodAndGlory.class);

    /**
     * 根据测试，我们发现只有在主类下调用这个方法才有效，在其他类调用无效
     */
    @Override
    public void onInitialize() {
        logger.info("BloodAndGlory started!");
        logger.info("OK,we are going to registered.");
        Registry.INSTANCE.registryAll();
    }
}
