package bard.bardrock.telemetry;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class TelemetryCollector {

    public TelemetrySample collect(MinecraftClient client) {

        if (client.player == null || client.world == null) {
            return null;
        }

        PlayerEntity player = client.player;
        BlockPos pos = player.getBlockPos();

        String dimension = client.world.getRegistryKey().getValue().toString();
        String biome = client.world.getBiome(pos).getKey().get().getValue().toString();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        long timeOfDay = client.world.getTimeOfDay() % 24000;

        // Future additions
        // - Number of nearby entities (hostile and passive)
        // - Player movement speed
        // - Combat status (in combat or not)

        return new TelemetrySample(
                dimension,
                biome,
                x,
                y,
                z,
                health,
                maxHealth,
                timeOfDay
        );
    }
}
