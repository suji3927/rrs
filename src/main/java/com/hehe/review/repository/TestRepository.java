package com.hehe.review.repository;

import com.hehe.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

    // JPA 방식
    public List<TestEntity> findAllByName(String name);
}

