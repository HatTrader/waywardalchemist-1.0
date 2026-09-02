package hat.waywardalchemist.items;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.potion.WaywardAlchemistPotions;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JeiPlugin
public class JeiBullshit implements IModPlugin {
    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.of(WaywardAlchemist.MOD_ID, "jei_plugin");
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IIngredientManager ingredientManager = jeiRuntime.getIngredientManager();
        Collection<ItemStack> stacksToHide = new ArrayList<>();
        stacksToHide.add(WaywardAlchemistItems.PHILOSOPHERS_ASH.getDefaultStack());
        ingredientManager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, stacksToHide);
        IModPlugin.super.onRuntimeAvailable(jeiRuntime);
    }

}
