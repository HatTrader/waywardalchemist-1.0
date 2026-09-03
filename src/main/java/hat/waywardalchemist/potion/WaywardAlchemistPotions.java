package hat.waywardalchemist.potion;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.List;


public class WaywardAlchemistPotions {

    public static final RegistryEntry<Potion> LUCK_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "luck"),
                    new Potion("luck", new StatusEffectInstance(StatusEffects.LUCK, 1800, 0)));

    public static final RegistryEntry<Potion> CONSTRUCTION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "construction"),
                    new Potion("construction", new StatusEffectInstance(WaywardAlchemistEffects.CONSTRUCTION, 36000, 0)));

    public static final RegistryEntry<Potion> ABSORPTION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "absorption"),
                    new Potion("absorption", new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0)));

    public static final RegistryEntry<Potion> LONG_ABSORPTION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "long_absorption"),
                    new Potion("absorption", new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 0)));

    public static final RegistryEntry<Potion> STRONG_ABSORPTION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "strong_absorption"),
                    new Potion("absorption", new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 1)));

    public static final RegistryEntry<Potion> FLAMMABILITY_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "flammability"),
                    new Potion("flammability", new StatusEffectInstance(WaywardAlchemistEffects.FLAMMABILITY, 1200, 0)));

    public static final RegistryEntry<Potion> MINING_FATIGUE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "mining_fatigue"),
                    new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1800, 0)));

    public static final RegistryEntry<Potion> STRONG_MINING_FATIGUE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "strong_mining_fatigue"),
                    new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 600, 2)));

    public static final RegistryEntry<Potion> HASTE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "haste"),
                    new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 9600, 0), new StatusEffectInstance(StatusEffects.WEAKNESS, 1800, 1)));

    public static final RegistryEntry<Potion> STRONG_HASTE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "strong_haste"),
                    new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 3600, 1), new StatusEffectInstance(StatusEffects.WEAKNESS, 1800, 1)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_LEAPING_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_leaping"),
                    new Potion("leaping", new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1800, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_SWIFTNESS_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_swiftness"),
                    new Potion("swiftness", new StatusEffectInstance(StatusEffects.SPEED, 1800, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_SLOWNESS_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_slowness"),
                    new Potion("slowness", new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 5)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_TURTLE_MASTER_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_turtle_master"),
                    new Potion("turtle_master", new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 4), new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 6)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_HEALING_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_healing"),
                    new Potion("healing", new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_HARMING_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_harming"),
                    new Potion("harming", new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_POISON_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_poison"),
                    new Potion("poison", new StatusEffectInstance(StatusEffects.POISON, 420, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_REGENERATION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_regeneration"),
                    new Potion("regeneration", new StatusEffectInstance(StatusEffects.REGENERATION, 440, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_STRENGTH_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.ofVanilla("extra_strong_strength"),
                    new Potion("strength", new StatusEffectInstance(StatusEffects.STRENGTH, 1800, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_ABSORPTION_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "extra_strong_absorption"),
                    new Potion("absorption", new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 2)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_MINING_FATIGUE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "extra_strong_mining_fatigue"),
                    new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 600, 5)));

    public static final RegistryEntry<Potion> EXTRA_STRONG_HASTE_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "extra_strong_haste"),
                    new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 3600, 2), new StatusEffectInstance(StatusEffects.WEAKNESS, 1800, 2)));

    public static final RegistryEntry<Potion> TRANSMUTATON_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "transmutation"),
                    new Potion("transmutation", new StatusEffectInstance(WaywardAlchemistEffects.TRANSMUTATION, 1, 0)));

    private static final List<RegistryEntry<Potion>> extraStrongs = List.of(
            WaywardAlchemistPotions.EXTRA_STRONG_ABSORPTION_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_HARMING_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_HASTE_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_HEALING_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_LEAPING_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_MINING_FATIGUE_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_POISON_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_REGENERATION_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_SLOWNESS_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_STRENGTH_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_SWIFTNESS_POTION,
            WaywardAlchemistPotions.EXTRA_STRONG_TURTLE_MASTER_POTION
    );

    public static void registerPotions() {
        // Basic Potion Recipes
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.THICK,
                    Items.EMERALD_BLOCK,
                    LUCK_POTION
            );
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    Items.BAMBOO,
                    CONSTRUCTION_POTION
            );
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    Items.BAMBOO,
                    CONSTRUCTION_POTION
            );
            builder.registerPotionRecipe(
                    Potions.THICK,
                    Items.GOLDEN_APPLE,
                    ABSORPTION_POTION
            );
            builder.registerPotionRecipe(
                    ABSORPTION_POTION,
                    Items.GLOWSTONE_DUST,
                    STRONG_ABSORPTION_POTION
            );
            builder.registerPotionRecipe(
                    ABSORPTION_POTION,
                    Items.REDSTONE,
                    LONG_ABSORPTION_POTION
            );
            builder.registerPotionRecipe(
                    Potions.THICK,
                    Items.PRISMARINE_CRYSTALS,
                    MINING_FATIGUE_POTION
            );
            builder.registerPotionRecipe(
                    MINING_FATIGUE_POTION,
                    Items.GLOWSTONE_DUST,
                    STRONG_MINING_FATIGUE_POTION
            );
            builder.registerPotionRecipe(
                    MINING_FATIGUE_POTION,
                    Items.FERMENTED_SPIDER_EYE,
                    HASTE_POTION
            );
            builder.registerPotionRecipe(
                    HASTE_POTION,
                    Items.GLOWSTONE,
                    STRONG_HASTE_POTION
            );
            builder.registerPotionRecipe(
                    Potions.THICK,
                    WaywardAlchemistItems.ALCHEMIST_FIRE,
                    FLAMMABILITY_POTION
            );
            // Pain agony and despair but like not actually though
            builder.registerItemRecipe(
                    Items.POTION,
                    Items.IRON_INGOT,
                    WaywardAlchemistItems.INJECTION_POTION
            );
            // Philosopher's Ash Bullshit
            builder.registerPotionRecipe(
                    Potions.STRONG_LEAPING,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_LEAPING_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_SWIFTNESS,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_SWIFTNESS_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_SLOWNESS,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_SLOWNESS_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_TURTLE_MASTER,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_TURTLE_MASTER_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_HEALING,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_HEALING_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_HARMING,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_HARMING_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_POISON,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_POISON_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_REGENERATION,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_REGENERATION_POTION
            );
            builder.registerPotionRecipe(
                    Potions.STRONG_STRENGTH,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_STRENGTH_POTION
            );
            builder.registerPotionRecipe(
                    STRONG_ABSORPTION_POTION,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_ABSORPTION_POTION
            );
            builder.registerPotionRecipe(
                    STRONG_MINING_FATIGUE_POTION,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_MINING_FATIGUE_POTION
            );
            builder.registerPotionRecipe(
                    STRONG_HASTE_POTION,
                    WaywardAlchemistItems.PHILOSOPHERS_ASH,
                    EXTRA_STRONG_HASTE_POTION
            );
            builder.registerPotionRecipe(
                    Potions.MUNDANE,
                    WaywardAlchemistItems.ALBEDO,
                    TRANSMUTATON_POTION
            );
        });
    }
}
