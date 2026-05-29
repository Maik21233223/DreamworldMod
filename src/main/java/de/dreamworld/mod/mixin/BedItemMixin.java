package de.dreamworld.mod.mixin;

import de.dreamworld.mod.client.TraumScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedBlock.class)
public abstract class BedItemMixin {

    @Inject(method = "useWithoutItem", at = @At("HEAD"), cancellable = true)
    private void onUseWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
        if (level.isClientSide()) {
            Minecraft.getInstance().setScreen(new TraumScreen());
        }
        cir.setReturnValue(InteractionResult.SUCCESS);
    }
}
