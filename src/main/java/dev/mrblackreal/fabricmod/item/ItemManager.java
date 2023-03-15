package dev.mrblackreal.fabricmod.item;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.block.BlockManager;
import dev.mrblackreal.fabricmod.client.Client;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager {

    private static final HashMap<ItemGroup, Item> itemHashMap = new HashMap<>();

    public static final BlockItem GUNPOWDER_BLOCK_ITEM = (BlockItem) registerItem(ItemGroups.NATURAL, "gunpowder_block", new BlockItem(BlockManager.GUNPOWDER_BLOCK, new Item.Settings().maxCount(64).recipeRemainder(Items.GUNPOWDER)));
    public static final Item CUSTOM_ITEM = Registry.register(Registries.ITEM, new Identifier(FabricMod.MOD_ID, "custom_item"), new Item(new FabricItemSettings()));

    public ItemManager() {


        ItemGroups.getGroups().forEach(group -> {
            final List<Item> items = new ArrayList<>();

            itemHashMap.forEach((group1, item) -> {
                if (group == group1) items.add(item);
            });

            if (items.size() > 0)
                ItemGroupEvents.modifyEntriesEvent(group).register(content -> items.forEach(content::add));
        });

        Client.getLogger().info(String.format("Registered items for %s!", FabricMod.MOD_ID));
    }

    private static Item registerItem(ItemGroup group, String id, Item object) {
        Client.getLogger().info(String.format("Registering item -> %s...", id));

        final Item item = Registry.register(Registries.ITEM, new Identifier(FabricMod.MOD_ID, id), object);
        itemHashMap.put(group, item);

        return item;
    }
}
