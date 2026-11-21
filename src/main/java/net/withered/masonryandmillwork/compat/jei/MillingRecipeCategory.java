package net.withered.masonryandmillwork.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.withered.masonryandmillwork.MasonryAndMillwork;
import net.withered.masonryandmillwork.block.ModBlocks;
import net.withered.masonryandmillwork.item.crafting.MillingTableRecipe;

public class MillingRecipeCategory implements IRecipeCategory<MillingTableRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MasonryAndMillwork.MOD_ID, "milling");
    public static final RecipeType<MillingTableRecipe> MILLING_TYPE = new RecipeType<>(UID, MillingTableRecipe.class);

    private static final ResourceLocation TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/container/stonecutter.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MillingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 19, 32, 142, 18);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MILLING_TABLE));
    }

    @Override
    public RecipeType<MillingTableRecipe> getRecipeType() {
        return MILLING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.masonryandmillwork.milling_table");
    }

    @Override
    public int getWidth() {
        return 142;
    }

    @Override
    public int getHeight() {
        return 18;
    }

    @Override
    public void draw(MillingTableRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MillingTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addIngredients(recipe.getIngredients().get(0));

        assert Minecraft.getInstance().level != null;
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 1)
                .addItemStack(recipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
    }
}
