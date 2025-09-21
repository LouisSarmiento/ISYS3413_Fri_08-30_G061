package model;

public class RentalProvider {
    private final int providerId;
    private final String name;
    private final String location;

    public RentalProvider(int providerId, String name, String location) {
        this.providerId = providerId;
        this.name = name;
        this.location = location;
    }

    public int getProviderId() {
        return providerId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getProviderInfo() {
        return name + " (" + location + ")";
    }
}
