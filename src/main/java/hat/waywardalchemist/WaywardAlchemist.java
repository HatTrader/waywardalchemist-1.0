package hat.waywardalchemist;

import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import hat.waywardalchemist.block.entity.WaywardAlchemistBlockEntities;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import hat.waywardalchemist.items.custom.EvilStateOfDoomAndDespair;
import hat.waywardalchemist.items.custom.WaywardAlchemistItemComponents;
import hat.waywardalchemist.particle.WaywardAlchemistParticles;
import hat.waywardalchemist.potion.WaywardAlchemistPotions;
import hat.waywardalchemist.screen.WaywardAlchemistScreenHandlers;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaywardAlchemist implements ModInitializer {
	public static final String MOD_ID = "waywardalchemist";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final SoundEvent CREATION = registerSound("creation");

	@Override
	public void onInitialize() {
        WaywardAlchemistPotions.registerPotions();
        WaywardAlchemistParticles.RegisterParticles();
		WaywardAlchemistItems.registerWAItems();
		WaywardAlchemistBlocks.registerWABlocks();
        WaywardAlchemistItemComponents.registerComponents();
		WaywardAlchemistBlockEntities.registerWABlockEntities();
		WaywardAlchemistScreenHandlers.registerWAScreenHandlers();
		FuelRegistryEvents.BUILD.register(((builder, context) -> {builder.add(WaywardAlchemistItems.ALCHEMIST_FIRE, 320 * 20);}));
		LOGGER.info("Hello alchemist!");



	}

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}


}
