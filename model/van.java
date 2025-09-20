public Van (int vehicleId, String make, String model, int seats, float price, int cargoVolume) {
    super(vehicleId, make, model, seats, price);
    this.cargoVolume = cargoVolume;
}


public SUV (int vehicleId, String make, String model, int seats, float price, boolean hasAWD) {
    super(vehicleId, make, model, seats, price);
    this.hasAWD = hasAWD;
}