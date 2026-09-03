package hat.waywardalchemist.effect.custom;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import hat.waywardalchemist.util.TransmutationUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class TransmutationEffect extends StatusEffect {
    public TransmutationEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xab3b41);
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public void applyInstantEffect(ServerWorld world, @Nullable Entity effectEntity, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        Collection<StatusEffectInstance> effects = List.copyOf(target.getStatusEffects());
        for (StatusEffectInstance instance : effects) {
            target.addStatusEffect(transmuteEffect(instance, target));
            target.removeStatusEffect(instance.getEffectType());
        }
        super.applyInstantEffect(world, effectEntity, attacker, target, amplifier, proximity);
    }

    private static StatusEffectInstance transmuteEffect(StatusEffectInstance instance, LivingEntity entity) {
        if (TransmutationUtils.transmutedPositiveEffects.containsKey(instance.getEffectType())) {
            RegistryEntry<StatusEffect> transmutedEffect = TransmutationUtils.transmutedPositiveEffects.get(instance.getEffectType());
            return new StatusEffectInstance(transmutedEffect, instance.getDuration(), instance.getAmplifier());
        } else if (TransmutationUtils.transmutedNegativeEffects.containsKey(instance.getEffectType())) {
            RegistryEntry<StatusEffect> transmutedEffect = TransmutationUtils.transmutedNegativeEffects.get(instance.getEffectType());
            return new StatusEffectInstance(transmutedEffect, instance.getDuration(), 0);
        } else {
            return instance;
        }
    }
}
