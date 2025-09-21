import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.SUV;
import model.Van;
import model.Vehicle;
import services.VehicleSearch;

/**
 * Supplies demonstration vehicle data for the console stub.
 */
public final class SampleVehicleData {
    private SampleVehicleData() {
        // Utility class
    }

    public static List<Vehicle> createSampleVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(2001, "Mazda", "MX-5", 2, 95f, true));
        vehicles.add(new SUV(2002, "Toyota", "RAV4", 5, 130f, true));
        vehicles.add(new Van(2003, "Mercedes", "Vito", 8, 150f, 1200));
        return vehicles;
    }

    public static VehicleSearch createVehicleSearch() {
        VehicleSearch search = new VehicleSearch();
        search.addVehicles(createSampleVehicles());
        return search;
    }
}
