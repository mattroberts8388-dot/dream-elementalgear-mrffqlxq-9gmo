package com.elementalgear;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ElementalGearItems {

    public static Item LAVA_HELMET;
    public static Item LAVA_CHESTPLATE;
    public static Item LAVA_LEGGINGS;
    public static Item LAVA_BOOTS;
    public static Item LAVA_SWORD;
    public static Item LAVA_PICKAXE;
    public static Item LAVA_AXE;
    public static Item LAVA_SHOVEL;
    public static Item LAVA_HOE;

    public static Item ICE_HELMET;
    public static Item ICE_CHESTPLATE;
    public static Item ICE_LEGGINGS;
    public static Item ICE_BOOTS;
    public static Item ICE_SWORD;
    public static Item ICE_PICKAXE;
    public static Item ICE_AXE;
    public static Item ICE_SHOVEL;
    public static Item ICE_HOE;

    public static void registerItems() {
        // Lava armor (also registers the ruby into group)
        ItemGroupEvents.modifyEntriesEvent(ElementalGearMod.id("main"))
                .register(entries -> entries.add(ElementalGearMod.RUBY));

        LAVA_HELMET = register("lava_helmet",
                new LavaArmorItem(ElementalGearArmorMaterials.LAVA, ArmorItem.Type.HELMET,
                        new FabricItemSettings()));
        LAVA_CHESTPLATE = register("lava_chestplate",
                new LavaArmorItem(ElementalGearArmorMaterials.LAVA, ArmorItem.Type.CHESTPLATE,
                        new FabricItemSettings()));
        LAVA_LEGGINGS = register("lava_leggings",
                new LavaArmorItem(ElementalGearArmorMaterials.LAVA, ArmorItem.Type.LEGGINGS,
                        new FabricItemSettings()));
        LAVA_BOOTS = register("lava_boots",
                new LavaArmorItem(ElementalGearArmorMaterials.LAVA, ArmorItem.Type.BOOTS,
                        new FabricItemSettings()));

        LAVA_SWORD = register("lava_sword",
                new ElementalSwordItem(ElementalGearToolMaterials.LAVA, 3, -2.4f,
                        new FabricItemSettings()));
        LAVA_PICKAXE = register("lava_pickaxe",
                new PickaxeItem(ElementalGearToolMaterials.LAVA, 1, -2.8f,
                        new FabricItemSettings()));
        LAVA_AXE = register("lava_axe",
                new AxeItem(ElementalGearToolMaterials.LAVA, 5.0f, -3.0f,
                        new FabricItemSettings()));
        LAVA_SHOVEL = register("lava_shovel",
                new ShovelItem(ElementalGearToolMaterials.LAVA, 1.5f, -3.0f,
                        new FabricItemSettings()));
        LAVA_HOE = register("lava_hoe",
                new HoeItem(ElementalGearToolMaterials.LAVA, -3, 0.0f,
                        new FabricItemSettings()));

        ICE_HELMET = register("ice_helmet",
                new IceArmorItem(ElementalGearArmorMaterials.ICE, ArmorItem.Type.HELMET,
                        new FabricItemSettings()));
        ICE_CHESTPLATE = register("ice_chestplate",
                new IceArmorItem(ElementalGearArmorMaterials.ICE, ArmorItem.Type.CHESTPLATE,
                        new FabricItemSettings()));
        ICE_LEGGINGS = register("ice_leggings",
                new IceArmorItem(ElementalGearArmorMaterials.ICE, ArmorItem.Type.LEGGINGS,
                        new FabricItemSettings()));
        ICE_BOOTS = register("ice_boots",
                new IceArmorItem(ElementalGearArmorMaterials.ICE, ArmorItem.Type.BOOTS,
                        new FabricItemSettings()));

        ICE_SWORD = register("ice_sword",
                new ElementalSwordItem(ElementalGearToolMaterials.ICE, 3, -2.4f,
                        new FabricItemSettings()));
        ICE_PICKAXE = register("ice_pickaxe",
                new PickaxeItem(ElementalGearToolMaterials.ICE, 1, -2.8f,
                        new FabricItemSettings()));
        ICE_AXE = register("ice_axe",
                new AxeItem(ElementalGearToolMaterials.ICE, 5.0f, -3.0f,
                        new FabricItemSettings()));
        ICE_SHOVEL = register("ice_shovel",
                new ShovelItem(ElementalGearToolMaterials.ICE, 1.5f, -3.0f,
                        new FabricItemSettings()));
        ICE_HOE = register("ice_hoe",
                new HoeItem(ElementalGearToolMaterials.ICE, -3, 0.0f,
                        new FabricItemSettings()));
    }

    private static Item register(String name, Item item) {
        Item registered = Registry.register(Registries.ITEM, new Identifier(ElementalGearMod.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(ElementalGearMod.id("main"))
                .register(entries -> entries.add(registered));
        return registered;
    }
}