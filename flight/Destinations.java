package flight;

public class Destinations {
    private String airportID;
    private String country;
    private String city;
    private String airportName;

    public Destinations(String airportID, String country, String city, String airportName) {
        this.airportID = airportID;
        this.country = country;
        this.city = city;
        this.airportName = airportName;
    }
    public String getAirportID() {
        return airportID;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getAirportName() {
        return airportName;
    }
    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}