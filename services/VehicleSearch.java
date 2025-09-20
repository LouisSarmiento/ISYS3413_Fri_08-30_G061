package services;

import model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class VehicleSearch {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> filterVehicles(Predicate<Vehicle> predicate) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (predicate.test(v)) {
                result.add(v);
            }
        }
        return result;
    }
}
