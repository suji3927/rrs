package com.hehe.review.service;

import com.hehe.review.model.ReviewEntity;
import com.hehe.review.repository.RestaurantRepository;
import com.hehe.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createReview(Long restaurantId, String content, Double score) {
        restaurantRepository.findById(restaurantId).orElseThrow();

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .restaurantId(restaurantId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();

        reviewRepository.save(reviewEntity);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);
    }
}
