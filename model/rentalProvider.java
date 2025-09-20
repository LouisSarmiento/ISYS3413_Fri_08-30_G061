package model;

public class RentalProvider {
    private int providerId;
    private String name;
    private String location;

    public RentalProvider(int providerId, String name, String location) {
        this.providerId = providerId;
        this.name = name;
        this.location = location;
    }

    public String getProviderInfo() {
        return name + " (" + location + ")";
    }
}
