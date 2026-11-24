package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MILLING_TABLE);
        addDrop(ModBlocks.ARTISANS_TABLE);

        addDrop(ModBlocks.OAK_BEAM);
        addDrop(ModBlocks.SPRUCE_BEAM);
        addDrop(ModBlocks.BIRCH_BEAM);
        addDrop(ModBlocks.JUNGLE_BEAM);
        addDrop(ModBlocks.ACACIA_BEAM);
        addDrop(ModBlocks.DARK_OAK_BEAM);
        addDrop(ModBlocks.MANGROVE_BEAM);
        addDrop(ModBlocks.CHERRY_BEAM);
        addDrop(ModBlocks.BAMBOO_BEAM);
        addDrop(ModBlocks.CRIMSON_BEAM);
        addDrop(ModBlocks.WARPED_BEAM);
    }
}
