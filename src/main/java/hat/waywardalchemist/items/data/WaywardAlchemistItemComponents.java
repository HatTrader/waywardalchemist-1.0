package hat.waywardalchemist.items.data;

import com.mojang.serialization.Codec;
import hat.waywardalchemist.WaywardAlchemist;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WaywardAlchemistItemComponents {
    public static final ComponentType<Integer> PROGRESS = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(WaywardAlchemist.MOD_ID, "progress"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );

    public static final ComponentType<Boolean> IS_PRIMAL = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(WaywardAlchemist.MOD_ID, "is_primal"),
            ComponentType.<Boolean>builder().codec(Codec.BOOL).build()
    );
    public static void registerComponents() {

    }
}
