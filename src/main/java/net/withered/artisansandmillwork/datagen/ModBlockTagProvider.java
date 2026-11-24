package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MILLING_TABLE)
                .add(ModBlocks.ARTISANS_TABLE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
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
                .add(ModBlocks.ARTISANS_TABLE)
                .add(ModBlocks.MILLING_TABLE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ARTISANS_TABLE)
                .add(ModBlocks.MILLING_TABLE);
    }
}
