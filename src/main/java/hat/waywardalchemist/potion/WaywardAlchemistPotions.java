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
import net.minecraft.util.Identifier;
import net.minecraft.world.event.listener.GameEventListener;


public class WaywardAlchemistPotions {

    public static final RegistryEntry<Potion> LUCK_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "luck"),
                    new Potion("luck", new StatusEffectInstance(StatusEffects.LUCK, 1800, 0)));

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

    public static final RegistryEntry<Potion> VULNERABILITY_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "vulnerability"),
                    new Potion("vulnerability", new StatusEffectInstance(WaywardAlchemistEffects.VULNERABILITY, 1200, 0)));

    public static final RegistryEntry<Potion> STRONG_VULNERABILITY_POTION =
            Registry.registerReference(
                    Registries.POTION,
                    Identifier.of(WaywardAlchemist.MOD_ID, "strong_vulnerability"),
                    new Potion("vulnerability", new StatusEffectInstance(WaywardAlchemistEffects.VULNERABILITY, 400, 1)));


    public static void registerPotions() {
        // Basic Potion Recipes
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.THICK,
                    Items.EMERALD_BLOCK,
                    LUCK_POTION
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
                    Items.ARMADILLO_SCUTE,
                    VULNERABILITY_POTION
            );
            builder.registerPotionRecipe(
                    VULNERABILITY_POTION,
                    Items.GLOWSTONE_DUST,
                    STRONG_VULNERABILITY_POTION
            );
            builder.registerPotionRecipe(
                    Potions.THICK,
                    WaywardAlchemistItems.ALCHEMIST_FIRE,
                    FLAMMABILITY_POTION
            );
            // Pain agony and despair
            builder.registerItemRecipe(
                    Items.POTION,
                    Items.IRON_INGOT,
                    WaywardAlchemistItems.INJECTION_POTION
            );
        });
    }
}
