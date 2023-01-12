package dev.mrblackreal.fabricmod.item;

import net.minecraft.item.Item;

import java.util.HashMap;

public class ItemManager {

    private final HashMap<String, Item> itemHashMap = new HashMap<>();

    public ItemManager() {
        itemHashMap.put("test_item", new Item(new Item.Settings().maxCount(64)));
    }

    private void addItem(String id, Item object) {
        itemHashMap.put(id, object);
    }

    public HashMap<String, Item> getItemHashMap() {
        return itemHashMap;
    }
}
