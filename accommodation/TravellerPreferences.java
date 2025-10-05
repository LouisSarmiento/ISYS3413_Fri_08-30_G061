package accommodation;

public class TravellerPreferences {
    private final String travellerId;

    private TravellerPreferences(String travellerId) {
        // this would hold more info later (budget, amenities, etc.)
        this.travellerId = travellerId;
    }

    public static TravellerPreferences placeholder(String travellerId) {
        return new TravellerPreferences(travellerId);
    }

    public String getTravellerId() {
        return travellerId;
    }
}
