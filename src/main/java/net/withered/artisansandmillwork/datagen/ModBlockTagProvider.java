package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MILLING_TABLE);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.OAK_BEAM)
                .add(ModBlocks.SPRUCE_BEAM)
                .add(ModBlocks.BIRCH_BEAM)
                .add(ModBlocks.JUNGLE_BEAM)
                .add(ModBlocks.ACACIA_BEAM)
                .add(ModBlocks.DARK_OAK_BEAM)
                .add(ModBlocks.MANGROVE_BEAM)
                .add(ModBlocks.CHERRY_BEAM)
                .add(ModBlocks.BAMBOO_BEAM)
                .add(ModBlocks.CRIMSON_BEAM)
                .add(ModBlocks.WARPED_BEAM)

                .add(ModBlocks.MILLING_TABLE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MILLING_TABLE);
    }
}
