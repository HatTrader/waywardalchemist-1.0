package hat.waywardalchemist.items.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class InjectionPotionItem extends PotionItem {
    public InjectionPotionItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack itemStack = super.getDefaultStack();
        itemStack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER));
        return super.getDefaultStack();
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (!player.getItemCooldownManager().isCoolingDown(stack)) {
                PotionContentsComponent potionContentsComponent = (PotionContentsComponent) stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
                for (StatusEffectInstance effect : potionContentsComponent.getEffects()) {
                    RegistryEntry<StatusEffect> registryEntry = effect.getEffectType();
                    target.addStatusEffect(new StatusEffectInstance(registryEntry, effect.getDuration(), effect.getAmplifier()));
                }
                target.getEntityWorld().playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.ITEM_SPEAR_HIT, SoundCategory.PLAYERS, 1.1f, 1.0f);
                player.getItemCooldownManager().set(stack, 75);
                stack.decrement(1);
            }
        }

        super.postHit(stack, target, attacker);
    }
}
