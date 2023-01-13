package dev.mrblackreal.fabricmod.client;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.block.BlockManager;
import dev.mrblackreal.fabricmod.item.ItemManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    private static final Logger logger = LogManager.getLogger(String.format("%s-%s", FabricMod.MOD_ID, Client.class.getSimpleName()));

    private static Client instance;

    private static ItemManager itemManager;
    private static BlockManager blockManager;

    @Override
    public void onInitializeClient() {
        instance = this;

        blockManager = new BlockManager();
        itemManager = new ItemManager();

        logger.info("Initialized clientside mod!");
    }

    public static Logger getLogger() {
        return logger;
    }

    public static Client getInstance() {
        return instance;
    }

    public static ItemManager getItemManager() {
        return itemManager;
    }

    public static BlockManager getBlockManager() {
        return blockManager;
    }
}
