package accommodation;

import java.util.List;

public class AccommodationComparisonController {
    private final AccommodationSearchService searchService;

    public AccommodationComparisonController(AccommodationSearchService searchService) {
        // keep a reference to the service so every request goes through the same path
        this.searchService = searchService;
    }

    public void compareSelectedAccommodations(String travellerId, List<String> selectedAccommodationIds) {
        // first step of the sequence: validate that the UI picked enough items
        ValidationResult validation = searchService.validateSelection(selectedAccommodationIds);
        if (validation.isError()) {
            System.out.println("Validation error: " + validation.getMessage());
            return;
        }
        if (validation.isSingleSelection()) {
            // the diagram says we show the details if only one was chosen
            System.out.println("Single selection: " + validation.getSuggestedAccommodationId());
            return;
        }
        // fetch the data for each ID (loop in the sequence diagram)
        List<AccommodationDetails> details = searchService.fetchAccommodationDetails(selectedAccommodationIds);
        // load any traveller preferences saved for this user
        TravellerPreferences preferences = searchService.loadTravellerPreferences(travellerId);
        // merge both into a comparison view
        ComparisonView comparisonView = searchService.assembleComparisonView(details, preferences);
        System.out.println("Comparison message: " + comparisonView.getMessage());
        System.out.println("Items compared: " + comparisonView.getItems().size());
    }

    public void proceedToBooking(String travellerId, String accommodationId) {
        // this is the branch where the traveller chooses one option to book
        BookingContext context = searchService.prepareBooking(travellerId, accommodationId);
        System.out.println("Booking prepared for " + context.getTravellerId() + " -> " + context.getAccommodationId());
    }

    public void refineSearch(SearchCriteria updatedCriteria) {
        // other branch from the sequence diagram (refine filters and show new results)
        List<AccommodationDetails> updatedResults = searchService.updateSearchCriteria(updatedCriteria);
        System.out.println("Updated results: " + updatedResults.size());
    }
}
