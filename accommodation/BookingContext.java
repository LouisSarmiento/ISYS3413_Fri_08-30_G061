package accommodation;

public class BookingContext {
    private final String travellerId;
    private final String accommodationId;

    public BookingContext(String travellerId, String accommodationId) {
        this.travellerId = travellerId;
        this.accommodationId = accommodationId;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public String getAccommodationId() {
        return accommodationId;
    }
}
