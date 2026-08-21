package hat.waywardalchemist.datagen;

import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.BlockState;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class WaywardAlchemistModelProvider extends FabricModelProvider {
    public WaywardAlchemistModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
       // itemModelGenerator.register(WaywardAlchemistItems.BOILING_BREWER, Models.GENERATED);
        itemModelGenerator.register(WaywardAlchemistItems.SWEET_TREAT, Models.GENERATED);
    }
}
