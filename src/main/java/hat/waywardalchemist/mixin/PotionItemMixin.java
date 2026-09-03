package hat.waywardalchemist.mixin;


import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import hat.waywardalchemist.potion.WaywardAlchemistPotions;
import hat.waywardalchemist.util.TransmutationUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(PotionItem.class)
public class PotionItemMixin {
    @Inject(at = @At("TAIL"), method = "useOnBlock", cancellable = true)
    private static void thinga(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
        BlockState blockState = world.getBlockState(blockPos);
        if (context.getSide() != Direction.DOWN && blockState.getBlock() instanceof Oxidizable oxidizable && potionContentsComponent.matches(Potions.WATER)) {
            if (oxidizable.getDegradationLevel() != Oxidizable.OxidationLevel.OXIDIZED) {
                if (!world.isClient() && oxidizable.getDegradationResult(blockState).isPresent()) {
                    world.setBlockState(blockPos, oxidizable.getDegradationResult(blockState).get());
                    playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
                    world.playSound((Entity)null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.emitGameEvent((Entity)null, GameEvent.FLUID_PLACE, blockPos);
                }
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        } else {
            cir.setReturnValue(ActionResult.PASS);
        }
        if (context.getSide() != Direction.DOWN && potionContentsComponent.matches(WaywardAlchemistPotions.TRANSMUTATON_POTION)) {
            if (TransmutationUtils.transmutationChainOreBlocks.contains(blockState.getBlock())) {
                for (int i = 0; i < TransmutationUtils.transmutationChainOreBlocks.size(); i++) {
                    if (world.getBlockState(blockPos).getBlock() == Blocks.COAL_BLOCK) {
                        cir.setReturnValue(ActionResult.PASS);
                    } else if (world.getBlockState(blockPos).getBlock() == TransmutationUtils.transmutationChainOreBlocks.reversed().get(i)) {
                        if (!world.isClient()) {
                            world.setBlockState(blockPos, TransmutationUtils.transmutationChainOreBlocks.reversed().get(i + 1).getDefaultState());
                            playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
                            world.playSound((Entity) null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, blockPos);
                        }
                        cir.setReturnValue(ActionResult.SUCCESS);
                        break;
                    }
                }
            } else if (TransmutationUtils.transmutationChainWoodSaplings.contains(blockState.getBlock())) {
                for (int i = 0; i < TransmutationUtils.transmutationChainWoodSaplings.size(); i++) {
                    if (world.getBlockState(blockPos).getBlock() == Blocks.COAL_BLOCK) {
                        cir.setReturnValue(ActionResult.PASS);
                    } else if (world.getBlockState(blockPos).getBlock() == TransmutationUtils.transmutationChainWoodSaplings.reversed().get(i)) {
                        if (!world.isClient()) {
                            world.setBlockState(blockPos, TransmutationUtils.transmutationChainWoodSaplings.reversed().get(i + 1).getDefaultState());
                            playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
                            world.playSound((Entity) null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                            world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, blockPos);
                        }
                        cir.setReturnValue(ActionResult.SUCCESS);
                        break;
                    }
                }
            }
        } else {
            cir.setReturnValue(ActionResult.PASS);
        }
    }
}
