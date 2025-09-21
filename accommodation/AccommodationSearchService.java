// Contributed by Louis Sarmiento
package accommodation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AccommodationSearchService {
    private final List<Accommodation> accommodations;
    private final Map<String, Object> criteria = new HashMap<>();

    public AccommodationSearchService(List<Accommodation> accommodations) {
        this.accommodations = new ArrayList<>(accommodations);
    }

    public void clearCriteria() {
        criteria.clear();
    }

    public void setLocationQuery(String query) {
        criteria.put("location", query);
    }

    public void setMaxPrice(Float maxPrice) {
        if (maxPrice == null) {
            criteria.remove("maxPrice");
        } else {
            criteria.put("maxPrice", maxPrice);
        }
    }

    public List<Accommodation> searchAccommodation() {
        return SearchFilter.applyFilter(accommodations, criteria);
    }
}
