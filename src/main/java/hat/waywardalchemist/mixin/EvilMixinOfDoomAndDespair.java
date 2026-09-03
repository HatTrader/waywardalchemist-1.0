package hat.waywardalchemist.mixin;

import net.minecraft.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class EvilMixinOfDoomAndDespair {
    @Inject(at = @At("HEAD"), method = "initialize", cancellable = true)
    private static void yuh(CallbackInfo ci) {
        if (Math.random() <= 0.1f) {
            ci.cancel();
        }
    }
}
