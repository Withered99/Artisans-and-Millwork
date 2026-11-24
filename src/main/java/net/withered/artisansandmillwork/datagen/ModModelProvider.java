package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    private static final Model BEAM_TEMPLATE = new Model(
            Optional.of(Identifier.of(ArtisansAndMillwork.MOD_ID, "block/template_beam")),
            Optional.empty(),
            TextureKey.SIDE,
            TextureKey.END
    );
    private static final Model BRACE_TEMPLATE = new Model(
            Optional.of(Identifier.of(ArtisansAndMillwork.MOD_ID, "block/template_brace")),
            Optional.empty(),
            TextureKey.SIDE,
            TextureKey.END
    );

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generators) {
        registerBeam(generators, ModBlocks.OAK_BEAM, Blocks.OAK_PLANKS);
        registerBeam(generators, ModBlocks.SPRUCE_BEAM, Blocks.SPRUCE_PLANKS);
        registerBeam(generators, ModBlocks.BIRCH_BEAM, Blocks.BIRCH_PLANKS);
        registerBeam(generators, ModBlocks.JUNGLE_BEAM, Blocks.JUNGLE_PLANKS);
        registerBeam(generators, ModBlocks.ACACIA_BEAM, Blocks.ACACIA_PLANKS);
        registerBeam(generators, ModBlocks.DARK_OAK_BEAM, Blocks.DARK_OAK_PLANKS);
        registerBeam(generators, ModBlocks.MANGROVE_BEAM, Blocks.MANGROVE_PLANKS);
        registerBeam(generators, ModBlocks.CHERRY_BEAM, Blocks.CHERRY_PLANKS);
        registerBeam(generators, ModBlocks.BAMBOO_BEAM, Blocks.BAMBOO_BLOCK);
        registerBeam(generators, ModBlocks.CRIMSON_BEAM, Blocks.CRIMSON_PLANKS);
        registerBeam(generators, ModBlocks.WARPED_BEAM, Blocks.WARPED_PLANKS);
    }

    private void registerBeam(BlockStateModelGenerator generators, Block beamBlock, Block textureSource) {
        TextureMap textures = new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(textureSource))
                .put(TextureKey.END, TextureMap.getId(textureSource));

        Identifier modelId = BEAM_TEMPLATE.upload(beamBlock, textures, generators.modelCollector);

        generators.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(beamBlock)
                        .coordinate(BlockStateVariantMap.create(Properties.AXIS)
                                .register(Direction.Axis.Y, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, modelId))
                                .register(Direction.Axis.Z, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, modelId)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                                .register(Direction.Axis.X, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, modelId)
                                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        )
        );
        generators.registerParentedItemModel(beamBlock, modelId);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
