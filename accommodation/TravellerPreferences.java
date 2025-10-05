package accommodation;

public class TravellerPreferences {
    private final String travellerId;

    private TravellerPreferences(String travellerId) {
        this.travellerId = travellerId;
    }

    public static TravellerPreferences placeholder(String travellerId) {
        return new TravellerPreferences(travellerId);
    }

    public String getTravellerId() {
        return travellerId;
    }
}
