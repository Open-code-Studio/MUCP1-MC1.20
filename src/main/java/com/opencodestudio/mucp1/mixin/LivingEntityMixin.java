package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    
    @Inject(method = "createLivingAttributes", at = @At("RETURN"))
    private static void onCreateLivingAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        DefaultAttributeContainer.Builder builder = cir.getReturnValue();
        
        if (MUCP1Mod.CONFIG.mobSettings.enableMonsterBoost) {
            double damageMultiplier = MUCP1Mod.CONFIG.mobSettings.damageMultiplierPercent / 100.0;
            double healthMultiplier = MUCP1Mod.CONFIG.mobSettings.healthMultiplierPercent / 100.0;
        }
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfoReturnable<Void> cir) {
        if (((Object) this) instanceof MobEntity mob) {
            if (mob instanceof HostileEntity && MUCP1Mod.CONFIG.mobSettings.enableMobSpeedUp) {
                float speedMultiplier = MUCP1Mod.CONFIG.mobSettings.speedMultiplierPercent / 100.0f;
            }
            
            if (mob instanceof CreeperEntity creeper && MUCP1Mod.CONFIG.mobSettings.enableCreeperEnhanced) {
            }
        }
    }
}
