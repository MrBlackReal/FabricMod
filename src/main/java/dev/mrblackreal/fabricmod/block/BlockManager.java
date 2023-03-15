package dev.mrblackreal.fabricmod.block;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.block.blocks.GunpowderBlock;
import dev.mrblackreal.fabricmod.client.Client;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockManager {

    private static final HashMap<ItemGroup, Block> blockHashMap = new HashMap<>();

    public static final Block GUNPOWDER_BLOCK = registerBlock(FabricMod.ITEM_GROUP, "gunpowder_block", new GunpowderBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT)));

    public BlockManager() {
        ItemGroups.getGroups().forEach(group -> {
            final List<Block> blocks = new ArrayList<>();

            blockHashMap.forEach((group1, block) -> {
                if (group == group1) blocks.add(block);
            });

            if (blocks.size() > 0)
                ItemGroupEvents.modifyEntriesEvent(group).register(content -> blocks.forEach(content::add));
        });

        Client.getLogger().info(String.format("Registered blocks for %s!", FabricMod.MOD_ID));
    }

    private static Block registerBlock(ItemGroup group, String id, Block object) {
        Client.getLogger().info(String.format("Registering block -> %s...", id));

        final Block block = Registry.register(Registries.BLOCK, new Identifier(FabricMod.MOD_ID, id), object);
        blockHashMap.put(group, block);

        return block;
    }
}
