// Contributed by Louis Sarmiento
package accommodation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccommodationSearchService {
    private String searchCriteria;
    private final List<Accommodation> accommodations;

    public AccommodationSearchService(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Accommodation> searchAccommodation() {
        Map<String, Object> criteria = new HashMap<>();
        if (searchCriteria != null && !searchCriteria.isEmpty()) {
            criteria.put("location", searchCriteria);
        }
        return SearchFilter.applyFilter(accommodations, criteria);
    }
}
