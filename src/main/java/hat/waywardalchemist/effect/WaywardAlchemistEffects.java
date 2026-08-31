package hat.waywardalchemist.effect;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.custom.ConstructionEffect;
import hat.waywardalchemist.effect.custom.FlammabilityEffect;
import hat.waywardalchemist.effect.custom.OverdoseEffect;
import hat.waywardalchemist.effect.custom.VulnerabilityEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class WaywardAlchemistEffects {
    public static final RegistryEntry<StatusEffect> VULNERABILITY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "vulnerability"), new VulnerabilityEffect());

    public static final RegistryEntry<StatusEffect> CONSTRUCTION =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "construction"), new ConstructionEffect().addAttributeModifier(EntityAttributes.BLOCK_INTERACTION_RANGE, Identifier.of("construction"), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> FLAMMABILITY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "flammability"), new FlammabilityEffect().addAttributeModifier(EntityAttributes.BURNING_TIME, Identifier.of("flammability"), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> OVERDOSE =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "overdose"), new OverdoseEffect());

}
