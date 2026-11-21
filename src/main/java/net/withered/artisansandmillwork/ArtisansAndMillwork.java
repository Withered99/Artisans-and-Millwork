package net.withered.artisansandmillwork;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.inventory.ModMenuTypes;
import net.withered.artisansandmillwork.item.ModItemGroups;
import net.withered.artisansandmillwork.item.crafting.ModRecipeSerializers;
import net.withered.artisansandmillwork.item.crafting.ModRecipeTypes;

public class ArtisansAndMillwork implements ModInitializer {
	public static final String MOD_ID = "artisansandmillwork";

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
