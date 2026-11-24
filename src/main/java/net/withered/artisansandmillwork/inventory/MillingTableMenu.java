package net.withered.artisansandmillwork.inventory;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.withered.artisansandmillwork.block.ModBlocks;
import net.withered.artisansandmillwork.item.crafting.MillingTableRecipe;
import net.withered.artisansandmillwork.item.crafting.ModRecipeTypes;

import java.util.List;

public class MillingTableMenu extends ScreenHandler {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;

    private final ScreenHandlerContext context;
    private final Property selectedRecipe = Property.create();
    private final World world;
    private List<RecipeEntry<MillingTableRecipe>> availableRecipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot outputSlot;
    Runnable contentsChangedListener = () -> {};
    public final Inventory input = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            MillingTableMenu.this.onContentChanged(this);
            MillingTableMenu.this.contentsChangedListener.run();
        }
    };
    final CraftingResultInventory output = new CraftingResultInventory();

    public MillingTableMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public MillingTableMenu(int syncId, PlayerInventory playerInventory, final ScreenHandlerContext context) {
        super(ModMenuTypes.MILLING_TABLE, syncId);
        this.context = context;
        this.world = playerInventory.player.getWorld();

        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());
                MillingTableMenu.this.output.unlockLastRecipe(player, this.getInputStacks());
                ItemStack remaining = MillingTableMenu.this.inputSlot.takeStack(1);
                if (!remaining.isEmpty()) {
                    MillingTableMenu.this.populateResult();
                }

                context.run((world, pos) -> {
                    long time = world.getTime();
                    if (MillingTableMenu.this.lastTakeTime != time) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        MillingTableMenu.this.lastTakeTime = time;
                    }
                });
                super.onTakeItem(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(MillingTableMenu.this.inputSlot.getStack());
            }
        });

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

        this.addProperty(this.selectedRecipe);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipe.get();
    }

    public List<RecipeEntry<MillingTableRecipe>> getRecipes() {
        return this.availableRecipes;
    }

    public int getNumRecipes() {
        return this.availableRecipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasStack() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.MILLING_TABLE);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }
        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        ItemStack stack = this.inputSlot.getStack();
        if (!stack.isOf(this.inputStack.getItem())) {
            this.inputStack = stack.copy();
            this.updateInput(inventory, stack);
        }
    }

    private void updateInput(Inventory input, ItemStack stack) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.outputSlot.setStack(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.availableRecipes = this.world.getRecipeManager().getAllMatches(
                    ModRecipeTypes.MILLING,
                    new SingleStackRecipeInput(stack),
                    this.world
            );
        }
    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RecipeEntry<MillingTableRecipe> recipeEntry = this.availableRecipes.get(this.selectedRecipe.get());
            ItemStack result = recipeEntry.value().craft(new SingleStackRecipeInput(this.input.getStack(0)), this.world.getRegistryManager());
            if (result.isItemEnabled(this.world.getEnabledFeatures())) {
                this.output.setLastRecipe(recipeEntry);
                this.outputSlot.setStack(result);
            } else {
                this.outputSlot.setStack(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.setStack(ItemStack.EMPTY);
        }
        this.sendContentUpdates();
    }

    public void registerUpdateListener(Runnable listener) {
        this.contentsChangedListener = listener;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack copy = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack slotStack = slot.getStack();
            Item item = slotStack.getItem();
            copy = slotStack.copy();
            if (slotIndex == 1) {
                item.onCraftByPlayer(slotStack, player.getWorld(), player);
                if (!this.insertItem(slotStack, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(slotStack, copy);
            } else if (slotIndex == 0) {
                if (!this.insertItem(slotStack, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world.getRecipeManager().getFirstMatch(ModRecipeTypes.MILLING, new SingleStackRecipeInput(slotStack), this.world).isPresent()) {
                if (!this.insertItem(slotStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex >= INV_SLOT_START && slotIndex < INV_SLOT_END) {
                if (!this.insertItem(slotStack, USE_ROW_SLOT_START, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex >= USE_ROW_SLOT_START && slotIndex < USE_ROW_SLOT_END && !this.insertItem(slotStack, INV_SLOT_START, INV_SLOT_END, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            }

            slot.markDirty();
            if (slotStack.getCount() == copy.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, slotStack);
            this.sendContentUpdates();
        }
        return copy;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.output.removeStack(1);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }
}
