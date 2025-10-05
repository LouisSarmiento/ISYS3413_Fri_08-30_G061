package accommodation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccommodationSearchService {
    public ValidationResult validateSelection(List<String> selectedAccommodationIds) {
        // check the list just like the diagram says (needs at least two)
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
        // stand-in for calling provider APIs
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
        // right now we just return a placeholder object
        return TravellerPreferences.placeholder(travellerId);
    }

    public ComparisonView assembleComparisonView(List<AccommodationDetails> details, TravellerPreferences preferences) {
        // in the diagram this is where the comparison view comes back to the controller
        return ComparisonView.placeholder(details);
    }

    public BookingContext prepareBooking(String travellerId, String accommodationId) {
        // this would call another service later
        return new BookingContext(travellerId, accommodationId);
    }

    public List<AccommodationDetails> updateSearchCriteria(SearchCriteria criteria) {
        // open for future filter logic
        return Collections.emptyList();
    }
}
