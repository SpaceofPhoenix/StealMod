package com.example.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.example.TemplateMod;
import com.example.material.ModToolMaterials;

public class ModItems {
    // ===== INGOTS =====
    public static final Item ROHSTAHL_GEMISCH = registerItem("rohstahl_gemisch",
            new Item(new Item.Settings()));

    public static final Item STAHLBARREN = registerItem("stahlbarren",
            new Item(new Item.Settings().fireResistant()));

    // ===== TOOLS =====
    public static final Item STAHL_SPITZHACKE = registerItem("stahl_spitzhacke",
            new PickaxeItem(ModToolMaterials.STEEL, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 1, -2.8f))));

    public static final Item STAHL_AXT = registerItem("stahl_axt",
            new AxeItem(ModToolMaterials.STEEL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 6.0f, -3.1f))));

    public static final Item STAHL_SCHAUFEL = registerItem("stahl_schaufel",
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 1.5f, -3.0f))));

    public static final Item STAHL_HACKE = registerItem("stahl_hacke",
            new HoeItem(ModToolMaterials.STEEL, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STEEL, -1.0f, -2.0f))));

    public static final Item STAHL_SCHWERT = registerItem("stahl_schwert",
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 7, -2.4f))));

    // ===== ARMOR =====
    public static final Item STAHL_HELM = registerItem("stahl_helm",
            new ArmorItem(ModToolMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));

    public static final Item STAHL_BRUSTPANZER = registerItem("stahl_brustpanzer",
            new ArmorItem(ModToolMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));

    public static final Item STAHL_HOSE = registerItem("stahl_hose",
            new ArmorItem(ModToolMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));

    public static final Item STAHL_SCHUHE = registerItem("stahl_schuhe",
            new ArmorItem(ModToolMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Items are registered when the class is loaded
    }
}
