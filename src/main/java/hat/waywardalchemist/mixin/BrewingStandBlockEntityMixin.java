package hat.waywardalchemist.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import hat.waywardalchemist.items.data.WaywardAlchemistItemComponents;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BrewingStandBlockEntity.class)
public class BrewingStandBlockEntityMixin {
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"), method = "craft")
    private static void waywardAlchemist$workDifferentlyWithPrimalStuff(ItemStack instance, int amount, Operation<Void> original) {
        if (instance.getOrDefault(WaywardAlchemistItemComponents.IS_PRIMAL, false)) {
            if (instance.getDamage() >= instance.getMaxDamage()-1) {
                original.call(instance, amount);
            } else {
                instance.setDamage(instance.getDamage() + 1);
                original.call(instance, 0);
            }
        }
    }
}
