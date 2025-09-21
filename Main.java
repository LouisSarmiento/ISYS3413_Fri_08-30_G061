// Contributed by Louis Sarmiento
import accommodation.Accommodation;
import accommodation.AccommodationSearchService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Main() {
        // Entry-point container
    }

    public static void main(String[] args) {
        List<Accommodation> accommodations = SampleAccommodationData.createSampleAccommodations();
        AccommodationSearchService searchService = new AccommodationSearchService(accommodations);

        System.out.println("Welcome to the Travel Finder");
        runMenu(searchService, accommodations);
    }

    private static void runMenu(AccommodationSearchService searchService, List<Accommodation> accommodations) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1. View all accommodations");
                System.out.println("2. Search by location");
                System.out.println("3. Search by budget (max price)");
                System.out.println("4. Advanced filters (coming soon)");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        displayAccommodations(accommodations);
                        break;
                    case "2":
                        handleLocationSearch(scanner, searchService);
                        break;
                    case "3":
                        handleBudgetSearch(scanner, searchService);
                        break;
                    case "4":
                        System.out.println("Advanced filters are not yet implemented in this skeleton.");
                        break;
                    case "5":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1-5.");
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
}
