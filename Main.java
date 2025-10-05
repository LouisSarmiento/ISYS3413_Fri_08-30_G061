import accommodation.AccommodationComparisonController;
import accommodation.AccommodationSearchService;
import accommodation.SearchCriteria;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> SAMPLE_IDS = SampleAccommodationData.placeholderAccommodationIds();

    public static void main(String[] args) {
        AccommodationSearchService service = new AccommodationSearchService();
        AccommodationComparisonController controller = new AccommodationComparisonController(service);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                // simple console menu so we can see the sequence play out
                System.out.println("\n--- Accommodation Comparison Demo ---");
                System.out.println("Sample IDs: " + SAMPLE_IDS);
                System.out.println("1) Compare first two IDs");
                System.out.println("2) Compare custom IDs");
                System.out.println("3) Proceed to booking (first ID)");
                System.out.println("4) Refine search (traveller placeholder)");
                System.out.println("5) Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1" -> controller.compareSelectedAccommodations(
                            "TRAVELLER-001",
                            SAMPLE_IDS.subList(0, Math.min(2, SAMPLE_IDS.size())));
                    case "2" -> {
                        System.out.print("Enter IDs separated by commas: ");
                        String input = scanner.nextLine().trim();
                        List<String> ids = input.isEmpty()
                                ? List.of()
                                : List.of(input.split("\\s*,\\s*"));
                        controller.compareSelectedAccommodations("TRAVELLER-001", ids);
                    }
                    case "3" -> {
                        if (!SAMPLE_IDS.isEmpty()) {
                            controller.proceedToBooking("TRAVELLER-001", SAMPLE_IDS.get(0));
                        } else {
                            System.out.println("No sample IDs available to book.");
                        }
                    }
                    case "4" -> {
                        // dummy criteria just to trigger the refine path
                        SearchCriteria criteria = new SearchCriteria("TRAVELLER-001");
                        controller.refineSearch(criteria);
                    }
                    case "5" -> running = false;
                    default -> System.out.println("Invalid option.");
                }
            }
        }
        System.out.println("Demo complete.");
    }
}
