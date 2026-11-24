package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;
import net.withered.artisansandmillwork.block.ModBlocks;

public class MillingTableRecipe extends CuttingRecipe {

    public MillingTableRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeTypes.MILLING, ModRecipeSerializers.MILLING, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.item());
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.MILLING_TABLE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.MILLING;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.MILLING;
    }
}
