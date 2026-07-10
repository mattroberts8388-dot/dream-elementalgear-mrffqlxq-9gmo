package com.elementalgear;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ElementalSwordItem extends SwordItem {

    public ElementalSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.postHit(stack, target, attacker);
        // Lava sword sets targets on fire
        if (getMaterial() == ElementalGearToolMaterials.LAVA) {
            target.setOnFireFor(4);
        }
        // Ice sword slows/freezes targets
        if (getMaterial() == ElementalGearToolMaterials.ICE) {
            target.setFrozenTicks(Math.min(target.getFrozenTicks() + 60, 200));
        }
        return result;
    }
}