package hat.waywardalchemist.block.entity;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.block.WaywardAlchemistBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WaywardAlchemistBlockEntities {
    public static final BlockEntityType<BoilingBrewerBlockEntity> BOILING_BREWER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(WaywardAlchemist.MOD_ID, "boiling_brewer_be"),
                    FabricBlockEntityTypeBuilder.create(BoilingBrewerBlockEntity::new, WaywardAlchemistBlocks.BOILING_BREWER_BLOCK).build(null));


    public static void registerWABlockEntities() {
        WaywardAlchemist.LOGGER.info("Registering block entities for " + WaywardAlchemist.MOD_ID);


    }
}
