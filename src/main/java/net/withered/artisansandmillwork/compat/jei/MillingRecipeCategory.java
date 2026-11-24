package net.withered.artisansandmillwork.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;
import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.item.crafting.MillingTableRecipe;

public class MillingRecipeCategory implements IRecipeCategory<MillingTableRecipe> {
    public static final Identifier UID = Identifier.of(ArtisansAndMillwork.MOD_ID, "milling");
    public static final RecipeType<MillingTableRecipe> MILLING_TYPE = new RecipeType<>(UID, MillingTableRecipe.class);

    private final IDrawable icon;
    private final IDrawable slotDrawable;
    private final IDrawable outputSlotDrawable;
    private final IDrawable arrow;

    public MillingRecipeCategory(IGuiHelper helper) {
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MILLING_TABLE));
        this.slotDrawable = helper.getSlotDrawable();
        this.outputSlotDrawable = helper.getOutputSlot();
        this.arrow = helper.getRecipeArrow();
    }

    @Override
    public RecipeType<MillingTableRecipe> getRecipeType() {
        return MILLING_TYPE;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("container.artisansandmillwork.milling");
    }

    @Override
    public int getWidth() {
        return 116;
    }

    @Override
    public int getHeight() {
        return 34;
    }

    @Override
    public void draw(MillingTableRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        this.slotDrawable.draw(guiGraphics, 17, 8);
        this.arrow.draw(guiGraphics, 41, 9);
        this.outputSlotDrawable.draw(guiGraphics, 73, 4);
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MillingTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 18, 9)
                .addIngredients(recipe.getIngredients().get(0));

        assert MinecraftClient.getInstance().world != null;
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 9)
                .addItemStack(recipe.getResult(MinecraftClient.getInstance().world.getRegistryManager()));
    }
}
