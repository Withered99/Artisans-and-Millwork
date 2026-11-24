package net.withered.artisansandmillwork.inventory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModMenuTypes {
    public static final ScreenHandlerType<MillingTableMenu> MILLING_TABLE = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(ArtisansAndMillwork.MOD_ID, "milling_table"),
            new ScreenHandlerType<>(MillingTableMenu::new, FeatureSet.empty())
    );

    public static void init() {}
}
