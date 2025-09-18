package accommodation;

public class Review {
    private int reviewID;
    private int rating;
    private String comment;

    public Review(int reviewID, int rating, String comment) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.comment = comment;
    }

    public String getReview() {
        return "Rating: " + rating + ", Comment: " + comment;
    }
}
