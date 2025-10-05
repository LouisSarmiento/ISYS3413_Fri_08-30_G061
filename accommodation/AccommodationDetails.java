package accommodation;

public class AccommodationDetails {
    private final String accommodationId;

    public AccommodationDetails(String accommodationId) {
        // store the id so other pieces know which place this is about
        this.accommodationId = accommodationId;
    }

    public String getAccommodationId() {
        return accommodationId;
    }
}
