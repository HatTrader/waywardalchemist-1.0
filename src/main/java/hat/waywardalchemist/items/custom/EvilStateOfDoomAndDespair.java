package hat.waywardalchemist.items.custom;

import com.mojang.serialization.Codec;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Uuids;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateType;

import java.util.*;

public class EvilStateOfDoomAndDespair extends PersistentState {
    private List<UUID> harvestedPlayers = new ArrayList<>();

    public EvilStateOfDoomAndDespair(List<UUID> players) {
        harvestedPlayers = new ArrayList<>();
        harvestedPlayers.addAll(players);
    }

    public EvilStateOfDoomAndDespair() {

    }

    public List<UUID> getHarvestedPlayers() {
        return harvestedPlayers;
    }

    public void addHarvestedPlayer(PlayerEntity player) {
        harvestedPlayers.add(player.getUuid());
        markDirty();
    }

    public void resetHarvestedPlayer(PlayerEntity player) {
        harvestedPlayers.remove(player.getUuid());
        markDirty();
    }

    private static final Codec<EvilStateOfDoomAndDespair> CODEC = Uuids.CODEC.listOf().xmap(EvilStateOfDoomAndDespair::new, EvilStateOfDoomAndDespair::getHarvestedPlayers);

    private static final PersistentStateType<EvilStateOfDoomAndDespair> TYPE = new PersistentStateType<>(
            "harvested_players",
            EvilStateOfDoomAndDespair::new,
            CODEC,
            null
    );

    public static EvilStateOfDoomAndDespair getSavedBlockData(MinecraftServer server) {
        ServerWorld world = server.getWorld(ServerWorld.OVERWORLD);

        if (world == null) {
            return new EvilStateOfDoomAndDespair();
        }
        return world.getPersistentStateManager().getOrCreate(TYPE);
    }

}
