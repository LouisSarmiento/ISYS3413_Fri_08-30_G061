package model;

public class SUV extends Vehicle {
    private boolean hasAWD;

    public SUV(int vehicleId, String make, String model, int seats, float pricePerDay, boolean hasAWD) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.hasAWD = hasAWD;
    }

    public void toggleAWD(boolean on) {
        this.hasAWD = on;
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (SUV, AWD: " + hasAWD + ")";
    }
}
