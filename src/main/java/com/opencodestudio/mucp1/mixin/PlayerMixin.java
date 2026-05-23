package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {
    
    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        
        if (MUCP1Mod.isGravityStormActive()) {
            if (this.age % 10 == 0) {
                if (MUCP1Mod.RANDOM.nextBoolean()) {
                    this.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.LEVITATION, 20, MUCP1Mod.RANDOM.nextInt(3)
                    ));
                }
            }
            return;
        }
        
        if (MUCP1Mod.CONFIG.gravitySettings.enableAntiGravity) {
            int chance = MUCP1Mod.CONFIG.gravitySettings.antiGravityChancePercent;
            if (MUCP1Mod.RANDOM.nextInt(100 * 20) < chance) {
                int duration = MUCP1Mod.CONFIG.gravitySettings.antiGravityDurationSeconds * 20;
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, duration, 0));
            }
        }
        
        if (MUCP1Mod.CONFIG.gravitySettings.enableSuperGravity) {
            int chance = MUCP1Mod.CONFIG.gravitySettings.superGravityChancePercent;
            if (MUCP1Mod.RANDOM.nextInt(100 * 20) < chance) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, -2));
            }
        }
    }
}
