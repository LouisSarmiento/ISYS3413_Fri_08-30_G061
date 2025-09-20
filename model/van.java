package model;

public class Van extends Vehicle {
    private int cargoVolume;

    public Van(int vehicleId, String make, String model, int seats, float pricePerDay, int cargoVolume) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.cargoVolume = cargoVolume;
    }

    public void foldRearBench() {
        // TODO: implement
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (Van, Cargo: " + cargoVolume + ")";
    }
}
