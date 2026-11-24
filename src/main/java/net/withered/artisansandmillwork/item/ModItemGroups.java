package net.withered.artisansandmillwork.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ARTISANS_AND_MILLWORK_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ArtisansAndMillwork.MOD_ID, "artisans_and_millwork"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.artisansandmillwork.artisans_and_millwork"))
                    .icon(() -> new ItemStack(ModBlocks.MILLING_TABLE))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MILLING_TABLE);
                        entries.add(ModBlocks.OAK_BEAM);
                        entries.add(ModBlocks.SPRUCE_BEAM);
                        entries.add(ModBlocks.BIRCH_BEAM);
                        entries.add(ModBlocks.JUNGLE_BEAM);
                        entries.add(ModBlocks.ACACIA_BEAM);
                        entries.add(ModBlocks.DARK_OAK_BEAM);
                        entries.add(ModBlocks.MANGROVE_BEAM);
                        entries.add(ModBlocks.CHERRY_BEAM);
                        entries.add(ModBlocks.BAMBOO_BEAM);
                        entries.add(ModBlocks.CRIMSON_BEAM);
                        entries.add(ModBlocks.WARPED_BEAM);
                    })
                    .build()
    );

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.STONECUTTER, ModBlocks.MILLING_TABLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
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
