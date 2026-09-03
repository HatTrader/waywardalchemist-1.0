package hat.waywardalchemist.component;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ClearAllEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.drink;
import static net.minecraft.component.type.ConsumableComponents.food;

public class WaywardAlchemistConsumableComponents {


    public static final ConsumableComponent SWEET_TREAT = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.SPEED, 100, 0)))).build();

    public static final ConsumableComponent PANCEA = drink()
            .consumeSeconds(0.2F)
            .finishSound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK)
            .consumeEffect(ClearAllEffectsConsumeEffect.INSTANCE)
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1)))).build();
}

