package kamenriderlibfix.kamenriderlib.mixin;

import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ClientLevel.class})
public class ClientLevelMixiin {
    @Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
    private void tick(CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop()) {
                ci.cancel();
            }
        }
    }

    @Inject(method = {"doAnimateTick"}, at = {@At("HEAD")}, cancellable = true)
    private void animateTick(CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop()) {
                ci.cancel();
            }
        }
    }
    @Inject(method = {"tickNonPassenger"}, at = {@At("HEAD")}, cancellable = true)
    private void tickNonPassenger(Entity entity, CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop() && StopManager.canEntityBeStop(entity)) {
                ci.cancel();
            }
        }
    }

    @Inject(method = {"tickPassenger"}, at = {@At("HEAD")}, cancellable = true)
    private void tickPassenger(Entity vehicle, Entity passenger, CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop() && StopManager.canEntityBeStop(passenger)) {
                ci.cancel();
            }

        }
    }
    @Inject(method = {"tickTime"}, at = {@At("HEAD")}, cancellable = true)
    private void tickTime(CallbackInfo ci) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            if (StopManager.getStop()) {
                ci.cancel();
            }
        }
    }
}
