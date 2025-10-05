package accommodation;

public class SearchCriteria {
    private final String travellerId;

    public SearchCriteria(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getTravellerId() {
        return travellerId;
    }
}
