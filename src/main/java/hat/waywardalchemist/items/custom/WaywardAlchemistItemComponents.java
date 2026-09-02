package hat.waywardalchemist.items.custom;

import com.mojang.serialization.Codec;
import hat.waywardalchemist.WaywardAlchemist;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;

import java.util.List;
import java.util.UUID;

public class WaywardAlchemistItemComponents {
    public static final ComponentType<Integer> PROGRESS = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(WaywardAlchemist.MOD_ID, "progress"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );
    public static void registerComponents() {

    }
}
