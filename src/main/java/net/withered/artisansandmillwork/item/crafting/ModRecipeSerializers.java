package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModRecipeSerializers {
    public static final RecipeSerializer<MillingTableRecipe> MILLING = register(
            "milling",
            new SingleItemRecipe.Serializer<>(MillingTableRecipe::new) {}
    );

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, name);
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, id, serializer);
    }

    public static void init() {}
}
