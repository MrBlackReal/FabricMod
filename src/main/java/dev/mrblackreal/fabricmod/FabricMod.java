package dev.mrblackreal.fabricmod;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.util.Identifier;

public class FabricMod implements ModInitializer {

    public static final String MOD_ID = "fabricmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "test_group")).icon(() -> new ItemStack(Items.ENDER_DRAGON_SPAWN_EGG)).build();

    @Override
    public void onInitialize() {
        
    }

    public static ItemGroup getItemGroup() {
        return ITEM_GROUP;
    }
}
