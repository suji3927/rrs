package com.hehe.review.api;

import com.hehe.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity")
    public void createETestEntity(@RequestBody CreateTestEntityRequest createTestEntityRequest) {
        testService.create(createTestEntityRequest.getName(), createTestEntityRequest.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(@PathVariable Long id) {
        testService.delete(id);
    }

    @PutMapping("/test/entity/{id}")
    public void updateTestEntity(@PathVariable Long id, @RequestBody CreateTestEntityRequest createTestEntityRequest) {
        testService.update(id, createTestEntityRequest.getName(), createTestEntityRequest.getAge());
    }

    @NoArgsConstructor(force = true)
    @Getter
    public static class CreateTestEntityRequest {
        private final String name;
        private final Integer age;
    }

}


