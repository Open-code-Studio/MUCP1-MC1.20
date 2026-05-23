package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {
    
    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    private void onGetHardness(BlockState state, CallbackInfoReturnable<Float> cir) {
        Block block = (Block) (Object) this;
        
        if (MUCP1Mod.CONFIG.blockSettings.enableDiamondLock && 
            (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE)) {
            float originalHardness = 3.0f;
            float multiplier = MUCP1Mod.CONFIG.blockSettings.diamondHardnessMultiplier;
            cir.setReturnValue(originalHardness * multiplier);
            return;
        }
        
        if (MUCP1Mod.CONFIG.blockSettings.enableRandomBlockHardness) {
            float min = MUCP1Mod.CONFIG.blockSettings.hardnessMinMultiplier / 100.0f;
            float max = MUCP1Mod.CONFIG.blockSettings.hardnessMaxMultiplier / 100.0f;
            float multiplier = min + MUCP1Mod.RANDOM.nextFloat() * (max - min);
        }
    }
}
