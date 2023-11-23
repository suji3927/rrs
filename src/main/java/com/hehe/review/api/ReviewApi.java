package com.hehe.review.api;

import com.hehe.review.api.request.CreateReview;
import com.hehe.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {

    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(@RequestBody CreateReview createReview) {
        reviewService.createReview(createReview.getRestaurantId(), createReview.getContent(), createReview.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

}
