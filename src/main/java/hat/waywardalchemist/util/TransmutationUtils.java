package hat.waywardalchemist.util;

import hat.waywardalchemist.effect.WaywardAlchemistEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class TransmutationUtils {
    public static final Map<RegistryEntry<StatusEffect>, RegistryEntry<StatusEffect>> transmutedPositiveEffects = Map.of(
            StatusEffects.LUCK, StatusEffects.UNLUCK,
            StatusEffects.STRENGTH, StatusEffects.WEAKNESS,
            StatusEffects.SPEED, StatusEffects.SLOWNESS,
            StatusEffects.REGENERATION, StatusEffects.POISON,
            StatusEffects.HASTE, StatusEffects.MINING_FATIGUE,
            StatusEffects.FIRE_RESISTANCE, WaywardAlchemistEffects.FLAMMABILITY,
            StatusEffects.RESISTANCE, WaywardAlchemistEffects.VULNERABILITY,
            StatusEffects.INVISIBILITY, StatusEffects.GLOWING,
            StatusEffects.NIGHT_VISION, StatusEffects.DARKNESS,
            StatusEffects.WITHER, StatusEffects.REGENERATION
    );
    public static final Map<RegistryEntry<StatusEffect>, RegistryEntry<StatusEffect>> transmutedNegativeEffects = Map.of(
            StatusEffects.UNLUCK, StatusEffects.LUCK,
            StatusEffects.WEAKNESS, StatusEffects.STRENGTH,
            StatusEffects.SLOWNESS, StatusEffects.SPEED,
            StatusEffects.POISON, StatusEffects.REGENERATION,
            StatusEffects.MINING_FATIGUE, StatusEffects.HASTE,
            WaywardAlchemistEffects.FLAMMABILITY, StatusEffects.FIRE_RESISTANCE,
            WaywardAlchemistEffects.VULNERABILITY, StatusEffects.RESISTANCE,
            StatusEffects.GLOWING, StatusEffects.INVISIBILITY,
            StatusEffects.DARKNESS, StatusEffects.NIGHT_VISION
    );
    public static final List<Block> transmutationChainOreBlocks = List.of(
            Blocks.COAL_BLOCK,
            Blocks.RAW_COPPER_BLOCK,
            Blocks.LAPIS_BLOCK,
            Blocks.RAW_IRON_BLOCK,
            Blocks.REDSTONE_BLOCK,
            Blocks.RAW_GOLD_BLOCK,
            Blocks.EMERALD_BLOCK,
            Blocks.DIAMOND_BLOCK
    );
    public static final List<Block> transmutationChainWoodSaplings = List.of(
            Blocks.SPRUCE_SAPLING,
            Blocks.OAK_SAPLING,
            Blocks.BIRCH_SAPLING,
            Blocks.PALE_OAK_SAPLING,
            Blocks.DARK_OAK_SAPLING,
            Blocks.CHERRY_SAPLING,
            Blocks.ACACIA_SAPLING,
            Blocks.JUNGLE_SAPLING,
            Blocks.MANGROVE_PROPAGULE,
            Blocks.SPRUCE_SAPLING
    );
    public static final List<Block> transmutationChainWoodLog = List.of(
            Blocks.SPRUCE_LOG,
            Blocks.OAK_LOG,
            Blocks.BIRCH_LOG,
            Blocks.PALE_OAK_LOG,
            Blocks.DARK_OAK_LOG,
            Blocks.CHERRY_LOG,
            Blocks.ACACIA_LOG,
            Blocks.JUNGLE_LOG,
            Blocks.MANGROVE_LOG,
            Blocks.SPRUCE_LOG
    );

    public static void advanceTransmutationChain(World world, BlockPos pos) {

    }
}
