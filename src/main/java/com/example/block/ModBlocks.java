package com.example.block;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.BlockSoundGroup;
import com.example.TemplateMod;

public class ModBlocks {

    // ===== STEEL BLOCK =====
    // Resistant to creeper explosions, can be pushed by pistons
    public static final Block STAHL_BLOCK = registerBlock("stahl_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(6.0f, 6.0f)
                    .sounds(BlockSoundGroup.METAL)
                    .burnsOnTopOfFire(false)));

    // ===== STEEL DOOR =====
    // Only responds to redstone (like iron door)
    public static final Block STAHL_DOOR = registerBlock("stahl_door",
            new DoorBlock(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(6.0f, 6.0f)
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
                    .burnsOnTopOfFire(false),
                    BlockSetType.IRON));

    // ===== STEEL TRAPDOOR =====
    // Only responds to redstone (like iron trapdoor)
    public static final Block STAHL_TRAPDOOR = registerBlock("stahl_trapdoor",
            new TrapdoorBlock(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(6.0f, 6.0f)
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
                    .burnsOnTopOfFire(false),
                    BlockSetType.IRON));

    // ===== REINFORCED ANVIL =====
    // Created from normal anvil + steel blocks on smithing table
    // Can be used 2x as often as normal anvil before breaking
    public static final Block VERSTAERKTER_ANVIL = registerBlock("verstaerkter_anvil",
            new AnvilBlock(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(5.0f, 1200.0f) // Very high explosion resistance
                    .sounds(BlockSoundGroup.ANVIL)
                    .nonOpaque()
                    .burnsOnTopOfFire(false)));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TemplateMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        // Blocks are registered when the class is loaded
    }
}
