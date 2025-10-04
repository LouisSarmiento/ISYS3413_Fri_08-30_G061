// Contributed by Louis Sarmiento
package accommodation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Applies the supplied search criteria to an accommodation collection.
 */
public final class SearchFilter {
    private SearchFilter() {
        // Utility class
    }

    public static List<Accommodation> applyFilter(List<Accommodation> accommodations, SearchCriteria criteria) {
        return accommodations.stream()
                .filter(accommodation -> matchesLocation(accommodation, criteria))
                .filter(accommodation -> matchesPrice(accommodation, criteria))
                .filter(accommodation -> matchesCapacity(accommodation, criteria))
                .collect(Collectors.toList());
    }

    private static boolean matchesLocation(Accommodation accommodation, SearchCriteria criteria) {
        String query = criteria.getLocationQuery();
        if (query == null || query.isEmpty()) {
            return true;
        }
        return accommodation.getLocation().matches(query);
    }

    private static boolean matchesPrice(Accommodation accommodation, SearchCriteria criteria) {
        Float max = criteria.getMaxNightlyRate();
        return max == null || accommodation.getPrice().getNightlyRate() <= max;
    }

    private static boolean matchesCapacity(Accommodation accommodation, SearchCriteria criteria) {
        Integer min = criteria.getMinCapacity();
        return min == null || accommodation.getCapacity() >= min;
    }
}
