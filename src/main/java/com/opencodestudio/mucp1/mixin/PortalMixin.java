package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.dimension.DimensionTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class PortalMixin {
    
    @Inject(method = "getTeleportTarget", at = @At("HEAD"), cancellable = true)
    private void onGetTeleportTarget(ServerWorld destination, CallbackInfoReturnable<TeleportTarget> cir) {
        Entity entity = (Entity) (Object) this;
        
        if (MUCP1Mod.CONFIG.portalSettings.enablePortalChaos) {
            int maxDist = MUCP1Mod.CONFIG.portalSettings.maxTeleportDistance;
            double x = entity.getX() + (MUCP1Mod.RANDOM.nextDouble() - 0.5) * maxDist * 2;
            double z = entity.getZ() + (MUCP1Mod.RANDOM.nextDouble() - 0.5) * maxDist * 2;
            double y = destination.getSeaLevel();
        }
    }
}
