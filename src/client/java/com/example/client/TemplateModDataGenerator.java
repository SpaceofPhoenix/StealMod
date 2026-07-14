package com.example.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import com.example.datagen.ModRecipeProvider;
import com.example.datagen.ModModelProvider;
import com.example.datagen.ModBlockLootTableProvider;

public class TemplateModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        
        // Register providers
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
    }
}
