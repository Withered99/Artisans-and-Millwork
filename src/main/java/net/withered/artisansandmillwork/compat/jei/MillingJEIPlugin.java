package net.withered.artisansandmillwork.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.item.crafting.MillingTableRecipe;
import net.withered.artisansandmillwork.item.crafting.ModRecipeTypes;

import java.util.List;

@JeiPlugin
public class MillingJEIPlugin implements IModPlugin {
    @Override
    public Identifier getPluginUid() {
        return Identifier.of(ArtisansAndMillwork.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MillingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert MinecraftClient.getInstance().world != null;
        RecipeManager recipeManager = MinecraftClient.getInstance().world.getRecipeManager();

        List<MillingTableRecipe> millingRecipes = recipeManager
                .listAllOfType(ModRecipeTypes.MILLING)
                .stream()
                .map(RecipeEntry::value)
                .toList();

        registration.addRecipes(MillingRecipeCategory.MILLING_TYPE, millingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MILLING_TABLE), MillingRecipeCategory.MILLING_TYPE);
    }
}
