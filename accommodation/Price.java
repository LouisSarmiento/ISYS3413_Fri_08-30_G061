// Contributed by Louis Sarmiento
package accommodation;

/**
 * Represents basic pricing information for the accommodation skeleton.
 */
public class Price {
    private final float nightlyRate;

    // TODO: Extend with weekly and seasonal rates if required by later iterations.

    public Price(float nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public float getNightlyRate() {
        return nightlyRate;
    }
}
