package com.hehe.review.api;

import com.hehe.review.api.request.CreateReview;
import com.hehe.review.service.ReviewService;
import com.hehe.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewDto getRestaurantReviews(@PathVariable("restaurantId") Long restaurantId,
                                          @RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit
    ) {
       return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offset / limit, limit));
    }
}
