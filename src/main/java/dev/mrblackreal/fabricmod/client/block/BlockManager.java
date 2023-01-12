package dev.mrblackreal.fabricmod.client.block;

import net.minecraft.block.Block;

import java.util.HashMap;

public class BlockManager {

    private final HashMap<String, Block> blockHashMap = new HashMap<>();

    public BlockManager() {

    }

    private void addBlock(String id, Block object) {
        blockHashMap.put(id, object);
    }

    public HashMap<String, Block> getBlockHashMap() {
        return blockHashMap;
    }
}
