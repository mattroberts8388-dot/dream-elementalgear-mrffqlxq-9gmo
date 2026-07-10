package com.elementalgear;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

public class ElementalGearMod implements ModInitializer {
    public static final String MOD_ID = "elementalgear";

    // Item group
    public static final net.minecraft.item.ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.MAGMA_BLOCK))
            .displayName(Text.translatable("itemGroup.elementalgear.main"))
            .build();

    // Ruby item
    public static Item RUBY;

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "main"), ITEM_GROUP);

        RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

        ElementalGearBlocks.registerBlocks();
        ElementalGearItems.registerItems();

        registerCombatEvents();
    }

    private static Item registerItem(String name, Item item) {
        Item registered = Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
        return registered;
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    private void registerCombatEvents() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClient()) {
                return ActionResult.PASS;
            }
            if (!(entity instanceof LivingEntity target)) {
                return ActionResult.PASS;
            }
            ItemStack held = player.getStackInHand(hand);
            Item item = held.getItem();

            // Lava tools do extra damage to entities wearing ice armor
            if (isLavaTool(item)) {
                if (isWearingIceArmor(target)) {
                    target.damage(player.getWorld().getDamageSources().magic(), 4.0f);
                }
            }

            // Ice tools do extra damage to entities wearing lava armor
            if (isIceTool(item)) {
                if (isWearingLavaArmor(target)) {
                    target.damage(player.getWorld().getDamageSources().magic(), 4.0f);
                }
            }
            return ActionResult.PASS;
        });
    }

    public static boolean isLavaTool(Item item) {
        return item == ElementalGearItems.LAVA_SWORD
                || item == ElementalGearItems.LAVA_PICKAXE
                || item == ElementalGearItems.LAVA_AXE
                || item == ElementalGearItems.LAVA_SHOVEL
                || item == ElementalGearItems.LAVA_HOE;
    }

    public static boolean isIceTool(Item item) {
        return item == ElementalGearItems.ICE_SWORD
                || item == ElementalGearItems.ICE_PICKAXE
                || item == ElementalGearItems.ICE_AXE
                || item == ElementalGearItems.ICE_SHOVEL
                || item == ElementalGearItems.ICE_HOE;
    }

    public static boolean isWearingIceArmor(LivingEntity entity) {
        for (ItemStack stack : entity.getArmorItems()) {
            if (stack.getItem() instanceof ArmorItem armor
                    && armor.getMaterial() == ElementalGearArmorMaterials.ICE) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWearingLavaArmor(LivingEntity entity) {
        for (ItemStack stack : entity.getArmorItems()) {
            if (stack.getItem() instanceof ArmorItem armor
                    && armor.getMaterial() == ElementalGearArmorMaterials.LAVA) {
                return true;
            }
        }
        return false;
    }
}