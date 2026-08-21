package hat.waywardalchemist.screen;

import hat.waywardalchemist.WaywardAlchemist;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;


public class WaywardAlchemistScreenHandlers {

  public static final ScreenHandlerType<? extends BoilingBrewerScreenHandler> BOILING_BREWER_SCREEN = Registry.register(Registries.SCREEN_HANDLER,
          Identifier.of(WaywardAlchemist.MOD_ID, "boiling_brewer_screen_handler"),
          new ScreenHandlerType<>(BoilingBrewerScreenHandler::new, FeatureFlags.DEFAULT_ENABLED_FEATURES));

    public static void registerWAScreenHandlers() {
        WaywardAlchemist.LOGGER.info("Registering screen handlers for " + WaywardAlchemist.MOD_ID);

        //BOILING_BREWER_SCREEN = Registry.register;
    }

}