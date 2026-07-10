package com.elementalgear;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ElementalGearToolMaterials {

    public static final ToolMaterial LAVA = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 2200;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 9.0f;
        }

        @Override
        public float getAttackDamage() {
            return 4.0f;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 12;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ElementalGearBlocks.COMPACTED_MAGMA_3.asItem());
        }
    };

    public static final ToolMaterial ICE = new ToolMaterial() {
        @Override
        public int getDurability() {
            // Ice tools lose durability faster
            return 900;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 8.0f;
        }

        @Override
        public float getAttackDamage() {
            return 3.5f;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 15;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ElementalGearBlocks.COMPACTED_ICE_3.asItem());
        }
    };
}