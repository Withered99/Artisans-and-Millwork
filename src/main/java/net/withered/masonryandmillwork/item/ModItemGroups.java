package net.withered.masonryandmillwork.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.withered.masonryandmillwork.block.ModBlocks;

public class ModItemGroups {
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.STONECUTTER, ModBlocks.MILLING_TABLE);
        });
    }
}
