package model;

public abstract class Vehicle {
    protected final int vehicleId;
    protected final String make;
    protected final String model;
    protected final int seats;
    private final float pricePerDay;

    public Vehicle(int vehicleId, String make, String model, int seats, float pricePerDay) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.seats = seats;
        this.pricePerDay = pricePerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Returns a short description for list displays.
     */
    public String summary() {
        return getDetails() + ", $" + pricePerDay + " per day";
    }

    public abstract String getDetails();
}
