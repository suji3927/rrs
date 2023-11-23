package com.hehe.review.service.dto;

import com.hehe.review.model.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewDtoPage {
        private Integer offset;
        private Integer limit;
    }

}
