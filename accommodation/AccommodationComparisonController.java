package accommodation;

import java.util.List;

public class AccommodationComparisonController {
    private final AccommodationSearchService searchService;

    public AccommodationComparisonController(AccommodationSearchService searchService) {
        this.searchService = searchService;
    }

    public void compareSelectedAccommodations(String travellerId, List<String> selectedAccommodationIds) {
        ValidationResult validation = searchService.validateSelection(selectedAccommodationIds);
        if (validation.isError()) {
            System.out.println("Validation error: " + validation.getMessage());
            return;
        }
        if (validation.isSingleSelection()) {
            System.out.println("Single selection: " + validation.getSuggestedAccommodationId());
            return;
        }
        List<AccommodationDetails> details = searchService.fetchAccommodationDetails(selectedAccommodationIds);
        TravellerPreferences preferences = searchService.loadTravellerPreferences(travellerId);
        ComparisonView comparisonView = searchService.assembleComparisonView(details, preferences);
        System.out.println("Comparison message: " + comparisonView.getMessage());
        System.out.println("Items compared: " + comparisonView.getItems().size());
    }

    public void proceedToBooking(String travellerId, String accommodationId) {
        BookingContext context = searchService.prepareBooking(travellerId, accommodationId);
        System.out.println("Booking prepared for " + context.getTravellerId() + " -> " + context.getAccommodationId());
    }

    public void refineSearch(SearchCriteria updatedCriteria) {
        List<AccommodationDetails> updatedResults = searchService.updateSearchCriteria(updatedCriteria);
        System.out.println("Updated results: " + updatedResults.size());
    }
}
