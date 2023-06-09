package com.github.x3r.synchroma.common.registry;

import com.github.x3r.synchroma.Synchroma;
import com.github.x3r.synchroma.common.block.basic_circuit_printer.BasicCircuitPrinterBlockEntity;
import com.github.x3r.synchroma.common.block.controller.ControllerBlockEntity;
import com.github.x3r.synchroma.common.block.energy_buffer.EnergyBufferBlockEntity;
import com.github.x3r.synchroma.common.block.multiblock.MultiBlockPartEntity;
import com.github.x3r.synchroma.common.block.ripperdoc_chair.RipperdocChairBlockEntity;
import com.github.x3r.synchroma.common.block.ripperdoc_interface.RipperdocInterfaceBlockEntity;
import com.github.x3r.synchroma.common.block.weapon_workbench.WeaponWorkbenchBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Synchroma.MOD_ID);

    public static final RegistryObject<BlockEntityType<RipperdocChairBlockEntity>> RIPPERDOC_CHAIR_TILE = BLOCK_ENTITIES.register("ripperdoc_chair",
            () -> BlockEntityType.Builder.of(RipperdocChairBlockEntity::new, BlockRegistry.RIPPERDOC_CHAIR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<RipperdocInterfaceBlockEntity>> RIPPERDOC_INTERFACE_TILE = BLOCK_ENTITIES.register("ripperdoc_interface",
            () -> BlockEntityType.Builder.of(RipperdocInterfaceBlockEntity::new, BlockRegistry.RIPPERDOC_INTERFACE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<ControllerBlockEntity>> CONTROLLER = BLOCK_ENTITIES.register("controller",
            () -> BlockEntityType.Builder.of(ControllerBlockEntity::new, BlockRegistry.CONTROLLER.get()).build(null));
    public static final RegistryObject<BlockEntityType<MultiBlockPartEntity>> MULTI_BLOCK_PART = BLOCK_ENTITIES.register("multi_block_part.json",
            () -> BlockEntityType.Builder.of(MultiBlockPartEntity::new, BlockRegistry.MULTI_BLOCK_PART.get()).build(null));
    public static final RegistryObject<BlockEntityType<WeaponWorkbenchBlockEntity>> WEAPON_WORKBENCH = BLOCK_ENTITIES.register("weapon_workbench",
            () -> BlockEntityType.Builder.of(WeaponWorkbenchBlockEntity::new, BlockRegistry.WEAPON_WORKBENCH.get()).build(null));
    public static final RegistryObject<BlockEntityType<BasicCircuitPrinterBlockEntity>> BASIC_CIRCUIT_PRINTER = BLOCK_ENTITIES.register("basic_circuit_printer",
            () -> BlockEntityType.Builder.of(BasicCircuitPrinterBlockEntity::new, BlockRegistry.BASIC_CIRCUIT_PRINTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyBufferBlockEntity>> ENERGY_BUFFER = BLOCK_ENTITIES.register("energy_buffer",
            () -> BlockEntityType.Builder.of(EnergyBufferBlockEntity::new, BlockRegistry.ENERGY_BUFFER.get()).build(null));
}
