package hat.waywardalchemist.mixin;

import hat.waywardalchemist.items.custom.CitrinasItem;
import hat.waywardalchemist.items.custom.EvilStateOfDoomAndDespair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageSource.class)
public class DeathMessageMixin {
    @Inject(at = @At("HEAD"), method = "getDeathMessage", cancellable = true)
    private void thingu(LivingEntity killed, CallbackInfoReturnable<Text> cir) {
        if (killed.getLastAttacker() != null && killed.getLastAttacker().getStackInHand(killed.getLastAttacker().preferredHand).getItem() instanceof CitrinasItem) {
            cir.setReturnValue(Text.literal(killed.getName().getString() + " was harvested"));
        }
    }
}
