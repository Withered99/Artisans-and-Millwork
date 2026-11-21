package net.withered.masonryandmillwork.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.withered.masonryandmillwork.MasonryAndMillwork;
import net.withered.masonryandmillwork.block.custom.MillingTableBlock;

public class ModBlocks {
    public static final Block MILLING_TABLE = registerBlock("milling_table",
            new MillingTableBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(MasonryAndMillwork.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MasonryAndMillwork.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void init() {
    }
}
