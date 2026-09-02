package hat.waywardalchemist.items.custom;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import hat.waywardalchemist.particle.WaywardAlchemistParticles;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AlbedoItem extends Item {
    public AlbedoItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (world.getBlockState(pos).getBlock() == Blocks.GOLD_BLOCK) {
            world.breakBlock(pos, false);
            Vec3d pos2 = pos.toCenterPos();
            world.playSound((Entity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.spawnEntity(new ItemEntity(world, pos2.x, pos2.y, pos2.z, new ItemStack(WaywardAlchemistItems.CITRINAS, 1)));
            context.getStack().decrement(1);
        }
        return super.useOnBlock(context);
    }
}
