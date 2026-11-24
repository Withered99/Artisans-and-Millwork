package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModRecipeTypes {
    public static final RecipeType<MillingTableRecipe> MILLING = register("milling");

    private static <T extends Recipe<?>> RecipeType<T> register(String name) {
        Identifier id = Identifier.of(ArtisansAndMillwork.MOD_ID, name);
        return Registry.register(Registries.RECIPE_TYPE, id, new RecipeType<T>() {
            @Override
            public String toString() {
                return id.toString();
            }
        });
    }

    public static void init() {}
}
