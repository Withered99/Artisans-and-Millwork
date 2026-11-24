package net.withered.artisansandmillwork;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.withered.artisansandmillwork.client.gui.screens.inventory.MillingTableScreen;
import net.withered.artisansandmillwork.inventory.ModMenuTypes;

public class ArtisansAndMillworkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.MILLING_TABLE, MillingTableScreen::new);
    }
}
