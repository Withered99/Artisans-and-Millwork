package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModRecipeSerializers {
    public static final RecipeSerializer<MillingTableRecipe> MILLING = register(
            "milling",
            new CuttingRecipe.Serializer<>(MillingTableRecipe::new) {}
    );

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
        Identifier id = Identifier.of(ArtisansAndMillwork.MOD_ID, name);
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }

    public static void init() {}
}
