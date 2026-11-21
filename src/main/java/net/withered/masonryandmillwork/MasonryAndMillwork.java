package net.withered.masonryandmillwork;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import net.withered.masonryandmillwork.block.ModBlocks;
import net.withered.masonryandmillwork.inventory.ModMenuTypes;
import net.withered.masonryandmillwork.item.ModItemGroups;
import net.withered.masonryandmillwork.item.crafting.ModRecipeSerializers;
import net.withered.masonryandmillwork.item.crafting.ModRecipeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasonryAndMillwork implements ModInitializer {
	public static final String MOD_ID = "masonryandmillwork";

	@Override
	public void onInitialize() {
        ModBlocks.init();
        ModMenuTypes.init();
        ModRecipeTypes.init();
        ModRecipeSerializers.init();
        ModItemGroups.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
