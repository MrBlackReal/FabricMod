package dev.mrblackreal.fabricmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Unmodifiable;

public class FabricMod implements ModInitializer {

    @Unmodifiable
    public static final String MOD_ID = "fabricmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "test_group")).icon(() -> new ItemStack(Items.ENDER_DRAGON_SPAWN_EGG)).build();

    @Override
    public void onInitialize() {
        
    }
}
