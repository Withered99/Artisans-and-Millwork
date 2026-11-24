package net.withered.artisansandmillwork.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.custom.ArtisansTableBlock;
import net.withered.artisansandmillwork.block.custom.BeamBlock;
import net.withered.artisansandmillwork.block.custom.MillingTableBlock;

public class ModBlocks {
    public static final Block MILLING_TABLE = registerBlock("milling_table",
            new MillingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));
    public static final Block ARTISANS_TABLE = registerBlock("artisans_table",
            new ArtisansTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));

    public static final Block QUARTERED_GLASS_PANE = registerBlock("quartered_glass_pane",
            new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)));

    public static final Block OAK_BEAM = registerBlock("oak_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block SPRUCE_BEAM = registerBlock("spruce_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block BIRCH_BEAM = registerBlock("birch_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block JUNGLE_BEAM = registerBlock("jungle_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block ACACIA_BEAM = registerBlock("acacia_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block DARK_OAK_BEAM = registerBlock("dark_oak_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block MANGROVE_BEAM = registerBlock("mangrove_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block CHERRY_BEAM = registerBlock("cherry_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block BAMBOO_BEAM = registerBlock("bamboo_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block CRIMSON_BEAM = registerBlock("crimson_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Block WARPED_BEAM = registerBlock("warped_beam", new BeamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, name),
                new BlockItem(block, new Properties()));
    }

    public static void init() {
    }
}
