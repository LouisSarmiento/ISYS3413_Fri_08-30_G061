// Contributed by Louis Sarmiento
package accommodation;

public class Location {
    private String city;
    private String region;
    private String country;

    public Location(String city, String region, String country) {
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public String getLocationDetails() {
        return "City: " + city + ", Region: " + region + ", Country: " + country;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }
}
