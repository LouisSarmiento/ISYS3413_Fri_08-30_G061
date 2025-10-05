package flight;

import java.util.ArrayList;
import java.util.List;

public class SearchFilters {
    private String airline;
    private float priceRange;
    private int seatType;
    private int duration;

    public SearchFilters() {
        this.airline = "";
        this.priceRange = 0.0f;
        this.seatType = 0;
        this.duration = 0;
    }
    public void clearFilters() {
        this.airline = "";
        this.priceRange = 0.0f;
        this.seatType = 0;
        this.duration = 0;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public void setPriceRange(float priceRange) {
        this.priceRange = priceRange;
    }
    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getAirlilne () {
        return airline;
    }
    public float getPriceRange () {
        return priceRange;
    }
    public int getSeatType () {
        return seatType;
    }
    public int getDuration () {
        return duration;
    }

public List<Flights> applyFilter(List<Flights> allFlights, String airline, int seatType, int duration) {
    List<Flights> filteredFlights = new ArrayList<>();

    for (Flights flight : allFlights) {
        boolean matches = true;
        if (!airline.isEmpty() && !flight.getAirline().equalsIgnoreCase(airline)) {
            matches = false;
        }
        if (seatType > 0 && flight.getAvailableSeat() != seatType) {
            matches = false;
        }
        if (duration > 0 && flight.getFlightDuration() != duration) {
            matches = false;
        }
        if (matches) {
            filteredFlights.add(flight);
        }
    }
    return filteredFlights;
    }
}
