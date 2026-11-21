package net.withered.artisansandmillwork.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.withered.artisansandmillwork.block.ModBlocks;

public class ModItemGroups {
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.STONECUTTER, ModBlocks.MILLING_TABLE);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.OAK_SLAB, ModBlocks.OAK_BEAM);
            entries.addAfter(Blocks.SPRUCE_SLAB, ModBlocks.SPRUCE_BEAM);
            entries.addAfter(Blocks.BIRCH_SLAB, ModBlocks.BIRCH_BEAM);
            entries.addAfter(Blocks.JUNGLE_SLAB, ModBlocks.JUNGLE_BEAM);
            entries.addAfter(Blocks.ACACIA_SLAB, ModBlocks.ACACIA_BEAM);
            entries.addAfter(Blocks.DARK_OAK_SLAB, ModBlocks.DARK_OAK_BEAM);
            entries.addAfter(Blocks.MANGROVE_SLAB, ModBlocks.MANGROVE_BEAM);
            entries.addAfter(Blocks.CHERRY_SLAB, ModBlocks.CHERRY_BEAM);
            entries.addAfter(Blocks.BAMBOO_SLAB, ModBlocks.BAMBOO_BEAM);
            entries.addAfter(Blocks.CRIMSON_SLAB, ModBlocks.CRIMSON_BEAM);
            entries.addAfter(Blocks.WARPED_SLAB, ModBlocks.WARPED_BEAM);
        });
    }
}
