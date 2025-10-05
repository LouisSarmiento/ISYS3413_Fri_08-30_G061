package flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearch {
    private String searchKeyword;
    private String destination;
    private Date departureDate;

    public FlightSearch() {
        this.searchKeyword = "";
        this.destination = "";
        this.departureDate = null;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }
    public String getDestination() {
        return destination;
    }
    public Date getDepartureDate() {
        return departureDate;
    }

public List<Flights> searchFlights(List<Flights> allFlights, String searchKeyword, String destination) {
    List<Flights> matchingFlights = new ArrayList<>();
    for (Flights flight : allFlights) {
        if (flight.getAirline().toLowerCase().contains(searchKeyword.toLowerCase()) ||
            flight.getDestination().toLowerCase().contains(destination.toLowerCase())) {
            matchingFlights.add(flight);
        }
    }
    return matchingFlights;
    }
}
