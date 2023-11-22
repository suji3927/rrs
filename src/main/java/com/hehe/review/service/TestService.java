package com.hehe.review.service;

import com.hehe.review.model.TestEntity;
import com.hehe.review.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void create(String name, Integer age) {
        TestEntity testEntity = TestEntity.builder()
                                            .name(name)
                                            .age(age)
                                            .build();
        testRepository.save(testEntity);
    }

    public void delete (Long id) {
        TestEntity savedEntity = testRepository.findById(id).get();
        testRepository.delete(savedEntity);
    }

    public void update(Long id, String name, Integer age) {
        TestEntity savedEntity = testRepository.findById(id).orElseThrow();
        savedEntity.changeNameAndAge(name, age);
        testRepository.save(savedEntity);
    }

    public List<TestEntity> findAllByNameByJPA(String name) {
        return testRepository.findAllByName(name);
    }

    public List<TestEntity> findAllByNameByQueryDSL(String name) {
        return testRepository.findAllByNameByQuerydsl(name);
    }
}
