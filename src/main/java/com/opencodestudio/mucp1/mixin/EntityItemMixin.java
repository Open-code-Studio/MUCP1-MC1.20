package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class EntityItemMixin {
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;
        
        if (MUCP1Mod.CONFIG.dropSettings.enableRandomDropTime && itemEntity.age == 0) {
            float min = MUCP1Mod.CONFIG.dropSettings.dropTimeMinMultiplier / 100.0f;
            float max = MUCP1Mod.CONFIG.dropSettings.dropTimeMaxMultiplier / 100.0f;
            float multiplier = min + MUCP1Mod.RANDOM.nextFloat() * (max - min);
            itemEntity.setDespawnImmediately();
        }
        
        if (MUCP1Mod.CONFIG.dropSettings.enableQuickDespawn) {
            int maxAge = MUCP1Mod.CONFIG.dropSettings.despawnTimeSeconds * 20;
            if (itemEntity.age >= maxAge) {
                itemEntity.discard();
            }
        }
        
        if (MUCP1Mod.CONFIG.dropSettings.enableItemTeleport) {
            int chance = MUCP1Mod.CONFIG.dropSettings.teleportChancePercent;
            if (MUCP1Mod.RANDOM.nextInt(100) < chance && itemEntity.age % 20 == 0) {
                double x = itemEntity.getX() + (MUCP1Mod.RANDOM.nextDouble() - 0.5) * 20;
                double y = itemEntity.getY() + (MUCP1Mod.RANDOM.nextDouble() - 0.5) * 10;
                double z = itemEntity.getZ() + (MUCP1Mod.RANDOM.nextDouble() - 0.5) * 20;
                itemEntity.teleport(x, y, z);
            }
        }
    }
}
