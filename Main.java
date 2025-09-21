// Contributed by Louis Sarmiento
import accommodation.Accommodation;
import accommodation.AccommodationSearchService;
import java.util.List;
import java.util.Scanner;
import model.Vehicle;
import services.VehicleSearch;

public class Main {
    private Main() {
        // Entry-point container
    }

    public static void main(String[] args) {
        List<Accommodation> accommodations = SampleAccommodationData.createSampleAccommodations();
        AccommodationSearchService accommodationSearch = new AccommodationSearchService(accommodations);
        VehicleSearch vehicleSearch = SampleVehicleData.createVehicleSearch();

        System.out.println("Welcome to the Travel Finder");
        runMenu(accommodationSearch, accommodations, vehicleSearch);
    }

    private static void runMenu(
            AccommodationSearchService accommodationSearch,
            List<Accommodation> accommodations,
            VehicleSearch vehicleSearch) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1. View all accommodations");
                System.out.println("2. Search by location");
                System.out.println("3. Search by budget (max price)");
                System.out.println("4. View all vehicles");
                System.out.println("5. Search vehicles by minimum seats");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        displayAccommodations(accommodations);
                        break;
                    case "2":
                        handleLocationSearch(scanner, accommodationSearch);
                        break;
                    case "3":
                        handleBudgetSearch(scanner, accommodationSearch);
                        break;
                    case "4":
                        displayVehicles(vehicleSearch.getAllVehicles());
                        break;
                    case "5":
                        handleVehicleSeatSearch(scanner, vehicleSearch);
                        break;
                    case "6":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1-6.");
                }
            }
        }
    }

    private static void handleLocationSearch(Scanner scanner, AccommodationSearchService searchService) {
        System.out.print("Enter a city, region, or country to search: ");
        String query = scanner.nextLine();
        searchService.clearCriteria();
        searchService.setLocationQuery(query);
        displayAccommodations(searchService.searchAccommodation());
    }

    private static void handleBudgetSearch(Scanner scanner, AccommodationSearchService searchService) {
        System.out.print("Enter your maximum nightly rate: ");
        String input = scanner.nextLine();
        try {
            float maxPrice = Float.parseFloat(input);
            searchService.clearCriteria();
            searchService.setMaxPrice(maxPrice);
            displayAccommodations(searchService.searchAccommodation());
        } catch (NumberFormatException ex) {
            System.out.println("Could not understand that amount. Please try again.");
        }
    }

    private static void handleVehicleSeatSearch(Scanner scanner, VehicleSearch vehicleSearch) {
        System.out.print("Enter the minimum number of seats required: ");
        String input = scanner.nextLine();
        try {
            int minSeats = Integer.parseInt(input);
            List<Vehicle> matches = vehicleSearch.filterVehicles(vehicle -> vehicle.getSeats() >= minSeats);
            displayVehicles(matches);
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a whole number for seats.");
        }
    }

    private static void displayAccommodations(List<Accommodation> accommodations) {
        if (accommodations.isEmpty()) {
            System.out.println("No accommodation matched your request.");
            return;
        }

        System.out.println();
        for (Accommodation accommodation : accommodations) {
            System.out.println("- " + accommodation.summary());
        }
    }

    private static void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles matched your request.");
            return;
        }

        System.out.println();
        for (Vehicle vehicle : vehicles) {
            System.out.println("- " + vehicle.summary());
        }
    }
}
