package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
    
    @Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At("HEAD"), cancellable = true)
    private void onPlay(CallbackInfo ci) {
        if (MUCP1Mod.CONFIG.soundSettings.enableSoundChaos) {
            if (MUCP1Mod.RANDOM.nextInt(100) < 10) {
            }
        }
    }
}
