package kamenriderlibfix.kamenriderlib.mixin;

import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({Minecraft.class})
public class MinecraftMixin {

    @ModifyArg(method = {"runTick"}, at = @At(value = "INVOKE",target = "Lnet/minecraft/client/renderer/GameRenderer;render(FJZ)V"), index = 0)
    private float partialTick(float tick) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            return tick;
        } else {
            return StopManager.getStop()? 0: tick;
        }
    }
}
