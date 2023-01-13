package dev.mrblackreal.fabricmod.block;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.client.Client;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class BlockManager {

    public BlockManager() {
        Client.getLogger().info(String.format("Registering items for %s...", FabricMod.MOD_ID));
    }

    public final Block TEST_BLOCK = null;
    public final Block SECOND_TEST_BLOCK = null;

    private Block registerBlock(String id, Block object) {
        return Registry.register(Registries.BLOCK, new Identifier(FabricMod.MOD_ID, id), object);
    }
}
