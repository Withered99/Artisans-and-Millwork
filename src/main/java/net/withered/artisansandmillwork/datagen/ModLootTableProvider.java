package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.MILLING_TABLE);

        dropSelf(ModBlocks.OAK_BEAM);
        dropSelf(ModBlocks.SPRUCE_BEAM);
        dropSelf(ModBlocks.BIRCH_BEAM);
        dropSelf(ModBlocks.JUNGLE_BEAM);
        dropSelf(ModBlocks.ACACIA_BEAM);
        dropSelf(ModBlocks.DARK_OAK_BEAM);
        dropSelf(ModBlocks.MANGROVE_BEAM);
        dropSelf(ModBlocks.CHERRY_BEAM);
        dropSelf(ModBlocks.BAMBOO_BEAM);
        dropSelf(ModBlocks.CRIMSON_BEAM);
        dropSelf(ModBlocks.WARPED_BEAM);
    }
}
