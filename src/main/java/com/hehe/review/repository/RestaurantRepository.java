package com.hehe.review.repository;

import com.hehe.review.api.response.RestaurantView;
import com.hehe.review.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
