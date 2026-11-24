package net.withered.artisansandmillwork.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.item.crafting.MillingTableRecipe;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.OAK_LOGS), Items.OAK_PLANKS, 4, "oak_logs", conditionsFromTag(ItemTags.OAK_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.ACACIA_LOGS), Items.ACACIA_PLANKS, 4, "acacia_logs", conditionsFromTag(ItemTags.ACACIA_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.BIRCH_LOGS), Items.BIRCH_PLANKS, 4, "birch_logs", conditionsFromTag(ItemTags.BIRCH_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.CHERRY_LOGS), Items.CHERRY_PLANKS, 4, "cherry_logs", conditionsFromTag(ItemTags.CHERRY_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.DARK_OAK_LOGS), Items.DARK_OAK_PLANKS, 4, "dark_oak_logs", conditionsFromTag(ItemTags.DARK_OAK_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.JUNGLE_LOGS), Items.JUNGLE_PLANKS, 4, "jungle_logs", conditionsFromTag(ItemTags.JUNGLE_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.MANGROVE_LOGS), Items.MANGROVE_PLANKS, 4, "mangrove_logs", conditionsFromTag(ItemTags.MANGROVE_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.SPRUCE_LOGS), Items.SPRUCE_PLANKS, 4, "spruce_logs", conditionsFromTag(ItemTags.SPRUCE_LOGS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.BAMBOO_BLOCKS), Items.BAMBOO_PLANKS, 4, "bamboo_blocks", conditionsFromTag(ItemTags.BAMBOO_BLOCKS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.CRIMSON_STEMS), Items.CRIMSON_PLANKS, 4, "crimson_stems", conditionsFromTag(ItemTags.CRIMSON_STEMS));
        offerMillingRecipe(exporter, Ingredient.fromTag(ItemTags.WARPED_STEMS), Items.WARPED_PLANKS, 4, "warped_stems", conditionsFromTag(ItemTags.WARPED_STEMS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_STAIRS, 1, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_STAIRS, 1, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_STAIRS, 1, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_STAIRS, 1, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_STAIRS, 1, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_STAIRS, 1, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_STAIRS, 1, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_STAIRS, 1, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_STAIRS, 1, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_STAIRS, 1, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_STAIRS, 1, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_SLAB, 2, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_SLAB, 2, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_SLAB, 2, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_SLAB, 2, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_SLAB, 2, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_SLAB, 2, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_SLAB, 2, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_SLAB, 2, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_SLAB, 2, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_SLAB, 2, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_SLAB, 2, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_FENCE, 1, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_FENCE, 1, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_FENCE, 1, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_FENCE, 1, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_FENCE, 1, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_FENCE, 1, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_FENCE, 1, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_FENCE, 1, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_FENCE, 1, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_FENCE, 1, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_FENCE, 1, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_FENCE_GATE, 1, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_FENCE_GATE, 1, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_FENCE_GATE, 1, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_FENCE_GATE, 1, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_FENCE_GATE, 1, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_FENCE_GATE, 1, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_FENCE_GATE, 1, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_FENCE_GATE, 1, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_FENCE_GATE, 1, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_FENCE_GATE, 1, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_FENCE_GATE, 1, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_DOOR, 1, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_DOOR, 1, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_DOOR, 1, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_DOOR, 1, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_DOOR, 1, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_DOOR, 1, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_DOOR, 1, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_DOOR, 1, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_DOOR, 1, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_DOOR, 1, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_DOOR, 1, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_TRAPDOOR, 2, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_TRAPDOOR, 2, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_TRAPDOOR, 2, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_TRAPDOOR, 2, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_TRAPDOOR, 2, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_TRAPDOOR, 2, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_TRAPDOOR, 2, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_TRAPDOOR, 2, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_TRAPDOOR, 2, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_TRAPDOOR, 2, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_TRAPDOOR, 2, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_PRESSURE_PLATE, 2, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_PRESSURE_PLATE, 2, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_PRESSURE_PLATE, 2, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_PRESSURE_PLATE, 2, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_PRESSURE_PLATE, 2, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_PRESSURE_PLATE, 2, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_PRESSURE_PLATE, 2, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_PRESSURE_PLATE, 2, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_PRESSURE_PLATE, 2, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_PRESSURE_PLATE, 2, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_PRESSURE_PLATE, 2, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_BUTTON, 6, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_BUTTON, 6, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_BUTTON, 6, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_BUTTON, 6, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_BUTTON, 6, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_BUTTON, 6, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_BUTTON, 6, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_BUTTON, 6, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_BUTTON, 6, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_BUTTON, 6, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_BUTTON, 6, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_SIGN, 2, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_SIGN, 2, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_SIGN, 2, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_SIGN, 2, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_SIGN, 2, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_SIGN, 2, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_SIGN, 2, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_SIGN, 2, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_SIGN, 2, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_SIGN, 2, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_SIGN, 2, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), Items.OAK_HANGING_SIGN, 1, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), Items.SPRUCE_HANGING_SIGN, 1, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), Items.BIRCH_HANGING_SIGN, 1, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), Items.JUNGLE_HANGING_SIGN, 1, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), Items.ACACIA_HANGING_SIGN, 1, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), Items.DARK_OAK_HANGING_SIGN, 1, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), Items.MANGROVE_HANGING_SIGN, 1, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), Items.CHERRY_HANGING_SIGN, 1, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), Items.BAMBOO_HANGING_SIGN, 1, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), Items.CRIMSON_HANGING_SIGN, 1, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), Items.WARPED_HANGING_SIGN, 1, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));

        offerMillingRecipe(exporter, Ingredient.ofItems(Items.OAK_PLANKS), ModBlocks.OAK_BEAM, 2, "oak_planks", conditionsFromItem(Items.OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.SPRUCE_PLANKS), ModBlocks.SPRUCE_BEAM, 2, "spruce_planks", conditionsFromItem(Items.SPRUCE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BIRCH_PLANKS), ModBlocks.BIRCH_BEAM, 2, "birch_planks", conditionsFromItem(Items.BIRCH_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.JUNGLE_PLANKS), ModBlocks.JUNGLE_BEAM, 2, "jungle_planks", conditionsFromItem(Items.JUNGLE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.ACACIA_PLANKS), ModBlocks.ACACIA_BEAM, 2, "acacia_planks", conditionsFromItem(Items.ACACIA_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.DARK_OAK_PLANKS), ModBlocks.DARK_OAK_BEAM, 2, "dark_oak_planks", conditionsFromItem(Items.DARK_OAK_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.MANGROVE_PLANKS), ModBlocks.MANGROVE_BEAM, 2, "mangrove_planks", conditionsFromItem(Items.MANGROVE_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CHERRY_PLANKS), ModBlocks.CHERRY_BEAM, 2, "cherry_planks", conditionsFromItem(Items.CHERRY_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.BAMBOO_PLANKS), ModBlocks.BAMBOO_BEAM, 2, "bamboo_planks", conditionsFromItem(Items.BAMBOO_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.CRIMSON_PLANKS), ModBlocks.CRIMSON_BEAM, 2, "crimson_planks", conditionsFromItem(Items.CRIMSON_PLANKS));
        offerMillingRecipe(exporter, Ingredient.ofItems(Items.WARPED_PLANKS), ModBlocks.WARPED_BEAM, 2, "warped_planks", conditionsFromItem(Items.WARPED_PLANKS));
    }
    private static void offerMillingRecipe(
            RecipeExporter exporter,
            Ingredient input,
            ItemConvertible output,
            int count,
            String inputName,
            AdvancementCriterion<?> unlockCriterion
    ) {
        String outputName = Registries.ITEM.getId(output.asItem()).getPath();
        Identifier recipeId = Identifier.of(
                ArtisansAndMillwork.MOD_ID,
                outputName + "from" + inputName + "_milling"
        );
        Advancement.Builder advancement = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .criterion("has_ingredient", unlockCriterion)
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        MillingTableRecipe recipe = new MillingTableRecipe("", input, new ItemStack(output, count));
        exporter.accept(
                recipeId,
                recipe,
                advancement.build(recipeId.withPrefixedPath("recipes/milling/"))
        );
    }
}