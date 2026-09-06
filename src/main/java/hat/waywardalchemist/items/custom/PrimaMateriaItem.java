package hat.waywardalchemist.items.custom;

import hat.waywardalchemist.items.data.WaywardAlchemistItemComponents;
import hat.waywardalchemist.util.WaywardAlchemistLists;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;

import java.util.List;

public class PrimaMateriaItem extends Item {
    public PrimaMateriaItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        for (List<Item> list : WaywardAlchemistLists.alchemicalIngredients) {
            if (list.contains(otherStack.getItem())) {
                stack.decrement(1);
                ItemStack primalStack = otherStack.copy();
                primalStack.set(WaywardAlchemistItemComponents.IS_PRIMAL, true);
                primalStack.setCount(1);
                primalStack.set(DataComponentTypes.MAX_DAMAGE, WaywardAlchemistLists.getIngredientDurability(otherStack));
                player.giveItemStack(primalStack);
                primalStack.setDamage(primalStack.getMaxDamage());
                primalStack.remove(DataComponentTypes.UNBREAKABLE);
            }
        }
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
    }
}
