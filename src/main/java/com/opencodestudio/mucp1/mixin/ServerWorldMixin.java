package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    
    private int timeTickCounter = 0;
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ServerWorld world = (ServerWorld) (Object) this;
        
        if (world.getRegistryKey() != World.OVERWORLD) return;
        
        if (MUCP1Mod.CONFIG.timeSettings.enableTimeAccelerator) {
            timeTickCounter++;
            int multiplier = MUCP1Mod.CONFIG.timeSettings.timeSpeedMultiplier;
            if (timeTickCounter % (20 / multiplier) == 0) {
                world.setTimeOfDay(world.getTimeOfDay() + 1);
            }
        }
        
        if (MUCP1Mod.CONFIG.timeSettings.enablePerpetualNight) {
            long time = world.getTimeOfDay();
            if (time < 13000 || time > 23000) {
                world.setTimeOfDay(13000);
            }
        }
        
        if (MUCP1Mod.CONFIG.timeSettings.enableRandomTimeJump) {
            int chance = MUCP1Mod.CONFIG.timeSettings.jumpChancePercent;
            if (MUCP1Mod.RANDOM.nextInt(100 * 20) < chance) {
                long newTime = MUCP1Mod.RANDOM.nextLong(24000);
                world.setTimeOfDay(newTime);
            }
        }
    }
}
