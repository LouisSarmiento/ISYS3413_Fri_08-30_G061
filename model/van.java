package model;

public class Van extends Vehicle {
    private final int cargoVolume;
    private boolean rearBenchFolded;

    public Van(int vehicleId, String make, String model, int seats, float pricePerDay, int cargoVolume) {
        super(vehicleId, make, model, seats, pricePerDay);
        this.cargoVolume = cargoVolume;
    }

    public void foldRearBench() {
        rearBenchFolded = true;
    }

    @Override
    public String getDetails() {
        return make + " " + model + " (Van, Cargo: " + cargoVolume + ")";
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    public boolean isRearBenchFolded() {
        return rearBenchFolded;
    }
}
