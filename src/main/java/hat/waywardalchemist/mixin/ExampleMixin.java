package hat.waywardalchemist.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class ExampleMixin {
    @Inject(at = @At("HEAD"), method = "damage", cancellable = true)
    private void thingy(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable cir) {
        //keeping this here for me to have later, also if you're an actual modder reading this, shut up about the names.
        //modder here, weird names are an essential part of having joy and whimsy in your life.
    }

    @WrapOperation(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void thingo(LivingEntity instance, ServerWorld world, DamageSource source, float amount, Operation<Void> original) {
        float multiplier = instance.hasStatusEffect(WaywardAlchemistEffects.FLAMMABILITY) || source.isOf(DamageTypes.ON_FIRE) ? 2.0f : 1.0f;
        if (instance.hasStatusEffect(WaywardAlchemistEffects.FLAMMABILITY) && source.isOf(DamageTypes.IN_FIRE) || source.isOf(DamageTypes.ON_FIRE)) {
            original.call(instance, world, source, amount*1.5f);
        } else if (instance.hasStatusEffect(WaywardAlchemistEffects.VULNERABILITY)) {
            original.call(instance, world, source, amount*(1.2f*(instance.getStatusEffect(WaywardAlchemistEffects.VULNERABILITY).getAmplifier()+1)));
        } else {
            original.call(instance, world, source, amount);
        }


    }

}
