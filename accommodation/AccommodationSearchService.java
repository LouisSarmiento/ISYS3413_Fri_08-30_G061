package accommodation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccommodationSearchService {
    public ValidationResult validateSelection(List<String> selectedAccommodationIds) {
        if (selectedAccommodationIds == null || selectedAccommodationIds.isEmpty()) {
            return ValidationResult.error("Select at least two accommodations");
        }
        Set<String> unique = new HashSet<>();
        for (String id : selectedAccommodationIds) {
            if (id != null && !id.isBlank()) {
                unique.add(id.trim());
            }
        }
        if (unique.size() < 1) {
            return ValidationResult.error("No valid accommodation IDs provided");
        }
        if (unique.size() == 1) {
            return ValidationResult.singleSelection(unique.iterator().next());
        }
        return ValidationResult.success();
    }

    public List<AccommodationDetails> fetchAccommodationDetails(List<String> accommodationIds) {
        if (accommodationIds == null) {
            return Collections.emptyList();
        }
        List<AccommodationDetails> details = new ArrayList<>();
        for (String id : accommodationIds) {
            if (id != null && !id.isBlank()) {
                details.add(new AccommodationDetails(id.trim()));
            }
        }
        return details;
    }

    public TravellerPreferences loadTravellerPreferences(String travellerId) {
        return TravellerPreferences.placeholder(travellerId);
    }

    public ComparisonView assembleComparisonView(List<AccommodationDetails> details, TravellerPreferences preferences) {
        return ComparisonView.placeholder(details);
    }

    public BookingContext prepareBooking(String travellerId, String accommodationId) {
        return new BookingContext(travellerId, accommodationId);
    }

    public List<AccommodationDetails> updateSearchCriteria(SearchCriteria criteria) {
        return Collections.emptyList();
    }
}
