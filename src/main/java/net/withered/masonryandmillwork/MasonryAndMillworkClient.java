package net.withered.masonryandmillwork;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.withered.masonryandmillwork.client.gui.screens.inventory.MillingTableScreen;
import net.withered.masonryandmillwork.inventory.ModMenuTypes;

public class MasonryAndMillworkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.MILLING_TABLE, MillingTableScreen::new);
    }
}
