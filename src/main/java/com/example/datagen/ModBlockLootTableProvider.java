package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.loot.LootTable;
import com.example.block.ModBlocks;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // Steel blocks drop themselves
        addDrop(ModBlocks.STAHL_BLOCK);
        addDrop(ModBlocks.STAHL_DOOR);
        addDrop(ModBlocks.STAHL_TRAPDOOR);
        addDrop(ModBlocks.VERSTAERKTER_ANVIL);
    }
}
