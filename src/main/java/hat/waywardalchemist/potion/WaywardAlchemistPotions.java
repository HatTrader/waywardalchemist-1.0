package hat.waywardalchemist.potion;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.PreparableModelLoadingPlugin;
import net.fabricmc.fabric.api.event.registry.FabricRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.stat.Stat;
import net.minecraft.util.Identifier;
import net.minecraft.world.event.listener.GameEventListener;


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
                    new Potion("mining_fatigue", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 600, 3)));

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
        });
    }
}
