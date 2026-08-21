package hat.waywardalchemist;

import hat.waywardalchemist.screen.BoilingBrewerScreen;
import hat.waywardalchemist.screen.WaywardAlchemistScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class WaywardAlchemistClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(WaywardAlchemistScreenHandlers.BOILING_BREWER_SCREEN, BoilingBrewerScreen::new);
    }
}
