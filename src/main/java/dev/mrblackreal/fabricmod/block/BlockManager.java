package dev.mrblackreal.fabricmod.block;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.client.Client;
import dev.mrblackreal.fabricmod.item.items.TestItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockManager {

    private final HashMap<ItemGroup, Block> blockHashMap = new HashMap<>();

    public BlockManager() {

        ItemGroups.getGroups().forEach(group -> {
            final List<Block> blocks = new ArrayList<>();

            this.blockHashMap.forEach((group1, item) -> {
                if (group == group1) blocks.add(item);
            });

            if (blocks.size() > 0)
                ItemGroupEvents.modifyEntriesEvent(group).register(content -> blocks.forEach(content::add));
        });

        Client.getLogger().info(String.format("Registering blocks for %s...", FabricMod.MOD_ID));
    }

    private Block registerBlock(String id, Block object) {
        return Registry.register(Registries.BLOCK, new Identifier(FabricMod.MOD_ID, id), object);
    }

    public HashMap<ItemGroup, Block> getBlockHashMap() {
        return blockHashMap;
    }
}
