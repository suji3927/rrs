package com.hehe.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class RestaurantDetailView {
    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private List<Menu> menus;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Menu {
        private Long id;
        private String name;
        private Integer price;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
    }
}
