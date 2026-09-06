package hat.waywardalchemist.mixin;

import hat.waywardalchemist.items.data.WaywardAlchemistItemComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(at = @At("HEAD"), method = "use", cancellable = true)
    private static void waywardAlchemist$ignoreThis(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.getOrDefault(WaywardAlchemistItemComponents.IS_PRIMAL, false)) {

            if (stack.getDamage() == stack.getMaxDamage()+1) {
                stack.decrement(1);
            } else {
                stack.setDamage(stack.getDamage() + 1);
            }
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}
