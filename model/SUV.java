package model;

public class SUV extends Vehicle {
    private boolean allWheelDrive;

    public SUV(int vehicleId, String make, String model, int seats, float pricePerDay, boolean hasAWD) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.allWheelDrive = hasAWD;
    }

    public void toggleAWD(boolean on) {
        this.allWheelDrive = on;
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (SUV, AWD: " + allWheelDrive + ")";
    }

    public boolean hasAllWheelDrive() {
        return allWheelDrive;
    }
}
