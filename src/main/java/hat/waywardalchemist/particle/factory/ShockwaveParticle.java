package hat.waywardalchemist.particle.factory;

import hat.waywardalchemist.WaywardAlchemist;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.Easing;
import net.minecraft.util.math.random.Random;
import org.joml.Quaternionf;
import org.jspecify.annotations.Nullable;

public class ShockwaveParticle extends BillboardParticle {
    protected ShockwaveParticle(ClientWorld world, double x, double y, double z, double VY, Sprite sprite) {
        super(world, x, y, z, sprite);
        this.maxAge = 120;
        this.scale = 1;
        this.alpha = 1.0f;
        this.velocityY = VY;
        this.velocityX = 0;
        this.velocityZ = 0;
        this.setColor(0.9621f, 0.27450980392156865f, 0.15294117647058825f);
    }

    @Override
    protected RenderType getRenderType() {
        return RenderType.PARTICLE_ATLAS_TRANSLUCENT;
    }

    @Override
    public void tick() {
        if (age+1 >= maxAge || alpha+0.02 <= 0) {
            markDead();
        } else {
            scale(1.05f);
            setAlpha(alpha-0.006f);
        }
        super.tick();
    }

    @Override
    protected void render(BillboardParticleSubmittable submittable, Camera camera, Quaternionf q, float tickProgress) {
        Quaternionf rotation = new Quaternionf();

        // over here we rotate it up and render
        rotation.rotateX((float) Math.toRadians(90));
        super.render(submittable, camera, rotation, tickProgress);
        // and now we flip it and render it again, just like the good old days in jersey eh lmao (help why am i writing this)
        rotation.rotateY((float) Math.toRadians(-180));
        super.render(submittable, camera, rotation, tickProgress);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider SPRITE;

        public Factory(SpriteProvider sprite) {
            SPRITE = sprite;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {
            return new ShockwaveParticle(world, x, y, z, velocityY, SPRITE.getFirst());
        }
    }
}

