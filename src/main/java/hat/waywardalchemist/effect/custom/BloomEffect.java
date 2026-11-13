package hat.waywardalchemist.effect.custom;

import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BloomEffect extends StatusEffect {
    public BloomEffect() { super(StatusEffectCategory.BENEFICIAL, 0xff6f00); }

    public StatusEffect onEffectRemoved(StatusEffectInstance statusEffectInstance) {
        new StatusEffectInstance(WaywardAlchemistEffects.BLIGHT, 600, 0);
        return null;
    }
}
