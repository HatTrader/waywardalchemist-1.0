package hat.waywardalchemist.mixin;

import hat.waywardalchemist.items.custom.CitrinasItem;
import hat.waywardalchemist.items.data.EvilStateOfDoomAndDespair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    private void waywardAlchemist$harvestVitriol(DamageSource damageSource, CallbackInfo ci) {
        if ((LivingEntity) (Object) this instanceof PlayerEntity killed) {
            if (damageSource.getAttacker() != null && damageSource.getAttacker() instanceof PlayerEntity killer) {
                if (killer.getStackInHand(killer.preferredHand).getItem() instanceof CitrinasItem citrinas) {
                    if (killed.getEntityWorld() instanceof ServerWorld world && world.getServer() != null) {
                        EvilStateOfDoomAndDespair stateOfDoomAndDespair = EvilStateOfDoomAndDespair.getHarvestedPlayers(world.getServer());
                        if (!stateOfDoomAndDespair.getHarvestedPlayers().contains(killed.getUuid())) {
                            stateOfDoomAndDespair.addHarvestedPlayer(killed);
                            citrinas.incrementProgress(killer.getStackInHand(killer.preferredHand));
                        }
                    }
                }
            }
        }
    }
}
