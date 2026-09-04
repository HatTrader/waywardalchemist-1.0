package hat.waywardalchemist.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class OverdoseEffect extends StatusEffect {
    public OverdoseEffect() {super(StatusEffectCategory.HARMFUL, 0xffd4e7);}

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.getStatusEffects().size() < 2.0F) {
            entity.damage(world, entity.getDamageSources().magic(), 1.0F);
        } else
            if (entity.getStatusEffects().size() < 3.0f) {
                entity.damage(world, entity.getDamageSources().magic(), 2.0F);
            } else
                if (entity.getStatusEffects().size() < 4.0f) {
                    entity.damage(world, entity.getDamageSources().magic(), 3.0F);
                } else
                if (entity.getStatusEffects().size() < 5.0f) {
                    entity.damage(world, entity.getDamageSources().magic(), 4.0F);
                } else
                if (entity.getStatusEffects().size() > 4.0f) {
                    entity.damage(world, entity.getDamageSources().magic(), 4.0F);
                }

        return true;
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }

}
}
