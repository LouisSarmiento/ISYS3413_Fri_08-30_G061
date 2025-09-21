package flight;

public class Airlines {
    private String iataCode;
    private String airlineName;
    private String icaoCode;
    private int rating;

    public Airlines(String iataCode, String airlineName, String icaoCode, int rating) {
        this.iataCode = iataCode;
        this.airlineName = airlineName;
        this.icaoCode = icaoCode;
        this.rating = rating;
    }
    public String getIataCode() {
        return iataCode;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public String getIcaoCode() {
        return icaoCode;
    }
    public int getRating() {
        return rating;
    }
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
