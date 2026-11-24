package net.withered.artisansandmillwork;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.withered.artisansandmillwork.client.gui.screens.inventory.MillingTableScreen;
import net.withered.artisansandmillwork.inventory.ModMenuTypes;

public class ArtisansAndMillworkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModMenuTypes.MILLING_TABLE, MillingTableScreen::new);
    }
}
