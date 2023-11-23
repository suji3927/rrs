package com.hehe.review.api;

import com.hehe.review.api.request.CreateAndEditRestaurant;
import com.hehe.review.model.RestaurantEntity;
import com.hehe.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService service;

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "getRestaurants";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId) {
        return "getRestaurant : " + restaurantId;
    }

    @PostMapping("/restaurant")
    public RestaurantEntity createRestaurant(@RequestBody CreateAndEditRestaurant request) {
        return service.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(@PathVariable Long restaurantId, @RequestBody CreateAndEditRestaurant request) {
       service.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
        service.deleteRestaurant(restaurantId);
    }
}
