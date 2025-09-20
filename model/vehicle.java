package model;

public abstract class Vehicle {
    protected int vehicleId;
    protected String make;
    protected String model;
    protected int seats;
    private float pricePerDay;

    public Vehicle(int vehicleId, String make, String model, int seats, float pricePerDay) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.seats = seats;
        this.pricePerDay = pricePerDay;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public abstract String getDetails();
}
