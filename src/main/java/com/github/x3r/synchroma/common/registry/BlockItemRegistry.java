package com.github.x3r.synchroma.common.registry;

import com.github.x3r.synchroma.Synchroma;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemRegistry {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Synchroma.MOD_ID);

    public static final RegistryObject<BlockItem> RIPPERDOC_CHAIR_ITEM = BLOCK_ITEMS.register("ripperdoc_chair",
            () -> new BlockItem(BlockRegistry.RIPPERDOC_CHAIR_BLOCK.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> RIPPERDOC_INTERFACE_ITEM = BLOCK_ITEMS.register("ripperdoc_interface",
            () -> new BlockItem(BlockRegistry.RIPPERDOC_INTERFACE_BLOCK.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> WEAPON_WORKBENCH_ITEM = BLOCK_ITEMS.register("weapon_workbench",
            () -> new BlockItem(BlockRegistry.WEAPON_WORKBENCH.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> BASIC_CIRCUIT_PRINTER_ITEM = BLOCK_ITEMS.register("basic_circuit_printer",
            () -> new BlockItem(BlockRegistry.BASIC_CIRCUIT_PRINTER.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> FRAME_ITEM = BLOCK_ITEMS.register("frame",
            () -> new BlockItem(BlockRegistry.FRAME.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> CONTROLLER_ITEM = BLOCK_ITEMS.register("controller",
            () -> new BlockItem(BlockRegistry.CONTROLLER.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> MULTI_BLOCK_PART_ITEM = BLOCK_ITEMS.register("multi_block_part",
            () -> new BlockItem(BlockRegistry.MULTI_BLOCK_PART.get(), ItemRegistry.DEFAULT_PROPERTIES));

    public static final RegistryObject<BlockItem> ENERGY_BUFFER_ITEM = BLOCK_ITEMS.register("energy_buffer",
            () -> new BlockItem(BlockRegistry.ENERGY_BUFFER.get(), ItemRegistry.DEFAULT_PROPERTIES));
}
