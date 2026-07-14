package com.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import com.example.item.ModItems;
import com.example.block.ModBlocks;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(FabricDataOutput output, RecipeExporter exporter) {
        return new RecipeGenerator(output, exporter) {
            @Override
            public void generate() {
                // Crafting Recipe: Iron Ingot + 4x Coal -> Rohstahl-Gemisch
                createShapedRecipe(ModItems.ROHSTAHL_GEMISCH)
                        .input('I', Items.IRON_INGOT)
                        .input('C', Items.COAL)
                        .pattern("CCC")
                        .pattern("CIC")
                        .pattern("CCC")
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                // Alternative with Charcoal
                createShapedRecipe(ModItems.ROHSTAHL_GEMISCH)
                        .input('I', Items.IRON_INGOT)
                        .input('C', Items.CHARCOAL)
                        .pattern("CCC")
                        .pattern("CIC")
                        .pattern("CCC")
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter, "rohstahl_gemisch_from_charcoal");

                // Smelting Recipe: Rohstahl-Gemisch -> Stahlbarren (in Blast Furnace)
                createBlastingRecipe(
                        new RecipeGenerator.Input(ModItems.ROHSTAHL_GEMISCH),
                        RecipeCategory.MISC,
                        ModItems.STAHLBARREN,
                        0.1f,
                        100
                )
                        .criterion(hasItem(ModItems.ROHSTAHL_GEMISCH), conditionsFromItem(ModItems.ROHSTAHL_GEMISCH))
                        .offerTo(exporter, "stahlbarren_from_blasting");

                // Stahlbarren -> Stahlblock (9x ingots in crafting table)
                createShapedRecipe(ModBlocks.STAHL_BLOCK)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Stahlblock -> Stahlbarren (uncrafting)
                createShapelessRecipe(RecipeCategory.MISC, ModItems.STAHLBARREN, 9)
                        .input(ModBlocks.STAHL_BLOCK)
                        .criterion(hasItem(ModBlocks.STAHL_BLOCK), conditionsFromItem(ModBlocks.STAHL_BLOCK))
                        .offerTo(exporter, "stahlbarren_from_block");

                // Steel Door: 3x Stahlbarren
                createShapedRecipe(ModBlocks.STAHL_DOOR)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("SS")
                        .pattern("SS")
                        .pattern("SS")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Steel Trapdoor: 4x Stahlbarren
                createShapedRecipe(ModBlocks.STAHL_TRAPDOOR)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("SSS")
                        .pattern("SSS")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Steel Tools
                // Pickaxe: 3x Stahlbarren + 2x Sticks
                createShapedRecipe(ModItems.STAHL_SPITZHACKE)
                        .input('S', ModItems.STAHLBARREN)
                        .input('#', Items.STICK)
                        .pattern("SSS")
                        .pattern(" # ")
                        .pattern(" # ")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Axe: 3x Stahlbarren + 2x Sticks
                createShapedRecipe(ModItems.STAHL_AXT)
                        .input('S', ModItems.STAHLBARREN)
                        .input('#', Items.STICK)
                        .pattern("SS")
                        .pattern("S#")
                        .pattern(" #")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Shovel: 1x Stahlbarren + 2x Sticks
                createShapedRecipe(ModItems.STAHL_SCHAUFEL)
                        .input('S', ModItems.STAHLBARREN)
                        .input('#', Items.STICK)
                        .pattern("S")
                        .pattern("#")
                        .pattern("#")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Hoe: 2x Stahlbarren + 2x Sticks
                createShapedRecipe(ModItems.STAHL_HACKE)
                        .input('S', ModItems.STAHLBARREN)
                        .input('#', Items.STICK)
                        .pattern("SS")
                        .pattern(" # ")
                        .pattern(" # ")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Sword: 2x Stahlbarren + 1x Stick
                createShapedRecipe(ModItems.STAHL_SCHWERT)
                        .input('S', ModItems.STAHLBARREN)
                        .input('#', Items.STICK)
                        .pattern("S")
                        .pattern("S")
                        .pattern("#")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Armor
                // Helmet: 5x Stahlbarren
                createShapedRecipe(ModItems.STAHL_HELM)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("SSS")
                        .pattern("S S")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Chestplate: 8x Stahlbarren
                createShapedRecipe(ModItems.STAHL_BRUSTPANZER)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("S S")
                        .pattern("SSS")
                        .pattern("SSS")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Leggings: 7x Stahlbarren
                createShapedRecipe(ModItems.STAHL_HOSE)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("SSS")
                        .pattern("S S")
                        .pattern("S S")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);

                // Boots: 4x Stahlbarren
                createShapedRecipe(ModItems.STAHL_SCHUHE)
                        .input('S', ModItems.STAHLBARREN)
                        .pattern("S S")
                        .pattern("S S")
                        .criterion(hasItem(ModItems.STAHLBARREN), conditionsFromItem(ModItems.STAHLBARREN))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Steel Mod Recipes";
    }
}
