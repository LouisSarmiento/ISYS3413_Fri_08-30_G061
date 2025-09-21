package model;

public class Review {
    private final int reviewId;
    private final int rating;
    private final String comment;

    public Review(int reviewId, int rating, String comment) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getReview() {
        return rating + "/5 - " + comment;
    }
}
