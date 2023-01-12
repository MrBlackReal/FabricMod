package dev.mrblackreal.fabricmod.client;

import dev.mrblackreal.fabricmod.block.BlockManager;
import dev.mrblackreal.fabricmod.item.ItemManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    private static final Logger logger = LogManager.getLogger(Client.class.getSimpleName());

    private static Client instance;

    private ItemManager itemManager;
    private BlockManager blockManager;

    @Override
    public void onInitializeClient() {
        instance = this;

        this.itemManager = new ItemManager();
        this.blockManager = new BlockManager();

        this.itemManager.getItemHashMap().forEach((itemId, itemObject) -> Registry.register(Registries.ITEM, new Identifier("fabricmod", itemId), itemObject));
        this.blockManager.getBlockHashMap().forEach((blockId, blockObject) -> Registry.register(Registries.BLOCK, new Identifier("fabricmod", blockId), blockObject));

        logger.info("Initialized clientside mod!");
    }

    public static Logger getLogger() {
        return logger;
    }

    public static Client getInstance() {
        return instance;
    }

    public ItemManager getItemManager() {
        return this.itemManager;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }
}
