import accommodation.Accommodation;
import accommodation.SearchFilter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating some sample accommodations
        List<Accommodation> accommodations = SampleAccommodationData.createSampleAccommodations();

        System.out.println("Welcome to the Accommodation Finder!");
        
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Search for Accommodations");
            System.out.println("2. View All Accommodations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchAccommodations(scanner, accommodations);
                    break;
                case 2:
                    viewAllAccommodations(accommodations);
                    break;
                case 3:
                    System.out.println("Thank you for using the Accommodation Finder!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void searchAccommodations(Scanner scanner, List<Accommodation> accommodations) {
        System.out.println("\nSearch Options:");
        System.out.println("1. Search by Location");
        System.out.println("2. Search by Price");
        System.out.println("3. Search by Amenities");
        System.out.println("4. Filter by Categories");
        System.out.print("Choose a search criterion: ");
        int searchOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (searchOption) {
            case 1:
                System.out.print("Enter the city to search: ");
                String city = scanner.nextLine();
                List<Accommodation> locationResults = SearchFilter.filterByLocation(accommodations, city);
                displayAccommodations(locationResults);
                break;
            case 2:
                System.out.print("Enter maximum price per night: ");
                float maxPrice = scanner.nextFloat();
                List<Accommodation> priceResults = SearchFilter.filterByPrice(accommodations, maxPrice);
                displayAccommodations(priceResults);
                break;
            case 3:
                System.out.println("Filter by Amenities:");
                System.out.print("Does it need WiFi? (yes/no): ");
                boolean wifi = scanner.nextLine().equalsIgnoreCase("yes");
                System.out.print("Does it need a pool? (yes/no): ");
                boolean pool = scanner.nextLine().equalsIgnoreCase("yes");
                List<Accommodation> amenityResults = SearchFilter.filterByAmenities(accommodations, wifi, pool);
                displayAccommodations(amenityResults);
                break;
            case 4:
                filterByCategories(scanner, accommodations);
                break;
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }

    private static void filterByCategories(Scanner scanner, List<Accommodation> accommodations) {
        List<Accommodation> filteredResults = accommodations;
        boolean selecting = true;

        while (selecting) {
            System.out.println("\nFilter Categories:");
            System.out.println("1. Minimum Capacity");
            System.out.println("2. Price Range");
            System.out.println("3. Bed Type");
            System.out.println("4. Optional Extra");
            System.out.println("5. Location (City/Region/Country)");
            System.out.println("6. Amenities (WiFi/Pool)");
            System.out.println("7. View Results");
            System.out.println("8. Reset Filters");
            System.out.println("9. Return to Search Menu");
            System.out.print("Choose a filter option: ");

            int filterChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (filterChoice) {
                case 1:
                    System.out.print("Enter minimum capacity required: ");
                    int minCapacity = scanner.nextInt();
                    scanner.nextLine();
                    filteredResults = SearchFilter.filterByCapacity(filteredResults, minCapacity);
                    notifyFilterOutcome(filteredResults);
                    break;
                case 2:
                    System.out.print("Enter minimum price per night: ");
                    float minPrice = scanner.nextFloat();
                    System.out.print("Enter maximum price per night: ");
                    float maxPrice = scanner.nextFloat();
                    scanner.nextLine();
                    if (minPrice > maxPrice) {
                        System.out.println("Minimum price cannot be greater than maximum price.");
                    } else {
                        filteredResults = SearchFilter.filterByPriceRange(filteredResults, minPrice, maxPrice);
                        notifyFilterOutcome(filteredResults);
                    }
                    break;
                case 3:
                    System.out.print("Enter bed type (e.g. King, Queen, Twin): ");
                    String bedType = scanner.nextLine();
                    filteredResults = SearchFilter.filterByBedType(filteredResults, bedType);
                    notifyFilterOutcome(filteredResults);
                    break;
                case 4:
                    System.out.print("Enter optional extra keyword (e.g. Parking, Transfer): ");
                    String extra = scanner.nextLine();
                    filteredResults = SearchFilter.filterByOptionalExtra(filteredResults, extra);
                    notifyFilterOutcome(filteredResults);
                    break;
                case 5:
                    System.out.print("Enter location keyword: ");
                    String locationKeyword = scanner.nextLine();
                    filteredResults = SearchFilter.filterByLocation(filteredResults, locationKeyword);
                    notifyFilterOutcome(filteredResults);
                    break;
                case 6:
                    System.out.print("Require WiFi? (yes/no): ");
                    boolean requireWifi = scanner.nextLine().equalsIgnoreCase("yes");
                    System.out.print("Require pool? (yes/no): ");
                    boolean requirePool = scanner.nextLine().equalsIgnoreCase("yes");
                    filteredResults = SearchFilter.filterByAmenities(filteredResults, requireWifi, requirePool);
                    notifyFilterOutcome(filteredResults);
                    break;
                case 7:
                    displayAccommodations(filteredResults);
                    return;
                case 8:
                    filteredResults = accommodations;
                    System.out.println("Filters have been reset.");
                    notifyFilterOutcome(filteredResults);
                    break;
                case 9:
                    selecting = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (filteredResults.isEmpty()) {
                System.out.println("No accommodations match the selected filters.");
            }
        }
    }

    private static void notifyFilterOutcome(List<Accommodation> filteredResults) {
        System.out.println("Current matches: " + filteredResults.size());
    }

    private static void viewAllAccommodations(List<Accommodation> accommodations) {
        System.out.println("\nAll Available Accommodations:");
        displayAccommodations(accommodations);
    }

    private static void displayAccommodations(List<Accommodation> accommodations) {
        if (accommodations.isEmpty()) {
            System.out.println("No accommodations found for the given criteria.");
        } else {
            for (Accommodation accommodation : accommodations) {
                System.out.println("\n" + accommodation.getDetails());
                System.out.println(accommodation.getPriceDetails());
                System.out.println(accommodation.getLocationDetails());
                if (accommodation.getBedDetails() != null) {
                    System.out.println(accommodation.getBedDetails().getBedDetails());
                }
                if (accommodation.getAmenities() != null) {
                    System.out.println("Amenities - WiFi: " + (accommodation.getAmenities().isWiFi() ? "Yes" : "No")
                            + ", Parking: " + (accommodation.getAmenities().isParking() ? "Yes" : "No")
                            + ", Pool: " + (accommodation.getAmenities().isPool() ? "Yes" : "No")
                            + ", Gym: " + (accommodation.getAmenities().isGym() ? "Yes" : "No"));
                }
                if (accommodation.getOptionalExtras() != null) {
                    System.out.println(accommodation.getOptionalExtras().getExtras());
                }
            }
        }
    }
}
