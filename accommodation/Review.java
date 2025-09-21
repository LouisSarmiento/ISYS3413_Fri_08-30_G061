// Contributed by Louis Sarmiento
package accommodation;

/**
 * Placeholder for future review support. Stored fields are enough for testing relationships.
 */
public class Review {
    private final String reviewerName;
    private final int rating;
    private final String comment;

    public Review(String reviewerName, int rating, String comment) {
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
