package hat.waywardalchemist.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @WrapOperation(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void waywardAlchemist$applyDamageMultiplier(LivingEntity instance, ServerWorld world, DamageSource source, float amount, Operation<Void> original) {
        if (instance.hasStatusEffect(WaywardAlchemistEffects.FLAMMABILITY) && source.isOf(DamageTypes.IN_FIRE) || source.isOf(DamageTypes.ON_FIRE)) {
            original.call(instance, world, source, amount*1.5f);
        } else if (instance.hasStatusEffect(WaywardAlchemistEffects.VULNERABILITY)) {
            original.call(instance, world, source, amount*(1.2f*(instance.getStatusEffect(WaywardAlchemistEffects.VULNERABILITY).getAmplifier()+1)));
        } else {
            original.call(instance, world, source, amount);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"), method = "tryUseDeathProtector")
    private void waywardAlchemist$purifyPutredo(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if ((LivingEntity) (Object) this instanceof PlayerEntity killed) {
            for (ItemStack stack : killed.getInventory()) {
                if (stack.isOf(WaywardAlchemistItems.PUTREDO)) {
                    stack.decrement(1);
                    killed.giveItemStack(new ItemStack(WaywardAlchemistItems.ALBEDO, 1));
                }
            }
        }
    }
}
