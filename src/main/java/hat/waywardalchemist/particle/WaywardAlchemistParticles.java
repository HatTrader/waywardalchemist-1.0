package hat.waywardalchemist.particle;

import hat.waywardalchemist.WaywardAlchemist;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WaywardAlchemistParticles {
    public static final SimpleParticleType SHOCKWAVE_PARTICLE = FabricParticleTypes.simple();

	public static void RegisterParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(WaywardAlchemist.MOD_ID, "shockwave_particle"), SHOCKWAVE_PARTICLE);
    }

}
