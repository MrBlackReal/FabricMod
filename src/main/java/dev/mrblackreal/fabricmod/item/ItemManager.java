package dev.mrblackreal.fabricmod.item;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.client.Client;
import dev.mrblackreal.fabricmod.item.items.TestItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager {

    private final HashMap<ItemGroup, Item> itemHashMap = new HashMap<>();

    public ItemManager() {
        this.itemHashMap.put(FabricMod.getItemGroup(), registerItem("test_item", new TestItem(new FabricItemSettings().maxCount(64))));

        ItemGroups.getGroups().forEach(group -> {
            final List<Item> items = new ArrayList<>();

            this.itemHashMap.forEach((group1, item) -> {
                if (group == group1) items.add(item);
            });

            if (items.size() > 0)
                ItemGroupEvents.modifyEntriesEvent(group).register(content -> items.forEach(content::add));
        });

        Client.getLogger().info(String.format("Registering items for %s...", FabricMod.MOD_ID));
    }

    private Item registerItem(String id, Item object) {
        return Registry.register(Registries.ITEM, new Identifier(FabricMod.MOD_ID, id), object);
    }

    public HashMap<ItemGroup, Item> getItemHashMap() {
        return itemHashMap;
    }
}
