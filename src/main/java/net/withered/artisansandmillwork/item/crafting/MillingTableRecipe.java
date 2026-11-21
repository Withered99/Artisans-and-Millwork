package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.withered.artisansandmillwork.block.ModBlocks;

public class MillingTableRecipe extends SingleItemRecipe {

    public MillingTableRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeTypes.MILLING, ModRecipeSerializers.MILLING, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.ingredient.test(input.item());
    }

    @Override
    public ItemStack getToastSymbol() {
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
