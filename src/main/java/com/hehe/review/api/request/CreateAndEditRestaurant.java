package com.hehe.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor()
@NoArgsConstructor(force = true)
public class CreateAndEditRestaurant {
    private final String name;
    private final String address;
    private final List<CreateAndEditRestaurantMenu> menus;
}
