package accommodation;

public final class ValidationResult {
    private final boolean error;
    private final boolean singleSelection;
    private final String message;
    private final String suggestedAccommodationId;

    private ValidationResult(boolean error, boolean singleSelection, String message, String suggestedAccommodationId) {
        this.error = error;
        this.singleSelection = singleSelection;
        this.message = message;
        this.suggestedAccommodationId = suggestedAccommodationId;
    }

    public static ValidationResult error(String message) {
        return new ValidationResult(true, false, message, null);
    }

    public static ValidationResult singleSelection(String accommodationId) {
        return new ValidationResult(false, true, "Only one selection provided", accommodationId);
    }

    public static ValidationResult success() {
        return new ValidationResult(false, false, "Valid selection", null);
    }

    public static ValidationResult pending() {
        return new ValidationResult(false, false, "Validation pending implementation", null);
    }

    public boolean isError() {
        return error;
    }

    public boolean isSingleSelection() {
        return singleSelection;
    }

    public String getMessage() {
        return message;
    }

    public String getSuggestedAccommodationId() {
        return suggestedAccommodationId;
    }
}
