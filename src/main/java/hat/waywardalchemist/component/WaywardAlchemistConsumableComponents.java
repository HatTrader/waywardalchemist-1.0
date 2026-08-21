package hat.waywardalchemist.component;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.drink;
import static net.minecraft.component.type.ConsumableComponents.food;

public class WaywardAlchemistConsumableComponents {


    public static final ConsumableComponent SWEET_TREAT = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.SPEED, 100, 0)))).build();
}
