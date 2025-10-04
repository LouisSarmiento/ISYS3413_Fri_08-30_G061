// Contributed by Louis Sarmiento
package accommodation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AccommodationSearchService {
    private final List<Accommodation> accommodations;
    private final SearchCriteria criteria = new SearchCriteria();

    public AccommodationSearchService(List<Accommodation> accommodations) {
        this.accommodations = new ArrayList<>(accommodations);
    }

    public List<Accommodation> getAllAccommodations() {
        return new ArrayList<>(accommodations);
    }

    public SearchCriteria getCriteriaSnapshot() {
        return criteria.copy();
    }

    public void clearCriteria() {
        criteria.clear();
    }

    public void setLocationQuery(String query) {
        criteria.setLocationQuery(query);
    }

    public void setMaxPrice(Float maxPrice) {
        criteria.setMaxNightlyRate(maxPrice);
    }

    public void setMinCapacity(Integer minCapacity) {
        criteria.setMinCapacity(minCapacity);
    }

    public List<Accommodation> searchAccommodation() {
        return SearchFilter.applyFilter(accommodations, criteria);
    }

    public ComparisonView compareAccommodations(List<String> accommodationIds, TravellerPreferences preferences) {
        if (preferences == null) {
            return ComparisonView.invalid("Traveller preferences are required for comparison.");
        }
        if (accommodationIds == null || accommodationIds.isEmpty()) {
            return ComparisonView.invalid("Select at least two accommodations to compare.");
        }

        List<String> normalisedIds = accommodationIds.stream()
                .filter(id -> id != null && !id.isBlank())
                .map(String::trim)
                .collect(Collectors.toList());

        if (normalisedIds.isEmpty()) {
            return ComparisonView.invalid("No valid accommodation IDs provided.");
        }

        Set<String> uniqueIds = new HashSet<>(normalisedIds);
        if (uniqueIds.size() == 1) {
            String onlyId = uniqueIds.iterator().next();
            return ComparisonView.singleOptionOnly(findById(onlyId).orElse(null));
        }

        List<ComparisonItem> items = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        for (String id : uniqueIds) {
            Optional<Accommodation> accommodation = findById(id);
            if (accommodation.isPresent()) {
                PreferenceMatch match = preferences.assess(accommodation.get());
                items.add(new ComparisonItem(accommodation.get(), match));
            } else {
                missing.add(id);
            }
        }

        if (items.size() < 2) {
            String message = missing.isEmpty()
                    ? "Unable to locate enough accommodations for comparison."
                    : "Missing accommodations: " + String.join(", ", missing);
            return ComparisonView.invalid(message);
        }

        return ComparisonView.success(items, missing);
    }

    public BookingContext prepareBooking(String accommodationId) {
        Accommodation accommodation = findById(accommodationId)
                .orElseThrow(() -> new IllegalArgumentException("Accommodation with ID " + accommodationId + " not found."));
        String reference = "BOOK-" + accommodation.getAccommodationId() + "-" + Instant.now().toEpochMilli();
        return new BookingContext(accommodation, reference);
    }

    public Optional<Accommodation> findById(String accommodationId) {
        return accommodations.stream()
                .filter(acc -> acc.getAccommodationId().equalsIgnoreCase(accommodationId))
                .findFirst();
    }
}
