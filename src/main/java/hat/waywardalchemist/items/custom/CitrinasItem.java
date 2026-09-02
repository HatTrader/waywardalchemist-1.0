package hat.waywardalchemist.items.custom;

import com.mojang.serialization.Codec;
import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import hat.waywardalchemist.particle.WaywardAlchemistParticles;
import hat.waywardalchemist.particle.factory.ShockwaveParticle;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.component.*;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;
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
                if (world.isClient()) {
                    for (PlayerEntity player : world.getPlayers()) {
                        world.playSoundFromEntityClient(player, WaywardAlchemist.CREATION, SoundCategory.PLAYERS, 0.6f, 1.0f);
                    }
                    world.addParticleClient(WaywardAlchemistParticles.SHOCKWAVE_PARTICLE, pos2.x, pos2.y, pos2.z, 0, 0.05, 0);
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
}
