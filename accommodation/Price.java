// Contributed by Louis Sarmiento
package accommodation;

import java.util.Optional;

/**
 * Represents pricing information for the accommodation skeleton.
 */
public class Price {
    private final float nightlyRate;
    private final Float weeklyRate;
    private final Float seasonalRate;

    public Price(float nightlyRate) {
        this(nightlyRate, null, null);
    }

    public Price(float nightlyRate, Float weeklyRate, Float seasonalRate) {
        this.nightlyRate = nightlyRate;
        this.weeklyRate = weeklyRate;
        this.seasonalRate = seasonalRate;
    }

    public float getNightlyRate() {
        return nightlyRate;
    }

    public Optional<Float> getWeeklyRate() {
        return Optional.ofNullable(weeklyRate);
    }

    public Optional<Float> getSeasonalRate() {
        return Optional.ofNullable(seasonalRate);
    }

    public String describe() {
        StringBuilder builder = new StringBuilder("Nightly: $").append(nightlyRate);
        getWeeklyRate().ifPresent(rate -> builder.append(", Weekly: $").append(rate));
        getSeasonalRate().ifPresent(rate -> builder.append(", Seasonal: $").append(rate));
        return builder.toString();
    }
}
