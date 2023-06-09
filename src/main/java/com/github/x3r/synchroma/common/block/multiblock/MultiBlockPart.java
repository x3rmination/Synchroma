package com.github.x3r.synchroma.common.block.multiblock;

import com.github.x3r.synchroma.common.block.controller.ControllerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class MultiBlockPart extends Block implements EntityBlock {
    public MultiBlockPart(Properties pProperties) {
        super(pProperties.noOcclusion());
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MultiBlockPartEntity(pPos, pState);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            if (pLevel.getBlockEntity(pPos) instanceof MultiBlockPartEntity part) {
                part.getControllerPos().ifPresent(pos -> {
                    if (pLevel.getBlockEntity(pos) instanceof ControllerBlockEntity controllerBlockEntity) {
                        controllerBlockEntity.disassemble();
                    }
                });
                pLevel.setBlockAndUpdate(pPos, pNewState);
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        ItemStack stack = ItemStack.EMPTY;
        if(level.getBlockEntity(pos) instanceof MultiBlockPartEntity part) {
            if(part.getControllerPos().isPresent() && level.getBlockEntity(part.getControllerPos().get()) instanceof ControllerBlockEntity controller) {
                return controller.getFirstItem();
            }
        }
        return stack;
    }
}
