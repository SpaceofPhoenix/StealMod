package com.example.material;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import com.example.TemplateMod;
import com.example.item.ModItems;

public class ModToolMaterials {

    public static final ToolMaterial STEEL = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 625; // 2.5x more durable than iron (250 * 2.5)
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 8.0f; // Same as diamond (8.0)
        }

        @Override
        public float getAttackDamage() {
            return 3.0f; // Base damage for tools
        }

        @Override
        public int getMiningLevel() {
            return 2; // Can mine iron/gold, but not diamond/obsidian (which is level 3)
        }

        @Override
        public int getEnchantability() {
            return 10; // Similar to iron
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.STAHLBARREN);
        }
    };

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new ArmorMaterial(
            // Protection values: Helmet, Chestplate, Leggings, Boots
            new int[]{3, 7, 6, 2},
            // Enchantability
            10,
            // Equip sound (use iron's sound)
            null, // Will use default
            // Repair ingredient
            () -> Ingredient.ofItems(ModItems.STAHLBARREN),
            // Toughness: +1 per armor piece = +4 total
            1.0f,
            // Knockback resistance
            0.0f,
            // Dyeable
            false
    );
}
