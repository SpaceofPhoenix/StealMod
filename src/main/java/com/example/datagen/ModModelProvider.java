package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import com.example.item.ModItems;
import com.example.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Steel Block - simple cube model
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STAHL_BLOCK);

        // Steel Door - standard door
        blockStateModelGenerator.registerDoor(ModBlocks.STAHL_DOOR);

        // Steel Trapdoor - standard trapdoor
        blockStateModelGenerator.registerTrapdoor(ModBlocks.STAHL_TRAPDOOR);

        // Reinforced Anvil - using anvil model
        blockStateModelGenerator.registerAnvil(ModBlocks.VERSTAERKTER_ANVIL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Ingots
        itemModelGenerator.register(ModItems.ROHSTAHL_GEMISCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAHLBARREN, Models.GENERATED);

        // Tools
        itemModelGenerator.register(ModItems.STAHL_SPITZHACKE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STAHL_AXT, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STAHL_SCHAUFEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STAHL_HACKE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STAHL_SCHWERT, Models.HANDHELD);

        // Armor
        itemModelGenerator.register(ModItems.STAHL_HELM, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAHL_BRUSTPANZER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAHL_HOSE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAHL_SCHUHE, Models.GENERATED);

        // Blocks as items
        itemModelGenerator.register(ModBlocks.STAHL_BLOCK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.STAHL_DOOR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.STAHL_TRAPDOOR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.VERSTAERKTER_ANVIL.asItem(), Models.GENERATED);
    }
}
