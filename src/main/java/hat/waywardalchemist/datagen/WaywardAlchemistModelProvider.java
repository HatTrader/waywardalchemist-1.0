package hat.waywardalchemist.datagen;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.BlockState;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.util.Identifier;

public class WaywardAlchemistModelProvider extends FabricModelProvider {
    public WaywardAlchemistModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(WaywardAlchemistItems.SWEET_TREAT, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.ALCHEMIST_FIRE, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistBlocks.BOILING_BREWER_BLOCK.asItem(), Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.PHILOSOPHERS_ASH, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.PUTREDO, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.ALBEDO, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.PANCEA, Models.GENERATED);
        itemModelGenerator.registerPotionTinted(WaywardAlchemistItems.INJECTION_POTION, Identifier.of(WaywardAlchemist.MOD_ID, "injection_potion"));
    }
}
