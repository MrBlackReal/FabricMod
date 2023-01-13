package dev.mrblackreal.fabricmod.item;

import dev.mrblackreal.fabricmod.FabricMod;
import dev.mrblackreal.fabricmod.client.Client;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ItemManager {

    public ItemManager() {
        Client.getLogger().info(String.format("Registering items for %s...", FabricMod.MOD_ID));
    }

    public final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings().maxCount(64).fireproof()));
    public final Item SECOND_TEST_ITEM = registerItem("second_test_item", new Item(new FabricItemSettings().maxCount(64).fireproof()));

    private Item registerItem(String id, Item object) {
        return Registry.register(Registries.ITEM, new Identifier(FabricMod.MOD_ID, id), object);
    }
}
