package hat.waywardalchemist;

import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import hat.waywardalchemist.block.entity.WaywardAlchemistBlockEntities;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import hat.waywardalchemist.screen.WaywardAlchemistScreenHandlers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaywardAlchemist implements ModInitializer {
	public static final String MOD_ID = "waywardalchemist";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		WaywardAlchemistItems.registerWAItems();
		WaywardAlchemistBlocks.registerWABlocks();
		WaywardAlchemistBlockEntities.registerWABlockEntities();
		WaywardAlchemistScreenHandlers.registerWAScreenHandlers();
		LOGGER.info("Hello alchemist!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
