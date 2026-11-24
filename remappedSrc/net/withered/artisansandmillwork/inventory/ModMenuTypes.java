package net.withered.artisansandmillwork.inventory;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.withered.artisansandmillwork.ArtisansAndMillwork;

public class ModMenuTypes {
    public static final MenuType<MillingTableMenu> MILLING_TABLE = Registry.register(
            BuiltInRegistries.MENU,
            ResourceLocation.fromNamespaceAndPath(ArtisansAndMillwork.MOD_ID, "milling_table"),
            new MenuType<>(MillingTableMenu::new, FeatureFlags.VANILLA_SET)
    );

    public static void init() {}
}
