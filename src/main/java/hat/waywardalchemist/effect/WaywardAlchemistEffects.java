package hat.waywardalchemist.effect;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

    public static final RegistryEntry<StatusEffect> TRANSMUTATION =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WaywardAlchemist.MOD_ID, "transmutation"), new TransmutationEffect());

    public static void init() {}
}
