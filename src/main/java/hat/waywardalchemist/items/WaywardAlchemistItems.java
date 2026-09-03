package hat.waywardalchemist.items;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.component.WaywardAlchemistConsumableComponents;
import hat.waywardalchemist.items.custom.*;
import hat.waywardalchemist.potion.WaywardAlchemistPotions;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class WaywardAlchemistItems {

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

    public static Item SWEET_TREAT = register("sweet_treat", Item::new, new Item.Settings().food(new FoodComponent(2,0.6f,false), WaywardAlchemistConsumableComponents.SWEET_TREAT));
    public static Item ALCHEMIST_FIRE = register("alchemist_fire", AlchemistFireItem::new, new Item.Settings().maxCount(64));
    public static Item INJECTION_POTION = register("injection_potion", InjectionPotionItem::new, new Item.Settings().maxCount(1));
    public static Item PUTREDO = register("putredo", Item::new, new Item.Settings().maxCount(1));
    public static Item CITRINAS = register("citrinas", CitrinasItem::new, new Item.Settings().maxCount(1).sword(ToolMaterial.NETHERITE, 2, -2.4f).component(WaywardAlchemistItemComponents.PROGRESS, 0));
    public static Item PHILOSOPHERS_ASH = register("philosophers_ash", Item::new, new Item.Settings().maxCount(16));
    public static Item ALBEDO = register("albedo", AlbedoItem::new, new Item.Settings().maxCount(1));


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WaywardAlchemist.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void registerWAItems() {
        WaywardAlchemist.LOGGER.info("Registering items for " + WaywardAlchemist.MOD_ID);
        //put items in creative menu below
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SWEET_TREAT);
            fabricItemGroupEntries.getContext().lookup().getOptional(RegistryKeys.POTION).ifPresent((registryWrapper) -> {
                addPotions(fabricItemGroupEntries, registryWrapper, INJECTION_POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, fabricItemGroupEntries.getContext().enabledFeatures());
            });
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ALCHEMIST_FIRE);
            fabricItemGroupEntries.addAfter(Items.GLASS_BOTTLE, ALBEDO);
            fabricItemGroupEntries.addAfter(Items.GLASS_BOTTLE, PUTREDO);
        } );
    }

    private static void addPotions(ItemGroup.Entries entries, RegistryWrapper<Potion> registryWrapper, Item item, ItemGroup.StackVisibility visibility, FeatureSet enabledFeatures) {
        registryWrapper.streamEntries().filter((potionEntry) -> ((Potion)potionEntry.value()).isEnabled(enabledFeatures)).map((entry) -> PotionContentsComponent.createStack(item, entry)).forEach((stack) -> entries.add(stack, visibility));
    }

}
