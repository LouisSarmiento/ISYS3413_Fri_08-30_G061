// Contributed by Louis Sarmiento
package accommodation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Applies a limited set of filters to the accommodation collection.
 */
public final class SearchFilter {
    private SearchFilter() {
        // Utility class
    }

    public static List<Accommodation> applyFilter(List<Accommodation> accommodations, Map<String, Object> criteria) {
        return accommodations.stream()
                .filter(accommodation -> matchesLocation(accommodation, criteria))
                .filter(accommodation -> matchesPrice(accommodation, criteria))
                .collect(Collectors.toList());
    }

    private static boolean matchesLocation(Accommodation accommodation, Map<String, Object> criteria) {
        Object locationCriterion = criteria.get("location");
        if (!(locationCriterion instanceof String)) {
            return true;
        }
        return accommodation.getLocation().matches((String) locationCriterion);
    }

    private static boolean matchesPrice(Accommodation accommodation, Map<String, Object> criteria) {
        Object maxPriceCriterion = criteria.get("maxPrice");
        if (!(maxPriceCriterion instanceof Number)) {
            return true;
        }
        float max = ((Number) maxPriceCriterion).floatValue();
        return accommodation.getPrice().getNightlyRate() <= max;
    }
}
