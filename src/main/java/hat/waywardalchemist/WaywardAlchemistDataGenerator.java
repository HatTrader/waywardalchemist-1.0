package hat.waywardalchemist;

import hat.waywardalchemist.datagen.WaywardAlchemistAdvancementProvider;
import hat.waywardalchemist.datagen.WaywardAlchemistModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class WaywardAlchemistDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(WaywardAlchemistAdvancementProvider::new);
		pack.addProvider(WaywardAlchemistModelProvider::new);
	}
}
