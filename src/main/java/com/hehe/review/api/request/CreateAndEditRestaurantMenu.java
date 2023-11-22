package com.hehe.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateAndEditRestaurantMenu {
    private final String name;
    private final Integer price;
}
