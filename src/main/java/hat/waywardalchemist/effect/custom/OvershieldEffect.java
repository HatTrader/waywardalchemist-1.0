package hat.waywardalchemist.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class OvershieldEffect extends StatusEffect {
    public OvershieldEffect() {super(StatusEffectCategory.BENEFICIAL, 0x77cfe3);}

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.getStatusEffects().size() < 4.0F) {
            entity.heal(1.0F);
        } else
            if (entity.getStatusEffects().size() < 5.0f) {
                entity.heal(2.0F);
            } else
                if (entity.getStatusEffects().size() < 6.0f) {
                    entity.heal(3.0F);
                } else
                if (entity.getStatusEffects().size() < 7.0f) {
                    entity.heal(4.0F);
                } else
                if (entity.getStatusEffects().size() > 6.0f) {
                    entity.heal(4.0F);
                }

        return true;
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 75 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }

}
}
