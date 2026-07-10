package com.elementalgear;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ElementalGearArmorMaterials {

    public static final ArmorMaterial LAVA = new LavaArmorMaterial();
    public static final ArmorMaterial ICE = new IceArmorMaterial();

    private static class LavaArmorMaterial implements ArmorMaterial {
        private final int[] protection = {3, 6, 8, 3};
        private final int[] baseDurability = {13, 15, 16, 11};

        @Override
        public int getDurability(ArmorItem.Type type) {
            return baseDurability[type.ordinal()] * 40;
        }

        @Override
        public int getProtection(ArmorItem.Type type) {
            return protection[type.ordinal()];
        }

        @Override
        public int getEnchantability() {
            return 12;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ElementalGearBlocks.COMPACTED_MAGMA_3.asItem());
        }

        @Override
        public String getName() {
            return "lava";
        }

        @Override
        public float getToughness() {
            return 3.0f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.1f;
        }
    }

    private static class IceArmorMaterial implements ArmorMaterial {
        private final int[] protection = {3, 6, 8, 3};
        // Ice armor loses durability faster: lower durability multiplier
        private final int[] baseDurability = {13, 15, 16, 11};

        @Override
        public int getDurability(ArmorItem.Type type) {
            return baseDurability[type.ordinal()] * 18;
        }

        @Override
        public int getProtection(ArmorItem.Type type) {
            return protection[type.ordinal()];
        }

        @Override
        public int getEnchantability() {
            return 15;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ElementalGearBlocks.COMPACTED_ICE_3.asItem());
        }

        @Override
        public String getName() {
            return "ice";
        }

        @Override
        public float getToughness() {
            return 2.5f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.05f;
        }
    }
}