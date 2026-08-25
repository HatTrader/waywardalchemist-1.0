package hat.waywardalchemist.items;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.component.WaywardAlchemistConsumableComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.advancement.criterion.ItemDurabilityChangedCriterion;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.FireChargeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class WaywardAlchemistItems {

    public static Item SWEET_TREAT = register("sweet_treat", Item::new, new Item.Settings().food(new FoodComponent(2,0.6f,false), WaywardAlchemistConsumableComponents.SWEET_TREAT));
    public static Item ALCHEMIST_FIRE = register("alchemist_fire", AlchemistFireItem::new, new Item.Settings().maxCount(64));

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
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ALCHEMIST_FIRE);
        } );
        //like here replace this sentence ok thanks past hat
    }

}
