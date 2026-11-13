package hat.waywardalchemist.effect;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class WaywardAlchemistEffects {


    public static final RegistryEntry<StatusEffect> VULNERABILITY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "vulnerability"), new VulnerabilityEffect());

    public static final RegistryEntry<StatusEffect> CONSTRUCTION =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "construction"), new ConstructionEffect().addAttributeModifier(EntityAttributes.BLOCK_INTERACTION_RANGE, Identifier.of("construction"), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> FLAMMABILITY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "flammability"), new FlammabilityEffect().addAttributeModifier(EntityAttributes.BURNING_TIME, Identifier.of("flammability"), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> OVERDOSE =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "overdose"), new OverdoseEffect());

    public static final RegistryEntry<StatusEffect> OVERSHIELD =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "overshield"), new OvershieldEffect());

    public static final RegistryEntry<StatusEffect> TRANSMUTATION =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "transmutation"), new TransmutationEffect());

    public static final RegistryEntry<StatusEffect> STURDY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "sturdy"), new SturdyEffect().addAttributeModifier(EntityAttributes.KNOCKBACK_RESISTANCE, Identifier.of("sturdy"), 0.5, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> GRACEFUL =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "graceful"), new GracefulEffect().addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.of("weightless"), 1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> CRASHLAND =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "crashland"), new CrashlandEffect().addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.of("crashland"), -0.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static void init() {}
}
