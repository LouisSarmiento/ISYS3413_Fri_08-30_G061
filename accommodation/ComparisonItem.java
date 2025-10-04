// Contributed by Louis Sarmiento
package accommodation;

/**
 * Represents a single accommodation within a comparison view, including preference compatibility data.
 */
public class ComparisonItem {
    private final Accommodation accommodation;
    private final PreferenceMatch preferenceMatch;

    public ComparisonItem(Accommodation accommodation, PreferenceMatch preferenceMatch) {
        this.accommodation = accommodation;
        this.preferenceMatch = preferenceMatch;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public PreferenceMatch getPreferenceMatch() {
        return preferenceMatch;
    }
}
