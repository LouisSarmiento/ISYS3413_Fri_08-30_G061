package accommodation;

public class ComparisonItem {
    private final AccommodationDetails details;

    public ComparisonItem(AccommodationDetails details) {
        // each row in the comparison keeps the detail reference
        this.details = details;
    }

    public AccommodationDetails getDetails() {
        return details;
    }
}
