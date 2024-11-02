package com.atyas.reviewmicroservice.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {

        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }

/*    @GetMapping("/{companyId}")
    public ResponseEntity<List<Review>> getReviewsbyCompanyId(@RequestParam Long companyId) {

        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,
                                            @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);

        if (isReviewSaved)
            return new ResponseEntity<>("Review saved successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review review){

        boolean isReviewUpdated = reviewService.updateReview(reviewId, review);

        if (isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);

        if (isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);

    }
}
