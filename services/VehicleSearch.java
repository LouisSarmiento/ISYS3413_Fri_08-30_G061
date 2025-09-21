package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import model.Vehicle;

public class VehicleSearch {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleSearch() {
    }

    public VehicleSearch(Collection<Vehicle> seedVehicles) {
        vehicles.addAll(seedVehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addVehicles(Collection<Vehicle> vehicles) {
        this.vehicles.addAll(vehicles);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public List<Vehicle> filterVehicles(Predicate<Vehicle> predicate) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (predicate.test(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }
}
