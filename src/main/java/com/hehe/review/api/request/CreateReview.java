package com.hehe.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateReview {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
