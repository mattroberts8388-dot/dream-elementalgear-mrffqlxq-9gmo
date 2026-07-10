package com.elementalgear;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceArmorItem extends ArmorItem {

    public IceArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient() && entity instanceof LivingEntity living) {
            if (isWearingFullSet(living)) {
                // Infinite water breathing
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,
                        220, 0, false, false, false));
            }
        }
    }

    private boolean isWearingFullSet(LivingEntity living) {
        for (ItemStack armorStack : living.getArmorItems()) {
            if (!(armorStack.getItem() instanceof ArmorItem armor)
                    || armor.getMaterial() != ElementalGearArmorMaterials.ICE) {
                return false;
            }
        }
        return true;
    }
}