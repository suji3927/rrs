package com.hehe.review.api;

import com.hehe.review.model.TestEntity;
import com.hehe.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {

    private final TestService testService;

    @GetMapping("test/query/jpa/{name}")
    public List<TestEntity> queryJpa(@PathVariable String name) {
        return testService.findAllByNameByJPA(name);
    }

    @GetMapping("test/query/querydsl/{name}")
    public List<TestEntity> queryDSL(@PathVariable String name) {
        return testService.findAllByNameByQueryDSL(name);
    }
}
