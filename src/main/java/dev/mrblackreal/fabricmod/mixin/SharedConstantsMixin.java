package dev.mrblackreal.fabricmod.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {
    @Inject(method = "enableDataFixerOptimization", at = @At("HEAD"), cancellable = true)
    private static void enableDataFixerOptimization(CallbackInfo ci) {
        ci.cancel();
    }
}
