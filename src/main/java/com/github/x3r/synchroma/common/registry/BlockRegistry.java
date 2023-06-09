package com.github.x3r.synchroma.common.registry;

import com.github.x3r.synchroma.Synchroma;
import com.github.x3r.synchroma.common.block.FrameBlock;
import com.github.x3r.synchroma.common.block.basic_circuit_printer.BasicCircuitPrinterBlock;
import com.github.x3r.synchroma.common.block.controller.ControllerBlock;
import com.github.x3r.synchroma.common.block.energy_buffer.EnergyBufferBlock;
import com.github.x3r.synchroma.common.block.multiblock.MultiBlockPart;
import com.github.x3r.synchroma.common.block.ripperdoc_chair.RipperdocChairBlock;
import com.github.x3r.synchroma.common.block.ripperdoc_interface.RipperdocInterfaceBlock;
import com.github.x3r.synchroma.common.block.weapon_workbench.WeaponWorkbenchBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Synchroma.MOD_ID);

    public static final RegistryObject<Block> RIPPERDOC_CHAIR_BLOCK = BLOCKS.register("ripperdoc_chair",
            () -> new RipperdocChairBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RIPPERDOC_INTERFACE_BLOCK = BLOCKS.register("ripperdoc_interface",
            () -> new RipperdocInterfaceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> FRAME = BLOCKS.register("frame",
            () -> new FrameBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CONTROLLER = BLOCKS.register("controller",
            () -> new ControllerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MULTI_BLOCK_PART = BLOCKS.register("multi_block_part",
            () -> new MultiBlockPart(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WEAPON_WORKBENCH = BLOCKS.register("weapon_workbench",
            () -> new WeaponWorkbenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BASIC_CIRCUIT_PRINTER = BLOCKS.register("basic_circuit_printer",
            () -> new BasicCircuitPrinterBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ENERGY_BUFFER = BLOCKS.register("energy_buffer",
            () -> new EnergyBufferBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
}

