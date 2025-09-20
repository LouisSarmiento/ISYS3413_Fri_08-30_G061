// Contributed by Louis Sarmiento
package accommodation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Skeleton service outlining how accommodation searches might be structured.
 */
public class AccommodationSearchService {
    private final List<Accommodation> accommodations;

    public AccommodationSearchService(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public void setSearchCriteria(Map<String, Object> criteria) {
        // TODO: Persist criteria for use during search.
    }

    public List<Accommodation> searchAccommodation() {
        // TODO: Implement search logic based on stored criteria.
        return Collections.emptyList();
    }
}
