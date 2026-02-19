package bard.bardrock.telemetry;

public class TelemetrySample {

    public final String dimension;
    public final String biome;
    public final int x;
    public final int y;
    public final int z;
    public final float health;
    public final float maxHealth;
    public final long timeOfDay;

    public TelemetrySample(String dimension, String biome, int x, int y,
                           int z, float health, float maxHealth, long timeOfDay) {
        this.dimension = dimension;
        this.biome = biome;
        this.x = x;
        this.y = y;
        this.z = z;
        this.health = health;
        this.maxHealth = maxHealth;
        this.timeOfDay = timeOfDay;
    }


}
