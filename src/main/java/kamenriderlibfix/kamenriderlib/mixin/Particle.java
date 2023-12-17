package kamenriderlibfix.kamenriderlib.mixin;

import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ParticleEngine.class})
public class Particle {
    public Particle() {
    }

    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    public void tick(CallbackInfo ci) {
        if (StopManager.getStop()) {
            ci.cancel();
        }
    }
}
