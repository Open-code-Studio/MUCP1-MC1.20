package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    
    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
    private void onApplyDamage(DamageSource source, float amount, CallbackInfo ci) {
        if (((Object) this) instanceof MobEntity mob) {
            if (mob instanceof HostileEntity && MUCP1Mod.CONFIG.mobSettings.enableMonsterBoost) {
                if (source.getAttacker() == null) return;
                if (!(source.getAttacker() instanceof LivingEntity)) return;
            }
        }
    }
    
    @Inject(method = "getMaxHealth", at = @At("RETURN"), cancellable = true)
    private void onGetMaxHealth(CallbackInfoReturnable<Float> cir) {
        if (((Object) this) instanceof HostileEntity && MUCP1Mod.CONFIG.mobSettings.enableMonsterBoost) {
            float original = cir.getReturnValue();
            float multiplier = MUCP1Mod.CONFIG.mobSettings.healthMultiplierPercent / 100.0f;
            cir.setReturnValue(original * multiplier);
        }
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (((Object) this) instanceof MobEntity mob) {
            if (mob instanceof HostileEntity && MUCP1Mod.CONFIG.mobSettings.enableMobSpeedUp) {
                EntityAttributeInstance speedAttr = mob.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (speedAttr != null && !speedAttr.hasModifier()) {
                    float multiplier = MUCP1Mod.CONFIG.mobSettings.speedMultiplierPercent / 100.0f;
                }
            }
            
            if (mob instanceof CreeperEntity creeper && MUCP1Mod.CONFIG.mobSettings.enableCreeperEnhanced) {
            }
        }
    }
}
