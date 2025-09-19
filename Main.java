import accommodation.Accommodation;
import accommodation.Amenities;
import accommodation.BedType;
import accommodation.Location;
import accommodation.OptionalExtras;
import accommodation.Price;
import accommodation.SearchFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating some sample accommodations
        List<Accommodation> accommodations = createSampleAccommodations();

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
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
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
            }
        }
    }

    private static List<Accommodation> createSampleAccommodations() {
        List<Accommodation> accommodations = new ArrayList<>();

        Price price1 = new Price(120, 800, 1000);
        Location location1 = new Location("Sydney", "New South Wales", "Australia");
        BedType bed1 = new BedType("King", 2);
        Amenities amenities1 = new Amenities(true, true, true, false);
        OptionalExtras extras1 = new OptionalExtras("Late Check-out", 30);
        Accommodation accommodation1 = new Accommodation("A101", "Luxury Stay", "Sydney", 2, 150);
        accommodation1.setPriceDetails(price1);
        accommodation1.setLocationDetails(location1);
        accommodation1.setBedDetails(bed1);
        accommodation1.setAmenities(amenities1);
        accommodation1.setOptionalExtras(extras1);
        
        accommodations.add(accommodation1);
        
        // Adding more sample accommodations
        Price price2 = new Price(100, 700, 900);
        Location location2 = new Location("Melbourne", "Victoria", "Australia");
        BedType bed2 = new BedType("Queen", 2);
        Amenities amenities2 = new Amenities(true, false, true, true);
        OptionalExtras extras2 = new OptionalExtras("Early Check-in", 20);
        Accommodation accommodation2 = new Accommodation("A102", "Cozy Stay", "Melbourne", 2, 100);
        accommodation2.setPriceDetails(price2);
        accommodation2.setLocationDetails(location2);
        accommodation2.setBedDetails(bed2);
        accommodation2.setAmenities(amenities2);
        accommodation2.setOptionalExtras(extras2);
        
        accommodations.add(accommodation2);

        return accommodations;
    }
}
