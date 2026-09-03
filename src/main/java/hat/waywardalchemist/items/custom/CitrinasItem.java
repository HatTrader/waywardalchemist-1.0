package hat.waywardalchemist.items.custom;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import hat.waywardalchemist.particle.WaywardAlchemistParticles;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class CitrinasItem extends Item {
    public CitrinasItem(Settings settings) {
        super(settings);
    }

    public void incrementProgress(ItemStack stack) {
        int count = stack.getOrDefault(WaywardAlchemistItemComponents.PROGRESS, 0);
        if (count < 4) {
            stack.set(WaywardAlchemistItemComponents.PROGRESS, ++count);
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (context.getStack().getOrDefault(WaywardAlchemistItemComponents.PROGRESS, 0) >= 4) {
            if (world.getBlockState(pos).getBlock() == Blocks.ANCIENT_DEBRIS) {
                world.breakBlock(pos, false);
                Vec3d pos2 = pos.toCenterPos();
                world.playSound(null, pos, WaywardAlchemist.CREATION, SoundCategory.PLAYERS, 0.6f, 1.0f);
                if (world instanceof ServerWorld world1){
                    world1.spawnParticles(WaywardAlchemistParticles.SHOCKWAVE_PARTICLE, pos2.x, pos2.y, pos2.z, 1, 0, 0, 0, 0);
                }
                context.getStack().decrement(1);
                world.spawnEntity(new ItemEntity(world, pos2.x, pos2.y, pos2.z, new ItemStack(WaywardAlchemistItems.PHILOSOPHERS_ASH, 3)));
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        int count = stack.getOrDefault(WaywardAlchemistItemComponents.PROGRESS, 0);
        if (count >= 4) {
            textConsumer.accept(Text.literal("§4Vitriols Harvested: " + count));
        } else {
            textConsumer.accept(Text.literal("§6Vitriols Harvested: " + count));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof PlayerEntity player && player.getMainHandStack() == stack) {
            HitResult hitResult = ProjectileUtil.getCollision(entity, entity1 -> {
                EvilStateOfDoomAndDespair stateOfDoomAndDespair = EvilStateOfDoomAndDespair.getHarvestedPlayers(world.getServer());
                if (entity1 instanceof PlayerEntity playerEntity && !stateOfDoomAndDespair.getHarvestedPlayers().contains(playerEntity.getUuid())) {
                    return true;
                }
                return false;
            }, 32);
            if (hitResult instanceof EntityHitResult e) {
                if (stack.getOrDefault(WaywardAlchemistItemComponents.PROGRESS, 0) != 4) {
                    player.sendMessage(Text.of("§6This one remains vitriolic..."), true);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }
}
