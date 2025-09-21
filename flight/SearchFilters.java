package flight;

public class SearchFilters {
    private String searchKeyword;
    private String destination;

    public SearchFilters() {
        this.searchKeyword = "";
        this.destination = "";
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}   
