package net.withered.artisansandmillwork.item.crafting;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModRecipeTypes {
    public static final RecipeType<MillingTableRecipe> MILLING = register("milling");

    private static <T extends Recipe<?>> RecipeType<T> register(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, name);
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, id, new RecipeType<T>() {
            @Override
            public String toString() {
                return id.toString();
            }
        });
    }

    public static void init() {}
}
