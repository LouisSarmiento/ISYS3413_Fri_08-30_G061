// Contributed by Louis Sarmiento
package accommodation;

import java.util.ArrayList;
import java.util.List;

/**
 * Traveller preferences used to highlight matches in comparisons.
 */
public class TravellerPreferences {
    private boolean preferWifi;
    private Float budgetPerNight;

    public static TravellerPreferences defaultPreferences() {
        TravellerPreferences preferences = new TravellerPreferences();
        preferences.preferWifi = true;
        return preferences;
    }

    public static TravellerPreferences copyOf(TravellerPreferences source) {
        TravellerPreferences copy = new TravellerPreferences();
        copy.preferWifi = source.preferWifi;
        copy.budgetPerNight = source.budgetPerNight;
        return copy;
    }

    public PreferenceMatch assess(Accommodation accommodation) {
        List<String> satisfied = new ArrayList<>();
        List<String> unmet = new ArrayList<>();

        if (preferWifi) {
            accommodation.getAmenities().ifPresentOrElse(amenities -> {
                if (amenities.hasWifi()) {
                    satisfied.add("WiFi available");
                } else {
                    unmet.add("WiFi not available");
                }
            }, () -> unmet.add("WiFi preference unknown"));
        }

        if (budgetPerNight != null) {
            float nightlyRate = accommodation.getPrice().getNightlyRate();
            if (nightlyRate <= budgetPerNight) {
                satisfied.add("Within budget");
            } else {
                unmet.add("Above budget ($" + nightlyRate + " > $" + budgetPerNight + ")");
            }
        }

        boolean allMatched = unmet.isEmpty();
        return new PreferenceMatch(allMatched, satisfied, unmet);
    }

    public boolean isPreferWifi() {
        return preferWifi;
    }

    public void setPreferWifi(boolean preferWifi) {
        this.preferWifi = preferWifi;
    }

    public Float getBudgetPerNight() {
        return budgetPerNight;
    }

    public void setBudgetPerNight(Float budgetPerNight) {
        this.budgetPerNight = budgetPerNight;
    }
}
