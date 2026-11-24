package net.withered.artisansandmillwork;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.withered.artisansandmillwork.datagen.ModBlockTagProvider;
import net.withered.artisansandmillwork.datagen.ModLootTableProvider;
import net.withered.artisansandmillwork.datagen.ModModelProvider;
import net.withered.artisansandmillwork.datagen.ModRecipeProvider;

public class ArtisansAndMillworkDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
    }
}
