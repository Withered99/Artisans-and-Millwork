package net.withered.artisansandmillwork.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.item.crafting.MillingTableRecipe;
import net.withered.artisansandmillwork.item.crafting.ModRecipeTypes;

import java.util.List;

@JeiPlugin
public class MillingJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MillingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<MillingTableRecipe> millingRecipes = recipeManager
                .getAllRecipesFor(ModRecipeTypes.MILLING)
                .stream()
                .map(RecipeHolder::value)
                .toList();

        registration.addRecipes(MillingRecipeCategory.MILLING_TYPE, millingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MILLING_TABLE), MillingRecipeCategory.MILLING_TYPE);
    }
}
