package com.elementalgear;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ElementalGearBlocks {

    public static Block COMPACTED_MAGMA_1;
    public static Block COMPACTED_MAGMA_2;
    public static Block COMPACTED_MAGMA_3;
    public static Block COMPACTED_ICE_1;
    public static Block COMPACTED_ICE_2;
    public static Block COMPACTED_ICE_3;
    public static Block RUBY_ORE;
    public static Block DEEPSLATE_RUBY_ORE;
    public static Block MAGMA_GENERATOR;
    public static Block ICE_GENERATOR;

    public static void registerBlocks() {
        COMPACTED_MAGMA_1 = register("compacted_magma_1",
                new Block(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).strength(2.0f)));
        COMPACTED_MAGMA_2 = register("compacted_magma_2",
                new Block(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).strength(3.0f)));
        COMPACTED_MAGMA_3 = register("compacted_magma_3",
                new Block(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).strength(4.0f)));

        COMPACTED_ICE_1 = register("compacted_ice_1",
                new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(2.0f)));
        COMPACTED_ICE_2 = register("compacted_ice_2",
                new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(3.0f)));
        COMPACTED_ICE_3 = register("compacted_ice_3",
                new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(4.0f)));

        RUBY_ORE = register("ruby_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE),
                        UniformIntProvider.create(3, 7)));
        DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE),
                        UniformIntProvider.create(3, 7)));

        MAGMA_GENERATOR = register("magma_generator",
                new Block(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).strength(5.0f)
                        .luminance(state -> 12).sounds(BlockSoundGroup.STONE)));
        ICE_GENERATOR = register("ice_generator",
                new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(5.0f)
                        .luminance(state -> 4).sounds(BlockSoundGroup.GLASS)));
    }

    private static Block register(String name, Block block) {
        Block registered = Registry.register(Registries.BLOCK, new Identifier(ElementalGearMod.MOD_ID, name), block);
        Item blockItem = Registry.register(Registries.ITEM, new Identifier(ElementalGearMod.MOD_ID, name),
                new BlockItem(registered, new net.fabricmc.fabric.api.item.v1.FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ElementalGearMod.id("main"))
                .register(entries -> entries.add(blockItem));
        return registered;
    }
}