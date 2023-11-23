package com.hehe.review.service;

import com.hehe.review.api.request.CreateAndEditRestaurant;
import com.hehe.review.api.response.RestaurantDetailView;
import com.hehe.review.api.response.RestaurantView;
import com.hehe.review.model.MenuEntity;
import com.hehe.review.model.RestaurantEntity;
import com.hehe.review.repository.MenuRepository;
import com.hehe.review.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public RestaurantEntity createRestaurant(CreateAndEditRestaurant request) {
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        });

        return restaurant;
    }

    @Transactional
    public void editRestaurant(Long restaurantId, CreateAndEditRestaurant request) {
        RestaurantEntity restaurant= restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑입니다."));
        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
        restaurantRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        });
    }

    @Transactional
    public void deleteRestaurant(Long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantId).orElseThrow();
        restaurantRepository.delete(restaurantEntity);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);
    }

    public List<RestaurantView> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map((restaurant) -> RestaurantView.builder()
                                                                        .id(restaurant.getId())
                                                                        .name(restaurant.getName())
                                                                        .address(restaurant.getAddress())
                                                                        .createdAt(restaurant.getCreatedAt())
                                                                        .updatedAt(restaurant.getUpdatedAt())
                                                                        .build()).toList();
    }

    public RestaurantDetailView getRestaurant(Long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantId).orElseThrow();
        List<MenuEntity> menuEntityList = menuRepository.findAllByRestaurantId(restaurantId);
        List<RestaurantDetailView.Menu> menus = menuEntityList.stream().map((menu) -> RestaurantDetailView.Menu.builder()
                .id(menu.getRestaurantId())
                .name(menu.getName())
                .price(menu.getPrice())
                .createdAt(menu.getCreatedAt())
                .updatedAt(menu.getUpdatedAt())
                .build()).toList();

        return RestaurantDetailView.builder()
                .id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .address(restaurantEntity.getAddress())
                .menus(menus)
                .createdAt(restaurantEntity.getCreatedAt())
                .updatedAt(restaurantEntity.getUpdatedAt())
                .build();
    }
}
