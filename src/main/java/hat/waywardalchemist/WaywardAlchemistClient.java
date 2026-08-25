package hat.waywardalchemist;

import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import hat.waywardalchemist.screen.BoilingBrewerScreen;
import hat.waywardalchemist.screen.WaywardAlchemistScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;

public class WaywardAlchemistClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(WaywardAlchemistScreenHandlers.BOILING_BREWER_SCREEN, BoilingBrewerScreen::new);
        BlockRenderLayerMap.putBlock(WaywardAlchemistBlocks.BOILING_BREWER_BLOCK, BlockRenderLayer.CUTOUT);
    }
}
