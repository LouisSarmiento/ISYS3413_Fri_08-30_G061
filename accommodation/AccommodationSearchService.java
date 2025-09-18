package accommodation;

import java.util.ArrayList;
import java.util.List;

public class AccommodationSearchService {
    private String searchCriteria;

    public AccommodationSearchService(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Accommodation> searchAccommodation(List<Accommodation> accommodations) {
        List<Accommodation> result = new ArrayList<>();

        // Implement search logic based on criteria (For now, returning all accommodations)
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getDetails().contains(searchCriteria)) {
                result.add(accommodation);
            }
        }

        return result;
    }
}
