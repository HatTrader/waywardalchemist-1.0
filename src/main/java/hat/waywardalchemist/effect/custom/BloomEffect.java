package hat.waywardalchemist.effect.custom;

import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BloomEffect extends StatusEffect {
    public BloomEffect() { super(StatusEffectCategory.BENEFICIAL, 0xff6f00); }

    @Override
    public void onEffectRemoved(StatusEffectInstance effectInstance, LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(WaywardAlchemistEffects.BLIGHT, 900, 0));
        super.onEffectRemoved(effectInstance, entity);
    }
}
