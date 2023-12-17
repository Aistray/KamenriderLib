package kamenriderlibfix.kamenriderlib.mixin;

import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.client.renderer.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({TextureManager.class})
public class TextureMixin {
    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    private void tick(CallbackInfo ci) {
        if (StopManager.getStop()) {
            ci.cancel();
        }
    }
}
