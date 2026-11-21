package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    private static final ModelTemplate BEAM_TEMPLATE = new ModelTemplate(
            Optional.of(ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, "block/template_beam")),
            Optional.empty(),
            TextureSlot.SIDE,
            TextureSlot.END
    );
    private static final ModelTemplate BRACE_TEMPLATE = new ModelTemplate(
            Optional.of(ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, "block/template_brace")),
            Optional.empty(),
            TextureSlot.SIDE,
            TextureSlot.END
    );

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generators) {
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

    private void registerBeam(BlockModelGenerators generators, Block beamBlock, Block textureSource) {
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(textureSource))
                .put(TextureSlot.END, TextureMapping.getBlockTexture(textureSource));

        ResourceLocation modelId = BEAM_TEMPLATE.create(beamBlock, textures, generators.modelOutput);

        generators.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(beamBlock)
                        .with(PropertyDispatch.property(BlockStateProperties.AXIS)
                                .select(Direction.Axis.Y, Variant.variant()
                                        .with(VariantProperties.MODEL, modelId))
                                .select(Direction.Axis.Z, Variant.variant()
                                        .with(VariantProperties.MODEL, modelId)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
                                .select(Direction.Axis.X, Variant.variant()
                                        .with(VariantProperties.MODEL, modelId)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        )
        );
        generators.delegateItemModel(beamBlock, modelId);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    }
}
