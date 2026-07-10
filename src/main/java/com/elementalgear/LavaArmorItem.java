package com.elementalgear;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class LavaArmorItem extends ArmorItem {

    public LavaArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient() && entity instanceof net.minecraft.entity.LivingEntity living) {
            if (isWearingFullSet(living)) {
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,
                        220, 0, false, false, false));
            }
        }
    }

    private boolean isWearingFullSet(net.minecraft.entity.LivingEntity living) {
        for (ItemStack armorStack : living.getArmorItems()) {
            if (!(armorStack.getItem() instanceof ArmorItem armor)
                    || armor.getMaterial() != ElementalGearArmorMaterials.LAVA) {
                return false;
            }
        }
        return true;
    }
}