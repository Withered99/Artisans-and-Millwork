package net.withered.artisansandmillwork.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.custom.ArtisansTableBlock;
import net.withered.artisansandmillwork.block.custom.BeamBlock;
import net.withered.artisansandmillwork.block.custom.MillingTableBlock;

public class ModBlocks {
    public static final Block MILLING_TABLE = registerBlock("milling_table",
            new MillingTableBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER)
                    .nonOpaque()
                    .requiresTool()));
    public static final Block ARTISANS_TABLE = registerBlock("artisans_table",
            new ArtisansTableBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER)
                    .nonOpaque()
                    .requiresTool()));

    public static final Block QUARTERED_GLASS_PANE = registerBlock("quartered_glass_pane",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.GLASS_PANE)));

    public static final Block OAK_BEAM = registerBlock("oak_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SPRUCE_BEAM = registerBlock("spruce_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block BIRCH_BEAM = registerBlock("birch_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block JUNGLE_BEAM = registerBlock("jungle_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block ACACIA_BEAM = registerBlock("acacia_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_BEAM = registerBlock("dark_oak_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block MANGROVE_BEAM = registerBlock("mangrove_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block CHERRY_BEAM = registerBlock("cherry_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block BAMBOO_BEAM = registerBlock("bamboo_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block CRIMSON_BEAM = registerBlock("crimson_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block WARPED_BEAM = registerBlock("warped_beam", new BeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArtisansAndMillwork.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ArtisansAndMillwork.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void init() {
    }
}
