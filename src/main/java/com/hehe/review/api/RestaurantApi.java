package com.hehe.review.api;

import com.hehe.review.api.request.CreateAndEditRestaurant;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "getRestaurants";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId) {
        return "getRestaurant : " + restaurantId;
    }

    @PostMapping("/restaurant")
    public String createRestaurant(@RequestBody CreateAndEditRestaurant request) {
        return "createRestaurant : " + request.getName() + ", " + request.getAddress() + ", " + request.getMenus().get(0).getName() + ", " + request.getMenus().get(0).getPrice();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(@PathVariable Long restaurantId, @RequestBody CreateAndEditRestaurant request) {
        return "editRestaurant : " + request.getName() + ", " + request.getAddress() + ", " + request.getMenus().get(0).getName() + ", " + request.getMenus().get(0).getPrice();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable Long restaurantId) {
        return "deleteRestaurant : " + restaurantId;
    }
}
