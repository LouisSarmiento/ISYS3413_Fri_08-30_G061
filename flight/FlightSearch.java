package flight;

public class FlightSearch {
    private String searchKeyword;
    private String destination;
    private String departureDate;

    public FlightSearch() {
        this.searchKeyword = "";
        this.destination = "";
        this.departureDate = "";
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

}
