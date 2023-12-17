package kamenriderlibfix.kamenriderlib.mixin;

import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({LevelRenderer.class})
public class LevelRendererMixin {
    /*
    @ModifyArgs(method = {"renderLevel"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;renderEntity(Lnet/minecraft/world/entity/Entity;DDDFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;)V"))
    private void renderEntity(Args args){
        ClientLevel level = Minecraft.getInstance().level;
        if(level==null)
            return;
        if(StopManager.getStop() && !StopManager.canEntityBeStop((Entity)args.get(0))){
            args.set(4,0);
        }
    }*/
    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    private void tick(CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop()) {
                ci.cancel();
            }
        }
    }


    @Inject(method = {"tickRain"}, at = {@At("HEAD")}, cancellable = true)
    private void tickRain(CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop()) {
                ci.cancel();
            }
        }
    }
}
