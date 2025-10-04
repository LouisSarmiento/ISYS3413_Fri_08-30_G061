// Contributed by whole group

import accommodation.Accommodation;
import accommodation.AccommodationSearchService;
import accommodation.BookingContext;
import accommodation.ComparisonItem;
import accommodation.ComparisonView;
import accommodation.TravellerPreferences;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Main() {
        // Entry-point container
    }

    public static void main(String[] args) {
        List<Accommodation> accommodations = SampleAccommodationData.createSampleAccommodations();
        AccommodationSearchService searchService = new AccommodationSearchService(accommodations);
        TravellerPreferences preferences = TravellerPreferences.defaultPreferences();

        System.out.println("Welcome to the Travel Finder (Accommodation Module)");
        runMenu(searchService, preferences);
    }

    private static void runMenu(AccommodationSearchService searchService, TravellerPreferences preferences) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("Active filters: " + searchService.getCriteriaSnapshot());
                System.out.println("1. Show search results");
                System.out.println("2. Update search filters");
                System.out.println("3. Compare accommodations");
                System.out.println("4. View accommodation details");
                System.out.println("5. Update traveller preferences");
                System.out.println("6. Prepare booking");
                System.out.println("7. Reset filters");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        displayAccommodations(searchService.searchAccommodation());
                        break;
                    case "2":
                        updateFilters(scanner, searchService);
                        break;
                    case "3":
                        handleComparison(scanner, searchService, preferences);
                        break;
                    case "4":
                        handleDetails(scanner, searchService);
                        break;
                    case "5":
                        preferences = capturePreferences(scanner, preferences);
                        break;
                    case "6":
                        handleBooking(scanner, searchService);
                        break;
                    case "7":
                        searchService.clearCriteria();
                        System.out.println("Filters cleared.");
                        break;
                    case "8":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1-8.");
                }
            }
        }
    }

    private static void displayAccommodations(List<Accommodation> accommodations) {
        if (accommodations.isEmpty()) {
            System.out.println("No accommodation matched your request.");
            return;
        }

        for (Accommodation accommodation : accommodations) {
            System.out.println(accommodation.getAccommodationId() + ": " + accommodation.summary());
        }
    }

    private static void updateFilters(Scanner scanner, AccommodationSearchService searchService) {
        System.out.print("Location keyword (blank to clear): ");
        searchService.setLocationQuery(nullIfBlank(scanner.nextLine()));

        searchService.setMaxPrice(readFloat(scanner, "Maximum nightly rate (blank to clear): "));
        searchService.setMinCapacity(readInteger(scanner, "Minimum capacity (blank to clear): "));

        System.out.println("Filters updated. Current results:");
        displayAccommodations(searchService.searchAccommodation());
    }

    private static void handleComparison(Scanner scanner, AccommodationSearchService searchService,
                                         TravellerPreferences preferences) {
        List<Accommodation> currentResults = searchService.searchAccommodation();
        if (currentResults.size() < 2) {
            System.out.println("Need at least two results to compare. Adjust filters or add more selections.");
            return;
        }

        System.out.println("Available accommodations: ");
        displayAccommodations(currentResults);
        System.out.print("Enter accommodation IDs to compare (comma separated): ");
        String input = scanner.nextLine();
        List<String> ids = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(id -> !id.isEmpty())
                .collect(Collectors.toList());

        ComparisonView comparisonView = searchService.compareAccommodations(ids, preferences);
        System.out.println(comparisonView.getMessage());

        comparisonView.getSingleOption().ifPresent(only -> {
            System.out.println(only.getAccommodationId() + ": " + only.detailedSummary());
            System.out.println("Add another accommodation to compare.");
        });

        if (!comparisonView.isValid()) {
            return;
        }

        for (ComparisonItem item : comparisonView.getItems()) {
            System.out.println();
            System.out.println(item.getAccommodation().getAccommodationId() + ": "
                    + item.getAccommodation().detailedSummary());
            if (item.getPreferenceMatch().matchesAll()) {
                System.out.println("    Preferences: All matched");
            } else {
                if (!item.getPreferenceMatch().satisfiedCriteria().isEmpty()) {
                    System.out.println("    Matched: " + String.join(", ", item.getPreferenceMatch().satisfiedCriteria()));
                }
                if (!item.getPreferenceMatch().unmetCriteria().isEmpty()) {
                    System.out.println("    Unmet: " + String.join(", ", item.getPreferenceMatch().unmetCriteria()));
                }
            }
        }
    }

    private static void handleDetails(Scanner scanner, AccommodationSearchService searchService) {
        System.out.print("Enter accommodation ID to view details: ");
        String id = scanner.nextLine().trim();
        searchService.findById(id)
                .ifPresentOrElse(
                        acc -> System.out.println(acc.getAccommodationId() + ": " + acc.detailedSummary()),
                        () -> System.out.println("Accommodation not found."));
    }

    private static TravellerPreferences capturePreferences(Scanner scanner, TravellerPreferences current) {
        TravellerPreferences updated = TravellerPreferences.copyOf(current);

        Boolean wifi = readBooleanWithDefault(scanner,
                "Prefer WiFi (current: " + yesNo(current.isPreferWifi()) + ")?");
        if (wifi != null) {
            updated.setPreferWifi(wifi);
        }

        updated.setBudgetPerNight(readBudget(scanner, current.getBudgetPerNight()));
        System.out.println("Preferences updated.");
        return updated;
    }

    private static void handleBooking(Scanner scanner, AccommodationSearchService searchService) {
        System.out.print("Enter accommodation ID to book: ");
        String id = scanner.nextLine().trim();
        try {
            BookingContext context = searchService.prepareBooking(id);
            System.out.println(context.describe());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Float readFloat(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return Float.parseFloat(value.trim());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number. Value cleared.");
            return null;
        }
    }

    private static Integer readInteger(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number. Value cleared.");
            return null;
        }
    }

    private static Boolean readBooleanWithDefault(Scanner scanner, String prompt) {
        System.out.print(prompt + " (y/n, blank=keep current): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.isEmpty()) {
            return null;
        }
        return response.startsWith("y");
    }

    private static Float readBudget(Scanner scanner, Float current) {
        System.out.print("Budget per night (current: " + valueOrNone(current)
                + ") - enter a value, 'clear', or press Enter to keep: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return current;
        }
        if (input.equalsIgnoreCase("clear")) {
            return null;
        }
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number. Budget unchanged.");
            return current;
        }
    }

    private static String nullIfBlank(String value) {
        return value == null || value.isBlank() ? null : value.trim();
    }

    private static String yesNo(boolean value) {
        return value ? "Yes" : "No";
    }

    private static String valueOrNone(Object value) {
        return value == null ? "None" : value.toString();
    }
}
